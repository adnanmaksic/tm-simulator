package tm;

/**
 * TM transitions.
 */
public class Transition {
    private final int nextState;
    private final int writeSymbol;
    private final Direction move;

    /**
     * Constructs a Transition
     * @param nextState The next state
     * @param writeSymbol The symbol to write
     * @param move The direction to move
     */
    public Transition(int nextState, int writeSymbol, Direction move) {
        this.nextState = nextState;
        this.writeSymbol = writeSymbol;
        this.move = move;
    }

    /**
     * Gets the next state
     * @return next state
     */
    public int getNextState() {
        return nextState;
    }

    /**
     * Gets the write symbol
     * @return write symbol
     */
    public int getWriteSymbol() {
        return writeSymbol;
    }

    /**
     * Gets the move direction
     * @return move direction
     */
    public Direction getMove() {
        return move;
    }
}