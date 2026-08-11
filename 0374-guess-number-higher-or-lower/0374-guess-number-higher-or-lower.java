public class Solution extends GuessGame {

    public int guessNumber(int n) {

        int s = 1;
        int e = n;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            int result = guess(mid);

            if (result == 0) {
                return mid;
            }
            else if (result == -1) {
                // mid is higher than picked number
                e = mid - 1;
            }
            else {
                // mid is lower than picked number
                s = mid + 1;
            }
        }

        return -1;
    }
}