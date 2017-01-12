package edu.clemson.cpsc2150.project4;

/**
 * Created by csheare on 11/4/2016.
 */
public class StringQueue2 extends AbstractSQE {
    private String[] myContents;
    private int myBack;

    public StringQueue2(int maxLength) {
        myContents = new String[maxLength];
        myBack = 0;
    }

    @Override
    public void enqueue(String element) {
        myContents[myBack++] = element;
    }

    @Override
    public String dequeue() {
        String tmp = myContents[0];
        --myBack;
        for (int i = 0; i < myBack; ++i) {
            myContents[i] = myContents[i + 1];
        }
        return tmp;
    }

    @Override
    public String front() {
        return myContents[0];
    }

    @Override
    public int length() {
        return myBack;
    }

    @Override
    public int maxLength() {
        return myContents.length;
    }

    @Override
    public void clear() {
        myBack = 0;
    }
}
