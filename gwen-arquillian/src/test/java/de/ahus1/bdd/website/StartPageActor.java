package de.ahus1.bdd.website;

import com.shazam.gwen.collaborators.Actor;

public class StartPageActor implements Actor {

	StartPage startPage;

	public StartPageActor(StartPage startPage) {
		this.startPage = startPage;
	}

	public ResultPage searchesFor(String string) {
		ResultPage result = startPage.search(string);
		return result;
	}
}
