package br.com.unincor.sistemacomanda.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author dioge
 */
@Entity
@Table(name = "PRODUTOS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nome;
    
    @Column(name = "tipo_unidade")
    @Enumerated(EnumType.STRING)
    private TipoUnidade tipoUnidade;
    
    private Double estoque;
    private Double preco;
    
    @Temporal(TemporalType.DATE)
    private Date validade;
    
    @ManyToMany(mappedBy = "produtos")
    List<Pedido> pedidos;

    public Produto(Long id, String nome, TipoUnidade tipoUnidade, Double estoque, Double preco, Date validade) {
        this.id = id;
        this.nome = nome;
        this.tipoUnidade = tipoUnidade;
        this.estoque = estoque;
        this.preco = preco;
        this.validade = validade;
    }
    
    
    
}
