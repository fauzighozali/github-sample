package app.ariadust.githubsample.github.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GitHubRepo {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("owner")
    private Owner owner;

    @SerializedName("forks_count")
    private Integer forks_count;

    @SerializedName("stargazers_count")
    private Integer stargazers_count;

    @SerializedName("watchers_count")
    private Integer watchers_count;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("id")
    private Integer id;

    @SerializedName("private")
    private Boolean set_private;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSet_private() {
        return set_private;
    }

    public void setSet_private(Boolean set_private) {
        this.set_private = set_private;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Integer getForks_count() {
        return forks_count;
    }

    public void setForks_count(Integer forks_count) {
        this.forks_count = forks_count;
    }

    public Integer getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(Integer stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public Integer getWatchers_count() {
        return watchers_count;
    }

    public void setWatchers_count(Integer watchers_count) {
        this.watchers_count = watchers_count;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}
