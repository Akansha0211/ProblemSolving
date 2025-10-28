package Oct28CSES;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class RoomAllocation {

    // https://cses.fi/problemset/task/1164/

    //FastIo required for CSES submission , it makes code faster
    // so after using it we don;t get TLE
    // snippet saved for futher use

    static class Customer implements Comparable<Customer>{
        int dept;
        int roomNo;

        Customer(int dept, int roomNo){
            this.dept = dept;
            this.roomNo = roomNo;
        }
        public int compareTo(Customer other ){
            return this.dept - other.dept;
        }
    }

    public static void main(String[] args){
        //Scanner sc = new Scanner(System.in);
        FastIO io = new FastIO();
        int n = io.nextInt();
        int[][] customers = new int[n][3];

        for(int i =0; i<n; i++){
            int arrival = io.nextInt();
            int dept = io.nextInt();

            int[] customer = new int[3];
            customer[0] = arrival;
            customer[1] = dept;
            customer[2] = i;

            customers[i] = customer;
        }
        // sorting when customers are arriving
        Arrays.sort(customers, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Customer> minHeap = new PriorityQueue<>();
        int ans = 0;
        int[] roomNumbersAllocated = new int[n];

        for(int i =0;i<customers.length; i++){
            int index = customers[i][2];
            if(!minHeap.isEmpty() && minHeap.peek().dept < customers[i][0]){
                Customer cust = minHeap.poll();
                minHeap.add(new Customer(customers[i][1], cust.roomNo)); // adding when cutsomers are leaving/ departure
                roomNumbersAllocated[index] = cust.roomNo;
            }else{
                ans++;
                minHeap.add(new Customer(customers[i][1], ans));
                roomNumbersAllocated[index] =ans;
            }
        }

//        System.out.println(ans);
//        for(int i = 0;i< roomNumbersAllocated.length; i++){
//            System.out.print(roomNumbersAllocated[i] + " ");
//        }
        io.println(ans);
        // use StringBuilder to speed up output
        StringBuilder str = new StringBuilder();
        for (int allocation : roomNumbersAllocated) { str.append(allocation).append(" "); }
        io.println(str);
        io.close();
    }



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
