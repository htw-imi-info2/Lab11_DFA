package nfa.examples;

import java.util.Arrays;
import java.util.Collection;

import nfa.NFA;


public class NFAWithEpsilon extends NFAWithExamples {

	@Override
	public NFA getFA() {
		NFA fa = new NFA(1, "NFAWithEpsilon");
		fa.addRule(1, NFA.EPSILON, 2);
		fa.addRule(1, NFA.EPSILON, 3);
		fa.addRule(2, 'a', 2);
		fa.addRule(2, 'a', 4);
		fa.addRule(3, 'b', 3);
		fa.addRule(3, 'b', 5);
		fa.addAcceptState(4);
		fa.addAcceptState(5);
		return fa;
	}

	@Override
	public Collection<Object[]> examples() {
		return Arrays.asList(new Object[][] { { "", false }, { "a", true },
				{ "aa", true }, { "aaa", true }, { "b", true }, { "bb", true },
				{ "bbb", true }, { "abb", false }, { "baaaa", false },
				{ "aaaaab", false }, { "abababa", false }, { "101", false } });
	}


	
}
