import java.util.HashMap;

public class longestStringLength_3 {
    public static int longestStringLength(String s){
        /* return the max length of a string with no repetitive characters occur */
        // e.g."abcabc" --> 3;   "bbbbb" --> 1
        // The idea of this exercise lies in the hashmap and two pointer method.
        // The intuition for hashmap is that we need to judge if there is repetitive value, which can be done using
        //   if map.containKey(). Here, the key of map is the character and the value is its index.
        //   Along the time, index will be used for max length calculation.
        // What is two pointer method? Like the word, for loop two pointers like i and j, here i is for the length
        //   of the string; j is the left variable, which is starter location with no repetitive character of one
        //   substring.
        // How to determine the left value is the key point of this exercise. We firstly choose the first after
        //   location that the repetitive character occurs. This raise issues like e.g. "t" in "tmmabct", where
        //   "mmabct" is not a string that follows the standard. So, for left value, we would better ensure it will
        //   increase always by using, left = Math.max(left, map.get(c) + 1), for longer substring may result in the
        //   failure.

        // if null object or empty string
        if (s == null || s.length() == 0) return 0;

        // else, maxlength at least 1
        int maxLength = 1;
        int left = 0;

        // for character and its index
        HashMap<Character, Integer> map = new HashMap<>();

        // loop string
        for (int i = 0; i < s.length(); i++) {
            // current character
            char c = s.charAt(i);

            // if c is in map, then reset left
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c)+1);
            }

            // update the maxlength
            if (maxLength < i - left + 1) {
                maxLength = i - left + 1;
            }

            // put current character and its index into the map
            map.put(c, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // String s = "tmmabct";  // 5
         String s = "bbbb";
        System.out.println(longestStringLength(s));
    }
}
