package src;

public class snake
{

private static int X_MAX_WIDTH = 50;
private static int Y_MAX_HEIGHT = 20;

public static int gameDelay = 200;

public static void main(String[] args) throws InterruptedException
{

   /*Create the required datatypes*/ 
   char[] mainMenuChoices = {'s', 'o', 'q'};
   myMenu mainMenu = new myMenu(mainMenuChoices, "1. Start (s)", "2. Options (o)", "3. Quit (q)");

   snakePlayer playerOne = new snakePlayer( X_MAX_WIDTH, Y_MAX_HEIGHT );

   System.out.println("Welcome to Snake by Christian Brunette!");
   System.out.println("Please choose an option: ");
   mainMenu.printMenu();
   mainMenu.userInput();

   if(mainMenu.getChoice() == 'q')
   {
      System.out.println("Quitting");
   }
   else if(mainMenu.getChoice() == 'o')
   {
      System.out.println("Opening options menu. (IMPLEMENTED LATER)");
   }
   else
   {
      System.out.println("Running game.");
   
      items snakeItems = new items(X_MAX_WIDTH, Y_MAX_HEIGHT);

      inputThread controls = new inputThread("Controls", playerOne);
      controls.start();

      int numMoves = 0;

      while(!playerOne.isDead())
      {
      
         output.clearScreen();
         if(snakeItems.wasEaten())
         {
            snakeItems.makeNewFood();
         }

         /*Print standard src.output.*/
         printAll(playerOne, snakeItems);
         System.out.println("Controls: W,A,S,D then ENTER!");
         System.out.println("Score: " + playerOne.currentSize());
         System.out.println("Number of turns: " + numMoves);
         
         /*Move player.*/
         playerOne.move(false);
         /*If head moves through an item, eat it.*/

         /*Print head coords and item coords for player use.*/
         System.out.println(playerOne.headPosToStr());
         snakeItems.printCoords();

         /*Implement gamespeed.*/
         Thread.sleep(gameDelay);

         if(snakeItems.has(playerOne.getHead()[0], playerOne.getHead()[1]))
         {
            snakeItems.eat(playerOne.getHead()[0], playerOne.getHead()[1]);
         }
         else
         {
            playerOne.removeLast();
         }
         
         numMoves++;

         playerOne.checkIfDead();
      }

      System.out.println("GAME OVER!");
      System.out.println("Final Score: " + playerOne.currentSize());
      
   }

   System.exit(0);
}

public static void printAll(snakePlayer player, items snakeItems)
{
/**
 * ii = X AXIS!
 * jj = Y AXIS!
 */

   /*Check every "pixel" within boundries.*/
   for(int jj = 0; jj < Y_MAX_HEIGHT; jj++)
   {
      /*Check row by row*/
      for(int ii = 0; ii < X_MAX_WIDTH; ii++)
      {

         /*If is boundry, print #*/
         if(ii == 0 || ii == X_MAX_WIDTH-1 || jj == 0 || jj == Y_MAX_HEIGHT - 1)
         {
               System.out.print("#");
         }
         /*If it is a player, print respective icon.*/
         else if(player.has(ii, jj))
         {
            if(player.isHead(ii, jj))
            {
               System.out.print("1");
            }
            else
            {
               System.out.print("0");
            }
         }
         /*Else if it's an item, print that item.*/
         else if(snakeItems.has(ii, jj))
         {
            System.out.print("@");
         }
         else
         {
            System.out.print(" ");
         }

         if(ii == X_MAX_WIDTH - 1)
         {
            System.out.printf("\n");
         }

      }

   }
}

}
















