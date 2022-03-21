package cn.sichu.graduate_practice.dp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegularExpressionMatchingTest {
    RegularExpressionMatching match;
    String s1, p1;
    boolean output1;

    @Before
    public void setUp() throws Exception {
        this.match = new RegularExpressionMatching();
        this.s1 = "mississippi";
        this.p1 = "mis*is*p*";
        this.output1 = false;
    }

    @After
    public void tearDown() throws Exception {
        this.match = null;
        this.s1 = null;
        this.p1 = null;
        this.output1 = false;
    }

    @Test
    public void test() {
        try {
            assertEquals(output1, match.isMatch(s1, p1));
        } catch (Exception e) {
            fail("failed" + e.getMessage());
        }
    }

}
