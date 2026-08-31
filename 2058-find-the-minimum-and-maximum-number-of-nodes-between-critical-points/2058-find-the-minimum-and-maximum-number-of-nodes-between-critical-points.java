/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        ArrayList<Integer> idx=new ArrayList<>();
        if(head==null)return new int[]{-1,-1};
        ListNode curr=head.next;
        ListNode cp=head;
        int i=1;
        while(curr.next!=null){
            if(cp.val<curr.val&&curr.val>curr.next.val){
                idx.add(i);
            }
            else if (cp.val>curr.val&&curr.val<curr.next.val){
                idx.add(i);
            }
            i++;
            cp=curr;
            curr=curr.next;
        }
        if(idx.size()<2){
            return new int [] {-1,-1};
        }
        int [] res=new int[2];
        int mxd=idx.get(idx.size()-1)-idx.get(0);
        int mind=Integer.MAX_VALUE;
        for(int j=1;j<idx.size();j++){
            mind=Math.min(mind,idx.get(j)-idx.get(j-1));
        }
        res[0]=mind;
        res[1]=mxd;
        return res;


    }
}