class Solution {
    public String reverseVowels(String s) {

        Set<Character> set = new HashSet<>();

        for (char c : "aeiouAEIOU".toCharArray()) {
            set.add(c);
        }

        ArrayList<Integer> positions = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                positions.add(i);
            }
        }

        char[] arr = s.toCharArray();

        int left = 0;
        int right = positions.size() - 1;

        while (left < right) {
            int i = positions.get(left);
            int j = positions.get(right);

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }
}