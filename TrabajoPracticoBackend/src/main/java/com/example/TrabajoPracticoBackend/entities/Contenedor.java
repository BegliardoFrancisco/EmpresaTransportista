package com.example.TrabajoPracticoBackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contenedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contenedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El peso no puede ser nulo")
    @Column(name = "peso", nullable = false)
    private Double peso;

    @NotNull(message = "El volumen no puede ser nulo")
    @Column(name = "volumen", nullable = false)
    private Double volumen;

    @NotNull(message = "El estado no puede ser nulo")
    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @NotNull(message = "El cliente asociado no puede ser nulo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

}