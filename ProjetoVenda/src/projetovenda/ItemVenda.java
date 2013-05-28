/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetovenda;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name="itensvendas")
public class ItemVenda implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Venda venda;

    
    @ManyToOne(fetch= FetchType.EAGER)
    private Produto produto;
    
    @Column(nullable=false)
    private Integer quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemVenda other = (ItemVenda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.venda);
        hash = 17 * hash + Objects.hashCode(this.produto);
        return hash;
    }

    
    @Override
    public String toString() {
        return "projetovenda.ItemVenda[ id=" + id + " ]";
    }
    
}
