import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
public class RandomWord {
    public static void main(String[] args) {
        double i = 0.0;
        String outString = "";

        while (!StdIn.isEmpty()) {
            String inString = StdIn.readString();
            i += 1;
            boolean isZero = StdRandom.bernoulli(1/i);
            if (isZero) {
                outString = inString;
            }
        }
        StdOut.println(outString);
    }
}
