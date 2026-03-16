package com.login.login.domain.entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(nullable = false, unique=true, updatable=false)
    private String name;

    @Column(nullable = true)
    private String description;

    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles;

    public Permission() {
    }

    public Permission(String id, String name, String description, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
