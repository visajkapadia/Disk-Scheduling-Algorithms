public class FCFS {

    int size = 8;
    int seekRate = 5;

    public int getTotalHeadMovement(int[] arr, int head) {

        int seek_count = 0;
        int distance, cur_track;

        for (int i = 0; i < size; i++) {
            cur_track = arr[i];
            distance = Math.abs(cur_track - head);
            seek_count += distance;
            head = cur_track;
        }

//        System.out.println("Total Head Movement : "
//                + seek_count);
//        System.out.println("Seek Time: " + (seekRate * seek_count));
//        System.out.println("Seek Sequence is");

//        for (int i = 0; i < size; i++) {
//            System.out.println(arr[i]);
//        }
        return seek_count;
    }
}
