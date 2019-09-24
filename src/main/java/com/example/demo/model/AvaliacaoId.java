

package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;





@Embeddable
public class AvaliacaoId implements Serializable{

    
@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name="id_cliente")
 private Cliente cliente;

@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_farmacia")
private Farmacia farmacia;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.cliente);
        hash = 11 * hash + Objects.hashCode(this.farmacia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AvaliacaoId other = (AvaliacaoId) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.farmacia, other.farmacia)) {
            return false;
        }
        return true;
    }

}
