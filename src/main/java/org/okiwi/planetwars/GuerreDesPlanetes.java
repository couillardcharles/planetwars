package org.okiwi.planetwars;

// Contestants do not need to worry about anything in this file. This is just
// helper code that does the boring stuff for you, so you can focus on the
// interesting stuff. That being said, you're welcome to change anything in
// this file if you know what you're doing.

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GuerreDesPlanetes {

	public GuerreDesPlanetes(final String étatDuJeu) {
		this();
		parseEtatDuJeu(étatDuJeu);
	}

	public GuerreDesPlanetes() {
		planètes = new ArrayList<Planete>();
		vols = new ArrayList<Vol>();
	}

	public int nombreDePlanètes() {
		return planètes.size();
	}

	public Planete getPlanète(final int idPlanète) {
		return planètes.get(idPlanète);
	}

	public List<Ordre> getOrdres() {
		return ordres;
	}

	public int nombreDeVols() {
		return vols.size();
	}

	public Vol getVol(final int idVol) {
		return vols.get(idVol);
	}

	public List<Planete> getPlanètes() {
		return planètes;
	}

	public void setPlanètes(final List<Planete> planètes) {
		this.planètes = planètes;
	}

	public List<Planete> mesPlanètes() {
		List<Planete> r = new ArrayList<Planete>();
		for (Planete p : planètes) {
			if (p.propriétaire() == 1) {
				r.add(p);
			}
		}
		return r;
	}

	public List<Planete> planètesNeutres() {
		List<Planete> r = new ArrayList<Planete>();
		for (Planete p : planètes) {
			if (p.propriétaire() == 0) {
				r.add(p);
			}
		}
		return r;
	}

	public List<Planete> planètesEnemies() {
		List<Planete> r = new ArrayList<Planete>();
		for (Planete p : planètes) {
			if (p.propriétaire() >= 2) {
				r.add(p);
			}
		}
		return r;
	}

	public List<Planete> planètesQueJeNePossèdePas() {
		List<Planete> r = new ArrayList<Planete>();
		for (Planete p : planètes) {
			if (p.propriétaire() != 1) {
				r.add(p);
			}
		}
		return r;
	}

	public List<Vol> getVols() {
		List<Vol> r = new ArrayList<Vol>();
		for (Vol f : vols) {
			r.add(f);
		}
		return r;
	}

	public void setVols(final List<Vol> vols) {
		this.vols = vols;
	}

	public List<Vol> mesVols() {
		List<Vol> r = new ArrayList<Vol>();
		for (Vol f : vols) {
			if (f.propriétaire() == 1) {
				r.add(f);
			}
		}
		return r;
	}

	public List<Vol> volsEnemis() {
		List<Vol> r = new ArrayList<Vol>();
		for (Vol f : vols) {
			if (f.propriétaire() != 1) {
				r.add(f);
			}
		}
		return r;
	}

	public int distance(final int planèteSource, final int planèteDestination) {
		Planete source = planètes.get(planèteSource);
		Planete destination = planètes.get(planèteDestination);
		double dx = source.x() - destination.x();
		double dy = source.y() - destination.y();
		return (int) Math.ceil(Math.sqrt(dx * dx + dy * dy));
	}

	public void envoieOrdre(final int planèteSource, final int planèteDestination, final int nombreVaisseaux) {
		System.out.println("" + planèteSource + " " + planèteDestination + " " + nombreVaisseaux);
		System.out.flush();
	}

	public void envoieOrdre(final Planete source, final Planete dest, final int nombreVaisseaux) {
		envoieOrdre(source.idPlanète(), dest.idPlanète(), nombreVaisseaux);
	}

	public void envoieOrdre(final Ordre ordre) {
		if (ordre != null) {
			ordres.add(ordre);
			envoieOrdre(ordre.getSource(), ordre.getDestination(), ordre.getNombreDeVaisseaux());
		}
	}

	public void finDuTour() {
		System.out.println("go");
		System.out.flush();
	}

	public boolean estVivant(final int idJoueur) {
		for (Planete p : planètes) {
			if (p.propriétaire() == idJoueur) {
				return true;
			}
		}
		for (Vol f : vols) {
			if (f.propriétaire() == idJoueur) {
				return true;
			}
		}
		return false;
	}

	public int gagnant() {
		Set<Integer> joueurs = new TreeSet<Integer>();
		for (Planete p : planètes) {
			joueurs.add(p.propriétaire());
		}
		for (Vol f : vols) {
			joueurs.add(f.propriétaire());
		}
		switch (joueurs.size()) {
		case 0:
			return 0;
		case 1:
			return ((Integer) joueurs.toArray()[0]).intValue();
		default:
			return -1;
		}
	}

	public int nombreVaisseaux(final int idJoueur) {
		int nombreVaisseaux = 0;
		for (Planete p : planètes) {
			if (p.propriétaire() == idJoueur) {
				nombreVaisseaux += p.nombreDeVaisseaux();
			}
		}
		for (Vol f : vols) {
			if (f.propriétaire() == idJoueur) {
				nombreVaisseaux += f.nombreDeVaisseaux();
			}
		}
		return nombreVaisseaux;
	}

	private int parseEtatDuJeu(final String s) {
		planètes.clear();
		vols.clear();
		int idPlanète = 0;
		String[] lines = s.split("\n");
		for (int i = 0; i < lines.length; ++i) {
			String line = lines[i];
			int commentBegin = line.indexOf('#');
			if (commentBegin >= 0) {
				line = line.substring(0, commentBegin);
			}
			if (line.trim().length() == 0) {
				continue;
			}
			String[] tokens = line.split(" ");
			if (tokens.length == 0) {
				continue;
			}
			if (tokens[0].equals("P")) {
				if (tokens.length != 6) {
					return 0;
				}
				double x = Double.parseDouble(tokens[1]);
				double y = Double.parseDouble(tokens[2]);
				int owner = Integer.parseInt(tokens[3]);
				int numShips = Integer.parseInt(tokens[4]);
				int growthRate = Integer.parseInt(tokens[5]);
				Planete p = new Planete(idPlanète++, owner, numShips, growthRate, x, y);
				planètes.add(p);
			} else if (tokens[0].equals("F")) {
				if (tokens.length != 7) {
					return 0;
				}
				int owner = Integer.parseInt(tokens[1]);
				int numShips = Integer.parseInt(tokens[2]);
				int source = Integer.parseInt(tokens[3]);
				int destination = Integer.parseInt(tokens[4]);
				int totalTripLength = Integer.parseInt(tokens[5]);
				int turnsRemaining = Integer.parseInt(tokens[6]);
				Vol f = new Vol(owner, numShips, source, destination, totalTripLength, turnsRemaining);
				vols.add(f);
			} else {
				return 0;
			}
		}
		return 1;
	}

	@SuppressWarnings("unused")
	private int chargeCarteDepuisFichier(final String fichierCarte) {
		String s = "";
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(fichierCarte));
			int c;
			while ((c = in.read()) >= 0) {
				s += (char) c;
			}
		} catch (Exception e) {
			return 0;
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				// Fucked.
			}
		}
		return parseEtatDuJeu(s);
	}

	private List<Planete> planètes;
	private List<Vol> vols;
	private final List<Ordre> ordres = new ArrayList<Ordre>();
}
