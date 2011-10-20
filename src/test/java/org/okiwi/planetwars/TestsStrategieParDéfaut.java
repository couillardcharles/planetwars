package org.okiwi.planetwars;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class TestsStrategieParDéfaut {

	@Before
	public void before() {
		guerreDesPlanètes = new GuerreDesPlanetes();
	}

	@Test
	public void neFaitRienSiIlYADéjà3Vols() {
		guerreDesPlanètes.setVols(Lists.newArrayList(unVolAMoi(), unVolAMoi(), unVolAMoi()));

		boolean envoiUnOrdre = new StrategieParDefaut().peutEnvoyerUnOrdre(guerreDesPlanètes);

		assertThat(envoiUnOrdre, is(false));
	}

	@Test
	public void peutEnvoyerUnOrdre() {
		guerreDesPlanètes.setVols(Lists.newArrayList(unVolAMoi()));

		boolean envoiUnOrdre = new StrategieParDefaut().peutEnvoyerUnOrdre(guerreDesPlanètes);

		assertThat(envoiUnOrdre, is(true));
	}

	private Vol unVolAMoi() {
		Vol vol = new Vol();
		vol.propriétaire(1);
		return vol;
	}

	private GuerreDesPlanetes guerreDesPlanètes;
}
