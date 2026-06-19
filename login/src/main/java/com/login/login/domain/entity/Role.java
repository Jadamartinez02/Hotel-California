package com.login.login.domain.entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id", columnDefinition = "CHAR(36)")
    private String id;

    @Column(name = "role_name")
    private String name;

    @Column(name = "can_edit_rooms")
    private Boolean canEditRoom;

    @Column(name = "can_view_rooms")
    private Boolean canViewRoom;

    @Column(name = "can_post_offers")
    private Boolean canPostOffers;

    @Column(name = "can_edit_packages")
    private Boolean canEditPackage;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    @ManyToMany
    @JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> permissions;

    public Role() {
    }

    public Role(String id, String name, Boolean canEditRoom, Boolean canViewRoom, Boolean canPostOffers,
            Boolean canEditPackage, List<User> users, List<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.canEditRoom = canEditRoom;
        this.canViewRoom = canViewRoom;
        this.canPostOffers = canPostOffers;
        this.canEditPackage = canEditPackage;
        this.users = users;
        this.permissions = permissions;
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

    public Boolean getCanEditRoom() {
        return canEditRoom;
    }

    public void setCanEditRoom(Boolean canEditRoom) {
        this.canEditRoom = canEditRoom;
    }

    public Boolean getCanViewRoom() {
        return canViewRoom;
    }

    public void setCanViewRoom(Boolean canViewRoom) {
        this.canViewRoom = canViewRoom;
    }

    public Boolean getCanPostOffers() {
        return canPostOffers;
    }

    public void setCanPostOffers(Boolean canPostOffers) {
        this.canPostOffers = canPostOffers;
    }

    public Boolean getCanEditPackage() {
        return canEditPackage;
    }

    public void setCanEditPackage(Boolean canEditPackage) {
        this.canEditPackage = canEditPackage;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}