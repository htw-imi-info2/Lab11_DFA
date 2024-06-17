package nfa;

import nfa.examples.NFA1AtThirdFromLast;
import nfa.examples.NFAWithEpsilon;
import nfa.examples.NFAWithExamples;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public  class NFATestAllExamples {

	public static List<Object[]> testCases() {
		NFAWithExamples[] examples = new NFAWithExamples[]{
				new NFAWithEpsilon(),
				new NFA1AtThirdFromLast()
		};

		List<Object[]> testCases = new ArrayList<>();
		for (NFAWithExamples nfa : examples) {
			for (String w : nfa.notInLanguage())
				testCases.add(new Object[]{nfa.getFA(), false, w});
			for (String w : nfa.inLanguage())
				testCases.add(new Object[]{nfa.getFA(), true, w});

		}
		return testCases;


	}
	@ParameterizedTest
	@MethodSource("testCases")
	public void test(NFA fa, boolean inLanguage, String word) {
		fa.readString(word);
		assertEquals(inLanguage, fa.accepts());
	}



}