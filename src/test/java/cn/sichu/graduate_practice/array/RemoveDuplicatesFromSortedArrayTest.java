package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayTest {

    RemoveDuplicatesFromSortedArray rd;
    int[] input1;
    int[] input2;
    int[] expectedNums1;
    int[] expectedNums2;

    @Before
    public void setUp() throws Exception {
        this.rd = new RemoveDuplicatesFromSortedArray();
        this.input1 = new int[] {1, 1, 2};
        this.input2 = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        this.expectedNums1 = new int[] {1, 2};
        this.expectedNums2 = new int[] {0, 1, 2, 3, 4};
    }

    @After
    public void tearDown() throws Exception {
        this.rd = null;
        this.input1 = null;
        this.input2 = null;
        this.expectedNums1 = null;
        this.expectedNums2 = null;
    }

    @Test
    public void test() {
        try {
            int len1 = rd.removeDuplicates(input1);
            assertEquals(len1, expectedNums1.length);

            for (int i = 0; i < len1; i++) {
                assertEquals(input1[i], expectedNums1[i]);
            }
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            int len2 = rd.removeDuplicates(input2);
            assertEquals(len2, expectedNums2.length);

            for (int i = 0; i < len2; i++) {
                assertEquals(input2[i], expectedNums2[i]);
            }
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
