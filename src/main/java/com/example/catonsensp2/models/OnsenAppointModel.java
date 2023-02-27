package com.example.catonsensp2.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "OnsenAppointment")
@Data
@NoArgsConstructor
@JsonIdentityInfo(scope = OnsenAppointModel.class,generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class OnsenAppointModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Room",nullable = false)
    private int room;

    @Column(name = "Date",nullable = false)
    private Date date;

    @Column(name = "paymentImage",nullable = false)
    private String onsenImage;
}
