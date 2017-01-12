package edu.clemson.cpsc2150.project4;

/**
 * Created by csheare on 11/4/2016.
 */
public interface StringSet {
    /**
      * mathematical model finite set(Z);
      * initialization ensures this = {};
      * defines maxSize: N;
      * constraints |this| <= maxSize;
      */
    /** @param element is the Integer element to be inserted
     * @requires this !=null && !Occurs_cn(element, this)
     * @ensures #this =  {element} union this
     */
    void insert(String element);
    /**@param element is the Integer element to be inserted
     * @requires this !=null && |this| > 0
     * @ensures #this = this
     * @returns true iff element is in this
     *
     */
    boolean contains(String element);
    /**
     * @param element is the Integer element to be inserted
     * @requires this !=null && |this| > 0
     * @ensures #this = this \ {element}
     */
    void remove(String element);
    /**
     *@requires this !=null
     * @ensures #this =  this union (what is returned)
     * @returned random element of this
     */
    String removeAny();
    /**
     *@requires this !=null
     * @ensures #this = this
     * @returns |this|
     */
    int size();
    /**
     * @return The maximum depth of the stack.
     *@requires return this.length?
     */
    int maxSize();
    /**
      * @ensures
      * this = < >
      */
    void clear();

}
