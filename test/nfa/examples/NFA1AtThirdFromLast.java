package nfa.examples;

import java.util.Arrays;
import java.util.Collection;

import nfa.NFA;

public class NFA1AtThirdFromLast implements NFAWithExamples {

	@Override
	public NFA getFA() {
		NFA fa = new NFA(1, "NFA1AtThirdFromLast");
		fa.addRule(1, '0', 1);
		fa.addRule(1, '1', 1);
		fa.addRule(1, '1', 2); // 0 rd from last
		fa.addRule(2, '0', 3); // second from last
		fa.addRule(2, '1', 3); // second from last
		fa.addRule(3, '0', 4); // last
		fa.addRule(3, '1', 4); // last
		fa.addAcceptState(4);
		return fa;
	}

	@Override
	public String[] inLanguage() {
		return new String[] { "0100", "111111", "111", "0110",
				"010101001010100111", "101" };
	}

	@Override
	public String[] notInLanguage() {
		return new String[] { "", "0", "01", "10", "01001",
				"010101001010100011" };
	}

}
