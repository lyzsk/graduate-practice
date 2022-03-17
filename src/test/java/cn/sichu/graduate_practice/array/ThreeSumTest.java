package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThreeSumTest {
    ThreeSum threesum;
    int[] intput1;
    int[] intput2;
    int[] intput3;
    List<List<Integer>> output1;

    @Before
    public void setUp() throws Exception {
        this.threesum = new ThreeSum();
        this.intput1 = new int[] {-1, 0, 1, 2, -1, -4};
        this.intput2 = new int[] {};
        this.intput3 = new int[] {0};
        this.output1 = new ArrayList<List<Integer>>();
        output1.add(Arrays.asList(-1, -1, 2));
        output1.add(Arrays.asList(-1, 0, 1));

    }

    @After
    public void tearDown() throws Exception {
        this.threesum = null;
        this.intput1 = null;
        this.intput2 = null;
        this.intput3 = null;
    }

    @Test
    public void test() {
        try {
            assertEquals(output1, threesum.threeSum(intput1));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertEquals(new ArrayList<List<Integer>>(), threesum.threeSum(intput2));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertEquals(Collections.EMPTY_LIST, threesum.threeSum(intput3));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
