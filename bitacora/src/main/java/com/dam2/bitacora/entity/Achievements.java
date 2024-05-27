package com.dam2.bitacora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Achievements")
public class Achievements {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="categoryid")
    private Long categoryid;

    @Column(name="title")
    private String title;

    @Column(name="descripcion")
    private String descripcion;

    public Achievements () {}

    public Achievements(Long id, Long categoryid, String title, String descripcion) {
        this.id = id;
        this.categoryid = categoryid;
        this.title = title;
        this.descripcion = descripcion;
    }

    public Long getAchievementId() {
        return id;
    }

    public void setAchievementId(Long achievementid) {
        this.id = achievementid;
    }

    public Long getCategoryId() {
        return categoryid;
    }

    public void setCategoryId(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", category=" + categoryid + ", title=" + title + ", description=" + descripcion + "]";
    }

}
