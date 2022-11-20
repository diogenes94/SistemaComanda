/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unincor.sistemacomanda.model.dao;

import br.com.unincor.sistemacomanda.model.domain.Produto;
import br.com.unincor.sistemacomanda.model.domain.TipoUnidade;

/**
 * Classe gerada com a finalidade de fornecer os recursos necessários
 * para a persistência de dados do objeto produto, que é vinculado a tabela
 * produtos. Com este recurso vários métodos estão gerados de forma automática
 * possibilitando a reutilização de códigos de forma dinâmica, inteligente, 
 * prática e de fácil manutenção
 * @author dioge
 */
public class ProdutoDao extends GenericDAO<Produto, Long> {
    
    
    
    public static void main(String[] args) {
        Produto produto = new Produto();
        //produto.setId(1l);
        produto.setNome("Meu 4 produto");
        produto.setPreco(5000.);
        produto.setEstoque(100.);
        produto.setTipoUnidade(TipoUnidade.UN);
        ProdutoDao produtoDao = new ProdutoDao();
        
        produtoDao.save(produto);
    }
}
