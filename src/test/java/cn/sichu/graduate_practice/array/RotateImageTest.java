package cn.sichu.graduate_practice.array;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RotateImageTest {
    RotateImage rotate;
    int[][] matrix1, matrix2, output1, output2;

    @Before
    public void setUp() throws Exception {
        this.rotate = new RotateImage();
        this.matrix1 = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        this.output1 = new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        this.matrix2 = new int[][] {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        this.output2 = new int[][] {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
    }

    @After
    public void tearDown() throws Exception {
        this.rotate = null;
        this.matrix1 = null;
        this.output1 = null;
        this.matrix2 = null;
        this.output2 = null;
    }

    @Test
    public void test() {
        rotate.rotate(matrix1);
        try {
            assertTrue(Arrays.deepEquals(output1, matrix1));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        rotate.rotate(matrix2);
        try {
            assertTrue(Arrays.deepEquals(output2, matrix2));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
