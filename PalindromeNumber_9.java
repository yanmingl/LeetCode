public class PalindromeNumber_9 {
    public static boolean palindromeNumber(int n){
        /* see if it is a palindrome number */
        // we use 3 pointers to solve the substring of palindrome number with the max length previously.
        // guess you may have the basic idea for that, how can we check if it is a palindrome number
        // think some cases below
        // True: 121; 1221; 0;  False: -1 (negative); 10 (10*n, where n > 0 but integer)
        // PseudoCode:
        // 0. remove all negative values
        // 1. remove all 10*n, but not remove the 0 case (0 is a palindrome number)
        // 2. get the number part with at least half-length of the whole number from right to left, resl
        // 3. resl / 10 == n || resl == n, then palindrome, otherwise not
        // The key point is that while loop stop at n < resl, which can grantee a at least half-length of whole number
        if (n < 0) return false;  // 0
        if (n % 10 == 0 && n != 0) return false;  // 1
        int resl = 0;
        while (n > resl) {  // n == resl or n < resl
            resl = resl * 10 + n % 10;
            n /= 10;
        }
        return resl == n || resl / 10 == n;
    }

    public static void main(String[] args) {
        int a = 123;
        int b = 121;
        int c = 1221;
        int d = 0;
        int e = -10;
        System.out.println(palindromeNumber(a));  // false
        System.out.println(palindromeNumber(b));  // true
        System.out.println(palindromeNumber(c));  // true
        System.out.println(palindromeNumber(d));  // true
        System.out.println(palindromeNumber(e));  // false
    }
}
