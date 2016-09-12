import java.io.Console;

public class Prompter{
    private Game mGame;
  
  public Prompter(Game game){
    mGame = game; 
  }
  
  /*
      Method starts the game and checks if the game is solved.
   */
  public void play(){
    while( mGame.getRemainingTries() > 0 && !mGame.isSolved()){
      displayProgress();
      promptForGuess();
    
    } 
    if(mGame.isSolved()){
          System.out.printf("Congratulations you won with %d tries remaining",  mGame.getRemainingTries() );
    } else{
         System.out.printf ("Bummer!! the correct word was %s. :( \n" , mGame.getAnswer());
    }
  }
  
   /*
      prompts the user for to guess
   */
  public boolean promptForGuess(){
    Console console = System.console();
    
    boolean isHit = false;
    boolean isValidGuess = false;
    
    while(! isValidGuess){
      String guessAsString = console.readLine("Enter a letter: ");
      //char guess = guessAsString.charAt(0);
        try{    
             isHit  = mGame.applyGuess(guessAsString);
             isValidGuess = true;
        } catch(IllegalArgumentException ex){
          console.printf("%s.   Please try again.\n" , ex.getMessage() );
        }
    }
    
     return isHit;
    }
  
  
    public void displayProgress(){
    System.out.printf("You have %d tries left to solve:  %s\n", 
                         mGame.getRemainingTries(), 
                         mGame.getCurrentProgress() );
    
    }
}
  
  
  
