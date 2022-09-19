import java.lang.Math.*;
class Solution {
    public boolean isPalindrome(int x) {
        int len=0;
        if(x<0)
        {
            return false;
        }
        int n=x;
        while(n>0)
        {
            len++;
            n/=10;
        }
        int arr[]=new int[len];
        int i=0;
        while(x>0)
        {
            arr[i]=x%10;
            x/=10;
            i++;
        }
        int left=0;
        int right=arr.length-1;
        while(left<right)
        {
            if(arr[left]!=arr[right])
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
        
    }
}