package magicbox.us.pitch.entities;

/**
 * Created by yangwu on 11/13/15.
 */
public class Chat {
    private String message;
    private String author;
    private String pid;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private Chat() {
    }

    public Chat(String pid, String message, String author) {
        this.pid = pid;
        this.message = message;
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }

    public String getPid() {
        return pid;
    }
}
