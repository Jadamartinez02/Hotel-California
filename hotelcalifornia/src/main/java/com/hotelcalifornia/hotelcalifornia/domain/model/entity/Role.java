package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Boolean canEditRoom;
    @Column(nullable = false)
    private Boolean canViewRoom;
    @Column(nullable = false)
    private Boolean canPostOffers;
    @Column(nullable = false)
    private Boolean canEditPackage;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    public Role() {
    }

    public Role(String id, String name, Boolean canEditRoom, Boolean canViewRoom, Boolean canPostOffers,
            Boolean canEditPackage, List<User> users) {
        this.id = id;
        this.name = name;
        this.canEditRoom = canEditRoom;
        this.canViewRoom = canViewRoom;
        this.canPostOffers = canPostOffers;
        this.canEditPackage = canEditPackage;
        this.users = users;
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

    
}
