a, b, c, m = map(int, input().split())

t = 0   # 피로도
dw = 0  # 최대작업량

for i in range(24): # 하루는 24시간이므로 24번 반복
    if t > m: 
        print(0)
    else:
        if t + a <= m: # 일을 할 수 있는 경우
            t += a # a만큼 피로도를 더하고
            dw += b # b만큼 작업량 추가
        else: # 일을 할 수 없는 경우
            if t-c >= 0: # 쉬어서 피로도가 c만큼 감소 되었을 때 그 값이 0이상인 경우, 피로도를 c만큼 감소
                t -= c 
            else: # 쉬어서 피로도가 음수인 경우, 피로도는 0
                t = 0
print(dw)