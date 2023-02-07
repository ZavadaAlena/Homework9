package MyQueue;


public class MyQueue<T> {
    private Node<T> first; //ссылка на первый обьект
    private Node<T> last; //ссылка на последний обьект
    private int size = 0;

    public void add(T value) {
        if (size == 0) {
            first = new Node<>(null, value, null);
            last = first;
        } else {
            Node<T> secondLast = last;
            last = new Node<>(secondLast, value, null);
            secondLast.next = last;
        }
        size++;

    }

    public Node<T> getNodeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Object get(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public void remove(int index) {
        Node<T> node = getNodeByIndex(index);
        Node<T> nodeNext = node.next;
        Node<T> nodePrevious = node.previous;
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

    public Object peek() {
        return size > 0 ? get(0) : null;
    }

    public Object pool() {
        Object returnFirstElement = peek();
        remove(0);
        return returnFirstElement;
    }

    @Override
    public String toString() {
        Node<T> node = first;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(node.value.toString()).append(" ");
            node = node.next;

        }
        return result.toString().strip();

    }

    private static class Node<E> {
        private Node<E> previous; // ссылка на предыдущий обьект
        private E value;
        private Node<E> next; // ссылка на следующий обьект

        public Node(Node<E> previous, E value, Node<E> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }


}


