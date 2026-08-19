class Solution {
    public int maximumGain(String s, int x, int y) {

        int score = 0;

        // Make "ab" the higher-value pair
        if (x < y) {
            // Swap x and y
            int temp = x;
            x = y;
            y = temp;

            // Swap a and b in the string
            s = s.replace('a', '#')
                 .replace('b', 'a')
                 .replace('#', 'b');
        }

        // Now x >= y
        // First remove all "ab"
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (c == 'b' && sb.length() > 0 &&
                sb.charAt(sb.length() - 1) == 'a') {

                sb.deleteCharAt(sb.length() - 1);
                score += x;

            } else {
                sb.append(c);
            }
        }

        // Now remove "ba"
        StringBuilder sb2 = new StringBuilder();

        for (char c : sb.toString().toCharArray()) {

            if (c == 'a' && sb2.length() > 0 &&
                sb2.charAt(sb2.length() - 1) == 'b') {

                sb2.deleteCharAt(sb2.length() - 1);
                score += y;

            } else {
                sb2.append(c);
            }
        }

        return score;
    }
}