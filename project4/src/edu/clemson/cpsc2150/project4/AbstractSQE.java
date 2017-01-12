package edu.clemson.cpsc2150.project4;

/**
 * Created by csheare on 11/4/2016.
 */
public abstract class AbstractSQE implements StringQueueExtended {
    @Override
    public final boolean contains(String element) {
        boolean containsFlag = false;
        String tmp;
        for (int i = 0; i < this.length(); ++i) {
            tmp = this.dequeue();
            if (tmp.equals(element)) {
                containsFlag = true;
            }
            this.enqueue(tmp);
        }
        return containsFlag;
    }

    @Override
    public final void copy(StringQueue queue) {
        String tmp;
        for (int i = 0; i < this.length(); ++i) {
            tmp = this.dequeue();
            queue.enqueue(tmp);
            this.enqueue(tmp);
        }
    }

    @Override
    public final boolean equals(Object obj) {
        boolean equalsFlag = false;
        if (obj != null && obj instanceof StringQueue) {
            StringQueue queue = (StringQueue)obj;
            if (this.length() == queue.length()) {
                equalsFlag = true;
                String tmp1, tmp2;
                for (int i = 0; i < this.length(); ++i) {
                    tmp1 = this.dequeue();
                    tmp2 = queue.dequeue();
                    if (!tmp1.equals(tmp2)) {
                        equalsFlag = false;
                    }
                    this.enqueue(tmp1);
                    queue.enqueue(tmp2);
                }
            }
        }
        return equalsFlag;
    }
    /**
     * This method returns a string representation of the queue,
     * listing the elements from front to back.
     * Example: [ "front", "elem2", "elem3", "back" ]
     */
    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        String tmp;
        for (int i = 0; i < this.length(); ++i) {
            tmp = this.dequeue();
            sb.append(String.format("\"%s\"", tmp));
            if (i < length()) {
                sb.append(", ");
            }
            this.enqueue(tmp);
        }
        sb.append(" ]");
        return sb.toString();
    }
}
