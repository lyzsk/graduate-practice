package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MergeSortedArrayTest {
    MergeSortedArray mergeSortedArray;
    int[] firstNums1;
    int[] secNums1;
    int[] expNums1;
    int m1;
    int n1;

    @Before
    public void setUp() throws Exception {
        this.mergeSortedArray = new MergeSortedArray();
        this.firstNums1 = new int[] {1, 2, 3, 0, 0, 0};
        this.secNums1 = new int[] {2, 5, 6};
        this.expNums1 = new int[] {1, 2, 2, 3, 5, 6};
        this.m1 = 3;
        this.n1 = 3;
    }

    @After
    public void tearDown() throws Exception {
        this.mergeSortedArray = null;
        this.firstNums1 = null;
        this.secNums1 = null;
        this.expNums1 = null;
        this.m1 = 0;
        this.n1 = 0;
    }

    @Test
    public void test() {
        mergeSortedArray.mergeSolution1(firstNums1, m1, secNums1, n1);
        try {
            assertTrue(Arrays.equals(expNums1, firstNums1));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
