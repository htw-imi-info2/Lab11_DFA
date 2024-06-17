package nfa;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NFATest {

	@Test
	public void testFollowFreeMoves() {
		NFA fa = new NFA(1);
		fa.addRule(1, NFA.EPSILON, 2);
		fa.addRule(1, NFA.EPSILON, 3);
		assertEquals(3, fa.currentStates().size());

	}

	@Test
	public void testReadCharacter() {
		NFA fa = new NFA(1);
		fa.addRule(1, 'a', 2);
		fa.readCharacter('a');
		Set<FAState> states = fa.currentStates();
		assertEquals(1, states.size());
		assertEquals(true, states.remove(new FAState(2)));
	}

	@Test
	public void testReadString() {
		NFA fa = new NFA(1);
		fa.addRule(1, 'a', 2);
		fa.addAcceptState(2);
		fa.readString("a");
		assertEquals(true, fa.accepts());
	}
	@Test 
	public void testGetAlphabet(){
		NFA fa = new NFA(1);
		fa.addRule(1, 'a', 1);
		fa.addRule(1, 'b', 2);
		Set<Character> alphabet = fa.getAlphabet();
		assertEquals(2,alphabet.size());
		assertEquals(true,alphabet.contains('a'));
		assertEquals(true,alphabet.contains('b'));
	}
	@Test
	public void test() {
		NFA fa = new NFA(1);
		fa.addRule(1, 'a', 1);
		fa.addRule(1, 'b', 2);
		fa.addAcceptState(2);
		Set<FAState> states = fa.currentStates();

		fa.addRule(2, 'b', 2);
		fa.readCharacter('a');
		states = fa.currentStates();
		assertEquals(false, fa.accepts());
		fa.readCharacter('b');
		states = fa.currentStates();
		assertEquals(1, states.size());
		assertEquals(true, fa.accepts());

	}

}
