/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class TelaLabirinto extends JFrame
{
    public int[][] labirinto =
    {   
        {0,0,0,0,0,0,0,0,0,0},
        {0,1,1,1,1,1,1,1,3,0}, //1
        {0,1,1,1,1,1,1,1,1,0}, //2
        {0,1,1,1,1,1,1,1,1,0}, //3
        {0,1,1,1,1,1,1,1,1,0}, //4
        {0,1,1,1,1,1,1,1,1,0}, //5
        {0,1,1,1,1,1,1,1,1,0}, //6
        {0,1,1,1,1,1,1,1,1,0}, //7
        {0,1,1,1,1,1,1,1,1,0}, //8
        {0,0,0,0,0,0,0,0,0,0},
    };
    
    public TelaLabirinto()
    {
        setSize(305, 338);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
    }


    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);

            
        for(int linha=0; linha<labirinto.length;linha++)
        {
            for(int coluna=0;coluna <labirinto[0].length;coluna++)
            {
                Color color;
                switch(labirinto[linha][coluna])
                {
                    case 0: color = Color.BLACK; break;
                    case 2: color = Color.RED; break;
                    default : color = Color.WHITE;
                }
                grphcs.setColor(color);
                grphcs.fillRect(30*coluna, 30*linha, 30, 30);
                grphcs.setColor(Color.BLACK);
                grphcs.drawRect(30*coluna, 30*linha, 30, 30);
            }
        }
        
        //grphcs.setColor(Color.GREEN);
        //grphcs.fillOval(1*30, 9*30, 30, 30);
    }
    
}
