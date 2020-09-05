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
        for(int linha=2; linha<matriz.length-1;linha++)
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
            
}
