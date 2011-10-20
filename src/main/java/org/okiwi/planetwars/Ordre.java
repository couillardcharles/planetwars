package org.okiwi.planetwars;

public class Ordre {

	public Ordre(final Planete source, final Planete dest, final int nombreDeVaisseaux) {
		this.source = source;
		this.destination = dest;
		this.nombreDeVaisseaux = nombreDeVaisseaux;
	}

	public Planete getSource() {
		return source;
	}

	public Planete getDestination() {
		return destination;
	}

	public int getNombreDeVaisseaux() {
		return nombreDeVaisseaux;
	}

	private final Planete source;
	private final Planete destination;
	private final int nombreDeVaisseaux;

}
