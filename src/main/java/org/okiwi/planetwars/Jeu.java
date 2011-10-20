package org.okiwi.planetwars;

public class Jeu {

	public static void main(final String[] args) {
		String line = "";
		String message = "";
		int c;
		try {
			while ((c = System.in.read()) >= 0) {
				switch (c) {
				case '\n':
					if (line.equals("go")) {
						GuerreDesPlanetes pw = new GuerreDesPlanetes(message);
						new Robot().tourne(pw);
						pw.finDuTour();
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
