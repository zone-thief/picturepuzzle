package cn.homework.util;

public class User implements Comparable<User>{
    private String username;
    private int score;

    public User() {
    }

    public User(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return o.getScore() - this.getScore();
    }
}

