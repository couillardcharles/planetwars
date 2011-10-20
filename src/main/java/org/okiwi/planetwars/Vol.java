package org.okiwi.planetwars;

public class Vol implements Cloneable {
	// Initializes a fleet.
	public Vol(final int propriétaire, final int nombreDeVaisseaux, final int planèteSource,
			final int planèteDestination, final int longueurDuVoyage, final int toursRestants) {
		this.propriétaire = propriétaire;
		this.nombreDeVaisseaux = nombreDeVaisseaux;
		this.planèteSource = planèteSource;
		this.planèteDestination = planèteDestination;
		this.longueurDuVoyage = longueurDuVoyage;
		this.toursRestants = toursRestants;
	}

	// Initializes a fleet.
	public Vol(final int propriétaire, final int nombreDeVaisseaux) {
		this.propriétaire = propriétaire;
		this.nombreDeVaisseaux = nombreDeVaisseaux;
		this.planèteSource = -1;
		this.planèteDestination = -1;
		this.longueurDuVoyage = -1;
		this.toursRestants = -1;
	}

	public Vol() {
		this(0, 0);
	}

	public int propriétaire() {
		return propriétaire;
	}

	public int nombreDeVaisseaux() {
		return nombreDeVaisseaux;
	}

	public int planèteSource() {
		return planèteSource;
	}

	public int planèteDestination() {
		return planèteDestination;
	}

	public int longueurDuVoyage() {
		return longueurDuVoyage;
	}

	public int toursRestant() {
		return toursRestants;
	}

	public void enleverVaisseaux(final int amount) {
		nombreDeVaisseaux -= amount;
	}

	public void tick() {
		if (toursRestants > 0) {
			--toursRestants;
		} else {
			toursRestants = 0;
		}
	}

	public int compareTo(final Object o) {
		Vol f = (Vol) o;
		return this.nombreDeVaisseaux - f.nombreDeVaisseaux;
	}

	private final int propriétaire;
	private int nombreDeVaisseaux;
	private final int planèteSource;
	private final int planèteDestination;
	private final int longueurDuVoyage;
	private int toursRestants;

	private Vol(final Vol _f) {
		propriétaire = _f.propriétaire;
		nombreDeVaisseaux = _f.nombreDeVaisseaux;
		planèteSource = _f.planèteSource;
		planèteDestination = _f.planèteDestination;
		longueurDuVoyage = _f.longueurDuVoyage;
		toursRestants = _f.toursRestants;
	}

	@Override
	public Object clone() {
		return new Vol(this);
	}
}
