
package br.com.unincor.sistemacomanda.model.domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dioge
 */
public class Pedido implements Serializable {
    
    private Long id;
    private List<Produto> produtos;
    private Cliente cliente;
    
    
}
