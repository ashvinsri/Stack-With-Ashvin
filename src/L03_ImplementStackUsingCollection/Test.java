/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package L03_ImplementStackUsingCollection;
import java.util.*;
/**
 *
 * @author DELL-PC
 */
public class Test {
    public static void main(String args[])
    {
        Stack<Integer> stack=new Stack<Integer>();
        stack.add(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        /**
         *         40<--- stack.peek()
         *         30
         *         20
         *         10
         *          stack.pop()
         *         30<--- stack.peek()
         *         20
         *         10
         */
        System.out.println(stack.peek());  //First ELement of Stack
        stack.pop();
        
        
    }
}
