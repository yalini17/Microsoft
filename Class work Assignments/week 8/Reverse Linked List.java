class Solution 
{ 
public ListNode reverseList(ListNode head)
{ 
ListNode res = null; 
ListNode temp = head;
while (temp != null) 
{
ListNode node = temp; 
    temp = temp.next; node.next = res; 
    res = node;
} return res; 
}
}
