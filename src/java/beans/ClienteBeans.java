/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.ClienteDao;
import daosimpl.ClienteDaoImpl;
import entidades.Cliente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Docente
 */
@ManagedBean (name = "clienteBeans")
@SessionScoped
public class ClienteBeans {
     private Cliente cliente;
     private List<Cliente> clientes;
     
    public Cliente getCliente() {
        return cliente;
    }
    public List<Cliente> getClientes() {
        ClienteDao dao = new ClienteDaoImpl();
        clientes = dao.listarCliente();
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }     
     public ClienteBeans(){
       cliente = new Cliente();
    }    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    //metodos de la tabla cliente
    public void agregarCliente() {
        ClienteDao dao = new ClienteDaoImpl();
        dao.registrarCliente(cliente);
        cliente = new Cliente();
    }
     public void modificarLCliente() {
        ClienteDao dao = new ClienteDaoImpl();
        dao.modificarCliente(cliente);
        cliente = new Cliente();
    }
    public void eliminarCliente() {
        ClienteDao dao = new ClienteDaoImpl();
         dao.eliminarCliente(cliente);
         cliente = new Cliente();
    }    
}
