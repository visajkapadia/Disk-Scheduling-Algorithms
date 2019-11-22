import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C_SCAN {

    int size = 8;
    int disk_size = 200;

    public int getTotalHeadMovement(int arr[], int head) {
        
        int seek_count = 0;
        int distance, cur_track;
        
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> seek_sequence = new ArrayList<>();

        // appending end values 
        // which has to be visited 
        // before reversing the direction 
        left.add(0);
        right.add(disk_size - 1);

        // tracks on the left of the 
        // head will be serviced when 
        // once the head comes back 
        // to the beggining (left end). 
        for (int i = 0; i < size; i++) {
            if (arr[i] < head)
                left.add(arr[i]);
            if (arr[i] > head)
                right.add(arr[i]);
        }

        // sorting left and right vectors 
        Collections.sort(left);
        Collections.sort(right);

        // first service the requests 
        // on the right side of the 
        // head. 
        for (int i = 0; i < right.size(); i++) {
            cur_track = right.get(i);
            // appending current track to seek sequence 
            seek_sequence.add(cur_track);

            // calculate absolute distance 
            distance = Math.abs(cur_track - head);

            // increase the total count 
            seek_count += distance;

            // accessed track is now new head 
            head = cur_track;
        }

        // once reached the right end 
        // jump to the beggining. 
        head = 0;
        seek_count += right.get(right.size()-1);

        // Now service the requests again 
        // which are left. 
        for (int i = 0; i < left.size(); i++) {
            cur_track = left.get(i);

            // appending current track to seek sequence 
            seek_sequence.add(cur_track);

            // calculate absolute distance 
            distance = Math.abs(cur_track - head);

            // increase the total count 
            seek_count += distance;

            // accessed track is now the new head 
            head = cur_track;
        }

//        System.out.println("Total number of seek operations = " + seek_count);
//
//        System.out.println("Seek Sequence is");
//
//        for (int i = 0; i < seek_sequence.size(); i++) {
//            System.out.println(seek_sequence.get(i));
//        }

        return seek_count;
    }

    // Driver code 
    public static void main(String[] args) {
        // request array
        int arr[] = { 98, 183, 41, 122, 14, 124, 65, 67 };
        int head = 53;

        System.out.println("Initial position of head: " + head);
        C_SCAN cscan = new C_SCAN();
        System.out.println(cscan.getTotalHeadMovement(arr, head));
    }
}
