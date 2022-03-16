package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {

    TwoSum twosum;
    int[] input1;
    int[] input2;
    int[] input3;
    int target1;
    int target2;
    int target3;

    @Before
    public void setUp() throws Exception {
        this.twosum = new TwoSum();
        this.input1 = new int[] {2, 7, 11, 15};
        this.input2 = new int[] {3, 2, 4};
        this.input3 = new int[] {3, 3};
        this.target1 = 9;
        this.target2 = 6;
        this.target3 = 6;
    }

    @After
    public void tearDown() throws Exception {
        this.twosum = null;
        this.input1 = null;
        this.input2 = null;
        this.input3 = null;
        this.target1 = 0;
        this.target2 = 0;
        this.target3 = 0;
    }

    @Test
    public void test() {
        try {
            assertTrue(Arrays.equals(new int[] {0, 1}, twosum.twoSumSolution1(input1, target1)));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertTrue(Arrays.equals(new int[] {1, 2}, twosum.twoSumSolution1(input2, target2)));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertTrue(Arrays.equals(new int[] {0, 1}, twosum.twoSumSolution1(input3, target3)));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertTrue(Arrays.equals(new int[] {0, 1}, twosum.twoSumSolution2(input1, target1)));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertTrue(Arrays.equals(new int[] {1, 2}, twosum.twoSumSolution2(input2, target2)));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertTrue(Arrays.equals(new int[] {0, 1}, twosum.twoSumSolution2(input3, target3)));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
