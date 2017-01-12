package edu.clemson.cpsc2150.project4;

import java.util.ArrayList;

/**
 * Created by csheare on 11/4/2016.
 */
public class GenericSet2<T> extends AbstractGSE<T> {
    /*
This class uses an ArrayList implementation, such
that the unique elements of the set are stored in any order
in an instance of java.util.ArrayList
invariant for all e: T, Occurs_Ct(e, list) <= 1;
correspondence conceptual this = Entries(list);
*/
    private ArrayList<T> myContents;

    public GenericSet2() {
        myContents = new ArrayList<T>();
    }

    @Override
    public void insert(T element) {
        myContents.add(element);

    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < myContents.size(); ++i) {
            if (myContents.get(i).equals(element)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public void remove(T element) {
        boolean foundFlag = false;
        for (int i = 0; i < myContents.size(); ++i) {
            if (myContents.get(i).equals(element)) {
                foundFlag = true;
                myContents.remove(i);
            }

        }

    }

    @Override
    public T removeAny() {
        T remove = myContents.get(myContents.size()-1);//maybe should be size()-1
        myContents.remove(myContents.size()-1);
        return remove;
    }

    @Override
    public int size() {
        return myContents.size();
    }

    @Override
    public int maxSize() {
        return 10000000;
    }

    @Override
    public void clear() {
        int size = myContents.size();
        for (int i = 0; i < size; i++) {
            myContents.remove(0);
        }

    }
}
