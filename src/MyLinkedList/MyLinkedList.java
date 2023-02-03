package MyLinkedList;


public class MyLinkedList {
    private Node first; //ссылка на первый обьект
    private Node last; //ссылка на последний обьект
    private int size = 0;

    public void add(Object value) {
        if (size == 0) {
            first = new Node(null, value, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, value, null);
            secondLast.next = last;
        }
        size++;

    }

    public Node getIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public Object get(int index){
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public void remove(int index) {
        Node node = getIndex(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
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

    private static class Node {
        private Node previous; // ссылка на предыдущий обьект
        private Object value;
        private Node next; // ссылка на следующий обьект

        public Node(MyLinkedList.Node previous, Object value, MyLinkedList.Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

}


