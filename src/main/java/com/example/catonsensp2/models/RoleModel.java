package com.example.catonsensp2.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Role")
@Data
@NoArgsConstructor
public class RoleModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    @OneToOne(cascade = CascadeType.ALL)
    private UserModel user;
}
