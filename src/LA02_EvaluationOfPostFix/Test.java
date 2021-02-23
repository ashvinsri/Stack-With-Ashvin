/**
 *    Evaluate the Postfix Expression
 *    I/P==>  657*42-/+
 *    O/P==>  23.5
 * 
 */
package LA02_EvaluationOfPostFix;
import java.util.*;
/**
 *
 * @author DELL-PC
 */
public class Test {
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        String str=obj.next();
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*' || str.charAt(i)=='/' )
            {
                int m=st.pop();
                int n=st.pop();
                if(str.charAt(i)=='+')
                {
                    st.push((n+m));
                }    
                if(str.charAt(i)=='-')
                {
                    st.push((n-m));
                }
                if(str.charAt(i)=='*')
                {
                    st.push((n*m));
                }
                if(str.charAt(i)=='/')
                {   
                    st.push((n/m));
                }
            }
            else
            {
                st.push((int)str.charAt(i)-(int)'0');
            }
        }
        if(st.size()==1)
            System.out.println(st.pop());
        else
        {
            System.out.println("Wrong Expression!!!");
        }
    }
}
