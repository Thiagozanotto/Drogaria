package br.edu.unifio.drogaria.entidades;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(length = 56, nullable = false, unique = true)
    private String nome;

    @Column(precision = 6, scale=2, nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Short quantidade;

    private LocalDate validade;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Categoria categoria;

}
