import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        ArrayList<Integer> list = new ArrayList<>();
        
        Arrays.sort(records, (a, b) -> {
            String numA = a.split(" ")[1];
            String numB = b.split(" ")[1];
            return numA.compareTo(numB);
        });
        
        boolean flag = false;
        int totalTime = 0; // 전체시간
         
        String[] input = records[0].split(" ");
        String prevTime = input[0]; // 시간
        String prevNum = input[1]; // 고유번호
        String prevOx = input[2]; // IN OUT
        
        String[] t1 = prevTime.split(":");
        int h1 = Integer.parseInt(t1[0]);
        int m1 = Integer.parseInt(t1[1]);
        
        int defaultTime = fees[0]; // 기본시간
        int defaultFee = fees[1];  // 기본요금
        int unitTime = fees[2];    // 단위시간
        int unitFee = fees[3];     // 단위요금
        
        for(int i=1; i<records.length; i++) {
            String[] inputs = records[i].split(" ");
            String time = inputs[0]; // 시간
            String num = inputs[1]; // 고유번호
            String ox = inputs[2]; // IN OUT
            
            String[] t2 = time.split(":");
            int h2 = Integer.parseInt(t2[0]);
            int m2 = Integer.parseInt(t2[1]);
              
            if(!num.equals(prevNum)) {
                if (prevOx.equals("IN")) {
                    totalTime += (23 - h1) * 60 + (59 - m1);
                }
  
                if (totalTime <= defaultTime) {
                    list.add(defaultFee);
                } else {
                    int overtime = totalTime - defaultTime;
                    int res = defaultFee + (int) Math.ceil((double) overtime / unitTime) * unitFee;
                    list.add(res);
                }
                h1 = h2;
                m1 = m2;
                totalTime = 0;
            } else if (ox.equals("OUT")) { 
                totalTime += (h2 - h1) * 60 + (m2 - m1);
            } else {
                h1 = h2;
                m1 = m2;
            }
            prevNum = num;
            prevOx = ox;
        }
        
        if(prevOx.equals("IN")) {
            totalTime += (23-h1) * 60 + (59 - m1);
        }
        if(totalTime <= defaultTime) {
            list.add(defaultFee);
        } else {
            int overTime = totalTime - defaultTime;
            int res = defaultFee + (int) Math.ceil((double) overTime / unitTime) * unitFee;
            list.add(res);
        }
        
        int[] res2 = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            res2[i] = list.get(i);
        }
        
        return res2; //차량 번호가 작은 자동차부터 출력
    }
}