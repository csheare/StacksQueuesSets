package edu.clemson.cpsc2150.project4;

/**
 * Created by csheare on 11/4/2016.
 */
public abstract class AbstractSSE implements StringSetExtended {
    @Override
    public final void union(StringSet rhs, StringSet result) {
        StringSet[] operands = new StringSet[] { this, rhs };
        for (StringSet operand : operands) {
            String[] tmpArr = new String[operand.size()];
            int i = 0;
            while (operand.size() > 0) {
                tmpArr[i] = operand.removeAny();
                if (!result.contains(tmpArr[i])) {
                    result.insert(tmpArr[i]);
                }
                ++i;
            }

            for (i = 0; i < tmpArr.length; ++i) {
                operand.insert(tmpArr[i]);
            }
        }

    }

    @Override
    public final void intersect(StringSet rhs, StringSet result) {
        StringSet biggerSet, smallerSet;
        if (this.size() > rhs.size()) {
            biggerSet = this;
            smallerSet = rhs;
        } else {
            biggerSet = rhs;
            smallerSet = this;
        }

        String[] tmpArr = new String[smallerSet.size()];
        int i = 0;
        while (smallerSet.size() > 0) {
            tmpArr[i] = smallerSet.removeAny();
            if (biggerSet.contains(tmpArr[i])) {
                result.insert(tmpArr[i]);
            }
            ++i;
        }

        for (i = 0; i < tmpArr.length; ++i) {
            smallerSet.insert(tmpArr[i]);
        }
    }

    @Override
    public final void difference(StringSet rhs, StringSet result) {
        String[] tmpArr = new String[this.size()];
        int i = 0;

        while (this.size() > 0) {
            tmpArr[i] = this.removeAny();
            if (!rhs.contains(tmpArr[i])) {
                result.insert(tmpArr[i]);
            }
            ++i;
        }

        for (i = 0; i < tmpArr.length; ++i) {
            this.insert(tmpArr[i]);
        }
    }

    @Override
    public void copy(StringSet set) {
        String[] tmpArr = new String[this.size()];
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
        if (obj != null && obj instanceof StringSet) {
            StringSet set = (StringSet)obj;
            if (this.size() == set.size()) {
                equalsFlag = true;
                String[] tmpArr = new String[this.size()];
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

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        String[] tmpArr = new String[this.size()];
        int i = 0;
        while (this.size() > 0) {
            tmpArr[i] = this.removeAny();
            sb.append(String.format("\"%s\"", tmpArr[i]));
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

