package edu.clemson.cpsc2150.project4;

/**
 * Created by csheare on 11/4/2016.
 */
public interface StringQueue {
    /**
      * mathematical model finite Str(Z);
      * initialization ensures this = <>;
      * defines maxSize: N;
      * constraints |this| <= maxSize;
      */

    /**
      * @param
      * element Element to be enqueued into the queue.
      * @requires
      * element != null and |this| < maxSize
      * @ensures
      * #element = element
      * this = #this o <element>
      */
    void enqueue(String element);
    /**
      * @return
      * The dequeued element.
      * @requires
      * |this| > 0
      * @ensures
      * |#this| = |<return> o this| 
      * @return dequeued element
      */
    String dequeue();
    /**
     * @return
      * The element at the front of the queue.
      * @requires
      * |this|>0
      * @ensures
      * this = #this and return = Prt_Btwn(0,1,this)
      * @return Integer element
      */
    String front();
    /**
      * @return
      * The length of the queue.
      * @ensures
      * #this = this and
      * return = |this|
      */
    int length();
    /**
     * @return The maximum depth of the stack.
     *@requires return this.length
     */
    int maxLength();
    /**
      * @ensures
      * this = < >
      */
    void clear();

}

