package com.pacientes.app.model;

import java.util.List;

public class InfoPaciente {
    // a quantidade de pacientes
    private int quantidadePacientes;
    //a quantidade de mulheres com altura entre 1,60 e 1,70 e peso acima de 70kg
    private int mulheres;
    // a quantidade de pessoas com idade entre 18 e 25.
    private int pessoas;
    //o nome do paciente mais velho
    private List<String> maisVelhos;
    //o nome da mulher mais baixa
    private List<String> mulheresMaisBaixas;
    //a média de idade dos homens
    private Double media;
    public InfoPaciente() {
    }
    public int getQuantidadePacientes() {
        return quantidadePacientes;
    }
    public void setQuantidadePacientes(int quantidadePacientes) {
        this.quantidadePacientes = quantidadePacientes;
    }
    public Double getMedia() {
        return media;
    }
    public void setMedia(Double media) {
        this.media = media;
    }
    public int getMulheres() {
        return mulheres;
    }
    public void setMulheres(int mulheres) {
        this.mulheres = mulheres;
    }
    public int getPessoas() {
        return pessoas;
    }
    public void setPessoas(int pessoas) {
        this.pessoas = pessoas;
    }
    
    public List<String> getMaisVelhos() {
        return maisVelhos;
    }
    public void setMaisVelhos(List<String> maisVelhos) {
        this.maisVelhos = maisVelhos;
    }
    public List<String> getMulheresMaisBaixas() {
        return mulheresMaisBaixas;
    }
    public void setMulheresMaisBaixas(List<String> mulheresMaisBaixas) {
        this.mulheresMaisBaixas = mulheresMaisBaixas;
    }

}
