package com.game.data.dto;

public class NotificationDto extends BaseDto {
    private String content;
    private Boolean active;
    private UserDto user;
    private String timeResolve;
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTimeResolve() {
        return timeResolve;
    }

    public void setTimeResolve(String timeResolve) {
        this.timeResolve = timeResolve;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
