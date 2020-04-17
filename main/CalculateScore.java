package main;

/**
 * @author nicolesullivan
 * Calculate Score class includes all functions required
 * to calculate the score of a 10 frame game
 * @since   2020-04-02 
 */
public class CalculateScore {
	private int totalScore;
	private int[ ] caseArray = new int [10];
	private char[ ] charArray;
	private int[ ] numArray;
	public String inputString;
	
	/**
	 * Constructor for CalculateScore
   * Sets up charArray, an array filled with the input chars without -
   * Sets up numArray, an array filled with the numbers from input excluding / and X
   * Sets up caseArray, an array filled with the five different cases
   * @param userInput an instance of a bowling game 
	 */
	public CalculateScore(String userInput) {
		inputString = userInput;
		totalScore = 0;
		charArray = new char [CalculateRolls(userInput)];
		numArray = new int [CalculateRolls(userInput)];
		FillCharArray(userInput);
		FillNumArray(charArray);
		FillCaseArray(userInput);
	}
	
    /**
    * The calculateRolls method calculates the total number of rolls
    * in each game. This is used to determine the length of the numArray
    * and charArray
    * @param userInput an instance of a bowling game 
    * @return counter the number of Rolls in one game
    */
	public int CalculateRolls(String userInput) {
		int counter = 0;
    int frameC = 0;
   	for (int i = 0; i < userInput.length(); i++) {
			if (userInput.charAt(i) != '-') {
			  counter++;
			} else {
        frameC++;
      }
		} 
		return counter;
	}
	
	
  /**
  * The FillCharArray method fills the charArray with the chars from
  * the user input, excluding '-'
  * @param userInput an instance of a bowling game 
  */
	private void FillCharArray(String userInput) {
		int counter = 0;
		for (int i = 0; i < userInput.length(); i++) {
			if (userInput.charAt(i) != '-') {
				charArray[counter] = userInput.charAt(i);
				counter++;
			}
		}	
	}

  /**
  * The FillNumArray method fills the numArray with converted numbers
  * from the char array. This numArray does not contain X or /, only
  * integer values
  * @param charArray an array filled with characters, including 1-9, X, / 
  */
	private void FillNumArray(char[] charArray) {
		for (int i = 0; i < charArray.length; i++) {
      // spares are calculated by taking subtracting 10 from the number before /
			if (charArray[i] == '/') {
				numArray[i] = 10 - (Character.getNumericValue(charArray[i-1]));
			} else if (charArray[i] == 'X' || charArray[i] == 'x') {
				numArray[i] = 10;
			} else {
				numArray[i] = Character.getNumericValue(charArray[i]);
			}
		}
	}
	
  /**
  * The FillCaseArray method fills the caseArray with the different cases
  * of frames. There are 5 different cases of frames, and this method
  * detects each case and inserts it into an array of 10, representing the
  * 10 frames in a single game
  * @param userInput an instance of a bowling game 
  */
	private void FillCaseArray(String userInput) {
		int counter = 0;
		int arrayCounter = 0;
		int frameCount = 0;       
		boolean spare = false;    //to detect if it is a spare
		for (int i = 0; i < (userInput.length()); i++) {
			if (userInput.charAt(i) != '-' && (frameCount <= 10)) {
				counter++;
				if (userInput.charAt(i) == '/') { //if it is a spare, true
					spare = true;
				}
				if (i == (userInput.length()) - 1) {
					if (counter == 3 && (frameCount > 8) && spare == false) {
						caseArray[arrayCounter] = 3;
						spare = false;
						arrayCounter++;		
						frameCount++;
						counter = 0;
					} else if (counter == 3 && (frameCount > 8) && spare == true) {
						caseArray[arrayCounter] = 4;
						spare = false;
						arrayCounter++;
						frameCount++;
						counter = 0;
					}	else if (counter == 2 && (frameCount > 8) && spare == false) {
						spare = false;
						caseArray[arrayCounter] = 2;
						arrayCounter++;	
						frameCount++;
						counter = 0;
					} 				
				}
				
			} else if (userInput.charAt(i) == '-') {
				if (counter == 1) {
					spare = false;
					caseArray[arrayCounter] = 0;
					arrayCounter++;
					frameCount++;
					counter = 0;
				} else if (counter == 2 && spare == true) {
					caseArray[arrayCounter] = 1;
					spare = false;
					arrayCounter++;
					frameCount++;
					counter = 0;
				} else if (counter == 3 && spare == false) {
					caseArray[arrayCounter] = 3;
					spare = false;
					arrayCounter++;		
					frameCount++;
					counter = 0;
				} else if (counter == 3 && spare == true) {
					caseArray[arrayCounter] = 4;
					spare = false;
					arrayCounter++;
					frameCount++;
					counter = 0;
				} else {
					spare = false;
					caseArray[arrayCounter] = 2;
					arrayCounter++;	
					frameCount++;
					counter = 0;
				}
			}

		}
	}

  /**
  * The GetTotal method calculates the total points in a game
  * of frames. It iterates through the caseArray (which contains the
  * one of five different cases for each frame) and calculates
  * the score for that game
  * @param none
  * @return totalScore  the final score of the game
  */
	public int GetTotal() {
		int	arrayIndex = 0;
		int tempTotal = 0;
		for (int i = 0; i < caseArray.length; i++) {
			if (caseArray[i] == 0) {
        //it's a strike
				tempTotal = 10 + numArray[arrayIndex + 1] + numArray[arrayIndex + 2];
				totalScore = totalScore + tempTotal;
				tempTotal = 0;
				arrayIndex ++;
			} else if (caseArray[i] == 1) {
				//it's a spare
				tempTotal = 10 + numArray[arrayIndex + 2];
				totalScore = totalScore + tempTotal;
				arrayIndex = arrayIndex + 2;
				tempTotal = 0;
			} else if (caseArray[i] == 2) {
				//it's an open frame (includes 10th frame open frame)
				tempTotal = numArray[arrayIndex] + numArray[arrayIndex + 1];
				totalScore = totalScore + tempTotal;
				if (i != 9) {
					arrayIndex = arrayIndex + 2;
				}
				tempTotal = 0;
			} else if (caseArray[i] == 3) {
        //it's a 10th frame strike
				tempTotal = 10 + numArray[arrayIndex + 1] + numArray[arrayIndex + 2];
				totalScore = totalScore + tempTotal;
				tempTotal = 0;
			} else if (caseArray[i] == 4) {
        //it's a 10th frame spare
				tempTotal = 10 + numArray[arrayIndex + 2];
				totalScore = totalScore + tempTotal;
				tempTotal = 0;
			}
		}
		return totalScore;
	}
}
	

