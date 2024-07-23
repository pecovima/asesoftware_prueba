package com.asesoftware.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VIAJE")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USUARIO")
    private Integer usuarioId;

    @Column(name = "CARRO")
    private Integer carroId;

    @Column(name = "DATA_RETIRADA")
    private Date dataRetirada;

    @Column(name = "DATA_ENTREGA")
    private Date dataEntrega;

}
