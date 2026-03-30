class Solution {
    public int trap(int[] height) {
        if(height==null||height.length==0)return 0;
        int totalwater=0;
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<height.length;i++){
            while(!s.isEmpty()&&height[i]>height[s.peek()]){
                int top=s.pop();
                if(s.isEmpty())break;
                int left=s.peek();
                 int width = i - left - 1; // Distance between the left and right boundaries
                int waterHeight = Math.min(height[left], height[i]) - height[top];
                
                totalwater += width * waterHeight;

            } 
            s.push(i);
        }
        return totalwater;
    }
}