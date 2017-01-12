package edu.clemson.cpsc2150.project4;

/**
 * Created by csheare on 11/4/2016.
 */
public interface StringSetExtended extends StringSet {
    /**
     * @param rhs The right-hand-side of the union operation,
    i.e. the set to union with this
     * @param result The set which will contain the result
    of the union operation
     * @requires
     * result = { }
     * result.maxSize >= |this| + |rhs|
     * @ensures
     * this = #this
     * rhs = #rhs
     * result = this union rhs
     * @updates result
     */
    void union(StringSet rhs, StringSet result);
    /**
     * @param rhs The right-hand-side of the intersect operation,
    i.e. the set to intersect with this
     * @param result The set which will contain the result
    of the intersect operation
     * @requires
     * result = { }
     * result.maxSize >= |this| or result.maxSize >= |rhs|
     * @ensures
     * this = #this
     * rhs = #rhs
     * result = this intersect rhs
     * @updates result
     */
    void intersect(StringSet rhs, StringSet result);
    /**
     * @param rhs The right-hand-side of the difference operation,
    i.e. the set to subtract from this
     * @param result The set which will contain the result
    of the difference operation
     * @requires
     * result = { }
     * result.maxSize >= |this|
     * @ensures
     * this = #this
     * rhs = #rhs
     * result = this \ rhs
     * @updates result
     */
    void difference(StringSet rhs, StringSet result);
    /**
     * @ensures
     * this = #this
     * queue = this
     * @updates queue
     *
     */
    void copy(StringSet set);
}

