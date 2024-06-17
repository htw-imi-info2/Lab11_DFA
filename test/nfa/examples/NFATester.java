package nfa.examples;

import nfa.NFA;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public  class NFATester {

	public static List<Object[]> testCases() {
		NFAWithExamples[] tc = new NFAWithExamples[]{  new NFAWithEpsilon(), new NFA1AtThirdFromLast()};
		List<Object[]> testCases = new ArrayList<>();
		for (NFAWithExamples nfa : tc) {
			for(Object[] example : nfa.examples()) {
				testCases.add(new Object[]{nfa.getFA(), example[0], example[1]});
			}
		}
		return testCases;


	}
	@ParameterizedTest
	@MethodSource("testCases")
	public void test(NFA fa, String string, boolean inLanguage) {
		fa.readString(string);
		assertEquals(inLanguage, fa.accepts(), string + " should " + (inLanguage ? "" : "not ")
				+ "be accepted: ");
	}



}