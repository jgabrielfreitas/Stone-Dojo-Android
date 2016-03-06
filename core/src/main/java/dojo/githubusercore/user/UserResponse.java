package dojo.githubusercore.user;

import dojo.githubusercore.BaseApiResponse;

/**
 * Created by JGabrielFreitas on 06/03/16.
 */
public class UserResponse extends BaseApiResponse {

    private String organizations_url;
    private String received_events_url;
    private String avatar_url;
    private String gravatar_id;
    private String public_gists;
    private String location;
    private String site_admin;
    private String type;
    private String blog;
    private String id;
    private String following;
    private String followers;
    private String public_repos;
    private String name;
    private String following_url;
    private String created_at;
    private String events_url;
    private String login;
    private String subscriptions_url;
    private String repos_url;
    private String gists_url;
    private String starred_url;
    private String url;
    private String html_url;
    private String hireable;
    private String updated_at;
    private String bio;
    private String email;
    private String company;
    private String followers_url;

    public String getOrganizations_url() {
        return organizations_url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String getPublic_gists() {
        return public_gists;
    }

    public String getLocation() {
        return location;
    }

    public String getSite_admin() {
        return site_admin;
    }

    public String getType() {
        return type;
    }

    public String getBlog() {
        return blog;
    }

    public String getId() {
        return id;
    }

    public String getFollowing() {
        return following;
    }

    public String getFollowers() {
        return followers;
    }

    public String getPublic_repos() {
        return public_repos;
    }

    public String getName() {
        return name;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String getLogin() {
        return login;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public String getUrl() {
        return url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getHireable() {
        return hireable;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getBio() {
        return bio;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public String toString() {
        return "UserResponse{" +
                "organizations_url='" + organizations_url + '\'' +
                ", received_events_url='" + received_events_url + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", gravatar_id='" + gravatar_id + '\'' +
                ", public_gists='" + public_gists + '\'' +
                ", location='" + location + '\'' +
                ", site_admin='" + site_admin + '\'' +
                ", type='" + type + '\'' +
                ", blog='" + blog + '\'' +
                ", id='" + id + '\'' +
                ", following='" + following + '\'' +
                ", followers='" + followers + '\'' +
                ", public_repos='" + public_repos + '\'' +
                ", name='" + name + '\'' +
                ", following_url='" + following_url + '\'' +
                ", created_at='" + created_at + '\'' +
                ", events_url='" + events_url + '\'' +
                ", login='" + login + '\'' +
                ", subscriptions_url='" + subscriptions_url + '\'' +
                ", repos_url='" + repos_url + '\'' +
                ", gists_url='" + gists_url + '\'' +
                ", starred_url='" + starred_url + '\'' +
                ", url='" + url + '\'' +
                ", html_url='" + html_url + '\'' +
                ", hireable='" + hireable + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", bio='" + bio + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", followers_url='" + followers_url + '\'' +
                '}';
    }
}
