import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            String[] inputs = br.readLine().split(" ");
            String order = inputs[0];

            if (order.equals("all")) {
                set.clear();
                for(int j=1; j<=20; j++) {
                    set.add(j);
                }
            } else if (order.equals("empty")) {
                set.clear();
            } else {
                int x = Integer.parseInt(inputs[1]);
                if (order.equals("add")) {
                    set.add(x);
                } else if (order.equals("remove")) {
                    set.remove(x);
                } else if (order.equals("check")) {
                    if (set.contains(x)) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                } else if (order.equals("toggle")) {
                    if (set.contains(x)) {
                        set.remove(x);
                    } else {
                        set.add(x);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}