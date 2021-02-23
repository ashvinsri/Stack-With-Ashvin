/**
 * 
 *   Largest Rectangular Area Histogram
 *   arr[]= [6 2 5 4 1 5 6]
 *         6           6
 *        | |  5     5| |
 *        | | | |4  | | |
 *        | | | | | | | |
 *        | |2| | | | | |
 *        | | | | |1| | |
 *        | | | | | | | |
 *    O/P =  10
 *    Idea is to find the previous smaller and the next smaller element 
 * 
 */
package L08_LargestRectangularAreaHistogram;
import java.util.*;
/**
 *
 * @author DELL-PC
 */
public class Test {
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        int n=obj.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=obj.nextInt();
        }
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
        System.out.println(res);
    }
}
