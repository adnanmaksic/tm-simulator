package tm;

/**
 * Minimal TM interface for tape operations
 */
public interface TMInterface{

    /**
     * Reads a symbol
     * @param name The symbol name
     * @return true if successful
     */
    public boolean read(String name);

    /**
     * Writes a symbol
     * @param name The symbol name
     * @return true if successful
     */
    public boolean write(String name);

    /**
     * Scans in a direction
     * @param dir The direction
     * @return true if successful
     */
    public boolean scan(Direction dir);

}