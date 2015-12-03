
//Son Ngo

import javax.swing.JOptionPane;

public class Lab1
{

	public static void main(String[] args)
	{
		int iDices = 1, iRound = 0, iScore = 0, iWin = 0, iLose = 0, iChoice;
		char cResult;
		boolean continueLoop = true;
		char[] aryGuess = new char[100]; // array to store user's guesses
		int[] aryResult = new int[100]; // array to store result for each round

		do
		{
			try
			{
				iDices = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of dices: "));
				continueLoop = false;
			} catch (Exception error)
			{
				JOptionPane.showMessageDialog(null, String.format("Exception: %s\nPlease try again", error));
			}
		} while (continueLoop);
		
		Low_High game = new Low_High(iDices);

		do
		{
			iRound++; // count the number of times played

			// ask for user's guess, making sure the input is correct
			do
			{
				aryGuess[iRound] = (JOptionPane.showInputDialog(
						String.format("Round %d: What's your guess? (L for Low and H for High)", iRound))).charAt(0);
			} while ((aryGuess[iRound] != 'L') && (aryGuess[iRound] != 'H'));

			cResult = game.Low_Or_High();

			System.out.println(cResult); // tracking and matching results

			if (aryGuess[iRound] == cResult) // win case
			{
				aryResult[iRound] = 1; // 1 for correct guess
				iScore++; // increase score by 1
				iWin++; // increase the number of wins by 1
				iChoice = JOptionPane.showConfirmDialog(null, "Your guess is correct. Do you want to continue?", null,
						JOptionPane.YES_NO_OPTION);
			} else // lose case
			{
				aryResult[iRound] = 0; // 0 for incorrect guess
				iScore--; // decrease score by 1
				iLose++; // increase the number of loses by 1
				iChoice = JOptionPane.showConfirmDialog(null, "Your guess is incorrect. Do you want to continue?", null,
						JOptionPane.YES_NO_OPTION);
			}
		} while (iChoice == JOptionPane.YES_OPTION); // keep playing if the user
														// chooses YES

		JOptionPane.showMessageDialog(null,
				String.format(
						"You've played %d times.\nYou've won %d times and lost %d times.\nYour final score is %d.",
						iRound, iWin, iLose, iScore));
	}

}
