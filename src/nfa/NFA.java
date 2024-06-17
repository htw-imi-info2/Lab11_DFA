package nfa;

import java.util.HashSet;
import java.util.Set;

/**
 * This Nondeterministic Finite Automaton Implementation is based on Tom Stuarts
 * NFA example for his computation book, see
 * https://github.com/tomstuart/computationbook
 * 
 * It simulates an NFA by keeping track of all possible states the automaton
 * might be in after reading a single character or sequence of characters.
 * 
 * Have a loot at NFATest to see how it can be used.
 * 
 * @author kleinen
 *
 */
public class NFA {
	Set<FAState> currentStates;
	NFARulebook rulebook;
	public final static char EPSILON = 7; // using BEL as epsilon
	String name;
	public NFA(Object startStateIdentifier,String name){
		this.name = name;
		this.rulebook = new NFARulebook();
		this.currentStates = new HashSet<>();
		this.currentStates.add(rulebook.getState(startStateIdentifier));
	}
	public NFA(Object startStateIdentifier) {
		this(startStateIdentifier, "NFA");
	}
	@Override
	public String toString() { return name; }

	public void readString(String string) {
		char[] characters = string.toCharArray();
		for (char c : characters)
			readCharacter(c);
	}

	public void readCharacter(char c) {
		currentStates = rulebook.nextStates(currentStates(), c);
	}

	public Set<FAState> currentStates() {
		return rulebook.followFreeMoves(currentStates);
	}

	public boolean accepts() {
		return currentStates().stream()
				.anyMatch(state -> state.isAcceptState());
	}

	public void addRule(int state1, char c, int state2) {
		rulebook.addRule(state1, c, state2);
	}

	public void addAcceptState(Object identifier) {
		rulebook.getState(identifier).setAcceptState(true);
	}

	public Set<Character> getAlphabet() {
		return rulebook.alphabet();
	}

}
