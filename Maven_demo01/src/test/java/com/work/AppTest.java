package com.work;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    @Test
    public void testsay(){
        App a = new App();
        String me = a.say("me");
        Assert.assertEquals("hello my",me);
    }
}
