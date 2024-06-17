package dfa;

import dfa.examples.DFAWithExamples;
import dfa.examples.UnevenNumberOfAs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DFATestParameterized {

    @ParameterizedTest
    @MethodSource("testCases")
    public void testAccept(DFA dfa, boolean inLanguage, String word) {

        assertEquals( inLanguage, dfa.readWord(word));
    }




    public static Collection<Object[]> testCases() {

        DFAWithExamples dfa_ex = new UnevenNumberOfAs();

        List<Object[]> testCases = new ArrayList<>();
        for (String w : dfa_ex.notInLanguage())
            testCases.add( new Object[] {dfa_ex.getFA(), false, w });
        for (String w : dfa_ex.inLanguage())
            testCases.add(new Object[] {dfa_ex.getFA(), true, w });
        return testCases;
    }

}
