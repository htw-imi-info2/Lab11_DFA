package examples;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import nfa.NFA;

import org.junit.Test;

public abstract class NFATester {
	protected NFA fa;
	String string;
	boolean inLanguage;

	public NFATester(String string, boolean inLanguage) {
		super();
		this.string = string;
		this.inLanguage = inLanguage;
	}

	@Test
	public void test() {
		fa.readString(string);
		assertEquals(string + " should " + (inLanguage ? "" : "not ")
				+ "be accepted: ", inLanguage, fa.accepts());
	}

	/**
	 * this is a utility method that can be used from the method annotated with @Parameters
	 * to construct the test cases out of two Lists of Strings:
	 * 
	 * @param wordsInLanguage
	 * @param wordsNotInLanguage
	 * @return
	 */
	public static Collection<Object[]> wordLists(
			Iterable<String> wordsInLanguage,
			Iterable<String> wordsNotInLanguage) {
		Collection<Object[]> testCases = new ArrayList<Object[]>();
		for (String word : wordsInLanguage) {
			testCases.add(new Object[] { word, true });
		}
		for (String word : wordsNotInLanguage) {
			testCases.add(new Object[] { word, false });
		}
		return testCases;
	}

}