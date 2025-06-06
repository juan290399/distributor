package com.jrvv.distributor.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Retailer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long retId;

    @NotBlank
    @Size(max = 50)
    private String retName;

    @NotBlank
    @Size(max = 50)
    private String retType;

    @Pattern(regexp = "^\\d{11}$")
    @Column(unique = true)
    private String retRuc;

    @Builder.Default
    private Boolean retActive = true;

    @Builder.Default
    private LocalDateTime retCreatedAt = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
        name = "retailer_owner",
        joinColumns = @JoinColumn(name = "ret_id"),
        inverseJoinColumns = @JoinColumn(name = "cli_id")
    )
    private Set<Client> owners;

    @OneToMany(mappedBy = "retailer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoreBranch> branches;
}
