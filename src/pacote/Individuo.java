/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.util.Random;

public class Individuo
{   
    private String[] caminho = new String[20];
    private int linhaatual;
    private int colunaatual;
    private int aptidao = 0;

    //gera um indivÃ­duo aleatÃ³rio
    public Individuo(int numero) 
    {
        for (int i = 0; i < numero; i++) 
        {
            Random r = new Random();
            String valor = "";
            for (int h = 0; h < 2; h++) {
        	valor += r.nextInt(2);
            }
           caminho[i] = valor;
        }
        
        geraAptidao();      
    }
    
    public Individuo(String[] caminho) {    
        this.caminho = caminho;
        
        Random r = new Random();
        //se for mutar, cria um gene aleatÃ³rio
        if (r.nextDouble() <= Algoritmo.getTaxaDeMutacao()) {
            
            String[] caminhoNovo = new String[20];
            int posAleatoria = r.nextInt(this.caminho.length);
            for (int i = 0; i < this.caminho.length; i++) {
                if (i==posAleatoria){
                    String valor = "";
                    for (int h = 0; h < 2; h++) {
                        valor += r.nextInt(2);
                    }
                    caminhoNovo[i] = valor;
                }else{
                    caminhoNovo[i] = this.caminho[i];
                }
                
            }
            this.caminho = caminhoNovo;   
        }
        geraAptidao();
    }
    
    private void geraAptidao()
    {
        
    }
    
    public int getAptidao() 
    {
        return aptidao;
    }

    public int getLinhaAtual() 
    {
        return this.linhaatual;
    }
    
    public int getColunaAtual()
    {
        return this.colunaatual;
    }
}
