/**
 * Span:- Span means the number of lft day values which are smaller or equal to the current.
 *       Efficient idea is :- 
 *       0    1    2   3    4  5 
 *      30   20   25   28  27  29 
 * span= 1    1   2    3    1  5
 *  check for the index of previous greater element if possible then (current index - index of previous greater element otherwise current index-1; 
 */
package L06_StackSpanProblem;
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
        Stack<Integer> st=new Stack<Integer>();
        st.push(0);
        System.out.print(1+" ");
        for(int i=1;i<n;i++)
        {
            while(!st.isEmpty() && arr[i]>arr[st.peek()])
            {
                st.pop();
            }
            int span=st.isEmpty()?i+1:(i-st.peek());
            System.out.print(span+" ");
            st.push(i);
        }
    }           
}
       