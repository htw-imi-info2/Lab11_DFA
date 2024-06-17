package nfa;

public class FARule {
	private FAState state, nextState;
	private char character;
	
	public char getCharacter() {
		return character;
	}

	public FARule(FAState state, char character, FAState nextState) {
		this.state = state;
		this.character = character;
		this.nextState = nextState;
	}

	public boolean appliesTo(FAState state, char character) {
		return (state.equals(this.state)) && (character == this.character);
	}

	public FAState follow() {
		return nextState;
	}

	@Override
	public String toString() {
		return "" + state + " --"
				+ ((character == NFA.EPSILON) ? "ε" : character) + "-->"
				+ nextState;

	}

}
