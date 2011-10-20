package org.okiwi.planetwars;

public class Planete implements Cloneable {

	public Planete(final int idPlanète, final int propriétaire, final int nombreDeVaisseaux,
			final int tauxDeCroissance, final double x, final double y) {
		this.idPlanète = idPlanète;
		this.propriétaire = propriétaire;
		this.nombreDeVaisseaux = nombreDeVaisseaux;
		this.tauxDeCroissance = tauxDeCroissance;
		this.x = x;
		this.y = y;
	}

	public int idPlanète() {
		return idPlanète;
	}

	public int propriétaire() {
		return propriétaire;
	}

	public int nombreDeVaisseaux() {
		return nombreDeVaisseaux;
	}

	public int tauxDeCroissance() {
		return tauxDeCroissance;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

	public void propriétaire(final int propriétaire) {
		this.propriétaire = propriétaire;
	}

	public void nombreDeVaisseaux(final int nombreDeVaisseaux) {
		this.nombreDeVaisseaux = nombreDeVaisseaux;
	}

	public void ajouteVaisseaux(final int nombre) {
		nombreDeVaisseaux += nombre;
	}

	public void enlèveVaisseaux(final int amount) {
		nombreDeVaisseaux -= amount;
	}

	private final int idPlanète;
	private int propriétaire;
	private int nombreDeVaisseaux;
	private final int tauxDeCroissance;
	private final double x, y;

	private Planete(final Planete _p) {
		idPlanète = _p.idPlanète;
		propriétaire = _p.propriétaire;
		nombreDeVaisseaux = _p.nombreDeVaisseaux;
		tauxDeCroissance = _p.tauxDeCroissance;
		x = _p.x;
		y = _p.y;
	}

	@Override
	public Object clone() {
		return new Planete(this);
	}
}
