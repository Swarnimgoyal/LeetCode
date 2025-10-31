import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Create a set to store unique characters in the current window
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // If char is duplicate, shrink window from left
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Add current char and update max length
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
