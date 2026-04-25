package test.tm;
import fa.tm.Direction;
import fa.tm.TMInterface;

// edit later
// need to ensure that TMSimulator has a timeout function
// within 5 minutes otherwise i get docked points
// (10 points for each file, 3 files given in test/)\
// bonus points for running the code fast relative to other submissions
public class TMSimulator implements TMInterface{
    public static void main(String[] args) {
        
    }

    @Override
    public boolean read(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean scan(Direction dir) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'scan'");
    }

    @Override
    public boolean write(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'write'");
    }
}