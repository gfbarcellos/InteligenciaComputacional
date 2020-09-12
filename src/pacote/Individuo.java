/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.util.Random;

public class Individuo
{   
    private int tamanhoInd = 20;
    private String[] caminho = new String[tamanhoInd];
    private int linhaatual = 8;
    private int colunaatual = 1;
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
        String posicao = "";
        for(int i=0;i<20;i++)
        {   
            int linhaAux = linhaatual;
            int colunaAux = colunaatual;
            switch(caminho[i])
            {   
                //leste ->
                case "00": this.colunaatual++;posicao = "L";break;
                //norte
                case "01": this.linhaatual--;posicao = "N";break;  
                //oeste <-
                case "10": this.colunaatual--;posicao = "O";break;
                //sul
                case "11": this.linhaatual++;posicao = "S";break;
                
                default: System.out.println("Erro no caminho");
            }
            if( linhaatual  >0  && linhaatual  <9  && colunaatual > 0 && colunaatual <9)
            {
                boolean flagParede = false;
                for(int j=0;j<Algoritmo.paredes.length;j++)
                {        
                    int linhaparede = Integer.parseInt(Algoritmo.paredes[j][0]);
                    int colunaparede = Integer.parseInt(Algoritmo.paredes[j][1]);
                    if (linhaparede == linhaAux && colunaparede == colunaAux) 
                    {   
                        for(int h=2;h<5;h++)
                        {
                            if(Algoritmo.paredes[j][h].equals(posicao))//Encontrou uma parede
                            {
                                flagParede = true;
                            }
                        }
                    }
                }
                if (flagParede)
                {
                    aptidao = aptidao - 20;
                }
                else
                {
                    aptidao = aptidao + 5; //Caminho válido
                }
            }
            else
            {
                aptidao = aptidao - 100;
            }   
        }
        aptidao = aptidao - ( linhaatual - 1 ) * 3;
        aptidao = aptidao - ( 8 - colunaatual ) * 3;
        //System.out.println("/Ap:" + aptidao);  
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
    
    public int getTamanhoInd()
    {
        return this.tamanhoInd;
    }
    
    public String[] getCaminho()
    {
        return this.caminho;
    }
}
