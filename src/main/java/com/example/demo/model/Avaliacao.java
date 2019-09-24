

package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Avaliacao implements Serializable{
    
   @EmbeddedId
   private AvaliacaoId id;
   private int nota;
   private String comentario;
   private Date data;
   
   /* private Cliente cliente;
    private Farmacia farmacia;*/

    
    
   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    /*
   @OneToOne
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @OneToOne
    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    } */

    public AvaliacaoId getId() {
        return id;
    }

    public void setId(AvaliacaoId id) {
        this.id = id;
    }

    
    }

    

    
    
    

