import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.MAX_VALUE;
        String input = br.readLine();
        
        String[] sub = input.split("-");
        for(int i=0; i<sub.length; i++) {
            int temp = 0;
            
            String[] add = sub[i].split("\\+");
            for(int j=0; j<add.length; j++) {
                temp += Integer.parseInt(add[j]);
            }
            
            if(answer == Integer.MAX_VALUE) {
                answer = temp;
            } else {
                answer -= temp;
            }
        }
        System.out.println(answer);
    }
}