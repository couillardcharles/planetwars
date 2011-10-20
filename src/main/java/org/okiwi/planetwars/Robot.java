package org.okiwi.planetwars;

public class Robot {

	public void tourne(final GuerreDesPlanetes pw) {
		Strategie stratégie = Stratege.meilleureStratégie(pw);
		if (stratégie.peutEnvoyerUnOrdre(pw)) {
			pw.envoieOrdre(stratégie.prochainOrdre(pw));
		}
	}

}
