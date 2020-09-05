
package pacote;

import javax.swing.SwingUtilities;

public class Principal {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                //TelaLabirinto tela = new TelaLabirinto();
               // tela.setVisible(true);
                Tela tela = new Tela();
                tela.setVisible(true);
            }
        });
        
        
    }
    
}
