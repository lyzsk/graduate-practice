package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FourSumTest {
    FourSum foursum;
    int[] input1;
    int[] input2;
    int target1;
    int target2;
    List<List<Integer>> res1;
    List<List<Integer>> res2;

    @Before
    public void setUp() throws Exception {
        this.foursum = new FourSum();
        this.input1 = new int[] {1, 0, -1, 0, -2, 2};
        this.target1 = 0;
        this.input2 = new int[] {2, 2, 2, 2, 2};
        this.target2 = 8;
        this.res1 = new ArrayList<List<Integer>>();
        res1.add(Arrays.asList(-2, -1, 1, 2));
        res1.add(Arrays.asList(-2, 0, 0, 2));
        res1.add(Arrays.asList(-1, 0, 0, 1));
        this.res2 = new ArrayList<List<Integer>>();
        res2.add(Arrays.asList(2, 2, 2, 2));
    }

    @After
    public void tearDown() throws Exception {
        this.foursum = null;
        this.input1 = null;
        this.target1 = 0;
        this.input2 = null;
        this.target2 = 0;
        this.res1 = null;
        this.res2 = null;
    }

    @Test
    public void test() {
        try {
            assertEquals(res1, foursum.fourSum(input1, target1));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertEquals(res2, foursum.fourSum(input2, target2));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
