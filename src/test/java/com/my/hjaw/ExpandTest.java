package com.my.hjaw;

import org.junit.Assert;
import org.junit.Test;

public class ExpandTest {

    @Test
    public void checkIt() {
        Assert.assertEquals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef", new Expand().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        Assert.assertEquals("abababababababababab", new Expand().decodeString("10[ab]"));
        Assert.assertEquals("aaabcbc", new Expand().decodeString("3[a]2[bc]"));
        Assert.assertEquals("accaccacc", new Expand().decodeString("3[a2[c]]"));
        Assert.assertEquals("abcabccdcdcdef", new Expand().decodeString("2[abc]3[cd]ef"));
        Assert.assertEquals("abccdcdcdxyz", new Expand().decodeString("abc3[cd]xyz"));
        Assert.assertEquals("", new Expand().decodeString("3"));
    }

}