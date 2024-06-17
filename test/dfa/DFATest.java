package dfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dfa.examples.DFAWithExamples;
import dfa.examples.UnevenNumberOfAs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DFATest {
	private DFA dfa;
		@BeforeEach
		public void setUp() {
			DFAWithExamples dfa_example =  new UnevenNumberOfAs();
			dfa = dfa_example.getFA();
		}
		@Test
		public void testStates() {
			Set<String> states = new HashSet<String>(Arrays.asList(new String[] { "q0", "q1" }));
			assertEquals(states, dfa.getStates());
		}

		@Test
		public void testInferredAlphabet() {
			// do I need to specify the alphabet?
			// not necessarily. (we might want that
			// if we want to output error messages if
			// a character is read that is not part of
			// the alphabet.
			Set<String> alphabet = new HashSet<String>(Arrays.asList(new String[] { "a" }));
			assertEquals(alphabet, dfa.getAlphabet());
		}
	}




