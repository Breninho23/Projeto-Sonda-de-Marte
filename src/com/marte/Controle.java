package com.marte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controle {

    public static List<Sonda> sondas = new ArrayList<>();

    public static class Planato{
        private Integer eixox;
        private Integer eixoy;

        public Planato(Integer eixox, Integer eixoy){
            this.eixox = eixox;
            this.eixoy = eixoy;
        }
    }

    //Menu 1 Defina as dimensões do planalto;
    //Menu 2 Cadastrar Nova sonda;
    //Menu 3 Mover sonda;

    /*
        Tamanho do planalto 8, 8
        Posiçao Inicial 0,0 N (new Sonda(0,0,N))
        List sondas.add(sonda);
        Comandos (cadastrar nova sonda)
        Lista de entradas possíveis:
        N: cadastrar nova sonda,
        R: virar sonda a direita,
        M: mover sonda,
        L: virar sonda a esquerda.
        */

    /*
    Lista de sondas no planalto:
    Sonda 1 (3, 2, W)
    Sonda 2 (1, 2, S)
     */
    public void moverSonda(){

    }

    Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        // 1. Entrando com o tamanho do planalto
        System.out.println("Entra com a porra do planalto X");
        Integer eixox = new Scanner(System.in).nextInt();
        System.out.println("Entra com a porra do planalto Y");
        Integer eixoy = new Scanner(System.in).nextInt();
        Planato planato = new Planato(eixox, eixoy);

        System.out.println("Criar uma sonda");
        System.out.println("Entra com a porra da Sonda no eixo X");
        Integer sondax = new Scanner(System.in).nextInt();
        System.out.println("Entra com a porra da Sonda no eixo Y");
        Integer sonday = new Scanner(System.in).nextInt();
        System.out.println("Entra com a porra da direção da Sonda");

        //Fazer Correção para implantação de Norte Sul Lest Oeste
        String sondaD = new Scanner(System.in).next();

        Sonda sonda = new Sonda(sondax,sonday,sondaD);
        sondas.add(sonda);

        System.out.println(sondas.get(0));
    }
}
