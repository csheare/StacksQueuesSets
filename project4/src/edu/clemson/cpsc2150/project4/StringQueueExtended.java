package edu.clemson.cpsc2150.project4;

/**
 * Created by csheare on 11/4/2016.
 */
public interface StringQueueExtended extends StringQueue {
    /**
     * @param element Element to search for in the queue.
     * @ensures
     * contains = Occurs_Ct(element, this) > 0
     */
    boolean contains(String element);
    /**
     * @ensures
     * this = #this
     * queue = this
     */
    void copy(StringQueue queue);
}
