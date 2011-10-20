package org.okiwi.planetwars;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.collect.Lists;

public class TestsBot {

	@Test
	public void doNothingIfFiveFleets() {
		Bot bot = new Bot();
		PlanetWars planetWars = new PlanetWars();
		planetWars.setFleets(Lists.newArrayList(new Fleet(), new Fleet(), new Fleet(), new Fleet(), new Fleet()));

		bot.run(planetWars);

		assertThat(planetWars.getOrders().size(), is(0));
	}
}
