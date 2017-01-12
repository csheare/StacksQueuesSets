package edu.clemson.cpsc2150.project4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csheare on 11/4/2016.
 */
public abstract class AbstractGSE<T> implements GenericSetExtended<T>{
    @Override
    public final void union(GenericSet<T> rhs) {
        List<T> tempRHS = new ArrayList<T>();
        int lengthRHS = rhs.size();
        for(int i = 0;i<lengthRHS;i++) {
            T remove = rhs.removeAny();
            tempRHS.add(i,remove);
        }
        for(int i = 0;i<lengthRHS;i++){
            if(!this.contains(tempRHS.get(i))){
                this.insert(tempRHS.get(i));
            }
        }
        rhs.clear();
    }
    @Override
    public final void intersect(GenericSet<T> rhs) {
        List<T> tempRHS = new ArrayList<T>();
        List<T>  intersectArray = new ArrayList<T>();
        int lengthRHS = rhs.size();
        for(int i = 0;i<lengthRHS;i++) {
            T remove = rhs.removeAny();
            tempRHS.add(i,remove);
        }
        for(int i = 0;i<lengthRHS;i++){
            if(this.contains(tempRHS.get(i))){
                intersectArray.add(tempRHS.get(i));
            }
        }
        rhs.clear();
        this.clear();
        for(int i = 0;i<intersectArray.size();i++){
            this.insert(intersectArray.get(i));
        }

    }
    @Override
    public final void difference(GenericSet<T> rhs) {
        List<T> tempRHS = new ArrayList<T>();
        List<T>  intersectArray = new ArrayList<T>();
        int lengthRHS = rhs.size();

        for(int i = 0;i<lengthRHS;i++) {
            T remove = rhs.removeAny();
            tempRHS.add(i,remove);
        }
        for(int i = 0;i<lengthRHS;i++){
            if(this.contains(tempRHS.get(i))){
                this.remove(tempRHS.get(i));
            }
        }
        rhs.clear();
    }
    @Override
    public final void copy(GenericSet<T> set) {
        T[] tmpArr = (T[]) new Object[this.size()];
        int i = 0;
        while (this.size() > 0) {
            tmpArr[i] = this.removeAny();
            ++i;
        }

        for (i = 0; i < tmpArr.length; ++i) {
            this.insert(tmpArr[i]);
            set.insert(tmpArr[i]);
        }
    }
    @Override
    public final boolean equals(Object obj) {
        boolean equalsFlag = false;
        if (obj != null && obj instanceof GenericSet) {
            GenericSet set = (GenericSet)obj;
            if (this.size() == set.size()) {
                equalsFlag = true;
                T[] tmpArr = (T[])new Object[this.size()];
                int i = 0;
                while (this.size() > 0) {
                    tmpArr[i] = this.removeAny();
                    if (!set.contains(tmpArr[i])) {
                        equalsFlag = false;
                    }
                    ++i;
                }

                for (i = 0; i < tmpArr.length; ++i) {
                    this.insert(tmpArr[i]);
                }
            }
        }
        return equalsFlag;
    }
    /**
     * This method returns a string representation of the set,
     * listing the elements in any order.
     * Example: { elem1, elem2, elem3, elem4 }
     */
    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        T[] tmpArr = (T[]) new Object[this.size()];
        int i = 0;
        while (this.size() > 0) {
            tmpArr[i] = this.removeAny();
            //sb.append(String.format("\"%s\"", tmpArr[i]));
            sb.append(tmpArr[i]);
            if (this.size() > 0) {
                sb.append(", ");
            }
            ++i;
        }

        for(i = 0; i < tmpArr.length; ++i) {
            this.insert(tmpArr[i]);
        }

        sb.append(" }");
        return sb.toString();

    }

}
