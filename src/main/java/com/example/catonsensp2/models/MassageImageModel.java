package com.example.catonsensp2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "MassageImageData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MassageImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String type;
    @Lob
    @Column(name = "imageData", length = 1000)
    private byte[] imageData;
}
