package ServiceLayer.Classes.Models;

/**
 * Created by Svetoslav on 7/4/2017.
 */

public class PostModel {
    int id;
    String title;
    String imageUrl;
    int score;
    int commentsCount;
    boolean anyNewComments;
    String youtubeLink;

    public PostModel(
            int id,
            String title,
            String imageUrl,
            int score,
            int commentsCount,
            boolean anyNewComments,
            String youtubeLink) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.score = score;
        this.commentsCount = commentsCount;
        this.anyNewComments = anyNewComments;
        this.youtubeLink = youtubeLink;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getScore() {
        return score;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public boolean isAnyNewComments() {
        return anyNewComments;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public void setAnyNewComments(boolean anyNewComments) {
        this.anyNewComments = anyNewComments;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }
}
