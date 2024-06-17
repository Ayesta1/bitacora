package com.dam2.bitacora.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Userachievements")
public class Userachievements {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="achievementid")
    private int achievementid;

    @Column(name="userid")
    private int userid;

    @Column(name="photo_proof")
    private String photoproof;

    @Column(name="completationdate")
    private Date completationdate;

    @Column(name="likes")
    private int like;

    @Column(name="dislikes")
    private int dislike;

    public Userachievements() {};

    public Userachievements(Long id, int achievementid, int userId, String photoproof, Date completationdate, int like, int dislike) {
        this.id = id;
        this.achievementid = achievementid;
        this.userid = userId;
        this.photoproof = photoproof;
        this.completationdate = completationdate;
        this.like = like;
        this.dislike = dislike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAchievementid() {
        return achievementid;
    }

    public void setAchievementid(int achievementid) {
        this.achievementid = achievementid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPhotoproof() {
        return photoproof;
    }

    public void setPhotoproof(String photoproof) {
        this.photoproof = photoproof;
    }

    public Date getCompletationdate() {
        return completationdate;
    }

    public void setCompletationdate(Date completationdate) {
        this.completationdate = completationdate;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    @Override
    public String toString() {
        return "UserAchievements [id=" + id + ", achievementid=" + achievementid + ", userid=" + userid + ", photoproof=" + photoproof + ", completationdate=" + completationdate + ", like=" + like + ",dislike=" + dislike +"]";
    }
}