/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetovenda;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Administrador
 */
@Entity
public class Venda implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, length = 50)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda;
    

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente")
    private Pessoa cliente;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "venda")
    private List<ItemVenda> itens;
    
    public Venda(){
        itens = new LinkedList<>();
    }
    
    public void add(ItemVenda item){
        if(!itens.contains(item)){
            item.setVenda(this);
            itens.add(item);
        }
    }
    
    public void remove(ItemVenda item){
        if(itens.contains(item)){
            itens.remove(item);
        }
    }

    
    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

          
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projetovenda.Venda[ id=" + id + " ]";
    }
}
