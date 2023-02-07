package MyLinkedList;


public class MyLinkedList<E> {
    private Node<E> first; //ссылка на первый обьект
    private Node<E> last; //ссылка на последний обьект
    private int size = 0;

    public void add(E value) {
        if (size == 0) {
            first = new Node<>(null, value, null);
            last = first;
        } else {
            Node<E> secondLast = last;
            last = new Node<>(secondLast, value, null);
            secondLast.next = last;
        }
        size++;

    }

    public Node<E> getNodeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public void remove(int index) {
        Node<E> node = getNodeByIndex(index);
        Node<E> nodeNext = node.next;
        Node<E> nodePrevious = node.previous;
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        size--;

    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;

    }

    @Override
    public String toString() {
        Node<E> node = first;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(node.value.toString()).append(" ");
            node = node.next;

        }
        return result.toString().strip();

    }

    private static class Node<T> {
        private Node<T> previous; // ссылка на предыдущий обьект
        private T value;
        private Node<T> next; // ссылка на следующий обьект

        public Node(Node<T> previous, T value, Node<T> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

}


