public class LongestPalindromicString_3 {
    // define global variables
    static int left = 0;
    static int maxLen = 0;

    public static String longestPalindromicString(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return s.substring(left, left+maxLen);
    }
    public static void helper(String s, int l, int r){
        /* return the longest palindromic substring */
        // regard this as a three pointers question
        // suppose two special cases, "aba" and "abba", both are palindromic string
        //    for each one; **
        //    we start in the middle character "b", then compare the nearest left one and right one
        //    if they equal, compare left and right character one more
        //          update maxlength; if the current length is greater than maxlength
        //          update left pointer and right pointer
        //    loop all steps above until conditions are not met
        //
        //    return the substring under the parameter left and maxlength
        //          though two cases, if current length is not greater than the maxlength, the left and maxlength
        //          would not be updated. Then the returned substring is exactly what we want.
        while (l >=0 && r < s.length() && s.charAt(r) == s.charAt(l)){
            if (r - l + 1 > maxLen) {
                left = l;  // record these two parameter for substring
                maxLen = r - l + 1;
            }
            l--;
            r++;
        }

    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindromicString(s));  // bab

        // rest Left and maxLength to get result "bb" below

        String s1 = "cbbd";
        System.out.println(longestPalindromicString(s1)); // bb
    }
}
