
package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.NotEmpty;


/*
 
  @author Alcídia Cristina
 */
@Entity
public class Medicamentos implements Serializable{
    
    
    private Long id;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String principioAtivo;
    @NotEmpty
    private String concentracao;
    
    private Long quantidade;
    @NotEmpty
    private String formaFarmaceutica;
   
    private int registroAnvisa;
    @NotEmpty
    private String detentorRegistro;
    
    private double preco;
    private List<Imagem> imagens;
    /*private Imagem imagens;*/
    private Farmacia farmacias;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "medicamento_id")
    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }
    /*
    @OneToOne
     public Imagem getImagens() {
        return imagens;
    }

    public void setImagens(Imagem imagens) {
        this.imagens = imagens;
    }
    */


    public String getPrincipioAtivo() {
        return principioAtivo;
    }

   

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(String concentracao) {
        this.concentracao = concentracao;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public int getRegistroAnvisa() {
        return registroAnvisa;
    }

    public void setRegistroAnvisa(int registroAnvisa) {
        this.registroAnvisa = registroAnvisa;
    }

    public String getDetentorRegistro() {
        return detentorRegistro;
    }

    public void setDetentorRegistro(String detentorRegistro) {
        this.detentorRegistro = detentorRegistro;
    }
    
    /*@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "cliente_id")
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }*/

    
    @OneToOne
    public Farmacia getFarmacias() {
        return farmacias;
    }

    public void setFarmacias(Farmacia farmacias) {
        this.farmacias = farmacias;
    }
    

    
   
    
    
}