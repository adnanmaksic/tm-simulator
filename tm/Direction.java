package tm;
/**
* Type enumeration for the direction
* Includes both L for left, R for right
* @author davisgrmn, adomaksic
*/
public enum Direction {
    L,
    R;

    public static Direction fromToken(String token) {
        String t = token.trim();
        if ("L".equals(t)){
            return L;
        }
        if ("R".equals(t)){
            return R;
        }
        throw new IllegalArgumentException("Not valid direction");
    }
}
