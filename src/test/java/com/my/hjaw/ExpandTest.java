package com.my.hjaw;

import org.junit.Assert;
import org.junit.Test;

public class ExpandTest {

    @Test
    public void checkIt() {
        Assert.assertEquals("abcdefg", new Expand().expand("abcdefg"));
        Assert.assertEquals("aaabcbcd", new Expand().expand("3[a]2[bc]d"));
        Assert.assertEquals("accaccaccd", new Expand().expand("3[a2[c]]d"));
    }

}