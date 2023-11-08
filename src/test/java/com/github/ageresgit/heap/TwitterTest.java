package com.github.ageresgit.heap;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwitterTest {
    @Test
    void test() {
        Twitter t = new Twitter();
        t.postTweet(1 ,5);
        t.getNewsFeed(1);
        t.follow(1, 2);
        t.postTweet(2, 6);
        var list = t.getNewsFeed(1);
        assertEquals(2,list.size());
        assertEquals(6,list.get(0));
        assertEquals(5,list.get(1));
    }
}