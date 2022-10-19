package br.edu.unifio.drogaria.beans;

import br.edu.unifio.drogaria.entidades.Item;
import br.edu.unifio.drogaria.entidades.Pedido;
import br.edu.unifio.drogaria.entidades.Produto;
import br.edu.unifio.drogaria.repositorios.PedidoRepository;
import br.edu.unifio.drogaria.repositorios.ProdutoRepository;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data @Component @ViewScoped
public class PedidoBean implements Serializable {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    private Pedido pedido;

    private List<Produto> produtos;

    private List<Produto> carrinho;

    public void novo(){
        pedido = new Pedido();
        produtos = produtoRepository.findAll();
        carrinho = new ArrayList<>();
    }

    public void adcionar (Produto cursor){
        carrinho.add(cursor);
    }
    public void salvar (){
       // pedido.setHorario(LocalDateTime.now());

        for (Produto produto : carrinho){
            Item item = new Item();
            item.setPedido(pedido);
            item.setProduto(produto);
           // item.setQuantidade(Byte.valueOf("1"));
            item.setPreco(produto.getPreco());

            pedido.getItens().add(item);
        }

        pedidoRepository.save(pedido);
        Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
        Faces.navigate("pedido-novo.xhtml?faces-redirect=true");
    }
}
