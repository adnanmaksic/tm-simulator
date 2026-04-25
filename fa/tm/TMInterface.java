package fa.tm;

/**
 * Adds a state to the TM instance
 * @param name is the label of the state 
 *
 */
public interface TMInterface{

    public boolean read(String name);

    public boolean write(String name);

    public boolean scan(Direction dir);

}