public class Hangman {
    
    public static void main(String[] args) {
        // Enter amazing code here:
      
       Game game = new Game("OGodomigodo");
       Prompter prompter = new Prompter(game);
       prompter.play();
      
       //prompter.displayProgress();
       //boolean isHit = prompter.promptForGuess();
       //{
       //if(isHit){
        //System.out.println("We got a hit");
       // prompter.displayProgress();
       //} else {
        //System.out.println("Whoops missed!! ");
     // }
     //}
      
    }
}

