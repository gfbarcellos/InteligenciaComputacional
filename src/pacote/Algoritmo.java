/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.time.Clock;
import java.util.Random;

/**
 *
 * @author gbarc
 */
public class Algoritmo 
{   
    private static int tamanhoCaminho = 20;
    private static double taxaDeMutacao;
    private static double taxaDeCrossover;
    
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
    
    
    public static Populacao novaGeracao(Populacao populacao, boolean elitismo) 
    {
        Random r = new Random();
        //nova populaÃ§Ã£o do mesmo tamanho da antiga
        Populacao novaPopulacao = new Populacao(populacao.getTamPopulacao());

        //se tiver elitismo, mantÃ©m o melhor indivÃ­duo da geraÃ§Ã£o atual
        if (elitismo) 
        {
            novaPopulacao.setIndividuo(populacao.getIndividuo(0));
        }

        //insere novos indivÃ­duos na nova populaÃ§Ã£o, atÃ© atingir o tamanho mÃ¡ximo
        while (novaPopulacao.getNumIndividuos() < novaPopulacao.getTamPopulacao()) {
            //seleciona os 2 pais por torneio
            Individuo[] pais = selecaoTorneio(populacao);

            Individuo[] filhos = new Individuo[2];

            //verifica a taxa de crossover, se sim realiza o crossover, se nÃ£o, mantÃ©m os pais selecionados para a prÃ³xima geraÃ§Ã£o
            if (r.nextDouble() <= taxaDeCrossover) {
                filhos = crossover(pais[1], pais[0]);
            } else {
                filhos[0] = new Individuo(pais[0].getCaminho());
                filhos[1] = new Individuo(pais[1].getCaminho());
            }

            //adiciona os filhos na nova geraÃ§Ã£o
            novaPopulacao.setIndividuo(filhos[0]);
            novaPopulacao.setIndividuo(filhos[1]);
        }

        //ordena a nova populaÃ§Ã£o
        novaPopulacao.ordenaPopulacao();
        return novaPopulacao;
    }
    
    public static Individuo[] crossover(Individuo individuo1, Individuo individuo2) {
        Random r = new Random();

        //sorteia o ponto de corte
        int pontoCorte1 = r.nextInt((individuo1.getTamanhoInd()/2) -2) + 1;
        int pontoCorte2 = r.nextInt((individuo1.getTamanhoInd()/2) -2) + individuo1.getTamanhoInd()/2;

        Individuo[] filhos = new Individuo[2];

        //pega os genes dos pais
        String[] genePai1 = individuo1.getCaminho();
        String[] genePai2 = individuo2.getCaminho();

        String[] geneFilho1;
        String[] geneFilho2;

        geneFilho1 = copiaGenesPai(genePai1, 0, pontoCorte1);
        geneFilho1 = juntaGenes(geneFilho1, genePai2, pontoCorte1, pontoCorte2);
        geneFilho1= juntaGenes(geneFilho1, genePai1, pontoCorte2, tamanhoCaminho);
        
        geneFilho2 = copiaGenesPai(genePai2, 0, pontoCorte1);
        geneFilho2 = juntaGenes(geneFilho2,genePai1,pontoCorte1, pontoCorte2);
        geneFilho2 = juntaGenes(geneFilho2,genePai2,pontoCorte2,tamanhoCaminho);
        
        //cria o novo indivÃ­duo com os genes dos pais
        filhos[0] = new Individuo(geneFilho1);
        filhos[1] = new Individuo(geneFilho2);

        return filhos;
    }
    
    public static String[] copiaGenesPai(String[] caminho,int inicio, int fim)
    {
        String[] retorno = new String[tamanhoCaminho];
        
        for(int i = inicio; i<fim;i++)
        {
            retorno[i] = caminho[i];
        }
        
        return retorno;
    }
    
     public static String[] juntaGenes(String[] caminhoPrincipal, String[] caminho, int inicio, int fim)
    {
        String[] retorno = new String[tamanhoCaminho];
        
        for(int i = 0; i<inicio;i++)
        {
             retorno[i] = caminhoPrincipal[i]; //Copia a primeira parte
        }
        
        for(int h = inicio; h<fim;h++)
        {
            retorno[h] = caminho[h]; //Copia a segunda parte
        }
        
        return retorno;
    }
    
    public static Individuo[] selecaoTorneio(Populacao populacao) {
        Random r = new Random();
        Populacao populacaoIntermediaria = new Populacao(3);

        //seleciona 3 indivÃ­duos aleatÃ³riamente na populaÃ§Ã£o
        populacaoIntermediaria.setIndividuo(populacao.getIndividuo(r.nextInt(populacao.getTamPopulacao())));
        populacaoIntermediaria.setIndividuo(populacao.getIndividuo(r.nextInt(populacao.getTamPopulacao())));
        populacaoIntermediaria.setIndividuo(populacao.getIndividuo(r.nextInt(populacao.getTamPopulacao())));
        
        //ordena a populaÃ§Ã£o
        populacaoIntermediaria.ordenaPopulacao();

        Individuo[] pais = new Individuo[2];

        //seleciona os 2 melhores deste populaÃ§Ã£o
        pais[0] = populacaoIntermediaria.getIndividuo(0);
        pais[1] = populacaoIntermediaria.getIndividuo(1);

        return pais;
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
