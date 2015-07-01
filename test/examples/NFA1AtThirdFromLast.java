package examples;

import java.util.Arrays;
import java.util.Collection;

import nfa.NFA;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NFA1AtThirdFromLast extends NFATester {
	@Before
	public void setUp() throws Exception {

		fa = new NFA(1);
		fa.addRule(1, '0', 1);
		fa.addRule(1, '1', 1);
		fa.addRule(1, '1', 2); // 0 rd from last
		fa.addRule(2, '0', 3); // second from last
		fa.addRule(2, '1', 3); // second from last
		fa.addRule(3, '0', 4); // last
		fa.addRule(3, '1', 4); // last
		fa.addAcceptState(4);
	}

	public static Iterable<String> wordsInLanguage() {
		return Arrays.asList(new String[] { "0100", "111111", "111", "0110",
				"010101001010100111", "101" });
	}

	public static Iterable<String> wordsNotInLanguage() {
		return Arrays.asList(new String[] { "", "0", "01", "10", "01001",
				"010101001010100011" });
	}

	public NFA1AtThirdFromLast(String string, boolean inLanguage) {
		super(string, inLanguage);
	}
	@Parameters(name = "{index}: {0} (in language: {1})")
	public static Collection<Object[]> data() {
		return wordLists(wordsInLanguage(), wordsNotInLanguage());
	}

}
