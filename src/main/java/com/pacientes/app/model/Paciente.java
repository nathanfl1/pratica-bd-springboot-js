package com.pacientes.app.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@EntityScan
@Table(name = "paciente")
public class Paciente {

    @Column("nome")
    private String nome;
    @Column("genero")
    private String genero;
    @Column("codigo")
    private int codigo;
    @Column("peso")
    private double peso;
    @Column("idade")
    private int idade;
    @Column("altura")
    private double altura;
    public Paciente()
    {

    }
    public Paciente(String nome, String genero, int codigo, double peso, int idade, double altura) {
        this.nome = nome;
        this.genero = genero;
        this.codigo = codigo;
        this.peso = peso;
        this.idade = idade;
        this.altura = altura;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
}
