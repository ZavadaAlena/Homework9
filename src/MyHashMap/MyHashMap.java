package MyHashMap;

import java.util.Objects;


public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Node<K, V>[] array = new Node[INITIAL_CAPACITY];
    private int size = 0;

    public void put(K key, V value) {
        if (size >= array.length * LOAD_FACTOR) {
            increaseArray();
        }
        boolean put = put(key, value, array);
        if (put) {
            size++;
        }
    }

    private boolean put(K key, V value, Node<K, V>[] dst) {
        int position = getElementPosition(key, dst.length);
        Node<K, V> existedElement = dst[position];
        if (existedElement == null) {
            Node<K, V> entry = new Node<>(key, value, null);
            dst[position] = entry;
            return true;
        } else {
            while (true) {
                if (existedElement.key.equals(key)) {
                    existedElement.value = value;
                    return false;
                }
                if (existedElement.next == null) {
                    existedElement.next = new Node<>(key, value, null);
                    return true;
                }
                existedElement = existedElement.next;

            }
        }
    }

    public Object get(Object key) {
        int position = getElementPosition(key, array.length);
        Node<K, V> existedElement = array[position];
        while (existedElement != null) {
            if (existedElement.key.equals(key)) {
                return existedElement.value;
            }
            existedElement = existedElement.next;
        }
        return null;
    }

    public void remove(Object key) {
        int position = getElementPosition(key, array.length);
        Node<K, V> existedElement = array[position];
        if (existedElement != null && existedElement.key.equals(key)) {
            array[position] = existedElement.next;
            size--;
        } else {
            while (existedElement != null) {
                Node<K, V> nextElement = existedElement.next;
                if (nextElement == null) {
                    return;
                }
                if ((nextElement.key.equals(key))) {
                    existedElement.next = nextElement.next;
                    size--;
                    return;
                }
                existedElement = existedElement.next;
            }
        }
    }


    public void clear() {
        array = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    private void increaseArray() {
        Node<K, V>[] newArray = new Node[array.length * 2];
        for (Node<K, V> node : array) {
            Node<K, V> existedElement = node;
            while (existedElement != null) {
                put(existedElement.key, existedElement.value, newArray);
                existedElement = existedElement.next;
                array = newArray;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object object : array) {
            if (object != null) {
                result.append(object).append(" ");
            }
        }
        return result.toString().trim();

    }

    private int getElementPosition(Object object, int arrayLength) {
        return Math.abs(object.hashCode() % arrayLength);
    }

    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value);
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }

}
