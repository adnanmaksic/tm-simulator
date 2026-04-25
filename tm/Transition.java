package tm;

/**
 * TM transitions.
 */
public class Transition {
    private final int nextState;
    private final int writeSymbol;
    private final Direction move;

    public Transition(int nextState, int writeSymbol, Direction move) {
        this.nextState = nextState;
        this.writeSymbol = writeSymbol;
        this.move = move;
    }

    public int getNextState() {
        return nextState;
    }

    public int getWriteSymbol() {
        return writeSymbol;
    }

    public Direction getMove() {
        return move;
    }
}