package br.ufc.pds;

import br.ufc.pds.entity.jogador.JogadorHumano;
import br.ufc.pds.pojo.Peca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Teste {

    public static String nomeJogador(int index) {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual o nome do Jogador " + index + "?");
        return input.nextLine();
    }

    public static int numJogadores() {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual a quantidade de Jogadores? Min 2 e Max 6");
        return  Integer.parseInt(input.nextLine());
    }

    public static void esperaQualquer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Aperte Enter");
        String t = input.nextLine();
    }

    public static void informaAvancoJogador(JogadorHumano jogadorHumano) {
        System.out.println();
        System.out.println(jogadorHumano.getNome() + " avançou até o campo " + jogadorHumano.getPeca().obterLocalizacao().getIndice());
        System.out.println(jogadorHumano.getPeca().obterLocalizacao().getNome());
        System.out.println();
    }

    public static int opcaoDoJogadorPropriedadeSemDono() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escolha: ");
        System.out.println("1- Comprar Propriedade;");
        System.out.println("0- Encerrar Turno");
        return  Integer.parseInt(input.nextLine());
    }

    public static int opcaoDoJogadorPropriedadeComDono() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escolha: ");
        System.out.println("1- Fazer uma Oferta pela Propriedade;");
        System.out.println("0- Encerrar Turno");
        return  Integer.parseInt(input.nextLine());
    }
}
