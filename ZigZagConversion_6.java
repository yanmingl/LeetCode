public class ZigZagConversion_6 {
    public static String zigZagConversion(String s, int numRows){
        /* change the string display style to zigZag format */
        // Taking input 'PAYPALISHIRING' as an example, numRows = 3
        // zigZag version
        // P   A   H   N
        // A P L S I I G
        // Y   I   R
        // Then output would be "PAHNAPLSIIGYIR"
        // Note: use stringBuilder to simulate the whole process

        // define string array with a size of numRows
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int i = 0;
        while (i < s.length()){  // then loop until the final character
            // from top to bottom row
            int row = 0;
            while (row < numRows && i < s.length()) {
                sbs[row++].append(s.charAt(i++));
            }
            // from bottom to top row
            row = row - 2;
            while (row > 0 && i < s.length()) {
                sbs[row--].append(s.charAt(i++));
            }
            // top to bottom and bottom to top can be seen as one pattern
        }
        // subarray to string
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            sb.append(sbs[j].toString());
        }
        // array to string
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(zigZagConversion(s, numRows));
    }
}
