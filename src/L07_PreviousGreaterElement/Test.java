/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package L07_PreviousGreaterElement;
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
        st.push(arr[0]);
        System.out.print(1+" ");
        for(int i=1;i<n;i++)
        {
            while(!st.isEmpty() && arr[i]>st.peek())
            {
                st.pop();
            }
            int ele=st.isEmpty()?-1:(st.peek());
            System.out.print(ele+" ");
            st.push(arr[i]);
        }
    }
}
