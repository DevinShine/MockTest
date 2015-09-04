package com.shadev.mocktest.model;

/**
 * Created by devinshine on 15/9/4.
 */
public class Owner {
    /**
     * login : DevinShine
     * id : 7385819
     * avatar_url : https://avatars.githubusercontent.com/u/7385819?v=3
     * gravatar_id :
     * url : https://api.github.com/users/DevinShine
     * html_url : https://github.com/DevinShine
     * followers_url : https://api.github.com/users/DevinShine/followers
     * following_url : https://api.github.com/users/DevinShine/following{/other_user}
     * gists_url : https://api.github.com/users/DevinShine/gists{/gist_id}
     * starred_url : https://api.github.com/users/DevinShine/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/DevinShine/subscriptions
     * organizations_url : https://api.github.com/users/DevinShine/orgs
     * repos_url : https://api.github.com/users/DevinShine/repos
     * events_url : https://api.github.com/users/DevinShine/events{/privacy}
     * received_events_url : https://api.github.com/users/DevinShine/received_events
     * type : User
     * site_admin : false
     */

    private String login;
    private int id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private boolean site_admin;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSite_admin(boolean site_admin) {
        this.site_admin = site_admin;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public String getType() {
        return type;
    }

    public boolean getSite_admin() {
        return site_admin;
    }
}
