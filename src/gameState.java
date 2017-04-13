package src;

import java.awt.event.*;

public class gameState implements KeyListener
{


   public void keyPressed(KeyEvent e)
   {
      if(e.getKeyCode() == KeyEvent.VK_UP)
      {
         System.out.println("UP Pressed");
      }
      else if(e.getKeyCode() == KeyEvent.VK_DOWN) 
      {
         System.out.println("DOWN Pressed");
      }
      else if(e.getKeyCode() == KeyEvent.VK_LEFT) 
      {
         System.out.println("LEFT Pressed");
      }
      else if(e.getKeyCode() == KeyEvent.VK_RIGHT) 
      {
         System.out.println("RIGHT Pressed");
      }
   }
   public void keyReleased(KeyEvent e)
   {

   }
   public void keyTyped(KeyEvent e)
   {

   }


}
