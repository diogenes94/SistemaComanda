package br.com.unincor.sistemacomanda.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author dioge
 */
@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToMany
    @JoinTable(name = "pedido_produtos",
            joinColumns = {
                @JoinColumn(name = "pedido_id"),},
            inverseJoinColumns = {
                @JoinColumn(name = "produto_id")
            })
    private List<Produto> produtos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "valor_itens")
    private Double valorItens;

    private Double desconto;

    @Column(name = "valor_entrega")
    private Double valorEntrega;

    @Column(name = "valor_total")
    private Double valorTotal;

    public void calcularValorTotalItens() {
        this.valorItens = produtos.stream().map(Produto::getPreco).reduce(0., Double::sum);
    }
    
    public void calcularValorTotal() {
        this.valorTotal = valorItens + valorEntrega - desconto;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", cliente=" + cliente + ", valorItens=" + valorItens + ", desconto=" + desconto + ", valorEntrega=" + valorEntrega + ", valorTotal=" + valorTotal + '}';
    }
    
    
}
