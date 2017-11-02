import java.util.Scanner;
import java.util.Random;

public class BlackJack 
{
   public static void main (String Args[])
   {
      int playerHand, dealerHand = 0, choice;
      boolean max = false;
      char playAgain = 'y', hit = 'n';
      Random rand = new Random();
      Scanner keyboard = new Scanner(System.in);
      
      
      do {
         int firstCard = rand.nextInt(10) +1, secondCard = rand.nextInt(10) +1;
         playerHand = firstCard + secondCard;
         System.out.println("Let's play some Blackjack!");
         System.out.println("You currently have: " + playerHand);
         System.out.println();
         System.out.print("Would you like to hit? (y/n): ");
         hit = keyboard.next().charAt(0);
         System.out.println();
         while (hit == 'y' && playerHand < 21)
         {
            int newCard = rand.nextInt(13) +1;
            if (newCard == 11 || newCard == 12 || newCard == 13)
               newCard = 10;

            if (newCard == 1)
            {
               do {
               System.out.print("Would you like your Ace to equal 1 or 11? (1/11): ");
               choice = keyboard.nextInt();
               } while (choice != 1 && choice != 11);
               newCard = choice;
            }
            playerHand += newCard;
            System.out.println("Your hand is now: " + playerHand);
            if (playerHand < 21)
            {
               System.out.print("Would you like to hit? (y/n): ");
               hit = keyboard.next().charAt(0);
            }
         }
         
         if (playerHand == 21)
            System.out.println("Blackjack! Suck that, dealer!");
         else if (playerHand < 21)
            System.out.println("You stayed at: " + playerHand);
         else 
            System.out.println("You busted!");
         
         System.out.println();
         System.out.println("Dealer deals its hand...");
         
         do
         {  
         int newCard = rand.nextInt(10) +1;
            if (dealerHand + newCard <= 21)
            {
               dealerHand += newCard;
               max = false;
               }
            else
               max = true;
         } while (max != true);
         System.out.println("The Dealer has: " + dealerHand);
         
         if ((playerHand > dealerHand && playerHand <= 21) || (playerHand < 22 && dealerHand > 21)) 
            System.out.println("You win!");
         else if ((playerHand < dealerHand && dealerHand < 22) || (playerHand > 21 && dealerHand < 22))
            System.out.println("The Dealer wins.");
         else if (playerHand == dealerHand)
            System.out.println("Push!");
          
         System.out.print("Great game! Would you like to play again?(y/n): ");
         playAgain = keyboard.next().charAt(0);
         playerHand = 0;
         dealerHand = 0;
      } while (playAgain != 'n');
      System.out.println();
      System.out.println("Toodles!");
   }
}