package Arrays.high;

public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);

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

        arr.display();

        int searchKey = 35;
        if (arr.find(searchKey)) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }

        arr.delete(0);
        arr.delete(55);
        arr.delete(99);

        arr.display();

        System.out.println("Project 2.1 =============================");

        long max = arr.getMax();
        if (max == 1) {
            System.out.println("Array is empty");
        } else {
            System.out.println("Max value: " + max);
        }

        System.out.println("Project 2.1 =============================");

        arr.display();

        System.out.println("Project 2.2 =============================");
        long removedMax = arr.removeMax();
        if (max == 1) {
            System.out.println("Array is empty");
        } else {
            System.out.println("Max value to remove: " + removedMax);
        }
        System.out.println("Project 2.2 =============================");

        arr.display();

        System.out.println("Project 2.3 =============================");
        HighArray inverseArray = new HighArray(100);
        while (arr.size() > 0) {
            long newValue = arr.removeMax();
            inverseArray.insert(newValue);
        }
        inverseArray.display();
        System.out.println("Project 2.3 =============================");

        System.out.println("Project 2.6 =============================");
        HighArray noDupsArr = new HighArray(100);
        noDupsArr.insert(12);
        noDupsArr.insert(12);
        noDupsArr.insert(32);
        noDupsArr.insert(32);
        noDupsArr.insert(32);
        noDupsArr.insert(44);
        noDupsArr.insert(11);
        noDupsArr.insert(54);
        noDupsArr.insert(0);
        noDupsArr.insert(66);
        noDupsArr.insert(66);

        noDupsArr.display();

        noDupsArr.noDups();

        noDupsArr.display();

        System.out.println("Project 2.6 =============================");


    }
}
