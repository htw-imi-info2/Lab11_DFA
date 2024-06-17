package dfa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFA {


    String startState;
    Set<String> finalStates = new HashSet<>();
    Set<String> alphabet = new HashSet<>();
    Set<String> states = new HashSet<>();
    Map<StateInputPair, String> transitions = new HashMap<>();
    String state;
    String name;

    public DFA(String name){this.name=name;}

    class StateInputPair {
        String state;
        char input;
        String string_rep;

        public StateInputPair(String s, String i) {
            this.state = s;
            this.input = i.charAt(0);
        }
        public StateInputPair(String s, char i) {
            this.state = s;
            this.input = i;
        }

        @Override
        public String toString() {
            // this is called lazy initialization:
            if (string_rep == null)
                string_rep = state + "," + input;
            return string_rep;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null)
                return false;
            return toString().equals(o.toString());
        }

        @Override
        public int hashCode() {
            return toString().hashCode();
        }

    }


    public void setTransitions(String[][] transition_array) {
        transitions = new HashMap<>();
        for (String[] t : transition_array) {
            addTransition(t);
        }
    }

    public void addRule(String q1, String input, String q2) {
        addTransition(new String[]{q1, input, q2});
    }

    private void addTransition(String[] t) {
        transitions.put(new StateInputPair(t[0], t[1]), t[2]);
        alphabet.add(t[1]);
        states.add(t[0]);
        states.add(t[2]);
    }

    public void setStartState(String state) {
        startState = state;
        this.state = state;
    }

    public void setFinalStates(String[] states) {
        finalStates = new HashSet<>();
        finalStates.addAll(Arrays.asList(states));
    }

    public Set<String> getAlphabet() {
        return alphabet;
    }

    public boolean readWord(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            read(c);
        }
        return finalStates.contains(state);
    }
    public String read(String c) {
        if (c.length() != 1) throw new IllegalArgumentException("read reads only one character - length must be 1 but was "+c.length());
        return read(c.charAt(0));
    }
    public String read(char c) {
        state = transitions.get(new StateInputPair(state, c));
        System.out.println("read: "+c+" now in state "+state);
        return state;
    }

    public Set<String> getStates() {
        return states;
    }
    @Override
    public String toString(){return name;}

}
