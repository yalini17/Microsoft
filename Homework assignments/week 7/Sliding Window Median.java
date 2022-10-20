class Solution {
    
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    
    private void removeFromHeap(int n) {
       if(n<=maxHeap.peek()) {
           if(maxHeap.size() > minHeap.size()) {
               maxHeap.remove(n);
           }else {
               maxHeap.remove(n);
               maxHeap.add(minHeap.poll());
           }
       }else {
           if(maxHeap.size() > minHeap.size()) {
               minHeap.remove(n);
               minHeap.add(maxHeap.poll());
           }else {
               minHeap.remove(n);
           }
       }
    }
    
    private void insertToHeap(int num) {
        if(maxHeap.isEmpty()) {
            maxHeap.add(num);
        }else {
            if(maxHeap.size() > minHeap.size()) {
                if(maxHeap.peek() < num) {
                    minHeap.add(num);
                }else {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                }
            }else {
                if(maxHeap.peek() <= num) {
                    minHeap.add(num);
                    maxHeap.add(minHeap.poll());
                }else {
                    maxHeap.add(num);
                }
            }
        }
    }
    
    private double median() {
        if(maxHeap.size()>minHeap.size()) {
            return maxHeap.peek();
        }
        long sum = (long)maxHeap.peek() + (long)minHeap.peek();
        return (double)((sum)/2.0);
    }
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        double[] res = new double[n];
        
        for(int i=0; i<=nums.length; ++i) {
            if(i>=k) {
                res[i-k] = median();
                removeFromHeap(nums[i-k]);
            }
            
            if(i<nums.length) {
                insertToHeap(nums[i]);
            }
        }
        
        return res;
    }
}