package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RemoveElementTest {
    RemoveElement re;
    int[] input1;
    int val1;
    int[] input2;
    int val2;

    @Before
    public void setUp() throws Exception {
        this.re = new RemoveElement();
        this.input1 = new int[] {3, 2, 2, 3};
        this.input2 = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
        this.val1 = 3;
        this.val2 = 2;
    }

    @After
    public void tearDown() throws Exception {
        this.re = null;
        this.input1 = null;
        this.input2 = null;
        this.val1 = 0;
        this.val2 = 0;
    }

    @Test
    public void test() {
        try {
            assertEquals(2, re.removeElement(input1, val1));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertEquals(5, re.removeElement(input2, val2));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
