import java.util.*;
/*
    스킬 순서대로 배우기 순서대로 동작하면 cnt++
    
    1. skill_trees 배열 순회
    2. 항상 skill의 첫번째 값부터 시작해야함
    2.1 첫번째 값이 나오면 skill의 두번째 값이 나와야함 
    2.2 첫번째 값이 안나오면 return false;
    2.3 마지막 값 까지 돌면 cnt++
    3. cnt 갯수 출력
*/
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int cnt = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<skill.length(); i++) {
            char ch = skill.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch, i);
            }
        }
        
        for(int i=0; i<skill_trees.length; i++) {
            int index = 0;
            boolean flag = false;
            for(int j=0; j<skill_trees[i].length(); j++) {
                char ch = skill_trees[i].charAt(j);

                // 2.1 첫번째 값이 나오면 skill의 두번째 값이 나와야함 
                // 2.2 첫번째 값이 안나오면 return false;
                // 2.3 마지막 값 까지 돌면 cnt++
                //System.out.println("ch: " + ch + " map.get(ch): " + map.get(ch));
                if(map.containsKey(ch)) {
                    if(map.get(ch) == index) {
                        index++;
                    } else {
                        flag = true;
                    }
                }
                if(flag) break;
            }
            if(!flag) cnt++;
        } 
        
        return cnt;
    }
}