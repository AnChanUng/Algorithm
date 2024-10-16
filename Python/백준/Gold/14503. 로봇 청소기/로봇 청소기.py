from collections import deque

# N: 세로 크기, M: 가로 크기
n, m = map(int, input().split())
# 로봇 청소기의 시작 좌표 (r, c)와 방향 d
r, c, d = map(int, input().split())
# 방의 상태
graph = [list(map(int, input().split())) for _ in range(n)]

# 방문 여부 확인하는 배열
visited = [[0] * m for _ in range(n)]

# 방향 벡터 (북, 동, 남, 서)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 현재 위치 청소
visited[r][c] = 1
cnt = 1  # 청소한 칸의 개수

def turn_left(d):
    return (d - 1) % 4  # 반시계 방향 회전

# BFS 함수
def bfs(r, c, d):
    global cnt
    queue = deque()
    queue.append((r, c, d))

    while queue:
        x, y, d = queue.popleft()
        turned = 0  # 새로운 방향으로 이동했는지 여부를 0으로 초기화

        # 현재 위치 청소
        if visited[x][y] == 0:
            visited[x][y] = 1
            cnt += 1

        # 4방향을 검사
        for _ in range(4):
            d = turn_left(d)  # 반시계 방향으로 회전
            nx = x + dx[d]
            ny = y + dy[d]

            # 청소되지 않은 빈 칸이 있는 경우
            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == 0 and graph[nx][ny] == 0:
                queue.append((nx, ny, d))  # 이동할 좌표와 방향 저장
                visited[nx][ny] = 1  # 청소 처리
                cnt += 1  # 청소한 칸 수 증가
                turned = 1  # 방향을 찾았다는 표시로 1로 설정
                break  # 그 방향으로 이동했으면 다시 4방향 탐색 중지

        # 4방향 모두 청소되었거나 벽인 경우
        if not turned:
            # 후진할 방향 (현재 방향에서 뒤로)
            back_x = x - dx[d]
            back_y = y - dy[d]

            # 후진할 수 있으면 후진
            if 0 <= back_x < n and 0 <= back_y < m and graph[back_x][back_y] == 0:
                queue.append((back_x, back_y, d))  # 후진한 좌표와 방향 저장
            # 후진할 수 없으면 작동 멈춤
            else:
                break

# BFS 시작
bfs(r, c, d)

# 청소한 칸의 개수 출력
print(cnt)