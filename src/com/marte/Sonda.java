package com.marte;

public class Sonda {

    private Integer eixox;
    private Integer eixoy;
    private String direcao;

    public Sonda(Integer eixox, Integer eixoy, String direcao){
        this.eixox = eixox;
        this.eixoy = eixoy;
        this.direcao = direcao;
    }


    public Integer getEixox() {
        return eixox;
    }

    public void setEixox(Integer eixox) {
        this.eixox = eixox;
    }

    public Integer getEixoy() {
        return eixoy;
    }

    public void setEixoy(Integer eixoy) {
        this.eixoy = eixoy;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }


    @Override
    public String toString() {
        return "está na posição{" +
                "X=" + eixox +
                ", Y=" + eixoy +
                ", Direção='" + direcao + '\'' +
                '}';
    }
}
