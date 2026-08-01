class User {
    LinkedList<Tweet> tweets;
    LinkedList<User> followers;
    HashSet<Integer> following;
    
    LinkedList<Tweet> feed;

    int id;

    public User(int id) {
        this.id = id;
        tweets = new LinkedList<>();
        followers = new LinkedList<>();
        feed = new LinkedList<>();

        following = new HashSet<>();
    }

    public void post(int tweetId) {
        Tweet toPost = new Tweet(tweetId, this.id);
        for (User follower : followers) {
            follower.feed.addFirst(toPost);
        }
        //feed.addFirst(toPost);
        tweets.addFirst(toPost);
    }

    public void followed(User newFollower) {
        if (newFollower.following.contains(this.id)) return;

        followers.addLast(newFollower);
        newFollower.following.add(this.id);

        if (newFollower.feed.isEmpty()) {
            for (Tweet post : tweets) {
                newFollower.feed.addLast(post);
            }
        } else {
            ListIterator<Tweet> it = newFollower.feed.listIterator();
            for (Tweet post : tweets) {
                while (it.hasNext()) {
                    Tweet insertAt = it.next();

                    if (post.timestamp > insertAt.timestamp) {
                        it.previous();
                        it.add(post);
                        break;
                    }
                }
            }
        }
    }

    public void getUnfollowed(User unfollowedBy) {
        unfollowedBy.following.remove(this.id);

        Iterator<Tweet> it = unfollowedBy.feed.iterator();
        while (it.hasNext()) {
            Tweet tweet = it.next();
            if (tweet.byUser == this.id) {
                it.remove();
            }
        }

        Iterator<User> userIt = this.followers.iterator();
        while (userIt.hasNext()) {
            User user = userIt.next();
            if (user.id == unfollowedBy.id) {
                userIt.remove();
                break;
            }
        }
    }
}

class Tweet {
    public static int latest = 0;

    int id;
    int timestamp;
    int byUser;

    public Tweet(int id, int byUser) {
        this.id = id;
        this.byUser = byUser;
        this.timestamp = latest++;
    }
}

class Twitter {

    HashMap<Integer, User> users;

    public Twitter() {
        users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) users.put(userId, new User(userId));
        users.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        ListIterator<Tweet> itFeed = users.get(userId).feed.listIterator();
        ListIterator<Tweet> ownTweets = users.get(userId).tweets.listIterator();

        int i = 0;
        while (i < 10 && itFeed.hasNext() && ownTweets.hasNext()) {
            Tweet tweetInFeed = itFeed.next();
            Tweet ownTweet = ownTweets.next();
            if (tweetInFeed.timestamp > ownTweet.timestamp) {
                res.add(tweetInFeed.id);
                ownTweets.previous();
            } else {
                res.add(ownTweet.id);
                itFeed.previous();
            }
            i++;
        }
        while (i < 10 && itFeed.hasNext()) {
            Tweet tweetInFeed = itFeed.next();
            res.add(tweetInFeed.id);
            i++;
        }
        while (i < 10 && ownTweets.hasNext()) {
            Tweet ownTweet = ownTweets.next();
            res.add(ownTweet.id);
            i++;
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        if (!users.containsKey(followerId)) users.put(followerId, new User(followerId));
        if (!users.containsKey(followeeId)) users.put(followeeId, new User(followeeId));

        users.get(followeeId).followed(users.get(followerId));
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        if (!users.containsKey(followerId)) users.put(followerId, new User(followerId));
        if (!users.containsKey(followeeId)) users.put(followeeId, new User(followeeId));

        users.get(followeeId).getUnfollowed(users.get(followerId));
    }
}
