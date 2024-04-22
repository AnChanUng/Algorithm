import heapq
import sys
input = sys.stdin.readline

n = int(input())
schedule_list = [list(map(int, input().split())) for _ in range(n)]
schedule_list.sort()

pq = list()

heapq.heappush(pq, schedule_list[0][1])

for i in range(1, n):
    if schedule_list[i][0] >= pq[0]:
        heapq.heappop(pq)
    heapq.heappush(pq, schedule_list[i][1])

print(len(pq))