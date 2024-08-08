package Queue;

public class QueueApp {
    public static void main(String[] args) {
        CustomQueue<Long> queue = new CustomQueue<Long>(5);

        queue.insert(10L);
        queue.insert(20L);
        queue.insert(30L);
        queue.insert(40L);

        queue.remove();
        queue.remove();
        queue.remove();

        queue.insert(50L);
        queue.insert(60L);
        queue.insert(70L);
        queue.insert(80L);

        while (!queue.isEmpty()) {
            long n = queue.remove();
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
