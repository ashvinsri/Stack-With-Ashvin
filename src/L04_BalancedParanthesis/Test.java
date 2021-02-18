/**
 * Balance the Paranthesis using Stack
 * String            Stack
 *  [                [             push([)
 *  {                [{            push({)
 *  }                [             check if top is { then pop() 
 *  {                [{            push({)
 *  (                [(            push(()
 *  )                [             check if top is ( then pop()
 *  ]              --empty--       check if top is [ then pop()4
 * 
 *       if at any step condition is false then return false
 *       if at last stack is empty then return true else false
 * 
 */
package L04_BalancedParanthesis;
import java.util.*;

/**
 *
 * @author DELL-PC
 */

public class Test {
    static boolean isBalancedParanthesis(String str)
    {
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='[')
            {
                st.push(str.charAt(i));
                continue;
            }
            if(!st.isEmpty()&&((str.charAt(i)==')' && st.peek()=='(')||(str.charAt(i)=='}' && st.peek()=='{') || (str.charAt(i)==']' && st.peek()=='[')))
            {
                st.pop();
            }
            else
            {
                return false;
            }
        }
            if(st.isEmpty())
               return true;
            return false;
    }
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        String str=obj.next();
        System.out.println(isBalancedParanthesis(str));
    }
}
