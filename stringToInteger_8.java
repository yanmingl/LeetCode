public class stringToInteger_8 {
    public static int stringToInteger(String s) {
        /* covert a string to an integer */
        // e.g. "42" --> 42; "  -42" --> -42; "4193 with words" --> 4193; "words and 987" --> 0;
        // "-91283472334" --> -2147483648

        // From the input and expected output, we have notes below:
        // 1. ignore the space before the digits
        // 2. ignore the characters
        // 3. avoid the cross boundary issue

        // PseudoCode
        // 0. check current string is a null object or an empty string
        // 1. define an index as 0, and loop it until first non-space character
        // 1~ if all characters are space, then we return 0
        // 2. check if the current character is with a sign "+" or "-", and mark "+" using sign = 1, otherwise -1
        //      default sign = 1 if no such character, index++
        // 3. define result, int resl = 0;
        // 4. find the numerical digit for current character, digit
        // 5. if it is not a digit, then we break the loop
        // 6. otherwise, get the current result, resl = resl * 10 + digit;
        // 6.1 check if resl is beyond the boundary
        //      rename the above statement as newResl = resl * 10 + digits;
        //      if (newResl / 10 != resl) means that the new result is beyond boundary, we return the max or min values
        //          if (sign == 1) return max value otherwise min value
        //      since you rename the result newResl, for each iteration, you need assign resl = newResl;
        // 7. index++
        // 8. loop 4 - 7 until the final length of the string
        // 9. return integer = sign * resl

        // 0
        if (s == null || s.length() == 0) return 0;

        // 1
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // 1~ be cautious at this situation if s is " "; empty string mean "" instead of " "
        if (index == s.length()) return 0;

        // 2
        int sign = 1;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // 3
        int resl = 0;

        // 8
        while (index < s.length()){
            // 4
            int digit = s.charAt(index) - '0';
            // 5
            if (digit > 9 || digit < 0) break;
            // 6
            int newResl = resl * 10 + digit;
            // 6.1
            if (newResl / 10 != resl) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            resl = newResl;
            // 7
            index++;
        }

        // 9
        return sign * resl;
    }

    public static void main(String[] args) {
        String s = "  +123w";
        System.out.println(stringToInteger(s));
        String s1 = "42";
        System.out.println(stringToInteger(s1));
        String s2 = "words and 987";
        System.out.println(stringToInteger(s2));
        String s3 = "11111111111111111";
        System.out.println(stringToInteger(s3));
        String s4 = " -1234ss";
        System.out.println(stringToInteger(s4));
        String s5 = "  ";
        System.out.println(stringToInteger(s5));
    }

}


