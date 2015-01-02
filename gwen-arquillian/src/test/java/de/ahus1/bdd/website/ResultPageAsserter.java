package de.ahus1.bdd.website;

import static org.fest.assertions.Assertions.assertThat;

public class ResultPageAsserter {

	private ResultPage resultPage;

	public ResultPageAsserter(ResultPage resultPage) {
		this.resultPage = resultPage;
	}

	public void showsAResultCountOf(int i) {
		assertThat(resultPage.getNumberOfsearchResults()).isEqualTo(i);
	}
}
