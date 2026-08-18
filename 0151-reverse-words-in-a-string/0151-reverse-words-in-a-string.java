class Solution {
    public String reverseWords(String s) {
        ArrayList<String> r = new ArrayList<>();
        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        int n = s.length() - 1;

        while (n >= 0 && s.charAt(n) == ' ') {
            n--;
        }

        StringBuilder sb = new StringBuilder();

        for (int j = i; j <= n; j++) {
            if (s.charAt(j) == ' ') {
                if (sb.length() > 0) {
                    r.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(s.charAt(j));
            }
        }

        if (sb.length() > 0) {
            r.add(sb.toString());
        }

        StringBuilder res = new StringBuilder();

        for (int k = r.size() - 1; k >= 0; k--) {
            res.append(r.get(k));

            if (k != 0) {
                res.append(" ");
            }
        }

        return res.toString();
    }
}