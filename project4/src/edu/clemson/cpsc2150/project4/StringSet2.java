package edu.clemson.cpsc2150.project4;

/**
 * Created by csheare on 11/4/2016.
 */
public class StringSet2 extends AbstractSSE {

    private StringQueueExtended myQueue;

    public StringSet2(StringQueueExtended queue) {
        myQueue = queue;
    }

    @Override
    public void insert(String element) {
        myQueue.enqueue(element);
    }

    @Override
    public boolean contains(String element) {
        return myQueue.contains(element);
    }

    @Override
    public void remove(String element) {
        String tmp;
        int length = myQueue.length();
        for (int i = 0; i < length; ++i) {
            tmp = myQueue.dequeue();
            if (!tmp.equals(element)) {
                myQueue.enqueue(tmp);
            }
        }
    }

    @Override
    public String removeAny() {
        return myQueue.dequeue();
    }

    @Override
    public int size() {
        return myQueue.length();
    }

    @Override
    public int maxSize() {
        return myQueue.maxLength();
    }

    @Override
    public void clear() {
        myQueue.clear();
    }
}
