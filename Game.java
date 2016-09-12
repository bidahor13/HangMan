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
    
    
        /**
    
         The method checks and validates if the input is a character. 
         
         @returns a letter that has already been selected. 
    
        **/
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
      
    
       /**
          When no letter are passed in by the user.
       
        **/
  
      public boolean applyGuess(String letters){
        if(letters.length() == 0){
          throw new IllegalArgumentException("No letter found");
        }
        
        return applyGuess(letters.charAt(0));
        
      }
    
    
       /**
         This method is used to check if a letter was passed 
         is a hit or a miss.
         
         @return  the number of isHit by the player. 
        **/
    
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
    
    
        /**
          This methods displays the progress of the 
          player dusing the game.
          
          @returns  The progress of the game.
       
        **/
       public String getCurrentProgress(){
       String progress = " ";
         for(char letter: mAnswer.toCharArray()){
             char display = '-';
             if(mHits.indexOf(letter) >= 0 ){
              display = letter;
              }
         progress += display;
       }
    return progress;
    }
    
    
         /**
            Calculates the number of tries remaining for the user. 
            
            @ return Remainig Tries.
       
        **/
    public int getRemainingTries(){
      return MAX_MISSES - mMisses.length(); 
    }
    
    
    
    
    /**
         Method returns the correct of the game to the user.
    **/
    public String getAnswer(){
      return mAnswer;
    }
    
    
    /**
       Tells us if the game has been solved.
    
    **/
    
    public boolean isSolved(){
      return getCurrentProgress().indexOf('-') == -1;
    }
    
      
  }   
  
      
