import java.util.Objects;

public class SinglyLinkedList implements List {
    private Node head;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            current = current.getNext();
            size++;
        }
        return size;
    }

    @Override
    public void add(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot add null");
        }
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
    }

    @Override
    public Node find(String value) {
        Node current = head;
        while (current != null) {
            if (Objects.equals(current.getValue(), value)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public void delete(String value) {
        if (head.getValue().equals(value)) {
            head = head.getNext();
        } else {
            Node current = head;
            while (current != null && !(value.equals(current.getNext().getValue()))) {
                current = current.getNext();
            }
            if (current != null) {
                current.setNext(current.getNext().getNext());
            }
        }
    }

    @Override
    public String[] values() {
        String[] result = new String[size()];
        Node current = head;
        int index = 0;
        while (current != null) {
            result[index++] = current.getValue();
            current = current.getNext();
        }
        return result;
    }
}
