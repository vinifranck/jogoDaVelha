/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jogodavelha;

import java.util.Scanner;

import java.util.*;
public class JogoDaVelha {   
    static String[] tabuleiro;
    static String rodada;
    static String verificarVencedor()
    {
        for (int i=0;i<8;i++) {
            String linha = null;
            switch (i) {
            case 0 -> linha=tabuleiro[0] + tabuleiro[1] + tabuleiro[2];
            case 1 -> linha=tabuleiro[3] + tabuleiro[4] + tabuleiro[5];
            case 2 -> linha=tabuleiro[6] + tabuleiro[7] + tabuleiro[8];
            case 3 -> linha=tabuleiro[0] + tabuleiro[3] + tabuleiro[6];
            case 4 -> linha=tabuleiro[1] + tabuleiro[4] + tabuleiro[7];
            case 5 -> linha=tabuleiro[2] + tabuleiro[5] + tabuleiro[8];
            case 6 -> linha=tabuleiro[0] + tabuleiro[4] + tabuleiro[8];
            case 7 -> linha=tabuleiro[2] + tabuleiro[4] + tabuleiro[6];
            }
            if (linha.equals("XXX")) {
                return "X";
            }
            else if (linha.equals("OOO")) {
                return "O";
            }
        }  
        for (int j=0;j<9;j++) {
            if (Arrays.asList(tabuleiro).contains(
                    String.valueOf(j+1))) {
                break;
            }
            else if (j == 8) {
                return "Empate";
            }
        }
        System.out.println(
            "é a vez de "+rodada + ", escolha uma casa: ");
        return null;
    }
    static void imprimirTabuleiro()
    {
        System.out.println("| "+ tabuleiro[0]+" | "+ tabuleiro[1]+" | "+tabuleiro[2]+" |");
        System.out.println("|-----------|");
        System.out.println("| "+ tabuleiro[3]+" | " +tabuleiro[4]+" | "+tabuleiro[5]+" |");
        System.out.println("|-----------|");
        System.out.println("| "+ tabuleiro[6]+" | "+ tabuleiro[7]+" | " +tabuleiro[8]+" |");
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        tabuleiro = new String[9];
        rodada = "X";
        String vencedor = null;
        for (int i=0;i<9;i++) {
            tabuleiro[i] = String.valueOf(i+1);
        }
        imprimirTabuleiro();
        System.out.println("X jogará primeiro, escolha uma casa");
        while (vencedor == null) {
            int num;
            try {
                num = in.nextInt();
                if (!(num>0 && num<= 9)) {
                    System.out.println("Jogada inválida, tente novamente");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Espaço inválido, tente novamente");
                continue;
            }
            if (tabuleiro[num-1].equals(
                    String.valueOf(num))) {
                tabuleiro[num-1] = rodada;
                if (rodada.equals("X")) {
                    rodada = "O";
                }
                else {
                    rodada = "X";
                }
                imprimirTabuleiro();
                vencedor = verificarVencedor();
            }
            else {
                System.out.println("Este espaço já foi usado, tente novamente");
            }
        }
        if (vencedor.equalsIgnoreCase("Empate")) {
            System.out.println("empatou");
        }
        else {
            System.out.println(vencedor+" ganhou");
        }
    }
}