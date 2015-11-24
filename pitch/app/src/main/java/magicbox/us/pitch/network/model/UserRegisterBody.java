package magicbox.us.pitch.network.model;

/**
 * Created by evan on 11/23/15.
 */
public class UserRegisterBody {
    private String email;
    private String password;
    private String skills;

    public UserRegisterBody() {

    }

    public UserRegisterBody(String email, String password, String skills) {
        this.email = email;
        this.password = password;
        this.skills = skills;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
