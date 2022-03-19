package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FindFirstLastPositionInSortedArrayTest {
    FindFirstLastPositionInSortedArray searchrange;
    int[] input1, input2, input3, output1, output2, output3;
    int target1, target2, target3;

    @Before
    public void setUp() throws Exception {
        this.searchrange = new FindFirstLastPositionInSortedArray();
        this.input1 = new int[] {5, 7, 7, 8, 8, 10};
        this.input2 = new int[] {5, 7, 7, 8, 8, 10};
        this.input3 = new int[] {};
        this.target1 = 8;
        this.target2 = 6;
        this.target3 = 0;
        this.output1 = new int[] {3, 4};
        this.output2 = new int[] {-1, -1};
        this.output3 = new int[] {-1, -1};
    }

    @After
    public void tearDown() throws Exception {
        this.searchrange = null;
        this.input1 = null;
        this.input2 = null;
        this.input3 = null;
        this.target1 = 0;
        this.target2 = 0;
        this.target3 = 0;
        this.output1 = null;
        this.output2 = null;
        this.output3 = null;
    }

    @Test
    public void test() {
        try {
            assertTrue(Arrays.equals(output1, searchrange.searchRange(input1, target1)));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertTrue(Arrays.equals(output2, searchrange.searchRange(input2, target2)));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertTrue(Arrays.equals(output3, searchrange.searchRange(input3, target3)));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
