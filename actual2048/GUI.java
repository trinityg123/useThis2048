import java.awt.*;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;
import javax.swing.*;

/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI
{
   Game game = new Game();
    
   int frameHeight = 394;
   int frameWidth = 328;
   int gameBoardSize = 296;
   int marginSize = 16;
   Color backgroundColor = new Color(255, 225,120);
   
   Map numberTiles;
   
   JFrame frame;
   
   public GUI(){
       frame = new JFrame();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       loadNumberTiles();
       
       GameBoard gb = new GameBoard();
       
       //north panel
       JPanel northPanel = new JPanel();
       northPanel.setLayout(new GridLayout());
       northPanel.setPreferredSize(new Dimension(frameWidth, 82));
       
       JLabel gameLabel = new JLabel("1024", SwingConstants.CENTER);
       gameLabel.setFont(new Font("Serif", Font.BOLD, 20));
       northPanel.add(gameLabel);
       northPanel.add(new JLabel("<html>Score:<br>524</html>", SwingConstants.CENTER));
       northPanel.add(new JLabel("<html> Hight Score: <br>2260</html>", SwingConstants.CENTER));
       northPanel.setBackground(backgroundColor);
       
       //other panels
       JPanel westBuffer = new JPanel();
       westBuffer.setPreferredSize(new Dimension(marginSize, gameBoardSize));
       westBuffer.setBackground(backgroundColor);
       
       JPanel eastBuffer = new JPanel();
       eastBuffer.setPreferredSize(new Dimension(marginSize, gameBoardSize));
       eastBuffer.setBackground(backgroundColor);
       
       JPanel southBuffer = new JPanel();
       southBuffer.setPreferredSize(new Dimension(frameWidth, marginSize));
       southBuffer.setBackground(backgroundColor);
       
       //add panels to frame
       frame.getContentPane().add(northPanel, BorderLayout.NORTH);
       frame.getContentPane().add(westBuffer, BorderLayout.WEST);
       frame.getContentPane().add(eastBuffer, BorderLayout.EAST);
       frame.getContentPane().add(southBuffer, BorderLayout.SOUTH);
       frame.getContentPane().add(gb, BorderLayout.CENTER);
       
       frame.getContentPane().setPreferredSize(new Dimension(frameWidth, frameHeight));
       frame.pack();
       frame.setVisible(true);
   }
   
   private void loadNumberTiles(){
       numberTiles = new Hashtable();
       ClassLoader cldr = this.getClass().getClassLoader();
       URL url0000 = cldr.getResource("bin/images/tile00.PNG");
       URL url0001 = cldr.getResource("bin/images/tile01.PNG");
       URL url0002 = cldr.getResource("bin/images/tile02.PNG");
       URL url0004 = cldr.getResource("bin/images/tile04.PNG");
       URL url0008 = cldr.getResource("bin/images/tile08.PNG");
       URL url0016 = cldr.getResource("bin/images/tile16.PNG");
       URL url0032 = cldr.getResource("bin/images/tile32.PNG");
       URL url0064 = cldr.getResource("bin/images/tile64.PNG");
       URL url0128 = cldr.getResource("bin/images/tile128.PNG");
       URL url0256 = cldr.getResource("bin/images/tile256.PNG");
       URL url0512 = cldr.getResource("bin/images/tile512.PNG");
       URL url1024 = cldr.getResource("bin/images/tile1024.PNG");
       
       numberTiles.put(0, new ImageIcon(url0000));
       numberTiles.put(1, new ImageIcon(url0001));
       numberTiles.put(2, new ImageIcon(url0002));
       numberTiles.put(4, new ImageIcon(url0004));
       numberTiles.put(8, new ImageIcon(url0008));
       numberTiles.put(16, new ImageIcon(url0016));
       numberTiles.put(32, new ImageIcon(url0032));
       numberTiles.put(64, new ImageIcon(url0064));
       numberTiles.put(128, new ImageIcon(url0128));
       numberTiles.put(256, new ImageIcon(url0256));
       numberTiles.put(512, new ImageIcon(url0512));
       numberTiles.put(1024, new ImageIcon(url1024));
    }
    
   class GameBoard extends JPanel{
       protected void paineComponent(Graphics g){
           g.setColor(new Color (20, 20, 20));
           g.fillRect(0,0, this.getWidth(), this.getHeight());
           int[][] test = {
               {0, 1, 2, 4}, 
               {8, 16, 32, 64 },
               {128, 256, 512, 1024},
               {0, 0, 0, 0}
            };
           for (int y=1; y<5; y++){
               for (int x=1; x<5; x++){
                   int X = (8*x) + (64 * (x-1));
                   int Y = (8*y) + (64 * (y-1));
                   
                   int thisNumber = test[y-1][x-1];
                   
                   if (numberTiles.containsKey(thisNumber)){
                       ImageIcon thisTile = (ImageIcon)numberTiles.get(thisNumber);
                       thisTile.paintIcon(this, g, X, Y);
                    }
                   
                }
            }
        }   
    }
}
