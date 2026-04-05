package CSESProblems;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;

/*
* https://cses.fi/problemset/task/1164/
* */
public class RoomAllocation {

    // Brute Force approach : Sorted on the basis of Departure time,
    // create a array of room number allocated to customers --> size n
    // pick the initial customer and allocate a room Number to it
    // then try to give this roomNumber (to the cstomers whose arrival > dept of this intial one )
    // after allocating this room Number to the customer --> update the start , end time
    // do this for every customer ( which is not allocated to any room)


    public static void main(String[] args) {
        FastIO io = new FastIO();
        int n = io.nextInt();
        int[][] customers = new int[n][2];

        for(int i =0; i<n; i++){
            int arrival = io.nextInt();
            int dept = io.nextInt();

            int[] customer = new int[3];
            customer[0] = arrival;
            customer[1] = dept;
            customer[2] = i; // index of current person
            customers[i] = customer;
        }

        //sorting on the basis of dept time
        Arrays.sort(customers, (a, b) -> a[1] - b[1] );
        int[] roomNumbersAllocated = new int[n];
        int ans = 0;
        int start = 0;
        int end = 0;

        for(int i = 0; i<n; i++){
            int[] customer = customers[i];
            if(roomNumbersAllocated[customer[2]] ==0){
                // no room allocated
                ans++;
                start = customer[0];
                end = customer[1];
                roomNumbersAllocated[customer[2]] = ans;
            }
            for(int j = i+1; j<n; j++){
                // if not allocated , can we allocate the same room Number as ith customer
                int[] customer_j  = customers[j];
                int index = customer_j[2];
                int arrival = customer_j[0];
                int depart = customer_j[1];
                if(roomNumbersAllocated[index] == 0 && arrival > end){
                    roomNumbersAllocated[index] = ans;
                    start = arrival;
                    end = depart;
                }
            }
        }
        io.println(ans); // gives the number of rooms required
        StringBuilder str = new StringBuilder();
        for (int allocation : roomNumbersAllocated) { str.append(allocation).append(" "); }
        io.println(str);
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
