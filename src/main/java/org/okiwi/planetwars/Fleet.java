package org.okiwi.planetwars;

public class Fleet implements Comparable, Cloneable {
	// Initializes a fleet.
	public Fleet(final int owner, final int numShips, final int sourcePlanet, final int destinationPlanet,
			final int totalTripLength, final int turnsRemaining) {
		this.owner = owner;
		this.numShips = numShips;
		this.sourcePlanet = sourcePlanet;
		this.destinationPlanet = destinationPlanet;
		this.totalTripLength = totalTripLength;
		this.turnsRemaining = turnsRemaining;
	}

	// Initializes a fleet.
	public Fleet(final int owner, final int numShips) {
		this.owner = owner;
		this.numShips = numShips;
		this.sourcePlanet = -1;
		this.destinationPlanet = -1;
		this.totalTripLength = -1;
		this.turnsRemaining = -1;
	}

	public Fleet() {
		this(0, 0);
	}

	// Accessors and simple modification functions. These should be mostly
	// self-explanatory.
	public int Owner() {
		return owner;
	}

	public int NumShips() {
		return numShips;
	}

	public int SourcePlanet() {
		return sourcePlanet;
	}

	public int DestinationPlanet() {
		return destinationPlanet;
	}

	public int TotalTripLength() {
		return totalTripLength;
	}

	public int TurnsRemaining() {
		return turnsRemaining;
	}

	public void RemoveShips(final int amount) {
		numShips -= amount;
	}

	// Subtracts one turn remaining. Call this function to make the fleet get
	// one turn closer to its destination.
	public void TimeStep() {
		if (turnsRemaining > 0) {
			--turnsRemaining;
		} else {
			turnsRemaining = 0;
		}
	}

	public int compareTo(final Object o) {
		Fleet f = (Fleet) o;
		return this.numShips - f.numShips;
	}

	private final int owner;
	private int numShips;
	private final int sourcePlanet;
	private final int destinationPlanet;
	private final int totalTripLength;
	private int turnsRemaining;

	private Fleet(final Fleet _f) {
		owner = _f.owner;
		numShips = _f.numShips;
		sourcePlanet = _f.sourcePlanet;
		destinationPlanet = _f.destinationPlanet;
		totalTripLength = _f.totalTripLength;
		turnsRemaining = _f.turnsRemaining;
	}

	@Override
	public Object clone() {
		return new Fleet(this);
	}
}
