package edu.clemson.cpsc2150.project4;

/**
 * Created by csheare on 11/4/2016.
 */

public interface GenericSet<T> {
/**
 * mathematical model: Set(T)
 * initialization ensures: this = { }
 */
        /**
         * Inserts an element into the set
         * @param element The element to insert
         * @alias element
         * @requires element is_not_in this
         * @ensures this = #this union { element }
         */
        void insert(T element);
        /**
         * Returns true if the element is contained in
         * the set, otherwise false
         * @param element The element to search for
         * @ensures contains = element is_in this
         */
        boolean contains(T element);
        /**
         * Removes the element from the set
         * @param element The element to remove
         * @requires element is_in this
         * @ensures this = #this \ { element }
         */
        void remove(T element);
        /**
         * Removes and returns an arbitrary element
         * from the set
         * @requires |this| > 0
         * @ensures this = #this \ { removeAny }
         */
        T removeAny();
        /**
         * Returns the cardinality of the set
         * @ensures size = |this|
         */
        int size();
        /**
         * Returns the maximum capacity of the set
         * @ensures maxSize = this.maxSize
         */
        int maxSize();
        /**
         * Removes all elements from the set
         * @ensures this = { }
         */
        void clear();
    }
