/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;


public class Populacao
{   
    private Individuo[] individuos;
    private int tamPopulacao;

    public Populacao(int numGenes, int tamPop) {
        tamPopulacao = tamPop;
        individuos = new Individuo[tamPop];
        for (int i = 0; i < individuos.length; i++) {
            individuos[i] = new Individuo(numGenes);
        }
    }
    
    public void setIndividuo(Individuo individuo, int posicao) {
        individuos[posicao] = individuo;
    }
    
    public void setIndividuo(Individuo individuo) {
        for (int i = 0; i < individuos.length; i++) {
            if (individuos[i] == null) {
                individuos[i] = individuo;
                return;
            }
        }
    }
    
     public boolean temSolucao(int linhaSolucao, int colunaSolucao) {
        Individuo i = null;
        for (int j = 0; j < individuos.length; j++) 
        {
            if(individuos[j].getColunaAtual() == linhaSolucao && individuos[j].getColunaAtual() == colunaSolucao)
            {
                i = individuos[j];
                break;
            }
        }
        if (i == null) {
            return false;
        }
        return true;
    }
    
     public void ordenaPopulacao() 
     {
        boolean trocou = true;
        while (trocou) 
        {
            trocou = false;
            for (int i = 0; i < individuos.length - 1; i++) {
                if (individuos[i].getAptidao() < individuos[i + 1].getAptidao()) {
                    Individuo temp = individuos[i];
                    individuos[i] = individuos[i + 1];
                    individuos[i + 1] = temp;
                    trocou = true;
                }
            }
        }
    }
     
      public int getNumIndividuos() {
        int num = 0;
        for (int i = 0; i < individuos.length; i++) {
            if (individuos[i] != null) {
                num++;
            }
        }
        return num;
    }
      
    public int getTamPopulacao() {
        return tamPopulacao;
    }

    public Individuo getIndividuo(int pos) {
        return individuos[pos];
    }
}


