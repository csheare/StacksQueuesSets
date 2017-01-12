package edu.clemson.cpsc2150.project4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by csheare on 11/4/2016.
 */
public class GenericSet1Test {
    AbstractGSE gs1;

    @Before
    public void setUp() throws Exception {
        gs1 = new GenericSet1<String>(10);
    }
    @Test
    public void insertTest(){
        Assert.assertEquals(gs1.toString(),"{  }");
        gs1.insert("4");
        gs1.insert("2");
        //gs1.insert("4");
        gs1.insert("3");
        gs1.insert("1");
        Assert.assertEquals(gs1.toString(),"{ 1, 3, 2, 4 }");
    }
    @Test
    public void  containsTest(){
        gs1.insert("4");
        gs1.insert("2");
        Assert.assertTrue(gs1.contains("4"));
        Assert.assertFalse(gs1.contains("3"));
    }
    @Test
    public void removeTest(){
        gs1.insert("4");
        gs1.insert("2");
        gs1.insert("3");
        gs1.insert("5");
        Assert.assertEquals(gs1.toString(),"{ 5, 3, 2, 4 }");
        gs1.remove("3");
        Assert.assertEquals(gs1.toString(),"{ 4, 2, 5 }");
        gs1.remove("4");
        Assert.assertEquals(gs1.toString(),"{ 5, 2 }");
        gs1.remove("2");
        Assert.assertEquals(gs1.toString(),"{ 5 }");
    }
    @Test
    public void removeAnyTest(){
        gs1.insert("4");
        gs1.insert("2");
        gs1.insert("3");
        Assert.assertEquals(gs1.toString(),"{ 3, 2, 4 }");
        Assert.assertEquals(gs1.removeAny(),"4");
        Assert.assertEquals(gs1.toString(),"{ 2, 3 }");
    }
    @Test
    public void sizeOfSetTest(){//also test max
        Assert.assertEquals(gs1.size(),0);
        gs1.insert("4");
        gs1.insert("2");
        gs1.insert("3");
        Assert.assertEquals(gs1.size(),3);
        Assert.assertEquals(gs1.maxSize(),10);
    }
    @Test
    public void clearTest(){
        gs1.insert("4");
        gs1.insert("2");
        gs1.insert("3");
        gs1.clear();
        Assert.assertEquals(gs1.toString(),"{  }");
        Assert.assertEquals(gs1.size(),0);
    }
    @Test
    public void unionTest(){
        AbstractGSE<String> gs2 = new GenericSet1(2);

        gs1.insert("4");
        gs1.insert("2");
        gs1.insert("3");

        gs2.insert("1");
        gs2.insert("5");

        Assert.assertEquals(gs1.toString(),"{ 3, 2, 4 }");
        Assert.assertEquals(gs2.toString(),"{ 5, 1 }");

        gs1.union(gs2);

        Assert.assertEquals(gs1.toString(),"{ 5, 1, 4, 2, 3 }");
        Assert.assertEquals(gs2.toString(),"{  }");
    }
    @Test
    public void intersectTest(){
        AbstractGSE<String> gs2 = new GenericSet1(2);

        gs1.insert("4");
        gs1.insert("2");
        gs1.insert("3");

        gs2.insert("2");
        gs2.insert("3");

        Assert.assertEquals(gs1.toString(),"{ 3, 2, 4 }");
        Assert.assertEquals(gs2.toString(),"{ 3, 2 }");

        gs1.intersect(gs2);

        Assert.assertEquals(gs1.toString(),"{ 3, 2 }");
        Assert.assertEquals(gs2.toString(),"{  }");
    }
    @Test
    public void differenceTest(){
        AbstractGSE<String> gs2 = new GenericSet1(2);

        gs1.insert("4");
        gs1.insert("2");
        gs1.insert("3");

        gs2.insert("2");
        gs2.insert("3");

        Assert.assertEquals(gs1.toString(),"{ 3, 2, 4 }");
        Assert.assertEquals(gs2.toString(),"{ 3, 2 }");

        gs1.difference(gs2);

        Assert.assertEquals(gs1.toString(),"{ 4 }");
        Assert.assertEquals(gs2.toString(),"{  }");

    }
    @Test
    public void copyTest(){
        AbstractGSE<String> gs2 = new GenericSet1(3);

        gs1.insert("4");
        gs1.insert("2");
        gs1.insert("3");
        gs1.copy(gs2);
        Assert.assertEquals(gs1.toString(),"{ 4, 2, 3 }");
        Assert.assertEquals(gs2.toString(),"{ 4, 2, 3 }");
    }
    @Test
    public void equalsTest(){
        AbstractGSE<String> gs2 = new GenericSet1(4);
        AbstractGSE<String> gs3 = new GenericSet1(1);
        AbstractGSE<String> gs4 = new GenericSet1(4);
        AbstractGSE<String> gs5 = new GenericSet1(4);

        gs1.insert("4");
        gs1.insert("2");
        gs1.insert("3");

        gs2.insert("4");
        gs2.insert("2");
        gs2.insert("3");

        gs3.insert("4");

        gs4.insert("4");
        gs4.insert("7");
        gs4.insert("3");

        gs5.insert("3");
        gs5.insert("4");
        gs5.insert("2");
        Assert.assertTrue(!gs1.equals(gs3));
        Assert.assertTrue(gs1.equals(gs2));
        Assert.assertTrue(!gs1.equals(gs4));
        Assert.assertTrue(gs1.equals(gs5));
    }

}