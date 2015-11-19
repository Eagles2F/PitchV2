package magicbox.us.pitch.entities;


public class UserBuilder {

    private String name = "";
    private String password = "";
    private String email = "";
    private String headline = "";
    private String url = "";
    private boolean pitchable = true;

    public UserBuilder(){}

    public User buildUser() {
        return new User(name, password, email, headline, url, pitchable);
    }

    public UserBuilder name(String _name) {
        this.name = _name;
        return this;
    }

    public UserBuilder password(String _password) {
        this.password = _password;
        return this;
    }

    public UserBuilder email(String _email) {
        this.email = _email;
        return this;
    }

    public UserBuilder headline(String _headline) {
        this.headline = _headline;
        return this;
    }

    public UserBuilder url(String _url) {
        this.url = _url;
        return this;
    }

    public UserBuilder pitchable(boolean _pitchable) {
        this.pitchable = _pitchable;
        return this;
    }
}
