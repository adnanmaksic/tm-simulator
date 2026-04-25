package tm;
/**
* Single TM state with transition indexed by reading the symbol
* @author davisgrmn, adomaksic
*/
public class TMState {
    private final int id;
    private final Transition[] transitions;

    public TMState(int id, int alphabetSize){
        this.id = id;
        this.transitions = new Transition[alphabetSize];
    }

    public int getId() {
        return id;
    }

    public void setTransition(int readSymbol, Transition transition){
        transitions[readSymbol] = transition;
    }

    public Transition getTransition(int readSymbol){
        return transitions[readSymbol];
    }
}