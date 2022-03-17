package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThreeSumClosestTest {

    ThreeSumClosest tsc;
    int[] input1;
    int target1;
    int[] input2;
    int target2;

    @Before
    public void setUp() throws Exception {
        this.tsc = new ThreeSumClosest();
        this.input1 = new int[] {-1, 2, 1, -4};
        this.input2 = new int[] {0, 0, 0};
        this.target1 = 1;
        this.target2 = 1;
    }

    @After
    public void tearDown() throws Exception {
        this.tsc = null;
        this.input1 = null;
        this.input2 = null;
        this.target1 = 0;
        this.target2 = 0;
    }

    @Test
    public void test() {
        try {
            assertEquals(2, tsc.threeSumClosest(input1, target1));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertEquals(0, tsc.threeSumClosest(input2, target2));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
