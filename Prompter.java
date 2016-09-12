import java.io.console;

public class Prompter{
  
  private Game mGame; // is placed her so we can use the method from the Game class
  
  public Prompter(Game game)
    mGame = game; 
   
  public boolean promptForGuess(){
    Console console = System.console();
    String guessAsString = console.readLine("Enter a letter: ");
    char guess = guessAsString.charAt(0);
    return applyGuess(guess); // calls the method applyGuess(letter) from the game class.
   }
  
  
  
}