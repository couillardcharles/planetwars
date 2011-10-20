package org.okiwi.planetwars;

public interface Strategie {

	public boolean peutEnvoyerUnOrdre(GuerreDesPlanetes pw);

	public Ordre prochainOrdre(GuerreDesPlanetes pw);

}
