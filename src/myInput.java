package src; /**
 * Created by: Christian Brunette (04/01/16)
 * Purpose: To make dealing with input easier for me.
 * 
 * What it does: Modified version of src.myInput, allows static use.
 * 
 */



import java.io.*;

public class myInput
{

private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

public static int readInt()
{
   int temp = -1;
   String tempStr;

    try{
      tempStr = input.readLine();
   }
   catch(IOException e){
      System.out.println("An error occured.");
      tempStr = "IntigerReadError";
   }
   
   try{
      temp = Integer.parseInt(tempStr);
   }
   catch(NumberFormatException e){
      System.out.println("Invalid input.");
      temp = -1;
   }

   return temp;
}



public static double readReal()
{
   double temp = -1.0;
   String tempStr;

    try{
      tempStr = input.readLine();
   }
   catch(IOException e){
      System.out.println("An error occured.");
      tempStr = "IntigerReadError";
   }
   
   try{
      temp = Double.parseDouble(tempStr);
   }
   catch(NumberFormatException e){
      System.out.println("Invalid input.");
      temp = -1.0;
   }
   

   return temp;
}

/*Two quick methods to make it more user friendly.*/
public static double readDouble()
{
   return readReal();
}
public static float readFloat()
{
   return (float)readReal();
}




public static char readChar()
{
   char temp = 'z';

    try{
      temp = (char)input.read();
   }
   catch(IOException e){
      System.out.println("An error occured.");
      temp = 'z';
   }  

   return temp;
}





public static String readString()
{
   String temp = "EmptyString";

   try{
      temp = input.readLine();
   }
   catch(IOException e){
      System.out.println("An error occured.");
      temp = "emptyStringError";
   }

   return temp;
}


public static String readLine()
{
   return readString();
}

/*Same functions as above, but can accept a prompt string to display to the user.*/
public static int readInt(String prompt)
{
   System.out.println(prompt);
   return readInt();
}
public static double readReal(String prompt)
{
   System.out.println(prompt);
   return readDouble();
}
public static double readDouble(String prompt)
{
   System.out.println(prompt);
   return readDouble();
}
public static float readFloat(String prompt)
{
   System.out.println(prompt);
   return readFloat();
}
public static char readChar(String prompt)
{
   System.out.println(prompt);
   return readChar();
}
public static String readString(String prompt)
{
   System.out.println(prompt);
   return readString();
}
public static String readLine(String prompt)
{
   return readString(prompt);
}



public static void waitInput()
{
   String wait = "obscureString_Here";
   System.out.println("");
   System.out.println("Press enter to return");
   while(wait.equals("obscureString_Here"))
   {
      try{
         wait = readLine();
      }
      catch(NumberFormatException e){
         System.out.print("The unlikely occured, please restart!");
      }
   }
}


}
