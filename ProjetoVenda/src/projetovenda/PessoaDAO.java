/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetovenda;


import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Administrador
 */
public class PessoaDAO {

    EntityManager manager;

    public PessoaDAO() {
        EntityManagerFactory pessoa = Persistence.createEntityManagerFactory("ProjetoVendaPU");
    }

    
    
    public void Salvar(Pessoa p) {

        EntityTransaction tran = manager.getTransaction();
        try {
            tran.begin();
            manager.persist(p);
            tran.commit();
        } catch (Exception ex) {
            tran.rollback();
        }
    }

    public void Apagar(Pessoa p) {

        EntityTransaction tran = manager.getTransaction();
        try {
            tran.begin();
            manager.remove(p);
            tran.commit();
        } catch (Exception ex) {
            tran.rollback();
        }
    }

    public Pessoa Abrir(Long id) {

        return (Pessoa) manager.find(Pessoa.class, id);

    }

    public List<Pessoa> Buscar(int inicio, int qtd) {
        Query consulta = (Query) manager.createQuery("Select p from Produto p" + " order by p.nome");
        consulta.setFirstResult(inicio);
        consulta.setMaxResults(qtd);
        List<Pessoa> lista = consulta.getResultList();
        return lista;
    }
      
}