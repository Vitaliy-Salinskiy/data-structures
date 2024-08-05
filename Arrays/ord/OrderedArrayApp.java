package Arrays.ord;

public class OrderedArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrderedArray arr = new OrderedArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        System.out.println("Project 2.5 =========================================");

        OrderedArray arr1 = new OrderedArray(maxSize);

        arr1.insert(12);
        arr1.insert(23);
        arr1.insert(34);
        arr1.insert(45);
        arr1.insert(56);
        arr1.insert(67);
        arr1.insert(78);
        arr1.insert(89);

        OrderedArray mergedArray = OrderedArray.merge(arr, arr1);
        mergedArray.display();

        System.out.println("Project 2.5 =========================================");


        int searchKey = 55;
        if (arr.find(searchKey) != arr.size()) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }

        arr.display();

        arr.delete(0);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }
}
