import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0;
        int y = 0;

        for (int i = 0; i < dirs.length(); i++) {
            int nx = x; 
            int ny = y;
            char ch = dirs.charAt(i);

            if (ch == 'U') ny++;
            else if (ch == 'D') ny--;
            else if (ch == 'L') nx--;
            else if (ch == 'R') nx++;

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            visited.add(x + "," + y + "," + nx + "," + ny);
            visited.add(nx + "," + ny + "," + x + "," + y);

            x = nx;
            y = ny;
        }
        return visited.size() / 2;
    }
}