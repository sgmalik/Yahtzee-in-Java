/**Surya Malik
CS110B
This program is my GameDriver
class which runs all of the methods
I have created throughout the various
files in this project to execute
a fully functioning game of yahtzee.
*/

import java.util.*;

public class Game
{
   //Instance Variables
   private Scanner keyboard;
   private ScoreCard player1;
   private ScoreCard player2;
   private DiceRoll diceRoll;
   private Dice savedDice;
   private ArrayList<Integer> SavedIndexes;
   String s;
   
   /** Game instantiates all of my instance variables with their various ojects
   */
   public Game()
   {
      keyboard = new Scanner(System.in); 
      player1 = new ScoreCard();
      player2 = new ScoreCard();
      diceRoll = new DiceRoll();
      savedDice = new Dice(); 
   }
   
   /** Player is my class that essentially runs each turn
      @param player is a ScoreCard object
      @param diceRoll is a diceRoll object
   */
   public void player(ScoreCard player, DiceRoll diceRoll)
   {
      System.out.print(player);
      System.out.printf("Dice to reroll:");
      System.out.println(diceRoll);
      
      boolean round = false;
      int index = 1;
      while (round == false && index < 3)
      {
         System.out.printf("\n\nSave dice with [ ] filled with index values seperated by spaces\n'roll' to reroll, 'score' to score\n");
         s = "" + keyboard.nextLine();
         
         if (s.equalsIgnoreCase("roll"))
         {
            index++;
            if (index!= 3)
            {
               reRoll();
               System.out.print(player1);
               System.out.printf("Dice to reroll:");
               System.out.println(diceRoll);
               if (savedDice.getNumDice() != 0)
               {
                  System.out.printf("\nDice to save:");
                  System.out.print(savedDice);
               }
            }
         }
         
         else if (s.equalsIgnoreCase("score"))
         {
            while (diceRoll.getNumDice() > 0)
            {
               savedDice.addDie(diceRoll.getDie(0));
               diceRoll.removeDie(0);
            }
            System.out.println("Final roll:");
            System.out.println(savedDice);
            getScore(player);
            round = true;
         }
         else if (s.charAt(0) == '[' && s.charAt(s.length() - 1) == ']')
         {
            SaveData();
            System.out.printf("Dice to reroll:");
            System.out.println(diceRoll);
            System.out.printf("\nDice to save:");
            System.out.print(savedDice);
         }
         if (index > 2)
         {
            while (diceRoll.getNumDice() > 0)
            {
               savedDice.addDie(diceRoll.getDie(0));
               diceRoll.removeDie(0);
            }
            System.out.println("Final dice:");
            System.out.println(savedDice);
            getScore(player);
            round = true;
         } 
      } 
      clear(); 
   }
   
   /** Clear is a method I created to clear all lists and objects I had to be used for the 2nd players turn
   */
   public void clear()
   {
      if (SavedIndexes!= null)
      {
         SavedIndexes.clear();
      }
      while(diceRoll.getNumDice() > 0)
      {
         diceRoll.removeDie(0);
      }
      while(savedDice.getNumDice() > 0)
      {
         savedDice.removeDie(0);
      }
   }
   
   /** NewObjects simply creates new DiceRoll and Dice objects to be used by the 2nd player
   */
   public void NewObjects()
   {
      diceRoll = new DiceRoll();
      savedDice = new Dice();
   }
   
   /** getScore scores the category stated by the user
   */
   public void getScore(ScoreCard player)
   {
      System.out.print("\nSelect a category you have not scored in yet:\n");
      int i = 1;
      String s = "";
      CategoryValue[] values = CategoryValue.values();
      for (CategoryValue cv : values)
      {
         if (!player.checkScored(cv) || (player.getCategoryScore(cv) == 50))
         {
            s += String.format("%d: %s, %d points\n", cv.getValue() + 1, cv, player.getEvaluation(cv, savedDice));
            i++;
         }
      }
      System.out.print(s);
      String userInput = keyboard.nextLine();
      int user_input = Integer.parseInt(userInput);
      CategoryValue cv = CategoryValue.values()[user_input - 1];
      
      player.choose(cv,savedDice);
      
      System.out.printf("You scored %d points in %s\n\n", player.getEvaluation(cv, savedDice), cv);
   }
   
   /** reRoll tosses the DiceRoll object
   */
   public void reRoll()
   {
      diceRoll.toss();
   }
   
   /** SaveData saves the indexes given by the user using a local array list before they are added to a dice object
   */
   public void SaveData()
   {
      s = s.substring(1,s.length() - 1);
      Scanner scan = new Scanner(s);
      SavedIndexes = new ArrayList<Integer>();
      while (scan.hasNext())
      {
         SavedIndexes.add(scan.nextInt());
      }
      Collections.sort(SavedIndexes);
      Collections.reverse(SavedIndexes);
      for (int i : SavedIndexes)
      {
         int die = i - 1;
         savedDice.addDie(diceRoll.getDie(die));
         diceRoll.removeDie(die);
      }
   }
   /** playGame uses the methods above to execute 13 rounds of yahtzee between 2 players
   */   
   public void playGame()
   {
      System.out.printf("*******************************************************\n");
      System.out.printf("%37s", "WELCOME TO YAHTZEE\n");
      System.out.printf("*******************************************************\n");
      
      //13 round condition
      int turns = 0;
      while (turns < 13)
      {
         System.out.printf("\nPlayer 1:\n");
         NewObjects();
         player(player1, diceRoll);
         NewObjects();
         System.out.printf("\nPlayer 2:\n");
         player(player2, diceRoll);
         turns++;
      }
      //Who won
      if (player1.score() > player2.score())
      {
         System.out.println("Player 1 won the game!");
      }
      else if (player2.score() > player1.score())
      {
         System.out.println("Player 2 won the game!");
      }
      else
      {
         System.out.println("The game was a tie!");
      }
   }
}