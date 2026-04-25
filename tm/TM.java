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

    /**
     * Constructs the Turing Machine
     * @param numberOfStates The number of states
     * @param inputAlphabetSize The size of the input alphabet
     */
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

    /**
     * Gets the halting state ID
     * @return halting state
     */
    public int getHaltingState() {
        return haltingState;
    }

    /**
     * Gets the input alphabet size
     * @return input alphabet size
     */
    public int getInputAlphabetSize() {
        return inputAlphabetSize;
    }

    /**
     * Sets a transition for the machine
     * @param fromState The starting state
     * @param readSymbol The symbol read from tape
     * @param nextState The resulting state
     * @param writeSymbol The symbol to write to the tape
     * @param move The direction to move the tape head
     */
    public void setTransition(int fromState, int readSymbol, int nextState, int writeSymbol, Direction move) {
        states[fromState].setTransition(readSymbol, new Transition(nextState, writeSymbol, move));
    }

    /**
     * Gets a transition rule
     * @param currentState The current state
     * @param readSymbol The symbol on the tape
     * @return The resulting transition
     */
    public Transition getTransition(int currentState, int readSymbol) {
        if (currentState == haltingState) return null;
        return states[currentState].getTransition(readSymbol);
    }

    /**
     * Runs the Turing Machine on the given tape
     * @param tape The tape to run on
     * @return The visited content on the tape
     */
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