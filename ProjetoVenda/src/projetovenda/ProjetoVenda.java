/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetovenda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class ProjetoVenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ProjetoVendaPU");
        EntityManager manager = fabrica.createEntityManager();
        Pessoa p = new Pessoa();
        p.setNome("Dener");
        EntityTransaction tran = manager.getTransaction();
        tran.begin();
        manager.persist(p);
        tran.commit();
        // TODO code application logic here
    }
}
