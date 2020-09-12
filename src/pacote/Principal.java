
package pacote;

import java.util.Random;
import javax.swing.SwingUtilities;

public class Principal {
    
    public static int linha = 10;
    public static int coluna = 1;
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                //TelaLabirinto tela = new TelaLabirinto();
               // tela.setVisible(true);
                
                int tamPop = 200;
                int numMaxGeracoes = 150;
                boolean temSolucao = false;
                boolean elitismo = true;
                int geracao = 0;
                /*
                for (int i = 0; i <20; i++) 
                {
                    Random r = new Random();
                    String valor = "";
                    for (int h = 0; h < 2; h++) {
                    valor += r.nextInt(2);
                    }
                    System.out.println(valor);
                }*/

                
                Populacao populacao = new Populacao(20, tamPop);
                while( !temSolucao && geracao < numMaxGeracoes )
                {
                    geracao++;
                    
                    populacao = Algoritmo.novaGeracao(populacao, elitismo);
                    
                    //printar
                    //temSolucao = populacao.temSolucao(Algoritmo.getSolucao());

                    //System.out.println("Aptidao:" + populacao.getIndividuo(0).getAptidao());
                    System.out.println("Linha final: " + populacao.getIndividuo(0).getLinhaAtual() );
                    System.out.println("Coluna final: " + populacao.getIndividuo(0).getColunaAtual());
                    temSolucao = populacao.temSolucao(1, 8);
                    
                    System.out.println("Geração " + geracao + " | Aptidão: " + populacao.getIndividuo(0).getAptidao() );
                    
                    if(temSolucao)
                    {
                        String[] caminho = populacao.getIndividuo(0).getCaminho();
                        System.out.println("Encontrou solução");
                        for(int k=0;k<20;k++)
                        {
                            /*
                            switch(caminho[k])
                            {   
                             //leste ->
                             case "00": System.out.println("L");break;
                            //norte
                            case "01": System.out.println("N"); break; 
                            //oeste <-
                            case "10": System.out.println("O");break;
                            //sul
                            case "11": System.out.println("S");break;
                            }*/
                        }
                        break;
                    }
                    if(geracao == numMaxGeracoes)
                    {
                        //System.out.println("Linha final: " + populacao.getIndividuo(0).getLinhaAtual() );
                       // System.out.println("Coluna final: " + populacao.getIndividuo(0).getColunaAtual());
                        break;
                    }
                }
                
            }
        });
        
        
    }
    
}
