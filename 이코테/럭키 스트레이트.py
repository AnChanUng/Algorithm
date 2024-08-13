n = input()

left = 0
for i in range(0, int(len(n)/2)):
    left += int(n[i])

right = 0
for j in range(int(len(n)/2), int(len(n))):
    right += int(n[j])

if left == right:
    print("LUCKY")
else:
    print("READY")