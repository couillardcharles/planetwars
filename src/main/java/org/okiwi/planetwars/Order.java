package org.okiwi.planetwars;

public class Order {

	public Order(final Planet source, final Planet dest, final int numShips) {
		this.source = source;
		this.dest = dest;
		this.numShips = numShips;
	}

	public Planet getSource() {
		return source;
	}

	public Planet getDest() {
		return dest;
	}

	public int getNumShips() {
		return numShips;
	}

	private final Planet source;
	private final Planet dest;
	private final int numShips;

}
