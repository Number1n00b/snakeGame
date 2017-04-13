package src;

public class output
{
   /*Quick print statement to clear the screan.*/
   public static void clearScreen()
   {
      System.out.print("\033[H\033[2J");
      System.out.flush();
   }

}
