package br.com.unincor.sistemacomanda.model.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Produto implements Serializable {
    
    private Long id;
    private String nome;
    private TipoUnidade tipoUnidade;
    private Double estoque;
    private Double preco;
    private Date validade;

    public Produto(Long id, String nome, TipoUnidade tipoUnidade, Double estoque, Double preco, Date validade) {
        this.id = id;
        this.nome = nome;
        this.tipoUnidade = tipoUnidade;
        this.estoque = estoque;
        this.preco = preco;
        this.validade = validade;
    }
    
    
    
}
