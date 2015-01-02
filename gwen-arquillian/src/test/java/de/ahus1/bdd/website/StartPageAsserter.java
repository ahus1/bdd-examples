package de.ahus1.bdd.website;

import static org.fest.assertions.Assertions.assertThat;

public class StartPageAsserter {

	private StartPage startPage;

	public StartPageAsserter(StartPage StartPage) {
		this.startPage = StartPage;
	}

	public void pageTitleIs(String string) {
		assertThat(startPage.getTitle()).isEqualTo(string);

	}
}
