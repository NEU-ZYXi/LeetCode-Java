
/*

Design a simplified version of Twitter where users can post tweets, 
follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. 
Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. 
Each item in the news feed must be posted by users who the user followed or by the user herself. 
Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.

Example:
Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);

*/

/*

O(nlogn),O(n)

*/

class Twitter {
    
    class Tweet {
        private int id;
        private int time;
        private Tweet next;
        
        public Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
        }
    }
    
    class User {
        private int id;
        private Set<Integer> follow;
        private Tweet tweet;
        
        public User(int id) {
            this.id = id;
            this.follow = new HashSet<>();
            follow(id);
        }
        
        public void follow(int id) {
            this.follow.add(id);
        }
        
        public void unfollow(int id) {
            this.follow.remove(id);
        }
        
        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = this.tweet;
            this.tweet = tweet;
        }
    }
    
    private int timestamp = 0;
    private Map<Integer, User> map;

    /** Initialize your data structure here. */
    public Twitter() {
        this.map = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        map.putIfAbsent(userId, new User(userId));
        map.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. 
    Each item in the news feed must be posted by users who the user followed or by the user herself. 
    Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        if (!map.containsKey(userId)) return ans;
        Set<Integer> follow = map.get(userId).follow;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (int user : follow) {
            Tweet tweet = map.get(user).tweet;
            if (tweet != null) pq.offer(tweet);
        }
        int cnt = 10;
        while (!pq.isEmpty() && cnt > 0) {
            Tweet tweet = pq.poll();
            ans.add(tweet.id);
            cnt--;
            if (tweet.next != null) pq.offer(tweet.next);
        }
        return ans;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        map.putIfAbsent(followerId, new User(followerId));
        map.putIfAbsent(followeeId, new User(followeeId));
        map.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!map.containsKey(followerId) || followerId == followeeId) return;
        map.get(followerId).unfollow(followeeId);
    }
}





