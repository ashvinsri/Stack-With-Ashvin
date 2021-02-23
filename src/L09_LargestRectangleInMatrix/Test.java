/**
 * Problem is to find the largest area rectangle with all 1's
 * 
 * arr[][] =  { 0  1  1  0                  0  1  1  0         res1=largestAreaHistogram([0,1,1,0],4)  = 2    
 *              1  1  1  1      ----->      1  2  2  1         res2=largestAreaHistogram([1,2,2,1],4)  = 4
 *              1  1  1  1                  2  3  3  2 ------> res3=largestAreaHistogram([2,3,3,2],4)  = 8    ---->    max=8 is the largest area rectangle
 *              1  1  0  0 }                3  4  0  0         res4=largestAreaHistogram([3,4,0,0],4)  = 6
 * 
 * 
 */
package L09_LargestRectangleInMatrix;
import java.util.*;
/**
 *
 * @author DELL-PC
 */
public class Test {
    static int largestAreaHistogram(int arr[],int n)
    {
        int res=1;
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && (arr[st.peek()]>=arr[i]))
            {
                int tp=st.pop();
                int curr=arr[tp]*(st.isEmpty()?i:i-st.peek()-1);
                res=Math.max(res,curr);
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            int tp=st.pop();
            int curr=arr[tp]*(st.isEmpty()?n:n-st.peek()-1);
            res=Math.max(res, curr);
        }
        return res;
    }
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        int m=obj.nextInt();
        int n=obj.nextInt();
        int arr[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=obj.nextInt();
            }
        }
        int res=largestAreaHistogram(arr[0],n);
        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==1)
                {
                    arr[i][j]=arr[i-1][j]+arr[i][j];
                }
            }
             res=Math.max(res,largestAreaHistogram(arr[i],n));
        }
        System.out.println(res);
    }
}
