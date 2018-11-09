/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_8.analytics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import lab_8.entities.Comment;
import lab_8.entities.Post;
import lab_8.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {

    public void userWithMostLikes() {
        Map<Integer, Integer> userLikecount = new HashMap<Integer, Integer>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        for (User user : users.values()) {
            for (Comment c : user.getComments()) {
                int likes = 0;
                if (userLikecount.containsKey(user.getId())) {
                    likes = userLikecount.get(user.getId());
                }
                likes += c.getLikes();
                userLikecount.put(user.getId(), likes);
            }
        }
        int max = 0;
        int maxId = 0;
        for (int id : userLikecount.keySet()) {
            if (userLikecount.get(id) > max) {
                max = userLikecount.get(id);
                maxId = id;
            }
        }

        System.out.println("User with most likes :" + max + "\n" + users.get(maxId));
    }

    public void getFiveMostLikedComment() {

        Map<Integer, Comment> Comments = DataStore.getInstance().getComments();

        List<Comment> commentList = new ArrayList<>(Comments.values());

        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return o2.getLikes() - o1.getLikes();
            }
        });

        System.out.println("5 most like comments: ");
        for (int i = 0; i < commentList.size() && i < 5; i++) {
            System.out.println(commentList.get(i));
        }

    }

    // 1. Find Average number of likes per comment.
    public void averageLikesPerComment() {
        Map<Integer, Comment> Comments = DataStore.getInstance().getComments();

        int totalLikes = 0;
        int totalComments = 0;

        for (Comment c : Comments.values()) {
            totalLikes = totalLikes + c.getLikes();
            totalComments++;
        }
        System.out.println();
        System.out.println("1. Average number of likes per comment: " + totalLikes / totalComments);
    }

    // 2. Post with most liked comments.
    public void postWithMostLikedComments() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        // Key: postId  Value: number of likes of the most liked comment under the post
        Map<Integer, Integer> PostWithMostLikes = new HashMap<>();

        Iterator<Comment> it = comments.values().iterator();
        while (it.hasNext()) {
            Comment next = it.next();
            int postId = next.getPostId();
            int likes = next.getLikes();
            if (PostWithMostLikes.containsKey(postId)) {
                int currentMax = PostWithMostLikes.get(postId);
                if (likes > currentMax) {
                    PostWithMostLikes.remove(postId);
                    PostWithMostLikes.put(postId, likes);
                }
            } else {
                PostWithMostLikes.put(postId, likes);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(PostWithMostLikes.entrySet());
        Collections.sort(list, descendingComp);

        System.out.println();
        System.out.println("2. Post with most liked comments: ");

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                int postId = list.get(i).getKey();
                Post post = getPostById(postId);
                System.out.println("  Post Id: " + postId);
                System.out.println("  Likes Number: " + list.get(i).getValue());
                System.out.println("  Posting User Id: " + post.getUserId());
                System.out.println("  Contains comments: ");
                for (Comment c : post.getComments()) {
                    System.out.println("     - Comment " + c.getId() + " with " + c.getLikes() + " Likes: " + c.getText());
                }
            } else {
                if (list.get(i).getValue().equals(list.get(0).getValue())) {;
                    System.out.println("  The following Post tied the top place: ");
                    int postId = list.get(i).getKey();
                    Post post = getPostById(postId);
                    System.out.println("    Post Id: " + postId);
                    System.out.println("    Likes Number: " + list.get(i).getValue());
                    System.out.println("    Posting User Id: " + post.getUserId());
                    System.out.println("    Contains comments: ");
                    for (Comment c : post.getComments()) {
                        System.out.println("       - Comment " + c.getId() + " with " + c.getLikes() + " Likes: " + c.getText());
                    }
                } else {
                    break;
                }
            }
        }
    }

    // 3. Post with most comments.
    public void postWithMostComments() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        // Key: Post Id  Value: total_comments under the post
        Map<Integer, Integer> totalComments = new HashMap<>();

        Iterator<Entry<Integer, Post>> it = posts.entrySet().iterator();

        while (it.hasNext()) {
            Entry<Integer, Post> next = it.next();
            int postId = next.getKey();
            Post post = next.getValue();

            totalComments.put(postId, post.getComments().size());
        }

        List<Entry<Integer, Integer>> list = new ArrayList<>(totalComments.entrySet());
        Collections.sort(list, descendingComp);

        System.out.println();
        System.out.println("3. Post with most comments: ");
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                int postId = list.get(i).getKey();
                Post post = getPostById(postId);
                System.out.println("Post Id: " + postId);
                System.out.println("Posting User Id: " + post.getUserId());
                System.out.println("Contains " + list.get(i).getValue() + " comments: ");
                for (Comment c : post.getComments()) {
                    System.out.println("   Comment " + c.getId() + " with " + c.getLikes() + " Likes: " + c.getText());
                }
            } else {
                if (list.get(i).getValue().equals(list.get(0).getValue())) {
                    int postId = list.get(i).getKey();
                    Post post = getPostById(postId);
                    System.out.println("The following Post tied the top place:  ");
                    System.out.println("   Post Id: " + post.getPostId());
                    System.out.println("   Posting User Id: " + post.getUserId());
                    System.out.println("   Contains " + list.get(i).getValue() + " comments: ");
                    for (Comment co : post.getComments()) {
                        System.out.println("      Comment " + co.getId() + " with " + co.getLikes() + " Likes: " + co.getText());
                    }
                }
            }
        }
    }

    // 4. Top 5 inactive users based on posts.
    public void getFiveInactiveUserByPosts() {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        // Key: userId  Value: total_post
        Map<Integer, Integer> totalPosts = new HashMap<>();

        Iterator<Map.Entry<Integer, User>> it = users.entrySet().iterator();

        while (it.hasNext()) {
            Entry<Integer, User> next = it.next();
            User user = next.getValue();
            int userId = next.getKey();

            totalPosts.put(userId, getTotalPostsByUser(user));
        }

        List<Entry<Integer, Integer>> list = new ArrayList<>(totalPosts.entrySet());
        Collections.sort(list, ascendingComp);

        System.out.println();
        System.out.println("4. Top 5 inactive users based on posts: ");
        for (int i = 0; i < list.size(); i++) {
            if (i < 5) {
                int userId = list.get(i).getKey();
                User user = getUserById(userId);
                System.out.println("   " + (i + 1) + ". User ID: " + userId + " Name: "
                        + user.getFirstName() + " " + user.getLastName() + " Total Posts: " + list.get(i).getValue());
            } else {
                if (list.get(i).getValue().equals(list.get(4).getValue())) {
                    System.out.println("  The following Post tied the fifth place:");
                    int userId = list.get(i).getKey();
                    User user = getUserById(userId);
                    System.out.println("     " + (i + 1) + ". User ID: " + userId + " Name: "
                            + user.getFirstName() + " " + user.getLastName() + " Total Posts: " + list.get(i).getValue());
                } else {
                    break;
                }
            }
        }
    }

    // 5. Top 5 inactive users based on comments.
    public void getFiveInactiveUsersByComments() {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        // Key: userId  Value: total_comment 
        Map<Integer, Integer> totalComments = new HashMap<>();

        Iterator<Map.Entry<Integer, User>> it = users.entrySet().iterator();

        while (it.hasNext()) {
            Entry<Integer, User> next = it.next();
            User user = next.getValue();
            int userId = next.getKey();

            totalComments.put(userId, user.getComments().size());
        }

        List<Entry<Integer, Integer>> list = new ArrayList<>(totalComments.entrySet());
        Collections.sort(list, ascendingComp);

        System.out.println();
        System.out.println("5. Top 5 inactive users based on comments: ");
        for (int i = 0; i < list.size(); i++) {
            if (i < 5) {
                int userId = list.get(i).getKey();
                User user = getUserById(userId);
                System.out.println("   " + (i + 1) + ". User ID: " + userId + " Name: "
                        + user.getFirstName() + " " + user.getLastName() + " Total Comments: " + list.get(i).getValue());
            } else {
                if (list.get(i).getValue().equals(list.get(4).getValue())) {
                    System.out.println("  The following Post tied the fifth place:");
                    int userId = list.get(i).getKey();
                    User user = getUserById(userId);
                    System.out.println("     " + (i + 1) + ". User ID: " + userId + " Name: "
                            + user.getFirstName() + " " + user.getLastName() + " Total Comments: " + list.get(i).getValue());
                } else {
                    break;
                }
            }
        }
    }

    // 6. Top 5 inactive users overall (comments, posts and likes)
    public void getFiveInactiveUsersOverall() {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        // Key: userId  Value: activeScores = total_post + total_comment 
        Map<Integer, Integer> activeScores = new HashMap<>();

        Iterator<Map.Entry<Integer, User>> it = users.entrySet().iterator();

        while (it.hasNext()) {
            Entry<Integer, User> next = it.next();
            User user = next.getValue();
            int userId = next.getKey();

            int scores = user.getComments().size() + getTotalPostsByUser(user) + getTotalCommentsLikesByUser(user);
            activeScores.put(userId, scores);
        }

        List<Entry<Integer, Integer>> list = new ArrayList<>(activeScores.entrySet());
        Collections.sort(list, ascendingComp);

        System.out.println();
        System.out.println("6. Top 5 inactive users overall: ");
        for (int i = 0; i < list.size(); i++) {
            if (i < 5) {
                int userId = list.get(i).getKey();
                User user = getUserById(userId);
                System.out.println("   " + (i + 1) + ". User ID: " + userId + " Name: "
                        + user.getFirstName() + " " + user.getLastName() + " Activities Points: " + list.get(i).getValue());
            } else {
                if (list.get(i).getValue().equals(list.get(4).getValue())) {
                    System.out.println("  The following Post tied the fifth place:");
                    int userId = list.get(i).getKey();
                    User user = getUserById(userId);
                    System.out.println("     " + (i + 1) + ". User ID: " + userId + " Name: "
                            + user.getFirstName() + " " + user.getLastName() + " Activities Points: " + list.get(i).getValue());
                } else {
                    break;
                }
            }
        }
    }

    // 7. Top 5 proactive users overall (comments, posts and likes)
    public void getFiveProactiveUsersOverall() {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        // Key: userId  Value: activeScores = total_post + total_comment 
        Map<Integer, Integer> activeScores = new HashMap<>();

        Iterator<Map.Entry<Integer, User>> it = users.entrySet().iterator();

        while (it.hasNext()) {
            Entry<Integer, User> next = it.next();
            User user = next.getValue();
            int userId = next.getKey();

            int scores = user.getComments().size() + getTotalPostsByUser(user) + getTotalCommentsLikesByUser(user);
            activeScores.put(userId, scores);
        }

        List<Entry<Integer, Integer>> list = new ArrayList<>(activeScores.entrySet());
        Collections.sort(list, descendingComp);

        System.out.println();
        System.out.println("7. Top 5 proactive users overall: ");
        for (int i = 0; i < list.size(); i++) {
            if (i < 5) {
                int userId = list.get(i).getKey();
                User user = getUserById(userId);
                System.out.println("   " + (i + 1) + ". User ID: " + userId + " Name: "
                        + user.getFirstName() + " " + user.getLastName() + " Activities Points: " + list.get(i).getValue());
            } else {
                if (list.get(i).getValue().equals(list.get(4).getValue())) {
                    System.out.println("  The following Post tied the fifth place:");
                    int userId = list.get(i).getKey();
                    User user = getUserById(userId);
                    System.out.println("     " + (i + 1) + ". User ID: " + userId + " Name: "
                            + user.getFirstName() + " " + user.getLastName() + " Activities Points: " + list.get(i).getValue());
                } else {
                    break;
                }
            }
        }
    }

    private User getUserById(int id) {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        if (users.containsKey(id)) {
            return users.get(id);
        } else {
            return null;
        }
    }

    private Post getPostById(int id) {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        if (posts.containsKey(id)) {
            return posts.get(id);
        } else {
            return null;
        }
    }

    public int getTotalPostsByUser(User u) {
        Map<Integer, Post> Posts = DataStore.getInstance().getPosts();
        List<Post> postList = new ArrayList<>(Posts.values());
        int totalPosts = 0;
        for (Post p : postList) {
            if (p.getUserId() == u.getId()) {
                totalPosts++;
            }
        }
        return totalPosts;
    }

    public int getTotalCommentsLikesByUser(User u) {
        int totalCommentsLikes = 0;
        for (Comment c : u.getComments()) {
            totalCommentsLikes = totalCommentsLikes + c.getLikes();
        }
        return totalCommentsLikes;
    }

    Comparator<Map.Entry<Integer, Integer>> descendingComp = new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o2.getValue() - o1.getValue();
        }
    };

    Comparator<Map.Entry<Integer, Integer>> ascendingComp = new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }
    };
}
