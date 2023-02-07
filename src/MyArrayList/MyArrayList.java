package MyArrayList;


public class MyArrayList<E> {
    private Object[] array = new Object[10];
    private int size = 0;

    public void add(Object value) {
        array[size] = value;
        size++;
        if (size == array.length) {
            Object[] newValue = new Object[array.length * 2];
            System.arraycopy(array, 0, newValue, 0, array.length);
            array = newValue;
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }

    public void clear() {
        array = new Object[1];
        size = 0;
    }

    public int size() {

        return size;
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

    public Object get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else {
            return "Element not found";
        }
    }
}
