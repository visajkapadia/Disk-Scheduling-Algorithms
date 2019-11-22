public class Demo {

    static int[] fcfs_r = new int[12];
    static int[] sstf_r = new int[12];
    static int[] look_r = new int[12];
    static int[] c_look_r = new int[12];
    static int[] scan_r = new int[12];
    static int[] c_scan_r = new int[12];
    static int index = 0;

    public void getHeadMovement(int arr[], int head, String direction) {

        FCFS fcfs = new FCFS();
        SSTF sstf = new SSTF();
        LOOK look = new LOOK();
        C_LOOK c_look = new C_LOOK();
        SCAN scan = new SCAN();
        C_SCAN c_scan = new C_SCAN();

        System.out.println();
        System.out.print("Input: (");
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println(")");
        System.out.println("Head: " + head);
        System.out.println("Direction: " + direction);

        System.out.println();

        System.out.println("Total Head Movement...");
        fcfs_r[index] = fcfs.getTotalHeadMovement(arr, head);
        System.out.println("FCFS: " + fcfs_r[index]);

        sstf_r[index] = sstf.getTotalHeadMovement(arr, head);
        System.out.println("SSTF: " + sstf_r[index]);

        look_r[index] = look.getTotalHeadMovement(arr, head, direction);
        System.out.println("LOOK: "+ look_r[index]);

        c_look_r[index] = c_look.getTotalHeadMovement(arr, head);
        System.out.println("C_LOOK: " + c_look_r[index]);

        scan_r[index] = scan.getTotalHeadMovement(arr, head, direction);
        System.out.println("SCAN: " + scan_r[index]);

        c_scan_r[index] = c_scan.getTotalHeadMovement(arr, head);
        System.out.println("C_SCAN: " + c_scan_r[index]);

        System.out.println();
        index++;

    }

    public float calculateAverage(int[] arr) {

        float sum = 0;
        int len = arr.length;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }

        return (sum/len);
    }

    public static void main(String[] args) {

        Demo demo = new Demo();

        // sorted order
        int asc_sorted_arr[] = {12, 23, 45, 123, 142, 148, 174, 196};
        int head = 22;
        demo.getHeadMovement(asc_sorted_arr, head, "left");

        head = 120;
        demo.getHeadMovement(asc_sorted_arr, head, "left");

        head = 200;
        demo.getHeadMovement(asc_sorted_arr, head, "left");

        // descending order
        int desc_sorted_order[] = {197, 175, 159, 120, 99, 75, 54, 21};
        head = 22;
        demo.getHeadMovement(desc_sorted_order, head, "left");

        head = 120;
        demo.getHeadMovement(desc_sorted_order, head, "left");

        head = 200;
        demo.getHeadMovement(desc_sorted_order, head, "left");

        // increase, decrease order
        int inc_dec_order[] = {200, 10, 190, 20, 180, 30, 170, 40};
        head = 22;
        demo.getHeadMovement(inc_dec_order, head, "left");

        head = 120;
        demo.getHeadMovement(inc_dec_order, head, "left");

        head = 200;
        demo.getHeadMovement(inc_dec_order, head, "left");

        // total random values
        int random[] = {34, 98, 12, 56, 190, 199, 187, 165};
        head = 22;
        demo.getHeadMovement(random, head, "left");

        head = 120;
        demo.getHeadMovement(random, head, "left");

        head = 200;
        demo.getHeadMovement(random, head, "left");

        System.out.println();
        System.out.println("Average");
        System.out.println();

        System.out.println("FCFS: " + demo.calculateAverage(fcfs_r));
        System.out.println("SSTF: " + demo.calculateAverage(sstf_r));
        System.out.println("LOOK: " + demo.calculateAverage(look_r));
        System.out.println("C_LOOK: " + demo.calculateAverage(c_look_r));
        System.out.println("SCAN: " + demo.calculateAverage(scan_r));
        System.out.println("C_SCAN: " + demo.calculateAverage(c_scan_r));


    }
}
