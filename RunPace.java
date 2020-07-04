/*
 * @author (JT Kelly)
 * <p> (Project1.java)
 * <p> (RunPace)
 * <p> (Takes run time and miles ran from a user and outputs the time in total seconds,
 * <p>  seconds per mile, and the run pace in simplified form)
 */

import java.util.Scanner;

public class RunPace
{

	public static void main(String[] args)
	{
		// Creating the data types
		int hours;
		int minutes;
		int seconds;
		double miles;

		Scanner kb = new Scanner(System.in).useDelimiter("\\s*:\\s*");

		// Prompt user for time data
		System.out.println("Enter the elapsed time in the form <hours : minutes : seconds:>");
		hours = kb.nextInt();
		minutes = kb.nextInt();
		seconds = kb.nextInt();

		// Convert all time into seconds
		final int CONVERT = 60;
		hours = ((hours * CONVERT) * CONVERT);
		minutes = minutes * CONVERT;
		long totalSec = hours + minutes + seconds;

		// Prompt user for miles data
		kb.nextLine();
		kb.reset();
		System.out.println("Enter the number of miles traveled:");
		miles = kb.nextDouble();

		// Do some math
		double secPerMile = (double) totalSec / miles;
		double newPerMile = Math.abs(secPerMile);
		int finalMin = (int) newPerMile / CONVERT;
		double min = finalMin * CONVERT;
		double finalSec = newPerMile - min;

		// Convert minutes into hours
		int finalHour = 0;
		while (finalMin >= CONVERT)
		{
			finalHour++;
			finalMin = finalMin - CONVERT;
		}

		// Convert hours into days
		final int DAY = 24;
		int finalDay = 0;
		while (finalHour >= DAY)
		{
			finalDay++;
			finalHour = finalHour - DAY;
		}

		// Display final result(s)
		String result = "The elapsed time consists of " + totalSec + " seconds.\n" + "Time per mile is "
				+ Math.round(secPerMile) + " seconds.\n" + "Simplified run pace: ";

		// Check for negative time
		if (totalSec < 0)
		{
			result += "-";
		}

		// Check for correct result to be displayed
			if (finalDay > 0)
			{
				result += finalDay + ":" + finalHour + ":" + finalMin + ":"
						+ Math.round(finalSec) + ":";
			} else
			{
				if (finalHour > 0)
				{
					result += finalHour + ":" + finalMin + ":" + Math.round(finalSec) + ":";
				} else if (finalMin > 0)
				{
					result += finalMin + ":" + Math.round(finalSec) + ":";
				} else if (finalSec <= 60)
				{
					result += Math.round(finalSec) + ":";
				}
			}
		System.out.println(result);
	}

}
