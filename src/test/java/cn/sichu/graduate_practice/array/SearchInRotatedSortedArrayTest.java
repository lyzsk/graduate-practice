package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {
    SearchInRotatedSortedArray search;
    int[] nums1, nums2, nums3;
    int target1, target2, target3;
    int output1, output2, output3;

    @Before
    public void setUp() throws Exception {
        this.search = new SearchInRotatedSortedArray();
        this.nums1 = new int[] {4, 5, 6, 7, 0, 1, 2};
        this.nums2 = new int[] {4, 5, 6, 7, 0, 1, 2};
        this.nums3 = new int[] {1};
        this.target1 = 0;
        this.output1 = 4;
        this.target2 = 3;
        this.output2 = -1;
        this.target3 = 0;
        this.output3 = -1;
    }

    @After
    public void tearDown() throws Exception {
        this.search = null;
        this.nums1 = null;
        this.nums2 = null;
        this.nums3 = null;
        this.target1 = 0;
        this.output1 = 0;
        this.target2 = 0;
        this.output2 = 0;
        this.target3 = 0;
        this.output3 = 0;
    }

    @Test
    public void test() {
        try {
            assertTrue(output1 == search.search(nums1, target1));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertTrue(output2 == search.search(nums2, target2));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertTrue(output3 == search.search(nums3, target3));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
