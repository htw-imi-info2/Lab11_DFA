package nfa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NFARulebook {
	Set<FARule> rules;
	Map<Object, FAState> states = new HashMap<>();

	public NFARulebook() {
		super();
		this.rules = new HashSet<>();
	}

	public Set<FAState> nextStates(Set<FAState> states, char c) {
		return states.stream().map(state -> followRulesFor(state, c))
				.flatMap(l -> l.stream()).collect(Collectors.toSet());
	}

	public Set<FAState> followRulesFor(FAState state, char character) {
		return rulesFor(state, character).stream().map(r -> r.follow())
				.collect(Collectors.toSet());
	}

	public Set<FAState> followFreeMoves(Set<FAState> states) {
		Set<FAState> moreStates = nextStates(states, NFA.EPSILON);
		if (states.containsAll(moreStates))
			return states;
		else {
			moreStates.addAll(states);
			return followFreeMoves(moreStates);
		}
	}

	public Set<FARule> rulesFor(FAState state, char c) {
		Stream<FARule> applicableRules = rules.stream().filter(
				r -> r.appliesTo(state, c));
		return applicableRules.collect(Collectors.toSet());
	}

	public Set<Character> alphabet() {
		return rules.stream().map(r -> r.getCharacter())
				.collect(Collectors.toSet());
	}

	public void addRule(int state1, char c, int state2) {
		rules.add(new FARule(getState(state1), c, getState(state2)));
	}

	FAState getState(Object identifier) {
		FAState state = states.get(identifier);
		if (state == null) {
			state = new FAState(identifier);
			states.put(identifier, state);
		}
		return state;
	}

}
