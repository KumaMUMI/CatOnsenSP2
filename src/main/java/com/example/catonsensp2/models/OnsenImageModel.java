package com.example.catonsensp2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "OnsenImageData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OnsenImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String type;
    @Lob
    @Column(name = "imageData", length = 1000)
    private byte[] imageData;
}
