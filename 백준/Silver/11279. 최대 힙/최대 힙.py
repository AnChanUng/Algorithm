import sys
input = sys.stdin.readline
import heapq

n = int(input())
heap = []

for i in range(n):
    x = int(input())

    if x == 0:
        if heap:
            max = heapq.heappop(heap)[1]
            print(max)
        else:
            print(0)
    else:
        heapq.heappush(heap, (-x, x))