package examples;

import static org.junit.Assert.assertEquals;
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
}