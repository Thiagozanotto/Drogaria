package br.edu.unifio.drogaria.entidades;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Data
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private LocalDateTime horario;

    @OneToMany(mappedBy = "pedido")
    private List<Item> itens;
}
