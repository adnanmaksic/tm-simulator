package tm;

import java.util.HashMap;
import java.util.Map;

/** 
 * Bi-infinite tape using sparsing (blank is 0)
 * @author adomaksic, davisgrmn
 */

public class Tape {
    private final Map<Integer, Integer> cells;
    private int head;

    private int minVisited;
    private int maxVisited;

    public Tape(String input) {
        this.cells = new HashMap<>();
        this.head = 0;
        this.minVisited = 0;
        this.maxVisited = 0;

        for (int i = 0; i < input.length(); i++) {
            int symbol = Character.digit(input.charAt(i), 10);
            if (symbol != 0) {
                cells.put(i, symbol);
            }
        }
    }

    public int read() {
        return cells.getOrDefault(head, 0);
    }

    public void write(int symbol) {
        if (symbol == 0) {
            cells.remove(head);
        } else {
            cells.put(head, symbol);
        }
    }

    public void move(Direction direction) {
        if (direction == Direction.L) {
            head--;
        } else {
            head++;
        }
        if (head < minVisited) minVisited = head;
        if (head > maxVisited) maxVisited = head;
    }

    public String visitedContent() {
        StringBuilder sb = new StringBuilder();
        for (int i = minVisited; i <= maxVisited; i++) {
            sb.append(cells.getOrDefault(i, 0));
        }
        return sb.toString();
    }
}
