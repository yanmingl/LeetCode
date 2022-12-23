import java.util.Arrays;
import java.util.HashMap;

public class twoSum_1 {
    /**Given list nums, and target value, return the i, j if nums[i] + nums[j] = target **/
    // Solution 1: for loop with i, j to see if nums[i] + num[j] = target, time complexity: o(n^2)
    // Solution 2: use a hashmap for decrease the time complexity to o(n) because of the intuition index and value

    // PseudoCode - solution 2
    // 1. input arrays num and target value, initialize a hashmap
    // 2. loop i to the length of arrays
    // 2.1 add value and i into map
    // 3. loop i again
    // 3.1 mark the current value as nums[i], difference value as target - nums[i], check if the difference in map or not
    // 3.1.1 if inside, return the i and j, which can be accessed by map.get(diff)
    // 4. nothing found after iteration, then return ints[][]{-1, -1}

    // We can simplify the above algo by merging step 2 and step 3 in below format
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int diff = target - temp;

            if (map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(temp, i);
        }

        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        // Arrays.toString for print those values instead of address
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
