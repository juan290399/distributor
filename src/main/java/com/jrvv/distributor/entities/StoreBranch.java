package com.jrvv.distributor.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreBranch implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stbId;

    @ManyToOne
    @JoinColumn(name = "ret_id")
    private Retailer retailer;

    @ManyToOne
    @JoinColumn(name = "cit_id")
    private City city;

    @NotBlank
    private String stbAddress;

    @Size(max = 50)
    private String stbZone;

    @Size(max = 20)
    private String stbPostalCode;

    private String stbLocationUrl;
    
    @Builder.Default
    private Boolean stbActive = true;
    
    @Builder.Default
    private LocalDateTime stbCreatedAt = LocalDateTime.now();
}