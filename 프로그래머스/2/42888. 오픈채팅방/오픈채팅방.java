import java.util.*;
/*
    1. Enter면 "xx"님이 들어왔습니다.
    1.1 같은 아이디가 들어왔다가 나가고 새로운 닉네임으로 들어왔을 때, 기존의 아이디들도 변경 
    2. Leave면 "xx님이 나갔습니다"
    3. Change면 닉네임 변경
*/
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        // 아이디, 닉네임
        Map<String, String> map = new HashMap<>();
        
        for(int i=0; i<record.length; i++) {
            String[] inputs = record[i].split(" ");
            String order = inputs[0];
            String id = inputs[1];
            
            if(order.equals("Leave")) {
                
            } else if (order.equals("Enter")) {
                String nickname = inputs[2];
                map.put(id, nickname);
            } else if (order.equals("Change")) {
                String nickname = inputs[2];
                map.put(id, nickname);
            }
        }
        
        List<String> list = new ArrayList<>();
        for(int i=0; i<record.length; i++) {
            String[] inputs = record[i].split(" ");
            String order = inputs[0];
            String id = inputs[1];
            
            if(order.equals("Enter")) {
                list.add(map.get(id) + "님이 들어왔습니다.");
            } else if (order.equals("Leave")) {
                list.add(map.get(id) + "님이 나갔습니다.");
            }
        }
        
        return list.toArray(new String[0]);
    }
}