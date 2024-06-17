package dfa.examples;

import dfa.DFA;

public class UnevenNumberOfAs implements DFAWithExamples{
    @Override
    public DFA getFA() {
        DFA automaton = new DFA("UnevenNumberOfAs");
        automaton.setTransitions(new String[][] { { "q0", "a", "q1" }, { "q1", "a", "q0" } });
        automaton.setStartState("q0");
        automaton.setFinalStates(new String[] { "q1" });
        return automaton;
    }

    @Override
    public String[] inLanguage() {
        return new String[] { "a", "aaa", "aaaaa", "aaaaaaaaaaaaaaaaa" };
    }

    @Override
    public String[] notInLanguage() {
        return new String[]{ "aa", "aaaa", "aaaaaa", "aaaaaaaaaaaaaaaaaa", "b", "aaab" };
    }

}
