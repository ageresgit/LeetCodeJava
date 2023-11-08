package com.github.ageresgit.heap.list;

import java.util.*;

public class Twitter {
    private int timer;
    private Map<Integer, User> users;
    private static final int FEED_LENGTH = 10;
    static class User{
        int userId;
        Tweet head;
        Set<User> authors;
        User(int userId) {
            this.userId = userId;
            this.head = null;
            authors = new HashSet<>();
            authors.add(this);
        }
        void addTweet(Tweet tweet) {
            tweet.next = head;
            head = tweet;
        }
        void follow(User author) {
            if (author != null) authors.add(author);
        }
        void unfollow(User author){
            if (author != null && author.userId != userId) authors.remove(author);
        }
        Set<User> allUsers() {return authors;}
        Tweet getHead() {return head;}
    }
    static class Tweet implements Comparable<Tweet> {
        int tweetId;
        int timeStamp;
        Tweet next;
        public Tweet(int tweetId, int timeStamp) {
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
            next = null;
        }
        @Override
        public int compareTo(Tweet o) {
            if (o == null) return 1;
            return o.timeStamp - this.timeStamp;
        }
    }
    private int getTimer() {return timer++;}
    private Tweet newTweet(int tweetId) {
        return new Tweet(tweetId, getTimer());
    }
    public Twitter() {
        timer = 0;
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        getUser(userId).addTweet(newTweet(tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        var queue = new PriorityQueue<Tweet>();
        for(var follower : getUser(userId).allUsers()) {
            if (follower.getHead() != null) queue.offer(follower.getHead());
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty() && list.size() < FEED_LENGTH) {
            Tweet tweet = queue.poll();
            list.add(tweet.tweetId);
            if (tweet.next != null) queue.offer(tweet.next);
        }
        return list;
    }
    private User getUser(int userId) {
        var user = users.get(userId);
        if (user == null) {
            user = new User(userId);
            users.put(userId, user);
        }
        return user;
    }
    public void follow(int followerId, int followeeId) {
        getUser(followerId).follow(getUser(followeeId));
    }

    public void unfollow(int followerId, int followeeId) {
        getUser(followerId).unfollow(getUser(followeeId));
    }
}
