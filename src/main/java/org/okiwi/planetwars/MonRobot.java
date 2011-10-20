package org.okiwi.planetwars;

public class MonRobot {

	public static void tourne(final GuerreDesPlanetes pw) {
		new Robot().tourne(pw);
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
						GuerreDesPlanetes pw = new GuerreDesPlanetes(message);
						tourne(pw);
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
