import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SCAN {
    int size = 8;
    int diskSize = 200;

        public int getTotalHeadMovement(int arr[], int head, String direction)
        {
                int seek_count = 0;
                int distance, cur_track;

                List<Integer> left = new ArrayList<>();
                List<Integer> right = new ArrayList<>();
                List<Integer> seek_sequence = new ArrayList<>();

                if (direction.equals("left")) {
                        left.add(0);
                }
                else if (direction == "right") {
                        right.add(diskSize - 1);
                }

                for (int i = 0; i < size; i++) {

                        if (arr[i] < head) {
                                left.add(arr[i]);
                        }

                        if (arr[i] > head) {
                                right.add(arr[i]);
                        }
                }

                // sorting left and right vectors
                Collections.sort(left);
                Collections.sort(right);

                // run the while loop two times.
                // one by one scanning right
                // and left of the head
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
                                direction = "left";
                        }
                        run--;
                }

//                System.out.println("Total number of seek operations = " + seek_count);
//
//                System.out.println("Seek Sequence is");
//
//                for (int i = 0; i < seek_sequence.size(); i++) {
//                        System.out.println(seek_sequence.get(i));
//                }

                return seek_count;
        }

        public static void main(String[] args) {

                int arr[] = { 98, 183, 41, 122, 14, 124, 65, 67 };
                int head = 53;
                String direction = "left";
                SCAN scan = new SCAN();
                System.out.println(scan.getTotalHeadMovement(arr, head, direction));

        }

}

