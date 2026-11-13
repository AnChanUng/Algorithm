import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int alp, cop, time;

        Node(int alp, int cop, int time) {
            this.alp = alp;
            this.cop = cop;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = alp;
        int maxCop = cop;

        for(int[] p : problems) {
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }

        int[][] dist = new int[maxAlp+1][maxCop+1];

        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[alp][cop] = 0;
        pq.offer(new Node(alp, cop, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.time > dist[cur.alp][cur.cop]) continue;
            
            if(cur.alp == maxAlp && cur.cop == maxCop) {
                return cur.time;
            }

            // 1. 알고력 공부
            if(cur.alp < maxAlp) {
                int na = cur.alp + 1;
                int nc = cur.cop;
                int nt = cur.time + 1;

                if (nt < dist[na][nc]) {
                    dist[na][nc] = nt;
                    pq.offer(new Node(na, nc, nt));
                }
            }

            // 2. 코딩력 공부
            if(cur.cop < maxCop) {
                int na = cur.alp;
                int nc = cur.cop + 1;
                int nt = cur.time + 1;

                if(nt < dist[na][nc]) {
                    dist[na][nc] = nt;
                    pq.offer(new Node(na, nc, nt));
                }
            }

            // 3. 문제 풀기
            for (int[] p : problems) {
                if(cur.alp < p[0] || cur.cop < p[1]) continue;

                int na = Math.min(maxAlp, cur.alp + p[2]);
                int nc = Math.min(maxCop, cur.cop + p[3]);
                int nt = cur.time + p[4];

                if(nt < dist[na][nc]) {
                    dist[na][nc] = nt;
                    pq.offer(new Node(na, nc, nt));
                }
            }
        }

        return -1;
    }
}