package tm;

/**
 * Minimal TM interface for tape operations
 */
public interface TMInterface{

    public boolean read(String name);

    public boolean write(String name);

    public boolean scan(Direction dir);

}