/**
 * 
 * Write a Java Code to convert Infix to PostFix Expression
 * Convert  A+B*C/(E-F) into PostFix Expression
 *      String            |             Stack          |            Output 
 *        A               |    (                       |  A
 *        +               |    (+                      |  A
 *        B               |    (+                      |  AB
 *        *               |    (+*                     |  AB
 *        C               |    (+*                     |  ABC
 *        /               |    (+/                     |  ABC*
 *        (               |    (+/(                    |  ABC*
 *        E               |    (+/(                    |  ABC*E
 *        -               |    (+/(-                   |  ABC*E
 *        F               |    (+/(-                   |  ABC*EF
 *        )               |    (+/                     |  ABC*EF-
 *        )(added)        |     ----empty----          |  ABC*EF-/+
 * 
 *               Output---->   ABC*EF-/+
 */
package LA01_InfixToPostfix;
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
        List<Character> output=infixToPostFix(str);
        for(Character c: output)
        {
            System.out.print(c+" ");
        }
    }
}
