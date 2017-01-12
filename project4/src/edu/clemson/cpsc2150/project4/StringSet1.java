package edu.clemson.cpsc2150.project4;

/**
 * Created by csheare on 11/4/2016.
 */
public class StringSet1 extends AbstractSSE {
    private String[] myContents;
    private int mySize;

    public StringSet1(int maxSize) {
        myContents = new String[maxSize];
        mySize = 0;
    }

    @Override
    public void insert(String element) {
        myContents[mySize++] = element;
    }

    @Override
    public boolean contains(String element) {
        for (int i = 0; i < mySize; ++i) {
            if (myContents[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(String element) {
        boolean foundFlag = false;
        for (int i = 0; i < mySize; ++i) {
            if (myContents[i].equals(element)) {
                foundFlag = true;
                --mySize;
            }

            if (foundFlag) {
                myContents[i] = myContents[i + 1];
            }
        }
    }

    @Override
    public String removeAny() {
        return myContents[--mySize];
    }

    @Override
    public int size() {
        return mySize;
    }

    @Override
    public int maxSize() {
        return myContents.length;
    }

    @Override
    public void clear() {
        mySize = 0;
    }
}

