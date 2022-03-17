package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlusOneTest {
    PlusOne plusOne;
    int[] digits1, digits2, digits3;
    int[] output1, output2, output3;

    @Before
    public void setUp() throws Exception {
        this.plusOne = new PlusOne();
        this.digits1 = new int[] {1, 2, 3};
        this.digits2 = new int[] {4, 3, 2, 1};
        this.digits3 = new int[] {0};

        this.output1 = new int[] {1, 2, 4};
        this.output2 = new int[] {4, 3, 2, 2};
        this.output3 = new int[] {1};
    }

    @After
    public void tearDown() throws Exception {
        this.plusOne = null;
        this.digits1 = null;
        this.digits2 = null;
        this.digits3 = null;

        this.output1 = null;
        this.output2 = null;
        this.output3 = null;
    }

    @Test
    public void test() {
        try {
            assertTrue(Arrays.equals(output1, plusOne.plusOne(digits1)));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertTrue(Arrays.equals(output2, plusOne.plusOne(digits2)));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertTrue(Arrays.equals(output3, plusOne.plusOne(digits3)));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
