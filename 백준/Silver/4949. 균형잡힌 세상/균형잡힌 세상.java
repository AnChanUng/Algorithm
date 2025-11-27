import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
    괄호(,[ 들의 균형이 잘 맞춰져 있는지 판단하는 프로그램
    - (), [] 짝을 이뤄야함
    - 입력은 여러 줄, 단독 '.' 입력 시 종료

    문제
    1.1 문자열을 .가 나올때까지 입력받는다.
    1.2 마지막에 .가 한개 나오면 입력을 종료한다.
    2   각 문자를 순회하며
    2.1 (나 [가 나오면 stack에 저장한다.
    2.2 )나 ]가 나오면 stack.pop()한다
    2.2 다른 문자는 무시
    3   stack에 아무것도 없으면 yes를 출력한다 아니면 no를 출력한다
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();
            if(str.equals(".")) break;
            
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for(int i=0; i<str.length(); i++) {
                char st = str.charAt(i);
                if (st == '.') continue;
                if (st == '(' || st == '[') {
                    stack.push(st);
                } else if (st == ')') {
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        flag = true;
                        System.out.println("no");
                        break;
                    }
                } else if (st == ']') {
                    if (!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        flag = true;
                        System.out.println("no");
                        break;
                    }
                }
            }
            if(flag) continue;
            if(stack.isEmpty()) {
               System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}