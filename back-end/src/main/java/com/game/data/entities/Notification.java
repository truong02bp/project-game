package com.game.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "notification")
public class Notification extends BaseEntity {
    @Column(name = "content")
    private String content;
    @Column(name = "active")
    private Boolean active = false;
    @Column(name = "link")
    private String link;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
