public class Game{

     public static final int MAX_MISSES = 7;
     private String mAnswer;
     private String mHits;
     private String mMisses;
  
     public Game(String answer){
       mAnswer =  answer;
       mHits = " ";
       mMisses = " ";
      }
  
  
  // the method checks and validates if the input is a character. 
  private char validateGuess(char letter){
    
    if(!Character.isLetter(letter)){
      throw new IllegalArgumentException("A letter is required here");
    }
     letter= Character.toLowerCase(letter);
     if(mMisses.indexOf(letter) >= 0 || mHits.indexOf(letter) >= 0){
       throw new IllegalArgumentException(letter + " has been already been guessed");
     }
    return letter;
  }
    
    
  
  public boolean applyGuess(char letter){
    letter = validateGuess(letter); // using the private method created above.
    boolean isHit = mAnswer.indexOf(letter) >= 0;
    if(isHit){
        mHits +=  letter;
    } else {
       mMisses += letter;
    }
    return isHit;
    }
  
     public String getCurrentProgress(){
     String progress = "";
       for(char letter: mAnswer.toCharArray()){
           char display = '-';
           if(mHits.indexOf(letter) >= 0 ){
            display = letter;
            }
       progress += display;
     }
  return progress;
  }
  
  
  public int getRemainingTries(){
    return MAX_MISSES - mMisses.length(); 
  }
    
}   

    
