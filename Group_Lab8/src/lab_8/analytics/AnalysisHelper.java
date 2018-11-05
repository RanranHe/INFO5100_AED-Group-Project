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
//        Map<Integer, Integer> userLinkcount =new HashMap<Integer, Integer>();
//        
//        Map<Integer, User>user=DataStore.getInstance().getUsers();
//        for(User user : user.values()){
//            for(Comment c: user.getComments()){
//                int likes = 0;
//                if(userLikecount.containsKey(user.getId()))
//                    likes=userLikecount.get(user.getId());
//                likes+=c.getLikes();
//                userLikecount.put(user.getId(),likes);
//            }
//        }
//        
//        int max=0;
//        int maxId=0;
//        for(int id:userLikecount.keySet()){
//            if(userLikecount.get(id)>max){
//                max=userLikecount.get(id);
//                maxId = id;
//            }
//        }

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
    public void postWithPostLikedComments() {
        Map<Integer, Post> Posts = DataStore.getInstance().getPosts();
        List<Post> postList = new ArrayList<>(Posts.values());
        Map<Integer, Post> postToLikes = new HashMap<Integer, Post>();

        for (Post p : postList) {
            List<Comment> list = p.getComments();
            Collections.sort(list, new Comparator<Comment>() {
                @Override
                public int compare(Comment o1, Comment o2) {
                    return o2.getLikes() - o1.getLikes();
                }
            });
            postToLikes.put(list.get(0).getLikes(), p);
        }

        TreeMap<Integer, Post> sorted = new TreeMap<>();
        sorted.putAll(postToLikes);

        Iterator<Integer> it = sorted.descendingKeySet().iterator();

        System.out.println();
        System.out.println("2. Post with most liked comments: ");

        int next = it.next();
        int flag = next;
        int postId = sorted.get(next).getPostId();
        System.out.println("Post Id: " + postId);
        System.out.println("Likes Number: " + next);
        System.out.println("Posting User Id: " + sorted.get(next).getUserId());
        System.out.println("Contains comments: ");
        for (Comment c : sorted.get(next).getComments()) {
            System.out.println("   Comment " + c.getId() + " with " + c.getLikes() + " Likes: " + c.getText());
        }

        System.out.println();
        for (Post p : postList) {
            for (Comment c : p.getComments()) {
                if (c.getLikes() == flag && postId != p.getPostId()) {
                    System.out.println("The following Post tied the top place:  ");
                    System.out.println("   Post Id: " + p.getPostId());
                    System.out.println("   Likes Number: " + flag);
                    System.out.println("   Posting User Id: " + p.getUserId());
                    System.out.println("   Contains comments: ");
                    for (Comment co : p.getComments()) {
                        System.out.println("      Comment " + co.getId() + " with " + co.getLikes() + " Likes: " + co.getText());
                    }
                    System.out.println();
                }
            }
        }
    }

    // 3. Post with most comments.
    public void postWithMostComments() {
        Map<Integer, Post> Posts = DataStore.getInstance().getPosts();
        List<Post> postList = new ArrayList<>(Posts.values());
        Map<Integer, Post> commentsNum = new HashMap<Integer, Post>();

        for (Post p : postList) {
            commentsNum.put(p.getComments().size(), p);
        }
        TreeMap<Integer, Post> sorted = new TreeMap<>();
        sorted.putAll(commentsNum);

        Iterator<Integer> it = sorted.descendingKeySet().iterator();

        int next = it.next();
        int flag = next;
        int postId = sorted.get(next).getPostId();
        System.out.println();
        System.out.println("3. Post with most comments: ");
        System.out.println("Post Id: " + postId);
        System.out.println("Posting User Id: " + sorted.get(next).getUserId());
        System.out.println("Contains " + next + " comments: ");
        for (Comment c : sorted.get(next).getComments()) {
            System.out.println("   Comment " + c.getId() + " with " + c.getLikes() + " Likes: " + c.getText());
        }

        System.out.println();
        for (Post p : postList) {
            for (Comment c : p.getComments()) {
                if (c.getLikes() == flag && postId != p.getPostId()) {
                    System.out.println("The following Post tied the top place:  ");
                    System.out.println("   Post Id: " + p.getPostId());
                    System.out.println("   Posting User Id: " + p.getUserId());
                    System.out.println("   Contains " + flag + " comments: ");
                    for (Comment co : sorted.get(next).getComments()) {
                        System.out.println("      Comment " + co.getId() + " with " + co.getLikes() + " Likes: " + co.getText());
                    }
                    System.out.println();
                }
            }
        }
    }

    // 4. Top 5 inactive users based on posts.
    public void getFiveInactiveUserByPosts(){
        Map<Integer, User> Users = DataStore.getInstance().getUsers();
        List<User> userList = new ArrayList<>(Users.values());

        Map<Integer, User> activities = new HashMap<Integer, User>();

        for (User u : userList) {
            int totalPosts = getTotalPostsByUser(u);
            activities.put(totalPosts, u);
        }

        TreeMap<Integer, User> sorted = new TreeMap<>();
        sorted.putAll(activities);

        Iterator<Integer> it = sorted.keySet().iterator();

        System.out.println();
        System.out.println("4. Top 5 inactive users based on posts: ");
        int num = 0;
        while (it.hasNext()) {
            for (int i = 0; i < Users.size(); i++) {
                try {
                    int next = it.next();
                    User user = sorted.get(next);
                    if (i + num < 5) {
                        System.out.println("   " + (i + 1 + num) + ". User ID: " + user.getId() + " Name: "
                                + user.getFirstName() + " " + user.getLastName() + " Total Posts: " + next);
                        for (User u : userList) {
                            if (next == getTotalPostsByUser(u) && u.getId() != user.getId()) {
                                if (i + num + 1 < 5) {
                                    System.out.println("   " + (i + 2 + num) + ". User ID: " + u.getId() + " Name: "
                                            + u.getFirstName() + " " + u.getLastName() + " Total Posts: " + next);
                                    num++;
                                } else {
                                    System.out.println("The following user tied the fifth place: ");
                                    System.out.println("   " + (i + 2 + num) + ". User ID: " + u.getId() + " Name: "
                                            + u.getFirstName() + " " + u.getLastName() + " Total Posts: " + next);
                                    num++;
                                }

                            }
                        }
                    }
                } catch (NoSuchElementException e) {

                }
            }
        }
    }
    
    // 5. Top 5 inactive users based on comments.
    public void getFiveInactiveUsersByComments() {
        Map<Integer, User> Users = DataStore.getInstance().getUsers();
        List<User> userList = new ArrayList<>(Users.values());

        Map<Integer, User> activities = new HashMap<Integer, User>();

        for (User u : userList) {
            int totalComments = u.getComments().size();
            activities.put(totalComments, u);
        }

        TreeMap<Integer, User> sorted = new TreeMap<>();
        sorted.putAll(activities);

        Iterator<Integer> it = sorted.keySet().iterator();

        System.out.println();
        System.out.println("5. Top 5 inactive users based on comments: ");
        int num = 0;
        while (it.hasNext()) {
            for (int i = 0; i < Users.size(); i++) {
                try {
                    int next = it.next();
                    User user = sorted.get(next);
                    if (i + num < 5) {
                        System.out.println("   " + (i + 1 + num) + ". User ID: " + user.getId() + " Name: "
                                + user.getFirstName() + " " + user.getLastName() + " Total Posts: " + next);
                        for (User u : userList) {
                            if (next == u.getComments().size() && u.getId() != user.getId()) {
                                if (i + num + 1 < 5) {
                                    System.out.println("   " + (i + 2 + num) + ". User ID: " + u.getId() + " Name: "
                                            + u.getFirstName() + " " + u.getLastName() + " Total Posts: " + next);
                                    num++;
                                } else {
                                    System.out.println("The following user tied the fifth place: ");
                                    System.out.println("   " + (i + 2 + num) + ". User ID: " + u.getId() + " Name: "
                                            + u.getFirstName() + " " + u.getLastName() + " Total Posts: " + next);
                                    num++;
                                }

                            }
                        }
                    }
                } catch (NoSuchElementException e) {

                }
            }
        }
    }
    
    // 6. Top 5 inactive users overall (comments, posts and likes) 
    public void getFiveInactiveUsersOverall() {
        Map<Integer, User> Users = DataStore.getInstance().getUsers();
        List<User> userList = new ArrayList<>(Users.values());

        Map<Integer, User> activities = new HashMap<Integer, User>();

        for (User u : userList) {
            int totalComments = u.getComments().size();
            int totalCommentsLikes = getTotalCommentsLikesByUser(u);
            int totalPosts = getTotalPostsByUser(u);
            activities.put(totalComments + totalCommentsLikes + totalPosts, u);
        }

        TreeMap<Integer, User> sorted = new TreeMap<>();
        sorted.putAll(activities);

        Iterator<Integer> it = sorted.keySet().iterator();

        System.out.println();
        System.out.println("6. Top 5 inactive users overall: ");
        int num = 0;
        while (it.hasNext()) {
            for (int i = 0; i < Users.size(); i++) {
                try {
                    int next = it.next();
                    User user = sorted.get(next);
                    if (i + num < 5) {
                        System.out.println("   " + (i + 1 + num) + ". User ID: " + user.getId() + " Name: "
                                + user.getFirstName() + " " + user.getLastName() + " Activities Points: " + next);
                        for (User u : userList) {
                            int total = getTotalPostsByUser(u) + getTotalCommentsLikesByUser(u) + u.getComments().size();
                            if (next == total && u.getId() != user.getId()) {
                                if (i + num + 1 < 5) {
                                    System.out.println("   " + (i + 2 + num) + ". User ID: " + u.getId() + " Name: "
                                            + u.getFirstName() + " " + u.getLastName() + " Activities Points: " + next);
                                    num++;
                                } else {
                                    System.out.println("The following user tied the fifth place: ");
                                    System.out.println("   " + (i + 2 + num) + ". User ID: " + u.getId() + " Name: "
                                            + u.getFirstName() + " " + u.getLastName() + " Activities Points: " + next);
                                    num++;
                                }

                            }
                        }
                    }
                } catch (NoSuchElementException e) {

                }
            }
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

    // 7. Top 5 proactive users overall (comments, posts and likes)
    public void getFiveProactiveUsersOverall() {
        Map<Integer, User> Users = DataStore.getInstance().getUsers();
        List<User> userList = new ArrayList<>(Users.values());

        Map<Integer, User> activities = new HashMap<Integer, User>();

        for (User u : userList) {
            int totalComments = u.getComments().size();
            int totalCommentsLikes = getTotalCommentsLikesByUser(u);
            int totalPosts = getTotalPostsByUser(u);
            activities.put(totalComments + totalCommentsLikes + totalPosts, u);
        }

        TreeMap<Integer, User> sorted = new TreeMap<>();
        sorted.putAll(activities);

        Iterator<Integer> it = sorted.descendingKeySet().iterator();

        System.out.println();
        System.out.println("7. Top 5 proactive users overall: ");
        int num = 0;
        while (it.hasNext()) {
            for (int i = 0; i < Users.size(); i++) {
                try {
                    int next = it.next();
                    User user = sorted.get(next);
                    if (i + num < 5) {
                        System.out.println("   " + (i + 1 + num) + ". User ID: " + user.getId() + " Name: "
                                + user.getFirstName() + " " + user.getLastName() + " Activities Points: " + next);
                        for (User u : userList) {
                            int total = getTotalPostsByUser(u) + getTotalCommentsLikesByUser(u) + u.getComments().size();
                            if (next == total && u.getId() != user.getId()) {
                                if (i + num + 1 < 5) {
                                    System.out.println("   " + (i + 2 + num) + ". User ID: " + u.getId() + " Name: "
                                            + u.getFirstName() + " " + u.getLastName() + " Activities Points: " + next);
                                    num++;
                                } else {
                                    System.out.println("The following user tied the fifth place: ");
                                    System.out.println("   " + (i + 2 + num) + ". User ID: " + u.getId() + " Name: "
                                            + u.getFirstName() + " " + u.getLastName() + " Activities Points: " + next);
                                    num++;
                                }

                            }
                        }
                    }
                } catch (NoSuchElementException e) {

                }
            }
        }
    }
}
