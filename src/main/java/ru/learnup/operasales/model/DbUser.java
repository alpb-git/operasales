package ru.learnup.operasales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class DbUser {

    @Id
    @Column(name = "USERNAME", length=30)
    private String username;

    @Column(name = "PASSWORD", length=255)
    private String password;

    @Column(name = "ROLENAME", length=30)
    private String roleName;

    protected DbUser() {
    }

    public DbUser(String username, String password, String roleName) {
        this.username = username;
        this.password = password;
        this.roleName = roleName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRoleName() {
        return roleName;
    }

}