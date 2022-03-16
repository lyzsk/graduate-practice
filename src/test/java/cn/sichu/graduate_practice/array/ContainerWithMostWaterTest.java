package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContainerWithMostWaterTest {

    ContainerWithMostWater mostwater;
    int[] input1;
    int[] input2;

    @Before
    public void setUp() throws Exception {
        this.mostwater = new ContainerWithMostWater();
        this.input1 = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        this.input2 = new int[] {1, 1};
    }

    @After
    public void tearDown() throws Exception {
        this.mostwater = null;
        this.input1 = null;
        this.input2 = null;
    }

    @Test
    public void test() {
        try {
            assertEquals(49, mostwater.maxArea(input1));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertEquals(1, mostwater.maxArea(input2));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
