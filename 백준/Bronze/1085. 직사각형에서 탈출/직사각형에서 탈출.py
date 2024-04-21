x, y, w, h = map(int, input().split())

distance_horizontal = min(x, w - x)  # x에서 w 또는 w에서 x 까지의 수평 거리
distance_vertical = min(y, h - y)  # y에서 h 또는 h에서 y 까지의 수직 거리

print(min(distance_horizontal, distance_vertical))