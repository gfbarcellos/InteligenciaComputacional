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
    private static int linhaSolucao = 1;
    private static int colunaSolucao = 7;
    private static double taxaDeCrossover;
    private static double taxaDeMutacao;
    
    public static int[][] matriz =
    {   
        {1,1,1,1,1,1,1,1,1}, 
        {1,0,0,0,0,0,0,2,1},
        {1,0,0,0,0,0,0,0,1}, 
        {1,0,0,0,0,0,0,0,1}, 
        {1,0,0,0,0,0,0,0,1}, 
        {1,0,0,0,0,0,0,0,1}, 
        {1,0,0,0,0,0,0,0,1}, 
        {1,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1}
    };
    
    public static String[][] paredes =
    {
        {"4","1","L","-","-"},
        {"7","1","L","-","-"},
        {"1","2","S","L","-"},
        {"2","2","N","-","-"},
        {"3","2","S","-","-"},
        {"4","2","N","O","L"},
        {"5","2","L","-","-"},
        {"7","2","O","-","-"},
        {"1","3","O","-","-"},
        {"2","3","L","S","-"},
        {"3","3","N","-","-"},
        {"4","3","O","L","-"},
        {"5","3","O","L","-"},
        {"6","3","S","-","-"},
        {"7","3","N","L","-"},
        {"2","4","O","-","-"},
        {"3","4","L","-","-"},
        {"4","4","O","-","-"},
        {"5","4","O","S","-"},
        {"6","4","N","-","-"},
        {"7","4","O","-","-"},
        {"1","5","L","-","-"},
        {"2","5","S","-","-"},
        {"3","5","N","O","-"},
        {"4","5","S","-","-"},
        {"5","5","N","-","-"},
        {"7","5","L","S","-"},
        {"8","5","N","-","-"},
        {"1","6","O","-","-"},
        {"2","6","L","-","-"},
        {"5","6","L","S","-"},
        {"6","6","N","-","-"},
        {"7","6","L","O","-"},
        {"2","7","O","-","-"},
        {"3","7","L","-","-"},
        {"5","7","L","O","-"},
        {"6","7","S","-","-"},
        {"7","7","O","N","-"},
        {"8","7","L","-","-"},
        {"3","8","O","S","-"},
        {"4","8","N","-","-"},
        {"5","8","O","-","-"},
        {"8","8","O","-","-"}
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
