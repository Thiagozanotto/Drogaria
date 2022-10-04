package br.edu.unifio.drogaria.repositorios;
import br.edu.unifio.drogaria.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Byte> {

}
