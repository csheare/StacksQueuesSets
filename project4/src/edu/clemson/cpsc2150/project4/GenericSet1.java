package edu.clemson.cpsc2150.project4;

/**
 * Created by csheare on 11/4/2016.
 */
public class GenericSet1<T> extends AbstractGSE<T> {
    /*
This class uses a standard array implementation, such that
the unique elements of the set are stored in any order
in the array.
invariant 0 <= next <= contents.length
and for all i and j between 0 and next,
if i != j then contents[i] != contents[j]
correspondence maxSize = contents.length;
correspondence conceptual this = Union {contents(i)}
for i = 1 to next
*/
    private int myNext;
    private T[] myContents;

    public GenericSet1(int maxSize) {
        myContents =  (T[]) new Object[maxSize];
        myNext = 0;
    }

    @Override
    public void insert(T element) {
        myContents[myNext++] = element;

    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < myNext; ++i) {
            if (myContents[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(T element) {
        boolean foundFlag = false;
        for (int i = 0; i < myNext; ++i) {
            if (myContents[i].equals(element)) {
                foundFlag = true;
                --myNext;
            }

            if (foundFlag) {
                myContents[i] = myContents[i + 1];
            }
        }

    }

    @Override
    public T removeAny() {
        return myContents[--myNext];
    }

    @Override
    public int size() {
        return myNext;
    }

    @Override
    public int maxSize() {
        return myContents.length;
    }

    @Override
    public void clear() {
        myNext = 0;

    }
}
