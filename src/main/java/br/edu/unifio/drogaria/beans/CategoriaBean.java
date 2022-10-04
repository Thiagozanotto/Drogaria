package br.edu.unifio.drogaria.beans;
import br.edu.unifio.drogaria.entidades.Categoria;
import br.edu.unifio.drogaria.repositorios.CategoriaRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.util.List;

@Component @ViewScoped /*PRECISA TER ESSES DOIS @ NO BEAN SEMPRE*/
@Data
public class CategoriaBean {
    private Categoria categoria;
    private List<Categoria> categorias;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void listar() {
        categorias = categoriaRepository.findAll();
    }

    public void novo() {
        categoria = new Categoria();
    }

    public void salvar() {
        try {
            categoriaRepository.save(categoria);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
            Faces.navigate("categoria-listagem.xhtml?faces-redirect=true");
        } catch (DataIntegrityViolationException excecao){
            excecao.printStackTrace();
            Messages.addFlashGlobalError("Essa Categoria já existe!");
        }
    }

    public void selecionarExclusao(Categoria cursor){
        Faces.setFlashAttribute("cursor", cursor);
        Faces.navigate("categoria-exclusao.xhtml?faces-redirect=true");
    }
    public void selecionarEdicao(Categoria cursor){
        Faces.setFlashAttribute("cursor", cursor);
        Faces.navigate("categoria-edicao.xhtml?faces-redirect=true");
    }

    public void carregar(){
        categoria = Faces.getFlashAttribute("cursor");
    }

    public void excluir(){
        categoriaRepository.delete(categoria);
        Messages.addFlashGlobalInfo("Registro removido com sucesso!");
        Faces.navigate("categoria-listagem.xhtml?faces-redirect=true");
    }
}
