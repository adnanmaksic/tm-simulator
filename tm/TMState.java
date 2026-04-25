package tm;
/**
* Single TM state with transition indexed by reading the symbol
* @author davisgrmn, adomaksic
*/
public class TMState {
    private final int id;
    private final Transition[] transitions;

    /**
     * Constructs a TMState
     * @param id The id
     * @param alphabetSize The alphabet size
     */
    public TMState(int id, int alphabetSize){
        this.id = id;
        this.transitions = new Transition[alphabetSize];
    }

    /**
     * Gets the state ID
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a transition for a given read symbol
     * @param readSymbol The read symbol
     * @param transition The transition rule
     */
    public void setTransition(int readSymbol, Transition transition){
        transitions[readSymbol] = transition;
    }

    /**
     * Gets the transition for a given read symbol
     * @param readSymbol The read symbol
     * @return the transition
     */
    public Transition getTransition(int readSymbol){
        return transitions[readSymbol];
    }
}