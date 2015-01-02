package de.ahus1.bdd.website;

import org.jboss.arquillian.graphene.Graphene;

import com.shazam.gwen.collaborators.Arranger;

public class StartPageArranger implements Arranger {

	StartPage startPage;

	public StartPageArranger(StartPage startPage) {
		this.startPage = startPage;
	}

	public void isOpenedInBrowser() {
		Graphene.goTo(startPage.getClass());
	}

}
