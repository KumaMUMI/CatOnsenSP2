package com.example.catonsensp2.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Customer")
@Data
@NoArgsConstructor
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Email",nullable = false)
    private String username;

    @Column(name = "Tel",nullable = false)
    private String password;

    @Column(name = "Name",nullable = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OnsenAppointModel> onsenAppoint;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MassageAppointModel> massageAppoint;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private RoleModel roles;

    public UserModel(String username, String password,String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

}
