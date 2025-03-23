import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class StackOperations {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       Stack<Integer>stack=new Stack<>();
       stack.add(1);
       stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);
        stack.add(7);
        stack.add(8);
        stack.add(9);
        stack.add(10);
        System.out.println("the stack elements "+stack);
        System.out.println("enter a index and number for insertion");
        int index=sc.nextInt();
        int number=sc.nextInt();
        stack.add(index,number);
        System.out.println("after insertion "+stack);
        System.out.println("this is also add the element but replace the element and add the element at that index");
        stack.set(index,number);
        System.out.println(("after set the element at particular index "+stack));
        System.out.println("it can retrivve the element at particular index "+stack.get(index));
        System.out.println("remove the last inserted element "+stack.pop());
        System.out.println("after the remove the element in the stack "+stack);
        System.out.println("it can access the top element in the stack "+stack.peek());
        stack.push(number);
        System.out.println("after push a elemet "+stack);
        System.out.println("it can check the is stack is empty or not "+stack.empty());
        System.out.println("enter a number to find the index of the element from last");
        int searc=sc.nextInt();
        System.out.println(stack.search(searc));
        Stack<Integer>stack2=new Stack<>();
        stack2.add(20);
        stack2.add(21);
        stack2.add(22);
        stack2.add(23);
        stack2.add(24);
        stack2.add(25);
        stack2.add(26);
        stack2.add(27);
        stack.addAll(stack2);
        System.out.println("after adding of the elements "+stack);
        stack.addElement(199);//the element is added at the end of the stack
        System.out.println("after adding a element "+stack);
        System.out.println("the capacity of the given stack is "+stack.capacity());
        System.out.println("after cloning the stack "+stack.clone());
        System.out.println("to check the all elements are there in stack2 in stack "+stack.containsAll(stack2));
        System.out.println("enter a index to access the element at index");
        int inde=sc.nextInt();
        System.out.println(stack.elementAt(inde));
        System.out.println(stack.equals(6));
        System.out.println("print the first element in the stack "+stack.firstElement());
        System.out.println("access the lase element in the stack "+stack.lastElement());
        System.out.println("check is the stack is empty or not "+stack.isEmpty());
        System.out.println("print the hash code of the stack "+stack.hashCode());
        System.out.println("enter a number to find the index of the element ");
        int a=sc.nextInt();
        System.out.println("print the index of the element "+stack.indexOf(a));
        System.out.println("the size of the stack is "+stack.size());
        Collections.sort(stack);
        System.out.println("after sorting "+stack);
        System.out.println("enter starting index and ending index");
        int starting=sc.nextInt();
        int end=sc.nextInt();
        System.out.println("this is sub stack "+stack.subList(starting,end));
        System.out.println("enter a number to remove it from stack");//this is for inded
        int num=sc.nextInt();
        stack.remove(num);
        System.out.println("after remove a number "+stack);
        System.out.println("enter a index to remove a number at given index");//this is also index
        int ind=sc.nextInt();
        stack.remove(ind);
        System.out.println("after delete a number "+stack);
        //System.out.println("convert the given stack into array "+stack.toArray());

    }
}
