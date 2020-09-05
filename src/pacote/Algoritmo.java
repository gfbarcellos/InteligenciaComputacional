/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.time.Clock;

/**
 *
 * @author gbarc
 */
public class Algoritmo 
{   
    private static int linhaSolucao;
    private static int colunaSolucao;
    private static double taxaDeCrossover;
    private static double taxaDeMutacao;
    
    public int[][] matriz =
    {   
        {0,0,0,0,0,0,0,0}, 
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0}, 
        {0,0,0,0,0,0,0,0}, 
        {0,0,0,0,0,0,0,0}, 
        {0,0,0,0,0,0,0,0}, 
        {0,0,0,0,0,0,0,0}, 
        {0,0,0,0,0,0,0,0}, 
    };
    
    public void setMatriz( int[][] matriz )
    {   
        int lm=0, cm=0;
        for(int linha=1; linha<matriz.length-1;linha++)
        {   
            for(int coluna=1;coluna <matriz[0].length-1;coluna++)
            {   
                this.matriz[lm][cm] = matriz[linha][coluna]; 
                cm++;
            }   
            lm++;
            cm=0;
        }

    }
    
    public int[][] getMatriz()
    {
        return this.matriz;
    }
    
    public static void setSolucao(int linha, int coluna) 
    {
        Algoritmo.linhaSolucao = linha;
        Algoritmo.colunaSolucao = coluna;
    }
    
    public static double getTaxaDeCrossover() {
        return taxaDeCrossover;
    }

    public static void setTaxaDeCrossover(double taxaDeCrossover) {
        Algoritmo.taxaDeCrossover = taxaDeCrossover;
    }

    public static double getTaxaDeMutacao() {
        return taxaDeMutacao;
    }

    public static void setTaxaDeMutacao(double taxaDeMutacao) {
        Algoritmo.taxaDeMutacao = taxaDeMutacao;
    }
            
}
