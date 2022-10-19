package br.edu.unifio.drogaria.entidades;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Data
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private LocalDateTime horario = LocalDateTime.now();

    @OneToMany(mappedBy = "pedido", cascade = {CascadeType.PERSIST})
    private List<Item> itens = new ArrayList<>();
}
