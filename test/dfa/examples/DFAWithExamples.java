package dfa.examples;

import dfa.DFA;

import java.util.Collection;

public interface DFAWithExamples {
     DFA getFA();
     public String[] inLanguage();
     public String[] notInLanguage();

}
