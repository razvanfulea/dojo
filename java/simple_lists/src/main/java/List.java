public interface List {

    boolean isEmpty();
    int size();
    void add(String value);
    Node find(String value);
    void delete(String value);
    String[] values();

}
