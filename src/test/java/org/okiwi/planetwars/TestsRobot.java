package org.okiwi.planetwars;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class TestsRobot {

	@Before
	public void avant() {
		bot = new Robot();
		guerreDesPlanètes = new GuerreDesPlanetes();
	}

	@Test
	public void peutNeRienFaire() {
		Stratege.setStratégies(Lists.newArrayList((Strategie) new MockStratégie(false)));

		bot.tourne(guerreDesPlanètes);

		assertThat(guerreDesPlanètes.getOrdres().size(), is(0));
	}

	@Test
	public void peutEnvoyerLeProchainOrdre() {
		Ordre ordre = new Ordre(new Planete(1, 1, 0, 0, 0, 0), new Planete(1, 1, 0, 0, 0, 0), 0);
		Stratege.setStratégies(Lists.newArrayList((Strategie) new MockStratégie(true, ordre)));

		bot.tourne(guerreDesPlanètes);

		assertThat(guerreDesPlanètes.getOrdres().size(), is(1));
		assertThat(guerreDesPlanètes.getOrdres().get(0), is(ordre));
	}

	public class MockStratégie implements Strategie {

		public MockStratégie(final boolean avecEnvoiDUnOrdre) {
			this.avecEnvoiDUnOrdre = avecEnvoiDUnOrdre;
		}

		public MockStratégie(final boolean avecEnvoiDUnOrdre, final Ordre ordre) {
			this.avecEnvoiDUnOrdre = avecEnvoiDUnOrdre;
			this.ordre = ordre;
		}

		@Override
		public boolean peutEnvoyerUnOrdre(final GuerreDesPlanetes pw) {
			return avecEnvoiDUnOrdre;
		}

		@Override
		public Ordre prochainOrdre(final GuerreDesPlanetes pw) {
			return ordre;
		}

		private final boolean avecEnvoiDUnOrdre;
		private Ordre ordre;
	}

	private Robot bot;
	private GuerreDesPlanetes guerreDesPlanètes;
}
