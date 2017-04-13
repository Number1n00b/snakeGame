package src;

/**
 * A class to handle user input to the game Snake.
 * 
*/

public class inputThread implements Runnable
{

   private String inputStr = " ";
   private String threadName = "default_thread_name";
   
   private snakePlayer player;

   /*Constructor*/
   public inputThread(String threadName, snakePlayer inputPlayer)
   {
      this.threadName = threadName;
      player = inputPlayer;
   }

   public void run()
   {
      while(!player.isDead())
      {
         String temp = inputStr;
         inputStr = myInput.readString();

         /*Just catch the last letter entered.*/
         try{
            temp = inputStr.substring(inputStr.length() - 1).toLowerCase();
         }
         catch(Exception e){
            clearInput();
            temp = " ";
         }
         if(temp.equals("w"))
         {
            player.move("UP", true);
         }
         else if(temp.equals("a"))
         {
            player.move("LEFT", true);
         }
         else if(temp.equals("s"))
         {
            player.move("DOWN", true);
         }
         else if(temp.equals("d"))
         {
            player.move("RIGHT", true);
         }

      }
   }

   public void start()
   {
      Thread tob = new Thread(this, threadName);
      tob.start();
   }

   public void clearInput()
   {
      inputStr = " ";
   }

}
