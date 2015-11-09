/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Cliente;
import java.util.List;

/**
 *
 * @author Docente
 */
public interface ClienteDao {
    public List<Cliente> listarCliente();
    public boolean registrarCliente(Cliente u);
    public boolean modificarCliente(Cliente u);
    public boolean eliminarCliente(Cliente u);
    public Cliente getCliente(int id);
    public Cliente buscarCliente(String cl);
}
