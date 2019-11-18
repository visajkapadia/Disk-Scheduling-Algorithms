public class Demo {
    public static void main(String[] args) {
        FCFS fcfs = new FCFS();

        int arr1[] = {176, 79, 34, 60, 92, 11, 41, 114};
        int head = 50;

        System.out.println("Head: " + head);
        fcfs.getTotalHeadMovement(arr1, head);
        SSTF sstf = new SSTF();
        sstf.shortestSeekTimeFirst(arr1, head);

        System.out.println();

        int arr2[] = {176, 79, 34, 60, 92, 11, 41, 114};
        head = 1;
        System.out.println("Head: " + head);

        fcfs.getTotalHeadMovement(arr2, head);
        sstf.shortestSeekTimeFirst(arr2, head);

        System.out.println();

        int arr3[] = {176, 79, 34, 60, 92, 11, 41, 114};
        head = 176;

        System.out.println("Head: " + head);
        fcfs.getTotalHeadMovement(arr3, head);
        sstf.shortestSeekTimeFirst(arr3, head);

        System.out.println();

        int arr4[] = {51, 62, 73, 84, 94, 105, 111, 125};
        head = 50;

        System.out.println("Head: " + head);
        fcfs.getTotalHeadMovement(arr4, head);
        sstf.shortestSeekTimeFirst(arr4, head);

        System.out.println();

        int arr5[] = {51, 62, 73, 84, 94, 105, 111, 125};
        head = 90;

        System.out.println("Head: " + head);
        fcfs.getTotalHeadMovement(arr5, head);
        sstf.shortestSeekTimeFirst(arr5, head);
        System.out.println();
    }
}
