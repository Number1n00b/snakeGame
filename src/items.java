package src; /**
 * A class to handle src.items for Snake.
 * This includes spawning and removing.
 * 
 */


import java.util.*;

public class items
{
   private int maxXVal;
   private int maxYVal;

   private boolean eaten;

   /*A linked list containing the coordinates of all src.items currently in play.*/
   /*(x, y)*/
   private LinkedList<Integer[]> itemPositions;

   private Random rand;

   /*Standard constructor.*/
   public items(int maxX, int maxY)
   {
      maxXVal = maxX;
      maxYVal = maxY;

      eaten = true;
      itemPositions =  new LinkedList<Integer[]>();
      rand = new Random();
      rand.setSeed((int)(Math.PI * 100));
   }

   /*Create a new piece of food within defined boundries.*/
   public void makeNewFood()
   {
      itemPositions.add(new Integer[]{rand.nextInt(maxXVal-2)+1, rand.nextInt(maxYVal-2)+1});
      eaten = false;
   }

   public boolean wasEaten()
   {
      return eaten;
   }
   
   public LinkedList<Integer[]> getItems()
   {
      return itemPositions;
   }


   public boolean has(int xPos, int yPos)
   {
      boolean retVal = false;

      for(Integer[] coOrd : itemPositions)
      {
         if(coOrd[0] == xPos && coOrd[1] == yPos)
         {
            retVal = true;
         }
      }
   
      return retVal;
   }

   public void printCoords()
   {
      for(Integer[] coOrd : itemPositions)
      {
         System.out.println(coOrd[0] + " " + coOrd[1]);  
      }
   }

   public void eat(int xVal, int yVal)
   {
      itemPositions.removeFirst();
      eaten = true;
   }


   public void setEaten(boolean newVal)
   {
      eaten = newVal;
   }
}
