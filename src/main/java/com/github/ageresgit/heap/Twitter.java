package com.github.ageresgit.heap;

import java.util.*;

public class Twitter {
    public static final int MAX_TWEET_COUNT = 10;
    private int timer;
    private Map<Integer, Set<Integer>> users;
    private Map<Integer, TweetHeap> messages;
    static class Tweet{
        Integer messageId;
        int timeStamp;
        Tweet(Integer messageId, int timeStamp) {this.messageId = messageId;this.timeStamp = timeStamp;}
    }
    static class TweetHeap {
        Queue<Tweet> data;
        TweetHeap() {data = new PriorityQueue<>((a,b)->(a.timeStamp - b.timeStamp));}
        int size() {return data.size();}
        boolean isEmpty() {return data.size() == 0;}
        Integer peek() {return data.peek().messageId;}
        Integer poll() {return data.poll().messageId;}
        boolean offer(Tweet newTweet) {
            if (newTweet == null) return false;
            if (size() == MAX_TWEET_COUNT) {
                if (newTweet.timeStamp <= data.peek().timeStamp) return false;
                poll();
            }
            return data.offer(newTweet);
        }
        void join(TweetHeap other) {
            if (other == null || other.size() == 0) return;
            for(Tweet tweet : other.data) offer(tweet);
        }
        List<Integer> tweetFeed() {
            LinkedList<Integer> list = new LinkedList<>();
            while(!data.isEmpty()) list.addFirst(data.poll().messageId);
            return list;
        }
    }
    public Twitter() {
       users = new HashMap<>();
       messages = new HashMap<>();
       timer = 0;
    }
    private Tweet newTweet(Integer tweetId) {
        return new Tweet(tweetId, timer++);
    }
    private Set<Integer> initUser(int userId) {
        Set<Integer> set = users.get(userId);
        if (set == null) {
            set = new HashSet<>(userId);
            set.add(userId);
            users.put(userId, set);
        }
        return set;
    }
    public void postTweet(int userId, int tweetId) {
        initUser(userId);
        TweetHeap tweets = messages.get(userId);
        if (tweets == null) tweets = new TweetHeap();
        tweets.offer(newTweet(tweetId));
        messages.put(userId, tweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        var set = initUser(userId);
        TweetHeap heap = new TweetHeap();
        for(Integer user : users.get(userId)) heap.join(messages.get(user));
        return heap.tweetFeed();
    }

    public void follow(int followerId, int followeeId) {
        var set = initUser(followerId);
        set.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        var set = initUser(followerId);
        set.remove(followeeId);
    }
}
