package org.okiwi.planetwars;

public class Robot {

	public void tourne(final GuerreDesPlanetes pw) {
		if (peutEnvoyerUnOrdre(pw)) {
			Ordre ordre = prochainOrdre(pw);
			pw.envoieOrdre(ordre);
		}
	}

	private boolean peutEnvoyerUnOrdre(final GuerreDesPlanetes pw) {
		return (pw.mesVols().size() <= 5);
	}

	private Ordre prochainOrdre(final GuerreDesPlanetes pw) {
		Planete source = null;
		double scoreSource = Double.MIN_VALUE;
		for (Planete p : pw.mesPlanètes()) {
			double score = p.nombreDeVaisseaux();
			if (score > scoreSource) {
				scoreSource = score;
				source = p;
			}
		}
		Planete dest = null;
		double scoreDest = Double.MIN_VALUE;
		for (Planete p : pw.planètesQueJeNePossèdePas()) {
			double score = 1.0 / (1 + p.nombreDeVaisseaux());
			if (score > scoreDest) {
				scoreDest = score;
				dest = p;
			}
		}
		if (source != null && dest != null) {
			int nombreVaisseaux = (int) (source.nombreDeVaisseaux() / 1.5);
			return new Ordre(source, dest, nombreVaisseaux);
		}
		return null;
	}

}
