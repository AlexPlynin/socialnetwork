package com.newsweaterproject.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;  //признак активности
    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)//fetch = FetchType.EAGER подгрузка базы происходит сразу
    @CollectionTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"))//то в какой таблице будет хранится наш Сет и объединение происходит с нашей таблицей в таблице усер ид
    @Enumerated(EnumType.STRING)//храним наш енум в виде строки
    private Set<Role> roles;  //набор ролей

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
