package src;

public class myMenu
{
   private String[] menuOptions;
   private char[] validChoiceList;
   private char choice;


   public myMenu(char[] validChoices, String... options)
   {
      menuOptions = new String[options.length];
      validChoiceList = new char[validChoices.length];

      for(int ii = 0; ii < validChoices.length; ii++)
      {     
         validChoiceList[ii] = validChoices[ii];
      }

      for(int ii = 0; ii < options.length; ii++)
      {
         menuOptions[ii] = options[ii];
      }

      choice = ' ';
   }

   public void printMenu()
   {
      for(int ii = 0; ii < menuOptions.length; ii++)
      {
         System.out.println(menuOptions[ii]);
      }

   }

   public void userInput()
   {
      choice = myInput.readChar();
      while(!validInput(choice))
      {
         output.clearScreen();
         System.out.println("Please enter a valid option!");
         printMenu();
         choice = myInput.readChar();
      } 
   }

   public char getChoice()
   {
      return choice;
   }

   public void setChoice(char inChar)
   {
      if(validInput(inChar))
      {
         choice = inChar;
      }
   }


   private boolean validInput(char test)
   {
      boolean valid = false;

      for(int ii = 0; ii < validChoiceList.length; ii++)
      {
         if(test == validChoiceList[ii]){ valid = true; }
      }      

      /*If still not valid, check if the user entered (1) or (2) etc.*/
      if(!valid)
      {
         valid = checkNumericInput(test);
      }

      return valid;
   }

   private boolean checkNumericInput(char test)
   {
      int testIntVal = 0;
      boolean retVal = false;

      try{
         testIntVal = Character.getNumericValue(test);
         for(int ii = 0; ii < validChoiceList.length; ii++)
         {
            if(testIntVal == ii+1)
            {
               choice = validChoiceList[ii];
               retVal = true;
            }
         }
      }
      catch(Exception e){
         System.out.println("Im a bad programmer and did not account for this error...");
      }

      return retVal;
   }

}






