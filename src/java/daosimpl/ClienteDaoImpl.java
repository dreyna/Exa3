/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daosimpl;

import daos.ClienteDao;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Docente
 */
public class ClienteDaoImpl implements ClienteDao{
    private Session session;
    @Override
    public List<Cliente> listarCliente() {
        List<Cliente> lista = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            lista = session.createQuery("from Cliente").list();
            t.commit();
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return lista;
        
    }

    @Override
    public boolean registrarCliente(Cliente u) {
        boolean op = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.save(u);
            t.commit();
            op = true;
        } catch (Exception e) {
        }
        return op;
       
    }

    @Override
    public boolean modificarCliente(Cliente u) {
        boolean op = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.update(u);
            t.commit();
            op = true;
        } catch (Exception e) {
        }
        return op;       
    }

    @Override
    public boolean eliminarCliente(Cliente u) {
         boolean op = false;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(u);
        t.commit();
        op = true;
        }catch(Exception e){
            
        }finally{
            session.close();
        }
        return op;
       
    }

    @Override
    public Cliente getCliente(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        return (Cliente) session.load(Cliente.class, id);        
    }

    @Override
    public Cliente buscarCliente(String cl) {
        session = HibernateUtil.getSessionFactory().openSession();
        return (Cliente) session.load(Cliente.class, cl);
       
    }
    
}
