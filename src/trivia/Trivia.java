/* Project author: Cameron Smith
 * Project class: IN211-11068: Java Programming
 * Project description: Assignment 14.1
 */
package trivia;

import java.util.Scanner;

public class Trivia {
    
    public static void main(String[] args) {
        WelcomeUser();
        AskQuestion();
    }
    
    // Welcome the user to the application
    public static void WelcomeUser() {
        LineSeparator();
        System.out.println("Welcome to Trivia");
        LineSeparator();
    }
    
     // Ask the user a question based on the category chosen.
    public static void AskQuestion() {
        int category = GetCategory();
        int index = 0;
        
        LineSeparator();
        
        if(category > -1)
        {            
            switch(category)
            {
                case 1:
                    index = 0;
                    // Software Development
                    System.out.println("Who is the developer of C++?");
                    LineSeparator();
                    System.out.printf("--> %d. Will Smith\n", ++index);
                    System.out.printf("--> %d. Ken Thompson\n", ++index);
                    System.out.printf("--> %d. Tim Berners-Lee\n", ++index);
                    System.out.printf("--> %d. Bjarne Stroustrup\n", ++index);
                    LineSeparator();
                    break;
                case 2: 
                    index = 0;
                    // Computers
                    System.out.println("Who is one of the founders of Microsoft?");
                    LineSeparator();
                    System.out.printf("--> %d. Bill Gates\n", ++index);
                    System.out.printf("--> %d. Ken Thompson\n", ++index);
                    System.out.printf("--> %d. Tim Berners-Lee\n", ++index);
                    System.out.printf("--> %d. Bjarne Stroustrup\n", ++index);
                    LineSeparator();
                    break;
                case 3: 
                    index = 0;
                    // Sports
                    System.out.println("What is professional wrestler John Cena's famous catchphrase?");
                    LineSeparator();
                    System.out.printf("--> %d. What's up, doc?\n", ++index);
                    System.out.printf("--> %d. What?\n", ++index);
                    System.out.printf("--> %d. You can't see me!\n", ++index);
                    System.out.printf("--> %d. It doesn't matter.\n", ++index);
                    LineSeparator();
                    break;
                default: break;
            }
            
            // Checks if the user has won
            if(CheckAnswer(category, GetInput(index)))
                System.out.println("Congratulations! You win!");
            else
                System.out.println("Sorry, you lose.");
        }
        else {
            AskQuestion();
        }
    }
    
    /********************/
    /* HELPER FUNCTIONS */
    /********************/

    // Provides a basic line separator for text formatting.
    public static void LineSeparator() {
        System.out.println("-------------------------------------------------------------------------");
    }
        
    // Check the answer that the user inputs based on the category.
    // Returns true if they got it right
    // Returns false if they did not.
    public static Boolean CheckAnswer(int category, int input) {
        Boolean correct = false;
        
        switch(category)
        {
            case 1:
                correct = (input == 4) ? true : false;
                break;
            case 2:
                correct = (input == 1) ? true : false;
                break;
            case 3:
                correct = (input == 3) ? true : false;
                break;
            default:
                return false;
        }
        
        return correct;
    }
    
    // Get the category the user wants to play.
    // Returns -1 for invalid input
    // Returns input otherwise
    public static int GetCategory() {
        int index = 0;
        
        System.out.println("Which category would you like your question to be in?");
        LineSeparator();
        System.out.printf("--> %d. Software Development\n", ++index);
        System.out.printf("--> %d. Computers\n", ++index);
        System.out.printf("--> %d. Sports\n", ++index);
        LineSeparator();

        return GetInput(index);
    }
    
    // Ask the user for input. Accepts a parameter for the maximum amount of menu items in the current menu. 
    // Returns -1 for invalid input
    // Returns input otherwise
    public static int GetInput(int max_items) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter a number between 1 and " + max_items);
        System.out.print("> ");
        int input = reader.nextInt();
        
        if(input < 0 || input > max_items) {
            return -1;
        }
        
        return input;
    }
    
}