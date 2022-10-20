class Solution
{
public ListNode mergeKLists(ListNode[] lists) 
{
 ArrayList<Integer> a=new ArrayList<Integer>();
 for(int i=0;i<lists.length;i++)
 { 
while (lists[i] != null) 
{ 
a.add(lists[i].val);
lists[i] = lists[i].next;
 }
 }
 int arr[]=new int[a.size()];
 for(int k=0;k<arr.length;k++)
 {
 arr[k]=a.get(k);
 }
 Arrays.sort(arr);
 ListNode head=null;
 ListNode tail=null;
 for(int i=0;i<arr.length;i++) 
{
 ListNode node=new ListNode(arr[i]);
 if(head==null) 
{
 head=node; 
tail=node; 
}
else
{
 tail.next=node;
 tail=node;
 } 
}
 return head; 
} 

}
