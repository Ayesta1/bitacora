package com.dam2.bitacora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Categories")
public class Category {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="icon")
    private String icon;

    public Category () {}

    public Category (Long id, String nombre, String icon) {
        this.id = id;
        this.nombre = nombre;
        this.icon = icon;
    }

    public Long getCategoryId() {
        return id;
    }

    public void setCategoryId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + nombre + ", icon=" + icon + "]";
    }
}
