package br.edu.unifio.drogaria.repositorios;

import br.edu.unifio.drogaria.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
