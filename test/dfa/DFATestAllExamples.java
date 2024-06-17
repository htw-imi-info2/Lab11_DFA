package dfa;

import dfa.examples.DFAWithExamples;
import dfa.examples.MisteryAutomaton;
import dfa.examples.UnevenNumberOfAs;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DFATestAllExamples {

    @ParameterizedTest
    @MethodSource("testCases")
    public void testAccept(DFA dfa, boolean inLanguage, String word) {
        assertEquals( inLanguage, dfa.readWord(word));
    }


    public static Collection<Object[]> testCases() {

        DFAWithExamples[] automata = {
                new UnevenNumberOfAs(),
                new MisteryAutomaton()
        };

        List<Object[]> testCases = new ArrayList<>();
        for (DFAWithExamples dfa : automata) {
            for (String w : dfa.notInLanguage())
                testCases.add(new Object[]{dfa.getFA(), false, w});
            for (String w : dfa.inLanguage())
                testCases.add(new Object[]{dfa.getFA(), true, w});
        }
        return testCases;
    }

}
