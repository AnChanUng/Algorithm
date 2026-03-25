import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static int max;
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList<>();
        
        for(int len : course) {
            map.clear();
            max = 0;
            
            for(String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                
                dfs(arr, "", 0, 0, len);
            }
            
            for(String key : map.keySet()) {
                if(map.get(key) == max && max >= 2) {
                    list.add(key);
                }
            }
        }
        
        Collections.sort(list);
        return list.toArray(new String[0]);
    }
    
    static void dfs(char[] arr, String str, int start, int depth, int len) {
        if(depth == len) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            max = Math.max(max, map.get(str));
            return;
        }
        for(int i=start; i<arr.length; i++) {
            dfs(arr, str+arr[i], i+1, depth+1, len);
        }
    }
}