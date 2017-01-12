package edu.clemson.cpsc2150.project4;

/**
 * Created by csheare on 11/4/2016.
 */
public class StringQueue1 extends AbstractSQE {
    private String[] myContents;
    private int myFront, myBack, myLength;

    public StringQueue1(int maxLength) {
        myContents = new String[maxLength];
        clear();
    }

    @Override
    public void enqueue(String element) {
        myContents[myBack] = element;
        myBack = (myBack + 1) % myContents.length;
        ++myLength;
    }

    @Override
    public String dequeue() {
        String tmp = myContents[myFront];
        myFront = (myFront + 1) % myContents.length;
        --myLength;
        return tmp;
    }

    @Override
    public String front() {
        return myContents[myFront];
    }

    @Override
    public int length() {
        return myLength;
    }

    @Override
    public int maxLength() {
        return myContents.length;
    }

    @Override
    public void clear() {
        myFront = 0;
        myBack = 0;
        myLength = 0;
    }
}
