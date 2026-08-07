import java.util.*;

class Solution {
    static HashMap<Character, Integer> map;
    static int answer;
    public int solution(String skill, String[] skill_trees) {
        answer = 0;
        map = new HashMap<>();
        
        for(int i=0; i<skill.length(); i++) {
            char ch = skill.charAt(i);
            map.put(ch, i);
        }
       
        for(int i=0; i<skill_trees.length; i++) {
            int curIdx = -1;
            boolean possible = true;
            for(int j=0; j<skill_trees[i].length(); j++) {
                char ch = skill_trees[i].charAt(j);

                if(!map.containsKey(ch)) { continue; }
                
                int chIdx = map.get(ch);
                
                if(curIdx + 1 != chIdx) {
                    possible = false;
                    break;
                }
                curIdx = chIdx;
            }
            if(possible) answer++;
        }
        return answer;
    }
}