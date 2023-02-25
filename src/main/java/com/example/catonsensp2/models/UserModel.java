package com.example.catonsensp2.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name = "Tel",length = 10,nullable = false)
    private String password;

    @Column(name = "Name",nullable = false)
    private String name;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private OnsenAppointModel onsenAppoint;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private MassageAppointModel massageAppoint;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private RoleModel roles;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
