package br.edu.unifio.drogaria.repositorios;
import br.edu.unifio.drogaria.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Short> {

}
