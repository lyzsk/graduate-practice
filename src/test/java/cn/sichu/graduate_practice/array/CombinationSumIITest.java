package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CombinationSumIITest {
    CombinationSumII combsum2;
    int[] input1, input2;
    int target1, target2;
    List<List<Integer>> output1, output2;

    @Before
    public void setUp() throws Exception {
        this.combsum2 = new CombinationSumII();
        this.input1 = new int[] {10, 1, 2, 7, 6, 1, 5};
        this.input2 = new int[] {2, 5, 2, 1, 2};
        this.target1 = 8;
        this.target2 = 5;
        this.output1 = new ArrayList<List<Integer>>();
        output1.add(new ArrayList<Integer>());
        output1.get(0).add(1);
        output1.get(0).add(1);
        output1.get(0).add(6);
        output1.add(new ArrayList<Integer>());
        output1.get(1).add(1);
        output1.get(1).add(2);
        output1.get(1).add(5);
        output1.add(new ArrayList<Integer>());
        output1.get(2).add(1);
        output1.get(2).add(7);
        output1.add(new ArrayList<Integer>());
        output1.get(3).add(2);
        output1.get(3).add(6);
        this.output2 = new ArrayList<List<Integer>>();
        output2.add(new ArrayList<Integer>());
        output2.get(0).add(1);
        output2.get(0).add(2);
        output2.get(0).add(2);
        output2.add(new ArrayList<Integer>());
        output2.get(1).add(5);
    }

    @After
    public void tearDown() throws Exception {
        this.combsum2 = null;
        this.input1 = null;
        this.input2 = null;
        this.target1 = 0;
        this.target2 = 0;
        this.output1 = null;
        this.output2 = null;
    }

    @Test
    public void test() {
        try {
            assertEquals(output1, combsum2.combinationSum2(input1, target1));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertEquals(output2, combsum2.combinationSum2(input2, target2));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
