package com.marte;

import java.util.*;

public class Controle {

    public static List<Sonda> sondas = new ArrayList<>();
    public static Planalto planalto;
    public static Sonda s;

    public static void main(String[] args) {
        menu();
    }

    public static void cadastraPlanalto() {
        try {
            System.out.println("Insira a largura do planalto (eixo X)");
            Integer eixox = new Scanner(System.in).nextInt();
            System.out.println("Insira o comprimento do planalto (eixo Y)");
            Integer eixoy = new Scanner(System.in).nextInt();
            planalto = new Planalto(eixox, eixoy);
            System.out.println("Área de exploração para as sondas foi definida");
        } catch (InputMismatchException e) {
            System.out.println("Apenas números inteiros são válidos");
            cadastraPlanalto();
        }
    }

    public static void cadastrarSonda() {
       if(planalto != null){
           Integer sondax;
           Integer sonday;
           try {
               System.out.println("Entra com a posição da sonda no eixo X");
               do {
                   sondax = new Scanner(System.in).nextInt();
                   if(sondax > planalto.getEixox() || sondax < 0){
                       System.out.println("Você não pode pousar uma sonda fora da área de exploração definida, área definida foi de: 0 á " + planalto.getEixox());
                   }
               } while (sondax > planalto.getEixox() || sondax < 0);
               System.out.println("Entra com a posição da Sonda no eixo Y");
               do {
                   sonday = new Scanner(System.in).nextInt();
                   if(sonday > planalto.getEixoy() || sonday < 0){
                       System.out.println("Você não pode pousar uma sonda fora da área de exploração definida, área definida foi de: 0 á " + planalto.getEixoy());
                   }
               } while (sonday > planalto.getEixoy() || sonday < 0);
               System.out.println("Entra com a direção para a qual a sonda está apontada as opções podem ser N (Norte), S (Sul), W (Oeste), E (Leste)");
               String sondaD;
               do {
                   sondaD = new Scanner(System.in).next();
               } while (!sondaD.equals("N") && !sondaD.equals("S") && !sondaD.equals("W") && !sondaD.equals("E"));
               Sonda sonda = new Sonda(sondax, sonday, sondaD);
               sondas.add(sonda);
               System.out.println("Sonda cadastrada com sucesso");
           } catch (InputMismatchException e) {
               System.out.println("Entre com um valor correspondente");
               cadastrarSonda();
           }
       }
       else{
           System.out.println("Caro explorador é necessário definir uma área limite para exploração antes de inserir uma sonda");
           System.out.println("Você não vai querer que uma delas pouse em um lugar desconhecido não é mesmo ?");
       }
    }

    public static void mostraSondasCadastradas() {
        if(sondas.isEmpty()){
            System.out.println("Caro explorador não existe nenhuma sonda registradas");
        }else{
            for (Sonda sonda : sondas) {
                System.out.println("Sonda número " + sondas.indexOf(sonda) +" " + sonda.toString());
            }
        }
    }

    public static void manusearSonda() {
        if (!sondas.isEmpty() && planalto != null) {
            String manuseio;
            Integer index;
            System.out.println("Lista de sondas para manuseiro");
            //Aqui eu varro e mostro todas as sondas cadastradas e suas posições
            mostraSondasCadastradas();
            System.out.println("Escolha uma sonda da lista, para isso digite o número da sonda");
            //Aqui eu pego uma sonda Cadastrada
            do {
                index = new Scanner(System.in).nextInt();
                if(index >= sondas.size() || index <= 0){
                    System.out.println("Sonda de número " + index + " inexistente, o número de uma sonda cadastrada");
                }
            } while (index >= sondas.size() || index <= 0);
            s = sondas.get(index);
            System.out.println("Entre com os comandos para manusear a sonda, L para virar a esquerda, M para mover a sonda para direção apontada ou R para virar a sonda para direita");
            manuseio = new Scanner(System.in).next();
            manuseio = manuseio.toUpperCase();
            for (int i = 0; i < manuseio.length(); i++) {
                Character c = manuseio.charAt(i);
                if (c.equals('L') || c.equals('M') || c.equals('R')) {
                    rosaDosVentos(c, s);
                } else {
                    System.out.println(c + " Não é um caractére válido");
                }
            }
        }else{
            System.out.println("Caro explorador para poder utilizar está opção é necessário antes ter as medidas do planato definidas e ao menos uma sonda cadastrada");
        }
    }

    public static void rosaDosVentos(Character c, Sonda sonda) {
        Integer va = 0;
        switch (sonda.getDirecao()) {
            case "N":
                if (c.equals('L')) {
                    sonda.setDirecao("W");
                } else if (c.equals('R')) {
                    sonda.setDirecao("E");
                } else if (c.equals('M')) {
                    va = (sonda.getEixoy() + 1);
                    if (va > planalto.getEixoy()) {
                        va = planalto.getEixoy();
                        System.out.println("A sonda atingiu o limite do planato " + va);
                    }
                    sonda.setEixoy(va);
                }
                ;
                break;
            case "S":
                if (c.equals('L')) {
                    sonda.setDirecao("E");
                } else if (c.equals('R')) {
                    sonda.setDirecao("W");
                } else if (c.equals('M')) {
                    va = (sonda.getEixoy() - 1);
                    if (va < 0) {
                        va = 0;
                        System.out.println("A sonda atingiu o limite do planato " + va);
                    }
                    sonda.setEixoy(va);
                }
                ;
                break;
            case "W":
                if (c.equals('L')) {
                    sonda.setDirecao("S");
                } else if (c.equals('R')) {
                    sonda.setDirecao("N");
                } else if (c.equals('M')) {
                    va = (sonda.getEixox() - 1);
                    if (va < 0) {
                        va = 0;
                        System.out.println("A sonda atingiu o limite do planato " + va);
                    }
                    sonda.setEixox(va);
                }
                ;
                break;
            case "E":
                if (c.equals('L')) {
                    sonda.setDirecao("N");
                } else if (c.equals('R')) {
                    sonda.setDirecao("S");
                } else if (c.equals('M')) {
                    va = (sonda.getEixox() + 1);
                    if (va > planalto.getEixox()) {
                        va = planalto.getEixox();
                        System.out.println("A sonda atingiu o limite do planato " + va);
                    }
                    sonda.setEixox(va);
                }
                break;
            default:
                break;
        }
    }

    private static void menu() {
        Integer opcao = 0;
        System.out.println("Bem vindo caro usuário, este é o programa para exploração de Marte");
        System.out.println("Confira o menu de ações abaixo: ");
        do {
            System.out.println("|------------------------------------------|");
            System.out.println("| 1 - Cadastrar área limite de exploração  |");
            System.out.println("| 2   Cadastrar uma sonda                  |");
            System.out.println("| 3 - Manusear uma sonda                   |");
            System.out.println("| 4 - Listar todas as sondas e posições    |");
            System.out.println("| 5 - Finalizar o programa                 |");
            System.out.println("|------------------------------------------|\n\n");
            System.out.print("Digite uma das opções listadas: ");
            try {
                opcao = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("A opção escolhida não é uma opção válida");
            }
            switch (opcao) {
                case 1:
                    cadastraPlanalto();
                    break;
                case 2:
                    cadastrarSonda();
                    break;
                case 3:
                    manusearSonda();
                    break;
                case 4:
                    mostraSondasCadastradas();
                    break;
                case 5:
                    System.out.println("Muito obrigado por utilizar nosso sistema e até breve caro explorador");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 5);
    }
}
