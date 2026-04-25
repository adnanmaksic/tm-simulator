package tm;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Project 3 entry point.
 * Usage: java tm.TMSimulator <input-file>
 * @author davisgrmn, adomaksic
 */
public class TMSimulator implements TMInterface {
    private TM tm;
    private Tape tape;

    /**
     * Program execution entry point
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            return;
        }

        TMSimulator sim = new TMSimulator();
        if (!sim.loadFromFile(args[0])) {
            return;
        }

        String output = sim.tm.run(sim.tape);
        System.out.println(output);
    }

    /**
     * Loads TM parameters and tape data from a file
     * @param fileName Name of the file
     * @return true if successful, false otherwise
     */
    private boolean loadFromFile(String fileName) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(fileName))) {
            String line1 = br.readLine();
            String line2 = br.readLine();
            if (line1 == null || line2 == null) return false;

            int n = Integer.parseInt(line1.trim());
            int m = Integer.parseInt(line2.trim());

            if (n < 2 || m < 1 || m > 9) return false;

            this.tm = new TM(n, m);

            int transitionCount = (n - 1) * (m + 1);
            for (int i = 0; i < transitionCount; i++) {
                String trLine = br.readLine();
                if (trLine == null) return false;

                String[] parts = trLine.split(",");
                if (parts.length != 3) return false;

                int nextState = Integer.parseInt(parts[0].trim());
                int writeSymbol = Integer.parseInt(parts[1].trim());
                Direction move = Direction.fromToken(parts[2]);

                int fromState = i / (m + 1);
                int readSymbol = i % (m + 1);

                tm.setTransition(fromState, readSymbol, nextState, writeSymbol, move);
            }

            String input = br.readLine();
            if (input == null) input = "";
            input = input.trim();

            for (int i = 0; i < input.length(); i++) {
                int sym = Character.digit(input.charAt(i), 10);
                if (sym < 1 || sym > m) return false;
            }

            this.tape = new Tape(input);
            return true;
        } catch (IOException | IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * Reads a symbol on the tape and validates it
     * @param name The expected symbol
     * @return true if matches under head
     */
    @Override
    public boolean read(String name) {
        if (tape == null) return false;
        try {
            int expected = Integer.parseInt(name.trim());
            return tape.read() == expected;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * Moves head in given direction
     * @param dir The movement direction
     * @return true if successful
     */
    @Override
    public boolean scan(Direction dir) {
        if (tape == null || dir == null) return false;
        tape.move(dir);
        return true;
    }

    /**
     * Writes symbol onto the current tape cell
     * @param name The symbol to write
     * @return true if successful format
     */
    @Override
    public boolean write(String name) {
        if (tape == null) return false;
        try {
            int symbol = Integer.parseInt(name.trim());
            if (symbol < 0 || symbol > 9) return false;
            tape.write(symbol);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}