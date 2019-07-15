package app.ariadust.githubsample.github.model;

import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("login")
    private String login;

    @SerializedName("avatar_url")
    private String avatar_url;

    @SerializedName("url")
    private String url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
