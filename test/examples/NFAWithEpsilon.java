package examples;

import java.util.Arrays;
import java.util.Collection;

import nfa.NFA;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NFAWithEpsilon extends NFATester{

	@Before
	public void setUp() throws Exception {
		fa = new NFA(1);
		fa.addRule(1, NFA.EPSILON, 2);
		fa.addRule(1, NFA.EPSILON, 3);
		fa.addRule(2, 'a', 2);
		fa.addRule(2, 'a', 4);
		fa.addRule(3, 'b', 3);
		fa.addRule(3, 'b', 5);
		fa.addAcceptState(4);
		fa.addAcceptState(5);
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { "", false }, { "a", true },
				{ "aa", true }, { "aaa", true }, { "b", true }, { "bb", true },
				{ "bbb", true }, { "abb", false }, { "baaaa", false },
				{ "aaaaab", false }, { "abababa", false }, { "101", false } });
	}

	public NFAWithEpsilon(String string, boolean inLanguage) {
		super(string,inLanguage);
	}

	
}
