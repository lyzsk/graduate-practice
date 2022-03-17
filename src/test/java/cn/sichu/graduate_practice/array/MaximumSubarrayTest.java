package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MaximumSubarrayTest {
    MaximumSubarray maxSubarray;
    int[] nums1, nums2, nums3;
    int output1, output2, output3;

    @Before
    public void setUp() throws Exception {
        this.maxSubarray = new MaximumSubarray();
        this.nums1 = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        this.nums2 = new int[] {1};
        this.nums3 = new int[] {5, 4, -1, 7, 8};
        this.output1 = 6;
        this.output2 = 1;
        this.output3 = 23;
    }

    @After
    public void tearDown() throws Exception {
        this.maxSubarray = null;
        this.nums1 = null;
        this.nums2 = null;
        this.nums3 = null;
        this.output1 = 0;
        this.output2 = 0;
        this.output3 = 0;
    }

    @Test
    public void test() {
        try {
            assertEquals(output1, maxSubarray.maxSubArray(nums1));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertEquals(output2, maxSubarray.maxSubArray(nums2));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertEquals(output3, maxSubarray.maxSubArray(nums3));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
