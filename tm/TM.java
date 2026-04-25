package tm;

/**
 * Deterministic Turing Machine model.
 * @author davisgrmn, adomaksic
 */
public class TM {
    private final int numberOfStates;
    private final int inputAlphabetSize;
    private final int haltingState;
    private final TMState[] states;

    public TM(int numberOfStates, int inputAlphabetSize) {
        this.numberOfStates = numberOfStates;
        this.inputAlphabetSize = inputAlphabetSize;
        this.haltingState = numberOfStates - 1;

        int tapeAlphabetSize = inputAlphabetSize + 1; // includes blank as "0"
        this.states = new TMState[numberOfStates];
        for (int i = 0; i < numberOfStates; i++) {
            states[i] = new TMState(i, tapeAlphabetSize);
        }
    }

    public int getHaltingState() {
        return haltingState;
    }

    public int getInputAlphabetSize() {
        return inputAlphabetSize;
    }

    public void setTransition(int fromState, int readSymbol, int nextState, int writeSymbol, Direction move) {
        states[fromState].setTransition(readSymbol, new Transition(nextState, writeSymbol, move));
    }

    public Transition getTransition(int currentState, int readSymbol) {
        if (currentState == haltingState) return null;
        return states[currentState].getTransition(readSymbol);
    }

    public String run(Tape tape) {
        int state = 0;
        while (state != haltingState) {
            int symbol = tape.read();
            Transition t = getTransition(state, symbol);
            if (t == null) {
                throw new IllegalStateException("Missing transition for state=" + state + ", symbol=" + symbol);
            }
            tape.write(t.getWriteSymbol());
            tape.move(t.getMove());
            state = t.getNextState();
        }
        return tape.visitedContent();
    }
}