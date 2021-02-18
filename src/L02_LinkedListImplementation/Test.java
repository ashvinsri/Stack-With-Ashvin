/**
 * start--> 30-->20-->10
 *          ^
 *          |
 *         top
 * push(40) Insert 40 at top
 * 
 * start--> 40-->30-->20-->10
 *          ^
 *          |
 *          top
 * pop()
 * 
 * start--> 30-->20-->10
 *          ^
 *          |
 *         top
 */         
 
package L02_LinkedListImplementation;
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d)
    {
      data=d;
      next=null;
    }
}
public class Test {
    static Node top=null;
    public static void main(String args[])
    {
       Scanner obj=new Scanner(System.in);
       char ch;
       do
       {
          System.out.println("1-Push \n 2-Pop");
          int choice=obj.nextInt();
          switch(choice)
          {
              case 1:
              {
                  System.out.println("Enter the data=>");
                  int d=obj.nextInt();
                  push(d);
                  break;
              }
              case 2:
              {
                  System.out.println("Deleted ELement is=>"+pop());
                  break;
              }
          }
          ch=obj.next().charAt(0);
       }while(ch=='y'||ch=='Y');
    }
       static void push(int d)
       {
           Node temp=new Node(d);
           if(top==null)
           {
               top=temp;
           }
               temp.next=top;
               top=temp;
       }
       static int pop()
       {
           if(top==null)
               return -1;
           int save=top.data;
           top=top.next;
           return save;
       }
}
