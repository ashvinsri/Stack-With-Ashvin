/**
 * Stack is a Last In First Out(LIFO) data structure. It has wide applications in Data Structure and Algorithms.
 * stack=[10,20,30]
 *               ^
 *               |
 *              top
 * push(40)
 * stack= [10,20,30,40]
 *                   ^
 *                   |
 *                  top
 * pop()
 * stack= [10,20,30]
 *                ^
 *                |
 *               top
 */
package L01_ArrayImplementationOfStack;
import java.util.*;
/**
 */
public class Test {
    static int arr[]=new int[100];
    static int top=-1;
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        char ch;
        do{
            System.out.println("1-Push\n2-Pop\n3-Top");
            int choice=obj.nextInt();
            switch(choice)
            {
                case 1:
                {
                    System.out.println("Enter the number to be inserted = ");
                    int d=obj.nextInt();
                    push(d);
                    break;
                }
                case 2:
                {
                    System.out.println("Deleted Element is ="+ pop());
                    break;
                }
                case 3:
                {
                    System.out.println(arr[top]);
                    break;
                }
            }
            System.out.println("Do you want more(Y/N)=>");
            ch=obj.next().charAt(0);
        }while(ch=='y'||ch=='Y');
    }
     static void push(int d)
     {
         if(top==-1)
         {
             top=0;
             arr[top]=d;
         }
         else
         {
             arr[++top]=d;
         }
     }
     static int pop()
     {
         if(top==-1)
         {
             return -1;
         }
         int save=arr[top--];
         return save;
     }
}
