import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LOOK {

    int size = 8;
    int disk_size = 200;

    public int getTotalHeadMovement(int arr[], int head, String direction)
    {
        int seek_count = 0;
        int distance, cur_track;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> seek_sequence = new ArrayList<>();

        // appending values which are 
        // currently at left and right 
        // direction from the head. 
        for (int i = 0; i < size; i++) {
            if (arr[i] < head)
                left.add(arr[i]);
            if (arr[i] > head)
                right.add(arr[i]);
        }

        // sorting left and right vectors 
        // for servicing tracks in the 
        // correct sequence. 
        Collections.sort(left);
        Collections.sort(right);

        // run the while loop two times. 
        // one by one scanning right 
        // and left side of the head 
        int run = 2;
        while (run > 0) {
            if (direction == "left") {
                for (int i = left.size() - 1; i >= 0; i--) {
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
                // reversing the direction 
                direction = "right";
            }
            else if (direction == "right") {
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
                // reversing the direction 
                direction = "left";
            }

            run--;
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

        // request array 
        int arr[] = { 176, 79, 34, 60, 92, 11, 41, 114 };
        int head = 50;
        String direction = "right";

        System.out.println("Initial position of head: " + head);
        LOOK look = new LOOK();
        look.getTotalHeadMovement(arr, head, direction);

    }

}
