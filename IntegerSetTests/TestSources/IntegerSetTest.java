import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntegerSetTest{
    IntegerSet testSet;
    @Before
    public void setup(){
        testSet = new IntegerSet();
    }
    @Test
    public void testInsertNotThere(){
        //checks if number is in set
        assertEquals(testSet.size(), 0);
        assertFalse(testSet.contains(2));
        //insert a number
        testSet.insert(2);
        //check the number is in the set
        assertEquals(testSet.size(), 1);
        assertTrue(testSet.contains(2));
    }
    @Test
    public void testInsertAlreadyThere(){
        //insert a number
        testSet.insert(3);
        //checks if set contains a number
        assertTrue(testSet.contains(3));
        assertEquals(testSet.size(), 1);
        //insert an existing number
        testSet.insert(3);
        //checks if set still contains only 1 number
        assertEquals(testSet.size(), 1);
    }
    @Test
    public void testRemove(){
        //insert a number
        testSet.insert(4);
        //check the number is in set
        assertEquals(testSet.size(), 1);
        assertTrue(testSet.contains(4));
        ///remove a number
        testSet.remove(4);
        //check the number is not in set
        assertEquals(testSet.size(), 0);
        assertFalse(testSet.contains(4));
    }
}
