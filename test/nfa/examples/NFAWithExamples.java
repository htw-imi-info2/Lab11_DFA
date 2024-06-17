package nfa.examples;

import nfa.NFA;

import java.util.ArrayList;
import java.util.Collection;

public interface NFAWithExamples {
    NFA getFA();
    String[] inLanguage();
    String[] notInLanguage();

}
