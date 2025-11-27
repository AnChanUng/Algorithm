import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int a=0; a<n; a++) {
            String str = br.readLine();
            Stack<Character> st = new Stack<>();
            boolean flag = true;
            for(int i=0; i<str.length(); i++) {
                char ch = str.charAt(i);
                if(ch == '(') {
                    st.push(ch);
                } else if (!st.empty() && ch == ')') {
                    if (st.peek() == '(') {
                        st.pop();
                    } else if (!st.empty() && st.peek() == ')') {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if(!flag) {
                System.out.println("NO");
                continue;
            }
            if(st.empty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}