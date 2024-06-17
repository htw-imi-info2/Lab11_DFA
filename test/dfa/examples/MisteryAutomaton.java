package dfa.examples;

import dfa.DFA;

public class MisteryAutomaton implements DFAWithExamples{

    @Override
    public DFA getFA() {
        DFA automaton = new DFA("MisteryAutomaton");
        automaton.addRule("q0", "0", "q1");
        automaton.addRule("q0", "1", "F");
        automaton.addRule("q1", "0", "q1");
        automaton.addRule("q1", "1", "q2");
        automaton.addRule("q2", "0", "q1");
        automaton.addRule("q2", "1", "q2");
        automaton.setStartState("q0");
        automaton.setFinalStates(new String[]{"q2"});
        return automaton;
    }

    @Override
    public String[] inLanguage() {
        return new String[]{"01", "001", "0001", "011", "0101", "0101010101", "01110111101"};
    }

    @Override
    public String[] notInLanguage() {
        return new String[]{"1", "10", "11", "12"};
    }
}
