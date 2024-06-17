package examples;

import nfa.NFA;

import java.util.ArrayList;
import java.util.Collection;

public abstract class NFAWithExamples {
    public abstract NFA getFA();
    public abstract Collection<Object[]> examples();

    protected Collection<Object[]> wordLists(
            Iterable<String> wordsInLanguage,
            Iterable<String> wordsNotInLanguage) {
        Collection<Object[]> testCases = new ArrayList<Object[]>();
        for (String word : wordsInLanguage) {
            testCases.add(new Object[] { word, true });
        }
        for (String word : wordsNotInLanguage) {
            testCases.add(new Object[] { word, false });
        }
        return testCases;
    }
}
