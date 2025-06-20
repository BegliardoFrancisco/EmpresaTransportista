package com.example.TrabajoPracticoBackend.Externals;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "camion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Camion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La capacidad de peso no puede ser nula")
    @Column(name = "capacidad_peso", nullable = false)
    private Double capacidadPeso;

    @NotNull(message = "La capacidad de volumen no puede ser nula")
    @Column(name = "capacidad_volumen", nullable = false)
    private Double capacidadVolumen;

    @NotNull(message = "El estado de disponibilidad no puede ser nulo")
    @Column(name = "disponible", nullable = false)
    private boolean disponible;
}
