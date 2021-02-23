/**
 * 
 * Convert the given Infix to Prefix Expression
 * 
 * Step 1 -> Reverse the given String of Expression
 * Step 2 -> Change the '(' to ')' and change ')' to '('
 * Step 3 -> Convert this resulting Expression to Postfix
 * Step 4 -> Prnt the reverse of the Result
 * 
 */
package LA03_InfixToPrefix;
import java.util.*;
/**
 *
 * @author DELL-PC
 */
public class Test {
        static ArrayList<Character> infixToPostFix(String str)
    {
        ArrayList<Character> output = new ArrayList<Character>();
        Stack<Character> st=new Stack<Character>();
        st.push('(');
        str=str+")";
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='(')
                st.push(str.charAt(i));
            else if(str.charAt(i)=='+' || str.charAt(i)=='-')
            {
                    while(!st.isEmpty() && (st.peek()!='('))
                    {    
                    output.add(st.pop());               // Since + and - has lowest precedence so all the operators present before that in stack till '(' is transferred to output array 
                    }
                    st.push(str.charAt(i));
            }
             else if(str.charAt(i)=='*' || str.charAt(i)=='/')
            {
                if(!st.isEmpty() && (st.peek()=='+' || st.peek()=='-'))
                {
                        st.push(str.charAt(i));
                }
                else if(!st.isEmpty() && (st.peek()=='*'||st.peek()=='/'))
                {
                   output.add(st.pop());
                }
                st.push(str.charAt(i));
            }
             else if(str.charAt(i)==')')
             {
                 while(!st.isEmpty() && st.peek()!='(')
                 {
                     output.add(st.pop());
                 }
                 st.pop();    
             }
            else
             {
                 output.add(str.charAt(i));
             }
        }
        return output;
    }
        public static void main(String args[])
        {
            Scanner obj=new Scanner(System.in);
            String str=obj.next();
            StringBuffer sb=new StringBuffer(str);
            sb.reverse();
            for(int i=0;i<sb.length();i++)
            {
                if(sb.charAt(i)=='(')
                    sb.replace(i, i+1, ")");
               else if(sb.charAt(i)==')')
                    sb.replace(i, i+1, "(");
            }
            str=sb.toString();
            List<Character> l=infixToPostFix(str);
            for(int i=l.size()-1;i>=0;i--)
            {
                System.out.print(l.get(i)+" ");
            }
        }
    
}
