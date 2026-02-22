import java.util.*;
import java.lang.*;
import java.io.*;
/*
    1.1 플레이어 수(n), 방의 정원(m) 입력 받기 
    1.2 p개의 줄에 플레이어의 레벨(l), 닉네임(n) 입력 받기
    2.  매칭 시스템
    2.1 입장 신청 -> 매칭 가능한 방 x -> 새로운 방 생성하고 입장
        (레벨 -10부터 +10까지 입장 가능)
    2.2 입장 가능한 방 -> 입장 -> 정원이 모두 찰 때까지 대기
    2.3 입장 가능한 방 여러개 -> 먼저 생성된 방 입장
    2.4 방 정원이 모두 꽉차면 게임 시작
    3.  모든 생성된 방의 게임의 시작 유무와
        방에 들어있는 플레이어들의 레벨과 아이디 출력
        - 사전순으로 앞서는 플레이어부터 출력
        - 방이 시작되었으면 Started! 대기중이면 Waiting! 출력
*/
class Main {
    public static class Player implements Comparable<Player> {
        int level;
        String name;
        boolean check;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player p1) {
            return name.compareTo(p1.name);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int p = Integer.parseInt(st.nextToken()); // 플레이어 수
        int m = Integer.parseInt(st.nextToken()); // 방의 정원

        Player[] players = new Player[p];
        
        for(int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken()); // 플레이어의 레벨
            String name = st.nextToken();                 // 닉네임
            players[i] = new Player(level, name);
        }

        for(int i=0; i<p; i++) {
            ArrayList<Player> room = new ArrayList<>(); 
            if(!players[i].check) {
                for(int j=i; j<p; j++) {
                    if(room.size() == m) {
                        break;
                    }
                    int level = players[j].level;
                    String name = players[j].name;
                    if(!players[j].check && players[i].level - 10 <= level && players[i].level + 10 >= level) {
                        players[j].check = true;
                        room.add(new Player(level, name));
                    }
                }
                Collections.sort(room);
                if(room.size() == m) {
                    sb.append("Started!").append("\n");
                } else {
                    sb.append("Waiting!").append("\n");
                }
                for(Player player : room) {
                    sb.append(player.level).append(" ").append(player.name).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}