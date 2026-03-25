class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Step 1: copy values into list
        ArrayList<Integer> a = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            a.add(curr.val);
            curr = curr.next;
        }

        int n = a.size();
        ArrayList<Integer> b = new ArrayList<>();

        // Step 2: reverse each k-group in array
        int fullGroups = n / k;
        for (int i = 0; i < fullGroups; i++) {
            for (int j = (i + 1) * k - 1; j >= i * k; j--) {
                b.add(a.get(j));
            }
        }

        // Step 3: add leftover (not reversed)
        for (int i = fullGroups * k; i < n; i++) {
            b.add(a.get(i));
        }

        // Step 4: rebuild linked list
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for (int val : b) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }

        return dummy.next;
    }
}