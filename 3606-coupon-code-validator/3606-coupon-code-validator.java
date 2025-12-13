class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<String> el = new ArrayList<>();
        List<String> gr = new ArrayList<>();
        List<String> ph = new ArrayList<>();
        List<String> rt = new ArrayList<>();

        int n = code.length;

        for (int i = 0; i < n; i++) {

            if (!isActive[i]) continue;
            if (code[i] == null || !code[i].matches("[a-zA-Z0-9_]+")) continue;

            if (businessLine[i].equals("electronics")) {
                el.add(code[i]);
            } else if (businessLine[i].equals("grocery")) {
                gr.add(code[i]);
            } else if (businessLine[i].equals("pharmacy")) {
                ph.add(code[i]);
            } else if (businessLine[i].equals("restaurant")) {
                rt.add(code[i]);
            }
        }

        Collections.sort(el);
        Collections.sort(gr);
        Collections.sort(ph);
        Collections.sort(rt);

        List<String> res = new ArrayList<>();
        res.addAll(el);
        res.addAll(gr);
        res.addAll(ph);
        res.addAll(rt);

        return res;
    }
}
