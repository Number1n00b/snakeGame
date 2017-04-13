package src;

import java.util.*;

public class snakePlayer
{
   private boolean dead;

   private LinkedList<Integer[]> bodyCoords;

   private Integer[] headPos;

   private String currDirection;

   /*Boundries*/
   private int maxXVal;
   private int maxYVal;

   public snakePlayer(int x_max, int y_max)
   {
      maxXVal = x_max;
      maxYVal = y_max;

      dead = false;

      currDirection = "RIGHT";

      bodyCoords = new LinkedList<Integer[]>();

      /*Place the head in the middle of the map.*/
      headPos = new Integer[]{maxXVal/2, maxYVal/2};

      /*Add first 3 body parts horizontally.*/
      bodyCoords.addFirst(headPos);
      bodyCoords.add(new Integer[]{headPos[0] - 1, headPos[1]});
      bodyCoords.addLast(new Integer[]{headPos[0] - 2, headPos[1]});
   }

   public void printBodyPos()
   {
      for(Integer[] arr : bodyCoords)
      {
         System.out.println("(" + arr[0].toString() + "," + arr[1].toString() + ")");
      }

   }

   public void move(String direction)
   {

      if(isValidMove(direction))
      {
         if(direction.equals("UP"))
         {
            headPos = new Integer[]{headPos[0], headPos[1]-1};
         }
         else if(direction.equals("LEFT"))
         {
            headPos = new Integer[]{headPos[0]-1, headPos[1]};
         }
         else if(direction.equals("DOWN"))
         {
            headPos = new Integer[]{headPos[0], headPos[1]+1};
         }
         else if(direction.equals("RIGHT"))
         {
            headPos = new Integer[]{headPos[0]+1, headPos[1]};
         }

         /*add new head location to body*/
         bodyCoords.addFirst(headPos);

         currDirection = direction;
      }
   }

   public void move(String direction, boolean delete)
   {
      this.move(direction);
      if(delete == true)
      {
         this.removeLast();
      }
   }

   public void move(boolean delete)
   {
      this.move(currDirection, delete);
   }

   public void removeLast()
   {
      bodyCoords.removeLast();
   }

   public void move()
   {
      this.move(currDirection);
   }

   private boolean isValidMove(String newDir)
   {
      boolean retVal = false;

      if(currDirection.equals("UP") && newDir.equals("DOWN"))
      {  /*Not Valid*/  }
      else if(currDirection.equals("LEFT") && newDir.equals("RIGHT"))
      {  /*Not Valid*/  }
      else if(currDirection.equals("DOWN") && newDir.equals("UP"))
      {  /*Not Valid*/  }
      else if(currDirection.equals("RIGHT") && newDir.equals("LEFT"))
      {  /*Not Valid*/  }
      else/*All Good*/
      {retVal = true;}

      return retVal;
   }

   public boolean has(int xVal, int yVal)
   {
      boolean retVal = false;

      for(Integer[] arr : bodyCoords)
      {
         if(arr[0] == xVal && arr[1] == yVal)
         {
            retVal = true;
         }
      }
      return retVal;
   }

   public Integer[] getHead()
   {
      return headPos;
   }

   public String headPosToStr()
   {
      String pos = "(" + headPos[0] + "," + headPos[1] +")";

      return pos;
   }

   public boolean isHead(int xVal, int yVal)
   {
      boolean retVal = false;

      if(xVal == headPos[0] && yVal == headPos[1])
      {
         retVal = true;
      }
      return retVal;
   }

   public void checkIfDead()
   {
      if(!(headPos[0] > 0 && headPos[0] < maxXVal-1))
      {
         dead = true;
      }
      if(!(headPos[1] > 0 && headPos[1] < maxYVal-1))
      {
         dead = true;
      }

      LinkedList<Integer[]> newList  = new LinkedList<Integer[]>();
      newList.addAll(0, bodyCoords);
      newList.removeFirst();

      for(Integer[] coord : newList)
      {
         if(coord[0] == headPos[0] && coord[1] == headPos[1])
         {
            dead = true;
         }
      }

   }

   public int currentSize()
   {
      return bodyCoords.size();
   }

   public boolean isDead()
   {
      return dead;
   }

   public LinkedList<Integer[]> getBodyPos()
   {
      return bodyCoords;
   }

   public void setDead(boolean value)
   {
      dead = value;
   }

}
