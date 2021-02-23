/**
 * Design a stack with getmin() feature where we can detect current minimum of Stack
 * 
 */
package L10_CurrentMinimumInStack;
import java.util.*;
/**
 *
 * @author DELL-PC
 */
public class Test {
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        Stack<Integer> st=new Stack<Integer>();
        Stack<Integer> min=new Stack<Integer>();
        char ch;
        do
        {
            System.out.println("1- PUSH \n2- POP \n3- GETMIN");
            int choice=obj.nextInt();
            switch(choice)
            {
                case 1:
                {
                 int d=obj.nextInt();   
                 st.push(d);
                 if(min.isEmpty())
                     min.push(d);
                 else
                 {
                     if(d<min.peek())
                         min.push(d);
                     else
                         min.push(min.peek());
                 }
                 break;   
                }
                case 2:
                {
                 if(!st.isEmpty())
                 {
                 st.pop();
                 min.pop();
                 }
                 break;    
                }
                case 3:
                {
                 if(!min.isEmpty())   
                 System.out.println(min.peek());
                 else
                 System.out.println("No ELement In Stack");    
                 break;   
                }
            }
            System.out.println("Do You Want More?(Y/N)?");
            ch=obj.next().charAt(0);
        }while(ch=='y'||ch=='Y');
    }
}
