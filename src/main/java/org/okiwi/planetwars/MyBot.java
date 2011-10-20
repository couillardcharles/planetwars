package org.okiwi.planetwars;

public class MyBot {
	// The DoTurn function is where your code goes. The PlanetWars object
	// contains the state of the game, including information about all planets
	// and fleets that currently exist. Inside this function, you issue orders
	// using the pw.IssueOrder() function. For example, to send 10 ships from
	// planet 3 to planet 8, you would say pw.IssueOrder(3, 8, 10).
	//
	// There is already a basic strategy in place here. You can use it as a
	// starting point, or you can throw it out entirely and replace it with
	// your own. Check out the tutorials and articles on the contest website at
	// http://www.ai-contest.com/resources.
	public static void DoTurn(final PlanetWars pw) {
		new Bot().run(pw);
	}

	public static void main(final String[] args) {
		String line = "";
		String message = "";
		int c;
		try {
			while ((c = System.in.read()) >= 0) {
				switch (c) {
				case '\n':
					if (line.equals("go")) {
						PlanetWars pw = new PlanetWars(message);
						DoTurn(pw);
						pw.FinishTurn();
						message = "";
					} else {
						message += line + "\n";
					}
					line = "";
					break;
				default:
					line += (char) c;
					break;
				}
			}
		} catch (Exception e) {
			// Owned.
		}
	}
}
