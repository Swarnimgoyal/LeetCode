class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        
        // binary search to find smallest index where missing >= k
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int missing = arr[mid] - (mid + 1);
            
            if (missing < k) {
                left = mid + 1;   // need more missing numbers
            } else {
                right = mid - 1;
            }
        }
        
        // final answer:
        return left + k;
    }
}