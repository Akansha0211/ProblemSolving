//package CSESProblems;

import java.io.*;
import java.util.InputMismatchException;

/*
* https://cses.fi/problemset/task/1620/
* */
public class FactoryMachines {

    public static void main(String[] args) {
        FastIO io = new FastIO();
        int n = io.nextInt();
        int t = io.nextInt();
        int[] machines = new int[n];
        for(int i=0; i<n; i++){
            machines[i] = io.nextInt();
        }

        // Brute Force approach...
        /*
        * eg n = 3, t = 7,  machines ==> [3 2 5]
        * at t =2  --> only 1 product by 2nd machine
        * at t = 3 --> 1 product by 1st machine
        * at t = 4 --> 2nd product by 2nd machine( the one taking 2 seconds to make a product)
        * at t = 5 --> 1 product by 3rd machine
        * at t = 6 --> By now we got 2 products by 1 machine, 3 products by 2nd machine , 1 by 3rd machine
        * at t = 7
        * at t = 8 --> Its giving 2 products by 1st machine, 4 products by 2nd machine , 1 product by 3rd machine ==> in all its --> 7 products
        *
        * so if notice we are getting more in the multiples of 2 ( ie multiples of min ( minimum time taken by machine))
        * This is linear --> we can do the same with Binary search in oprimised approach
        * */

        int min = Integer.MAX_VALUE;
        for(int mach : machines)min = Math.min(min, mach);


        int val = 1;
        int time = 0;
        while(true){
            time = min*val;
            int products = 0;
            for(int mach : machines){
                products += (time/mach);
            }
            if(products >= t){
                io.println(time);
                break;
            }
            val++;
        }
        io.close();
    }

    // Template for Fast IO....

    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

        // standard input
        public FastIO() { this(System.in, System.out); }
        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }
        // file input
        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }

        // throws InputMismatchException() if previously detected end of file
        private int nextByte() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) { throw new InputMismatchException(); }
                if (numChars == -1) return -1;  // end of file
            }
            return buf[curChar++];
        }

        // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
        public String next() {
            int c;
            do { c = nextByte(); } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }
        public int nextInt() {  // nextLong() would be implemented similarly
            int c;
            do { c = nextByte(); } while (c <= ' ');
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}
