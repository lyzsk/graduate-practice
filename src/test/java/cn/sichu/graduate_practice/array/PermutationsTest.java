package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PermutationsTest {
    Permutations permute;
    int[] input1, input2, input3;
    List<List<Integer>> output1, output2, output3;

    @Before
    public void setUp() throws Exception {
        this.permute = new Permutations();
        this.input1 = new int[] {1, 2, 3};
        this.input2 = new int[] {0, 1};
        this.input3 = new int[] {1};
        this.output1 = new ArrayList<List<Integer>>();
        output1.add(new ArrayList<Integer>());
        output1.get(0).add(1);
        output1.get(0).add(2);
        output1.get(0).add(3);
        output1.add(new ArrayList<Integer>());
        output1.get(1).add(1);
        output1.get(1).add(3);
        output1.get(1).add(2);
        output1.add(new ArrayList<Integer>());
        output1.get(2).add(2);
        output1.get(2).add(1);
        output1.get(2).add(3);
        output1.add(new ArrayList<Integer>());
        output1.get(3).add(2);
        output1.get(3).add(3);
        output1.get(3).add(1);
        output1.add(new ArrayList<Integer>());
        output1.get(4).add(3);
        output1.get(4).add(1);
        output1.get(4).add(2);
        output1.add(new ArrayList<Integer>());
        output1.get(5).add(3);
        output1.get(5).add(2);
        output1.get(5).add(1);
        this.output2 = new ArrayList<List<Integer>>();
        output2.add(new ArrayList<Integer>());
        output2.get(0).add(0);
        output2.get(0).add(1);
        output2.add(new ArrayList<Integer>());
        output2.get(1).add(1);
        output2.get(1).add(0);
        this.output3 = new ArrayList<List<Integer>>();
        output3.add(new ArrayList<Integer>());
        output3.get(0).add(1);
    }

    @After
    public void tearDown() throws Exception {
        this.permute = null;
        this.input1 = null;
        this.input2 = null;
        this.input3 = null;
        this.output1 = null;
        this.output2 = null;
        this.output3 = null;
    }

    @Test
    public void test() {
        try {
            assertEquals(output1, permute.permute(input1));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertEquals(output2, permute.permute(input2));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertEquals(output3, permute.permute(input3));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
