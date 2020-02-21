/*
Created By
akaanksha
on 21/02/20
*/
//Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. (Expected complexity ­ O(1))
import java.util.Stack;


class Q8_Stack extends Stack<Integer>
{
    Stack<Integer> min = new Stack<>();
    void push(int x)
    {
        if(isEmpty() == true)
        {
            super.push(x);
            min.push(x);
        }
        else
        {
            super.push(x);
            int y = min.pop();
            min.push(y);
            if(x < y)
                min.push(x);
            else
                min.push(y);
        }
    }
    public Integer pop()
    {
        int x = super.pop();
        min.pop();
        return x;
    }

    int getMin()
    {
        int x = min.pop();
        min.push(x);
        return x;
    }

    public static void main(String[] args)
    {
        Q8_Stack s = new Q8_Stack();
        s.push(10);
        s.push(2);
        s.push(3);
        System.out.println("stack=="+s);
        System.out.println("min element "+s.getMin());
        s.push(1);
        System.out.println("stack=="+s);
        System.out.println("min element "+s.getMin());
    }
}