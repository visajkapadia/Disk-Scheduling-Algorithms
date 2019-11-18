import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C_LOOK {
    int size = 8;
    int disk_size = 200;

    // Function to perform C-LOOK on the request 
// array starting from the given head 
    public int getTotalHeadMovement(int arr[], int head)
    {
        int seek_count = 0;
        int distance, cur_track;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> seek_sequence = new ArrayList<>();

        // Tracks on the left of the 
        // head will be serviced when 
        // once the head comes back 
        // to the beggining (left end) 
        for (int i = 0; i < size; i++) {
            if (arr[i] < head)
                left.add(arr[i]);
            if (arr[i] > head)
                right.add(arr[i]);
        }

        // Sorting left and right vectors 
        Collections.sort(left);
        Collections.sort(right);

        // First service the requests 
        // on the right side of the 
        // head 
        for (int i = 0; i < right.size(); i++) {
            cur_track = right.get(i);

            // Appending current track to seek sequence 
            seek_sequence.add(cur_track);

            // Calculate absolute distance 
            distance = Math.abs(cur_track - head);

            // Increase the total count 
            seek_count += distance;

            // Accessed track is now new head 
            head = cur_track;
        }

        // Once reached the right end 
        // jump to the last track that 
        // is needed to be serviced in 
        // left direction 
        seek_count += Math.abs(head - left.get(0));
        head = left.get(0);

        // Now service the requests again 
        // which are left 
        for (int i = 0; i < left.size(); i++) {
            cur_track = left.get(i);

            // Appending current track to seek sequence 
            seek_sequence.add(cur_track);

            // Calculate absolute distance 
            distance = Math.abs(cur_track - head);

            // Increase the total count 
            seek_count += distance;

            // Accessed track is now the new head 
            head = cur_track;
        }

        System.out.println("Total number of seek operations = " + seek_count);
        System.out.println("Seek Sequence is");

        for (int i = 0; i < seek_sequence.size(); i++) {
            System.out.println(seek_sequence.get(i));
        }
        return seek_count;
    }

    // Driver code 
    public static void main(String[] args)
    {
        // Request array 
        int arr[] = { 176, 79, 34, 60, 92, 11, 41, 114};
        int head = 50;

        System.out.println("Initial position of head: " + head);
        C_LOOK c_look = new C_LOOK();
        c_look.getTotalHeadMovement(arr, head);

    }
}
