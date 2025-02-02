import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 포켓몬의 개수
        int m = Integer.parseInt(st.nextToken()); // 문제의 개수

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> reverseMap = new HashMap<>();
        for(int i=1; i<=n; i++) {
            String poketmon = br.readLine();
            map.put(poketmon, i);
            reverseMap.put(i, poketmon);
        }

        for(int j=0; j<m; j++) {
            String problem = br.readLine();

            try{
                int problemNumber = Integer.parseInt(problem);
                System.out.println(reverseMap.get(problemNumber));
            } catch(NumberFormatException e) {
                System.out.println(map.get(problem));
            }
        }
    }
}