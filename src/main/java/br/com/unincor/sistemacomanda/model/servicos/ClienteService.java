/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unincor.sistemacomanda.model.servicos;

import br.com.unincor.sistemacomanda.model.dao.ClienteDao;
import br.com.unincor.sistemacomanda.model.domain.Cliente;
import br.com.unincor.sistemacomanda.model.exceptions.ClienteException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dioge
 */
public class ClienteService {
    
    public Cliente salvarCliente(Cliente cliente) throws ClienteException {        
        ClienteDao clienteDao = new ClienteDao();
        if(clienteDao.findPorCPF(cliente.getCpf()) != null) {
            throw new ClienteException("Este CPF já se encontra cadastrado");
        }
        if(clienteDao.findPorEmail(cliente.getEmail()) != null) {
            throw new ClienteException("Este e-mail já está cadastrado!");
        }
        
        return clienteDao.save(cliente);
    }
    
    public static void main(String[] args) {
        try {
            Cliente cliente = new Cliente();
            cliente.setNome("Otávio God of War");
            cliente.setCpf("4566");
            cliente.setDataNascimento(new Date());
            cliente.setEmail("godof@war.dead");            
            System.out.println(new ClienteService().salvarCliente(cliente));
        } catch (ClienteException ex) {
            
            System.err.println(ex.getMessage());
            
        }
    }
    
}
