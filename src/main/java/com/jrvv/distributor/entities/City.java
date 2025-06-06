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
public class City implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long citId;

    @NotBlank
    @Size(max = 25)
    private String citName;

    @NotBlank
    @Size(max = 25)
    private String citRegion;

    @Size(max = 20)
    private String citPostalCode;
    
    @Builder.Default
    private LocalDateTime citCreatedAt = LocalDateTime.now();

    //Getters and Setters
    public Long getCitId() {
        return citId;
    }
    public void setCitId(Long citId) {
        this.citId = citId;
    }
    public String getCitName() {
        return citName;
    }
    public void setCitName(String citName) {
        this.citName = citName;
    }
    public String getCitRegion() {
        return citRegion;
    }

    public void setCitRegion(String citRegion) {
        this.citRegion = citRegion;
    }

    public String getCitPostalCode() {
        return citPostalCode;
    }

    public void setCitPostalCode(String citPostalCode) {
        this.citPostalCode = citPostalCode;
    }

    public LocalDateTime getCitCreatedAt() {
        return citCreatedAt;
    }
    public void setCitCreatedAt(LocalDateTime citCreatedAt) {
        this.citCreatedAt = citCreatedAt;
    }
    @Override
    public String toString() {
        return "City{" +
                "citId=" + citId +
                ", citName='" + citName + '\'' +
                ", citRegion='" + citRegion + '\'' +
                ", citPostalCode='" + citPostalCode + '\'' +
                ", citCreatedAt=" + citCreatedAt +
                '}';
    }
}