class StockSpanner {
    Deque<int[]> d;

    public StockSpanner() {
        d = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;

        while (!d.isEmpty() && d.peek()[0] <= price) {
            span += d.peek()[1];
            d.pop();   // pop instead of poll (stack style)
        }

        d.push(new int[]{price, span}); // ✅ FIX
        return span;
    }
}
