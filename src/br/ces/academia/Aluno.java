/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ces.academia;

import java.util.Date;

/**
 *
 * @author Lucas Gomes
 */
public class Aluno {
    
    private Long id;
    private String nome;
    private Date dataMatricula;
    private String endereco;
    private String telefone;
    private Date dataNascimento;
    private float altura;
    private float peso;

    public Aluno() {
    }

    public Aluno(long id, String nome, Date dataMatricula, String endereco, String telefone, Date dataNascimento, float altura, float peso) {
        this.id = id;
        this.nome = nome;
        this.dataMatricula = dataMatricula;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.peso = peso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", nome=" + nome + ", dataMatricula=" + dataMatricula + ", endereco=" + endereco + ", telefone=" + telefone + ", dataNascimento=" + dataNascimento + ", altura=" + altura + ", peso=" + peso + '}'+"\n";
    }
    
    
    
    
    
    
}
