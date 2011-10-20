package org.okiwi.planetwars;

public class Planet implements Cloneable {
	// Initializes a planet.
	public Planet(final int planetID, final int owner, final int numShips, final int growthRate, final double x,
			final double y) {
		this.planetID = planetID;
		this.owner = owner;
		this.numShips = numShips;
		this.growthRate = growthRate;
		this.x = x;
		this.y = y;
	}

	// Accessors and simple modification functions. These should be mostly
	// self-explanatory.
	public int PlanetID() {
		return planetID;
	}

	public int Owner() {
		return owner;
	}

	public int NumShips() {
		return numShips;
	}

	public int GrowthRate() {
		return growthRate;
	}

	public double X() {
		return x;
	}

	public double Y() {
		return y;
	}

	public void Owner(final int newOwner) {
		this.owner = newOwner;
	}

	public void NumShips(final int newNumShips) {
		this.numShips = newNumShips;
	}

	public void AddShips(final int amount) {
		numShips += amount;
	}

	public void RemoveShips(final int amount) {
		numShips -= amount;
	}

	private final int planetID;
	private int owner;
	private int numShips;
	private final int growthRate;
	private final double x, y;

	private Planet(final Planet _p) {
		planetID = _p.planetID;
		owner = _p.owner;
		numShips = _p.numShips;
		growthRate = _p.growthRate;
		x = _p.x;
		y = _p.y;
	}

	@Override
	public Object clone() {
		return new Planet(this);
	}
}
