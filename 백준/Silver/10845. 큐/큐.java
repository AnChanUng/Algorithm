import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            String[] inputs = br.readLine().split(" ");
            if(inputs[0].equals("push")) {
                q.offer(Integer.valueOf(inputs[1]));
            } else if (inputs[0].equals("pop")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peek());
                    q.poll();
                }
            } else if (inputs[0].equals("size")) {
                System.out.println(q.size());
            } else if (inputs[0].equals("empty")) {
                if(q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (inputs[0].equals("front")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peekFirst());
                }
            } else if (inputs[0].equals("back")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peekLast());
                }
            }
        }
    }
}