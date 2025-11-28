import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            arr.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int idx = 0;
        while(!arr.isEmpty()) {
            idx = (idx + k - 1) % arr.size();
            sb.append(arr.remove(idx));

            if(!arr.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}