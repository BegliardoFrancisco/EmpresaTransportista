package com.example.TrabajoPracticoBackend.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ciudad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la ciudad no puede estar vacío")
    @Size(max = 100, message = "El nombre de la ciudad no puede exceder los 100 caracteres")
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @NotNull(message = "La latitud no puede ser nula")
    @Column(name = "latitud", nullable = false)
    private Double latitud;

    @NotNull(message = "La longitud no puede ser nula")
    @Column(name = "longitud", nullable = false)
    private Double longitud;
}