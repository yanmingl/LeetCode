public class reverseInteger_7 {
    public static int reversInteger(int a) {
        /* reverse integer and avoid crossing the boundary */
        // input: 321 expected output: 123
        // workflow
        // 321
        // 321 % 10 = 1
        // 0 * 10 + 1 = 1
        // 321 / 10 = 32
        // loop
        // 32 % 10 = 2
        // 1 * 10 + 2 = 12
        // 32 / 10 = 3
        // loop
        // 3 % 10 = 3
        // 12 * 10 + 3 = 123
        // 3 / 10 = 0
        // stop as x/10 = 0, and return 123

        // pseudoCode:
        //      0. define int resl = 0
        //      1. find each digit from right to left as nail = a % 10;
        //      2. for next step, we multiply resl with 10 that may result in crossing boundary
        //              we need deal with such situation, if it occurs, then return 0
        //              what are they?
        //              if resl is positive,
        //              resl > Integer.MAX_VALUE / 10 || (resl = Integer.MAX_VALUE / 10 && nail > Integer.MAX_VALUE % 10)
        //              otherwise, resl is negative,
        //              resl < Integer.MAX_VALUE / 10 || (resl = Integer.MAX_VALUE / 10 && nail < Integer.MAX_VALUE % 10)
        //      3. resl = resl * 10 + nail
        //      4. a /= 10;
        //      5. loop 1 - 4 until a = 0, i.e., loop length of integer times

        // Time complexity: o(log(n)), Space complexity: o(1)

        int resl = 0;
        while (a != 0) {
            int nail = a % 10;
            // judge if resl * 10 will cross boundary or not
            if (resl > 0) {
                if (resl > Integer.MAX_VALUE / 10 || (resl == Integer.MAX_VALUE / 10 && nail > Integer.MAX_VALUE % 10)) {
                    return 0;
                }
            }
            else if (resl < 0) {
                if (resl < Integer.MIN_VALUE / 10 || (resl == Integer.MIN_VALUE / 10 && nail < Integer.MIN_VALUE % 10)) {
                    return 0;
                }
            }
            resl = resl * 10 + nail;
            a /= 10;
        }
        return resl;
    }

    public static int reverseInteger_1(int a){
        // a smart way for crossing boundary check
        int resl = 0;
        while (a != 0) {
            int nail = a % 10;
            // let's calculate result first
            int newResl = resl * 10 + nail;
            if (newResl / 10 != resl) {  // if cross boundary, then condition holds
                return 0;
            }
            // otherwise, reassign the temp newResl to resl
            resl = newResl;
            a /= 10;
        }
        return resl;
    }

    public static void main(String[] args) {
        int a = -123;
        // test
        System.out.println(reversInteger(a));
        // test another method
        int b = 123;
        System.out.println(reverseInteger_1(b));
    }

}
