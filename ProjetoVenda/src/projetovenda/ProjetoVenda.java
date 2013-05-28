/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetovenda;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import projetovenda.Produto;

/**
 *
 * @author Administrador
 */
public class ProjetoVenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PessoaDAO dao = new PessoaDAO();

        Pessoa teste = new Pessoa();
        teste.setNome("teste");
        dao.Salvar(teste);

        for (Pessoa p : dao.Buscar(0, 1000)) {
            System.out.println(p);
        }
    }
//        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ProjetoVendaPU");
//        EntityManager manager = fabrica.createEntityManager();
//          Pessoa p = new Pessoa(); p.setNome("Dener"); EntityTransaction tran =
//          manager.getTransaction(); tran.begin(); manager.persist(p);
//          tran.commit();
//        Query consulta = manager.createQuery("select p form Produto p"
//                + "where p.preco < :preco"
//                + "order by p.nome");
//
//        consulta.setFirstResult(9);
    //consulta.setMaxResults(3);
    //consulta.setParameter("preco", 10);
//        List<Produto> lista = consulta.getResultList();
//        for (Produto p : lista) {
//            System.out.println(p);
//        }
//}
}
