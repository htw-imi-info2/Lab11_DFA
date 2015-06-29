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

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { "0", false }, { "01", false },
				{ "0100", true }, { "111111", true }, { "01001", false },
				{ "0110", true }, { "010101001010100111", true },
				{ "111", true }, { "010101001010100011", false },
				{ "", false }, { "10", false }, { "101", true } });
	}

	public NFA1AtThirdFromLast(String string, boolean inLanguage) {
		super(string, inLanguage);
	}

}
