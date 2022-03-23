package cn.sichu.graduate_practice.dp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LongestPalindromicSubstringTest {
    LongestPalindromicSubstring lpss;
    String input1, output1, output1another;
    String input2, output2;
    String input3, output3;

    @Before
    public void setUp() throws Exception {
        this.lpss = new LongestPalindromicSubstring();
        this.input1 = new String("babad");
        this.output1 = new String("bab");
        this.output1another = new String("aba");
        this.input2 = new String("cbbd");
        this.output2 = new String("bb");
        this.input3 = new String("ac");
        this.output3 = new String("a");
    }

    @After
    public void tearDown() throws Exception {
        this.lpss = null;
        this.input1 = null;
        this.output1 = null;
        this.output1another = null;
        this.input2 = null;
        this.output2 = null;
        this.input3 = null;
        this.output3 = null;
    }

    @Test
    public void test() {

        String s = lpss.longestPalindrome(input1);

        try {
            assertTrue(s.matches("(bab|aba)"));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertEquals(output2, lpss.longestPalindrome(input2));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }

        try {
            assertEquals(output3, lpss.longestPalindrome(input3));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
