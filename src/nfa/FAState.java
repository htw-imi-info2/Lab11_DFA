package nfa;

public class FAState {
	private Object identifier;
	private boolean acceptState = false;

	public FAState(Object identifier) {
		super();
		this.identifier = identifier;
	}

	public Object getIdentifier() {
		return identifier;
	}

	public boolean isAcceptState() {
		return acceptState;
	}

	public void setAcceptState(boolean acceptState) {
		this.acceptState = acceptState;
	}

	@Override
	public int hashCode() {
		return getIdentifier().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof FAState))
			return false;
		FAState other = (FAState) obj;
		return this.getIdentifier().equals(other.getIdentifier());

	}

	@Override
	public String toString() {
		return "[" + identifier + "]";
	}

}
