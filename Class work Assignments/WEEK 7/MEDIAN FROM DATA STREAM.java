class MedianFinder {

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    
    public MedianFinder() {
        this.left = new PriorityQueue<Integer>((a,b) -> b-a);
        this.right = new PriorityQueue<Integer>((a,b) -> a-b);
    }
    
    public void addNum(int num) {
        int l = this.left.size(), r = this.right.size();
        if (l==r || l<r) 
        { 
            this.left.add(num);
        } else {
            this.right.add(num);
        }
        this.balance();
    }
    
    private void balance() { 
        while (this.left.size()>0 && this.right.size()>0 && 
               this.left.peek()>this.right.peek()) {
            int n1 = this.left.poll();
            int n2 = this.right.poll();
            this.right.add(n1);
            this.left.add(n2);
        }
    }
    
    public double findMedian() {
        if (this.left.size()==this.right.size()) {
            return (this.left.peek()+this.right.peek())/2.0;
        } else {
            if (this.left.size()>this.right.size()) {
                return this.left.peek();
            } else {
                return this.right.peek();
            }
        }
    }
}
