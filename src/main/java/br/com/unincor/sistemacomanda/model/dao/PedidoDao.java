/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unincor.sistemacomanda.model.dao;

import br.com.unincor.sistemacomanda.model.domain.Cliente;
import br.com.unincor.sistemacomanda.model.domain.Pedido;
import br.com.unincor.sistemacomanda.model.domain.Produto;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author dioge
 */
public class PedidoDao extends GenericDAO<Pedido, Long>{
    
    public List<Pedido> buscarPedidosPorCliente(Cliente cliente) {
        return getEntityManagerReadOnly()
                .createQuery("from Pedido p where p.cliente = :cliente", Pedido.class)
                .setParameter("cliente", cliente)
                .getResultList();
    }
    
    public static void main(String[] args) {
        Cliente cliente = new ClienteDao().findById(3l);
        new PedidoDao().buscarPedidosPorCliente(cliente)
                .forEach(System.out::println);
    }
    
    public static void main1(String[] args) {
        Cliente cliente = new ClienteDao().findById(3l);
        List<Produto> produtos = new ProdutoDao().findAll();        
        
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDesconto(0.);
        pedido.setValorEntrega(10.);
        pedido.setProdutos(produtos);
        
        pedido.calcularValorTotalItens();
        pedido.calcularValorTotal();
        
        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.save(pedido);
    }
}
