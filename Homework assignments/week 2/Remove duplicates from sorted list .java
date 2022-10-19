class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev =head;
        ListNode temp = head;
        while(temp!=null){
            if(prev.val!=temp.val){
                prev.next = temp;
                prev = temp;
            }
            temp = temp.next;
        }
        if(prev!=temp){
            prev.next = null;
        }
        return head;
    }
}