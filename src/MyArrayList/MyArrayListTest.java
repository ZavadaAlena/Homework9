package MyArrayList;



public class MyArrayListTest {
    public static void main(String[] args) {


        MyArrayList arrayList = new MyArrayList();
        arrayList.add(15);
        arrayList.add(23);
        arrayList.add(59);
        arrayList.add(7);
        arrayList.add(5);
        arrayList.add(55);
        arrayList.add(59);
        arrayList.remove(0);

        System.out.println("arrayList.getSize = " + arrayList.size());
        System.out.println(arrayList);
    }
}
