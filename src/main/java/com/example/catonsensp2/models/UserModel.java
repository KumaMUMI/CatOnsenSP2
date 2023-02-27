package com.example.catonsensp2.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
<<<<<<< HEAD
=======
import java.io.Serializable;
<<<<<<< HEAD
>>>>>>> parent of 6b3f4a9 (27/02/66:19.34)
=======
>>>>>>> parent of 6b3f4a9 (27/02/66:19.34)

@Entity
@Table(name = "Customer")
@Data
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

<<<<<<< HEAD
<<<<<<< HEAD
    @Column(nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
=======
=======
>>>>>>> parent of 6b3f4a9 (27/02/66:19.34)
    @Column(name = "Tel",length = 10,nullable = false)
    private String password;

    @Column(name = "Name",nullable = false)
    private String name;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private OnsenAppointModel onsenAppoint;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private MassageAppointModel massageAppoint;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
>>>>>>> parent of 6b3f4a9 (27/02/66:19.34)
    private RoleModel roles;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
