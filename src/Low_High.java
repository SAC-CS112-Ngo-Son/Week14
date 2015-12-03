
//Son Ngo

import java.util.Random;

import javax.swing.JOptionPane;

public class Low_High
{
	private int iDice, iThrow;

	// default constructor
	public Low_High()
	{
		iDice = 1;
	}

	// constructor with 1 variable carrying the number of dices
	public Low_High(int dices)
	{
		if (!this.isLessThanZero(dices))
			iDice = dices;
		else
			throw new IllegalArgumentException();
	}

	public boolean isLessThanZero(int aDiceNumber)
	{
		if (aDiceNumber <= 0)
			return true;
		else
			return false;
	}

	// method to return the result of the throw (low or high)
	public char Low_Or_High()
	{
		Random rand = new Random();

		iThrow = (rand.nextInt(6) + 1) * iDice;

		if (iThrow <= (iDice * 3))
			return 'L';
		else
			return 'H';
	}
}
