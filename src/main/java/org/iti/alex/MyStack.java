package org.iti.alex;

import java.util.ArrayList;

public class MyStack {

    ArrayList<String> myStack;

    public MyStack() {
        myStack = new ArrayList<String>();
    }

    public void push(String element) {
        myStack.add(element);
    }

    public String pop() {
        String poppedItem;
        if (getCurrentStack().isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Out of Bound Exception");
        }
        poppedItem = myStack.remove(myStack.size() - 1);
        return poppedItem;
    }

    public ArrayList<String> getCurrentStack() {
        return myStack;
    }

    public String getStackPeek() {
        if (myStack.isEmpty()) {
            return null;
        }
        return myStack.get(myStack.size() - 1);
    }

    public int getSize() {
        return myStack.size();
    }


}