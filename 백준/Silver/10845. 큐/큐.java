import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            String[] inputs = br.readLine().split(" ");

            if(inputs[0].equals("push")) {
                q.offer(Integer.parseInt(inputs[1]));
            } else if(inputs[0].equals("pop")) {
                if(!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println(-1);
                }
            } else if(inputs[0].equals("size")) {
                System.out.println(q.size());
            } else if(inputs[0].equals("empty")) {
                if(q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(inputs[0].equals("front")) {
                if(!q.isEmpty()) { 
                    System.out.println(q.peek());
                } else {
                    System.out.println(-1);
                }
            } else if(inputs[0].equals("back")) {
                if(!q.isEmpty()) {
                    Integer lastElement = null;
                    for(Integer a : q) {
                        lastElement = a;
                    }
                    System.out.println(lastElement);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}