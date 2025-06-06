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
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliId;

    @NotBlank
    @Size(max = 100)
    private String cliNames;

    @NotBlank
    @Size(max = 50)
    private String cliLastNames;

    @Pattern(regexp = "^\\d{8}$")
    private String cliDni;

    @Pattern(regexp = "^\\d{9}$")
    private String cliCellphone;

    @Pattern(regexp = "^\\d{9}$")
    private String cliWhatsapp;

    @Email
    @Size(max = 50)
    private String cliEmail;

    @Builder.Default
    private LocalDateTime cliRegistrationDate = LocalDateTime.now();
}