package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchInsertTest {
    SearchInsert si;
    int[] nums1;
    int[] nums2;
    int[] nums3;
    int[] nums4;
    int[] nums5;
    int target1;
    int target2;
    int target3;
    int target4;
    int target5;
    int output1;
    int output2;
    int output3;
    int output4;
    int output5;

    @Before
    public void setUp() throws Exception {
        this.si = new SearchInsert();
        this.nums1 = new int[] {1, 3, 5, 6};
        this.nums2 = new int[] {1, 3, 5, 6};
        this.nums3 = new int[] {1, 3, 5, 6};
        this.nums4 = new int[] {1, 3, 5, 6};
        this.nums5 = new int[] {1};
        this.target1 = 5;
        this.target2 = 2;
        this.target3 = 7;
        this.target4 = 0;
        this.target5 = 0;
        this.output1 = 2;
        this.output2 = 1;
        this.output3 = 4;
        this.output4 = 0;
        this.output5 = 0;
    }

    @After
    public void tearDown() throws Exception {
        this.si = null;
        this.nums1 = null;
        this.nums2 = null;
        this.nums3 = null;
        this.nums4 = null;
        this.nums5 = null;
        this.target1 = 0;
        this.target2 = 0;
        this.target3 = 0;
        this.target4 = 0;
        this.target5 = 0;
        this.output1 = 0;
        this.output2 = 0;
        this.output3 = 0;
        this.output4 = 0;
        this.output5 = 0;
    }

    @Test
    public void test() {
        try {
            assertEquals(output1, si.searchInsert(nums1, target1));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
        try {
            assertEquals(output2, si.searchInsert(nums2, target2));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
        try {
            assertEquals(output3, si.searchInsert(nums3, target3));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
        try {
            assertEquals(output4, si.searchInsert(nums4, target4));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
        try {
            assertEquals(output5, si.searchInsert(nums5, target5));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
