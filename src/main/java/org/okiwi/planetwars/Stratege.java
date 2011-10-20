package org.okiwi.planetwars;

import java.util.List;

import com.google.common.collect.Lists;

public class Stratege {

	public static Strategie meilleureStratégie(final GuerreDesPlanetes pw) {
		return stratégies.get(0);
	}

	public static void setStratégies(final List<Strategie> stratégies) {
		Stratege.stratégies = stratégies;
	}

	private static List<Strategie> stratégies = Lists.newArrayList((Strategie) new StrategieParDefaut());

}
