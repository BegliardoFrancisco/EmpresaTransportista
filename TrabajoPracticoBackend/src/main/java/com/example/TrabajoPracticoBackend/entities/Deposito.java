package com.example.TrabajoPracticoBackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deposito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deposito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(max = 255, message = "La dirección no puede exceder los 255 caracteres")
    @Column(name = "direccion", length = 255, nullable = false)
    private String direccion;

    @NotNull(message = "La latitud no puede ser nula")
    @Column(name = "latitud", nullable = false)
    private Double latitud;

    @NotNull(message = "La longitud no puede ser nula")
    @Column(name = "longitud", nullable = false)
    private Double longitud;

    @NotNull(message = "La ciudad asociada no puede ser nula")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Ciudad ciudad;
}