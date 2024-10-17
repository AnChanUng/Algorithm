from collections import deque

n, w, l = map(int, input().split())
trucks = list(map(int, input().split()))
bridge = deque([0] * w)
current_weight = 0
time = 0

for truck in trucks:
    while True:
        time += 1
        current_weight -= bridge.popleft()

        if current_weight + truck <= l:
            bridge.append(truck)
            current_weight += truck
            break
        else:
            bridge.append(0)

time += w

print(time)