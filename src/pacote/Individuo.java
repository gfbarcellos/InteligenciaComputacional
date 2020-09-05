/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.util.Random;

public class Individuo
{   
    private int[] caminho;
    private int aptidao = 0;

    //gera um indivÃ­duo aleatÃ³rio
    public Individuo(int numero) 
    {
        for (int i = 0; i < numero; i++) 
        {
           Random rand = new Random();
           int randomValue = rand.nextInt() % 2;
           caminho[i] = randomValue;
        }
        
        geraAptidao();      
    }
    
    private void geraAptidao()
    {
        
    }
}
