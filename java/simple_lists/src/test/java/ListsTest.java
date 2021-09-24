import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListsTest {
    private static final String VALUE = "1";
    private static final String ANOTHER_VALUE = "2";

    private List list;

    @BeforeEach
    public void setUp() {
        list = new SinglyLinkedList();
    }

    @Test
    public void testCanAddSingleValue() {
        assertTrue(list.isEmpty());
        list.add(VALUE);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testCanAddMultipleValues() {
        list.add(VALUE);
        list.add(ANOTHER_VALUE);
        assertThat(list.size(), is(2));
    }

    @Test
    public void testCanAddValuesInOrder() {
        list.add(VALUE);
        list.add(ANOTHER_VALUE);
        assertThat(list.find(VALUE).getNext(),
                is(list.find(ANOTHER_VALUE)));
        assertNull(list.find(ANOTHER_VALUE).getNext());
    }

    @Test
    public void testCannotAddNull() {
        assertThrows(IllegalArgumentException.class, () -> list.add(null));
    }

    @Test
    public void testCanFindValue() {
        list.add(VALUE);
        assertNotNull(list.find(VALUE));
        assertNull(list.find(ANOTHER_VALUE));
    }

    @Test
    public void testCanDeleteFirstValue() {
        list.add(VALUE);
        list.add(ANOTHER_VALUE);

        assertThat(list.size(), is(2));
        list.delete(VALUE);
        assertThat(list.size(), is(1));
    }

    @Test
    public void testCanDeleteLastValue() {
        list.add(VALUE);
        list.add(ANOTHER_VALUE);

        assertThat(list.size(), is(2));
        list.delete(ANOTHER_VALUE);
        assertThat(list.size(), is(1));
    }

    @Test
    public void testCanReturnEmptyArrayOfValues() {
        String[] values = list.values();
        assertThat(values.length, is(0));
    }

    @Test
    public void testCanReturnArrayOfValues() {
        list.add(VALUE);
        list.add(ANOTHER_VALUE);
        String[] values = list.values();

        assertThat(values.length, is(2));
        assertThat(values[0], is(VALUE));
        assertThat(values[1], is(ANOTHER_VALUE));

        list.delete(VALUE);
        values = list.values();

        assertThat(values[0], is(ANOTHER_VALUE));
    }

}
