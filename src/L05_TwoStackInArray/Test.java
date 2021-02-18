/**
 * 
 *  st[] =  10  20  30  __  __  __  __  80 90 100
 *                  ^                    ^
 *                  |                    |
 *                 top1                 top2
 * 
 *   start top1 from left side and top2 from right side and stop when top1 and top2 became neighbor in this way we
 *   will save space
 * 
 */
package L05_TwoStackInArray;
import java.util.*;
/**
 *
 * @author DELL-PC
 */
public class Test {
    static int top1=0,n=20;   // Initial condition top1 will start from left and top2 will start from right
    static int top2=n;
    static int arr[]=new int[n];
    static void push1(int d)
    {
        if(top1==n || top1==top2-1)
            System.out.println("Overflow");
        else
        {
            arr[++top1]=d;
        }
            
    }
    static void push2(int d)
    {
        if(top2==-1 || top2==top1+1)
            System.out.println("Overflow");
        else
        {
            arr[--top2]=d;
        }
            
    }
    static int pop1()
    {
        if(top1==-1)
            return -1;
        int save=arr[top1];
        top1--;
        return save;
    }
    static int pop2()
    {
        if(top2==n)
            return -1;
        int save=arr[top2];
        top2++;
        return save;
    }
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        int arr[]=new int[n];
        char ch;
        do
        {
           System.out.println("1-PUSH1()\n 2-PUSH2() \n 3-POP1() \n 4-POP2()");
           int choice=obj.nextInt();
           switch(choice)
           {
               case 1:
               {
                   System.out.println("Enter the data");
                   int data=obj.nextInt();
                   push1(data);
                   break;
               }
                case 2:
               {
                   System.out.println("Enter the data");
                   int data=obj.nextInt();
                   push2(data);
                   break;
               }
                case 3:
               {
                   System.out.println("Deleted Element is="+pop1());
                   break;
               }
                case 4:
               {
                   System.out.println("Deleted Element is="+pop2());
                   break;
               }
           }
           System.out.println("Do you want more (Y/y)=>");
           ch=obj.next().charAt(0);
        }while(ch=='y'||ch=='Y');
    }
    
}
