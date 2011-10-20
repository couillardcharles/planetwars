package org.okiwi.planetwars;

public class Bot {

	public void run(final PlanetWars pw) {
		if (hasNextOrder(pw)) {
			Order order = nextOrder(pw);
			pw.IssueOrder(order);
		}
	}

	private boolean hasNextOrder(final PlanetWars pw) {
		return (pw.MyFleets().size() <= 5);
	}

	private Order nextOrder(final PlanetWars pw) {
		// (2) Find my strongest planet.
		Planet source = null;
		double sourceScore = Double.MIN_VALUE;
		for (Planet p : pw.MyPlanets()) {
			double score = p.NumShips();
			if (score > sourceScore) {
				sourceScore = score;
				source = p;
			}
		}
		// (3) Find the weakest enemy or neutral planet.
		Planet dest = null;
		double destScore = Double.MIN_VALUE;
		for (Planet p : pw.NotMyPlanets()) {
			double score = 1.0 / (1 + p.NumShips());
			if (score > destScore) {
				destScore = score;
				dest = p;
			}
		}
		if (source != null && dest != null) {
			int numShips = (int) (source.NumShips() / 1.5);
			return new Order(source, dest, numShips);
		}
		return null;
	}

}
