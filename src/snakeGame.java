package src;

public class snakeGame
{
   private String gameName;

   /*Game option variables.*/
   private int X_MAX_WIDTH;
   private int Y_MAX_HEIGHT;

   private int gameDelay;

   /*Menu options, always the same for every src.snake game.*/
   private char[] mainMenuChoices;
   private myMenu mainMenu;

   private char[] optionMenuChoices;
   private myMenu optionMenu;

   /*Game variables.*/
   snakePlayer playerOne;
   items gameItems;
   inputThread controls;

   /*Default constructor*/
   public snakeGame()
   {
      gameName = new String("default_name");
      
      setXMax(30);
      setYMax(20);
      gameDelay = 250;

      mainMenuChoices = new char[]{'s', 'o', 'q'};
      mainMenu = new myMenu(mainMenuChoices, "1. Start (s)", "2. Options (o)", "3. Quit (q)");

      optionMenuChoices = new char[]{'x', 'y', 's'};
      optionMenu = new myMenu(optionMenuChoices, "1. x_max", "2. y_max", "3. gameSpeed");

      playerOne = new snakePlayer(X_MAX_WIDTH, Y_MAX_HEIGHT);
      gameItems = new items(X_MAX_WIDTH, Y_MAX_HEIGHT);
      controls = new inputThread("Snake Controls", playerOne);
   }

   /*Customisable constructor.*/
   public snakeGame(String gameName, int xMax, int yMax, int gameDelay)
   {
      gameName = new String(gameName);
      
      setXMax(xMax);
      setYMax(yMax);
      this.gameDelay = gameDelay;

      mainMenuChoices = new char[]{'s', 'o', 'q'};
      mainMenu = new myMenu(mainMenuChoices, "1. Start (s)", "2. Options (o)", "3. Quit (q)");

      optionMenuChoices = new char[]{'x', 'y', 's', 'b'};
      optionMenu = new myMenu(optionMenuChoices, "1. x_max", "2. y_max", "3. gameSpeed", "4.back");

      playerOne = new snakePlayer(X_MAX_WIDTH, Y_MAX_HEIGHT);
      gameItems = new items(X_MAX_WIDTH, Y_MAX_HEIGHT);
      controls = new inputThread("Snake Controls", playerOne);
   }

   public void setXMax(int max)
   {
      X_MAX_WIDTH = max;
   }

   public void setYMax(int max)
   {
      Y_MAX_HEIGHT = max;
   }

   /*Accesor to print src.gameState*/
   public void printGameState()
   {
      System.out.println(gameName);
   }


   /*The main src.snake game.*/
   public float runGame() throws InterruptedException
   {
      System.out.println("Welcome to Snake by Christian Brunette!");
      System.out.println("Please choose an option: ");
      mainMenu.printMenu();
      mainMenu.userInput();

      int numMoves = 0;

      if(mainMenu.getChoice() == 'q')
      {
         System.out.println("Quitting");
      }
      else if(mainMenu.getChoice() == 'o')
      {
         optionMenu.printMenu();
         optionMenu.userInput();
      }
      else
      {
         System.out.println("Running game.");

         controls.start();

         while(!playerOne.isDead())
         {
         
            output.clearScreen();
            if(gameItems.wasEaten())
            {
               gameItems.makeNewFood();
            }

            /*Print standard src.output.*/
            printAll();
            System.out.println("Controls: W,A,S,D then ENTER!");
            System.out.println("Score: " + playerOne.currentSize());
            System.out.println("Number of turns: " + numMoves);
            
            /*Move player.*/
            playerOne.move(false);
            /*If head moves through an item, eat it.*/

            /*Print head coords and item coords for player use.*/
            System.out.println(playerOne.headPosToStr());
            gameItems.printCoords();

            /*Implement gamespeed.*/
            Thread.sleep(gameDelay);

            if(gameItems.has(playerOne.getHead()[0], playerOne.getHead()[1]))
            {
               gameItems.eat(playerOne.getHead()[0], playerOne.getHead()[1]);
            }
            else
            {
               playerOne.removeLast();
            }
            
            numMoves++;

            playerOne.checkIfDead();
         }
      }


      float gameScore = calcScore(numMoves, playerOne.currentSize());
      return gameScore;
   }

   private float calcScore(int numMoves, int score)
   {
      return (float)(score * 10.0 - numMoves / 2.0);
   }

   private void printAll()
   {
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
               else if(playerOne.has(ii, jj))
               {
                  if(playerOne.isHead(ii, jj))
                  {
                     System.out.print("1");
                  }
                  else
                  {
                     System.out.print("0");
                  }
               }
               /*Else if it's an item, print that item.*/
               else if(gameItems.has(ii, jj))
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












}
