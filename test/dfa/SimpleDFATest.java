package dfa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleDFATest {

    @Test
    public void test() {
        DFA automaton = new DFA("Mistery");
        automaton.addRule("q0", "0", "q1");
        automaton.addRule("q0", "1", "F");
        automaton.addRule("q1", "0", "q1");
        automaton.addRule("q1", "1", "q2");
        automaton.addRule("q2", "0", "q1");
        automaton.addRule("q2", "1", "q2");
        automaton.setStartState("q0");
        automaton.setFinalStates(new String[]{"q2"});
        assertEquals(true, automaton.readWord("010101"));
        assertEquals(false, automaton.readWord("0101010"));


    }

}


