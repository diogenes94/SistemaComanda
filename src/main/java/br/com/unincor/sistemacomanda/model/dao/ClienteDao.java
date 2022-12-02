/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unincor.sistemacomanda.model.dao;

import br.com.unincor.sistemacomanda.model.domain.Cliente;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author dioge
 */
public class ClienteDao extends GenericDAO<Cliente, Long> {
    
    public Cliente findPorCPF(String cpf) {
        Query query = getEntityManagerReadOnly()
                .createQuery("from Cliente c where c.cpf = :cpf", Cliente.class)
                .setParameter("cpf", cpf);
        List<Cliente> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
    
    public Cliente findPorEmail(String email) {
        Query query = getEntityManagerReadOnly()
                .createQuery("from Cliente c where c.email = :email", Cliente.class)
                .setParameter("email", email);
        List<Cliente> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Diogenes");
        cliente.setCpf("1234");
        cliente.setDataNascimento(new Date());
        cliente.setEmail("teste@mail.com");
        cliente.setCelular("35988220819");
        
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.save(cliente);
    }
}
