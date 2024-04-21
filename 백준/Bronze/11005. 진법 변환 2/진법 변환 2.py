n, b = map(int, input().split())
s = ''
arr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

while n:
		s = s + str(arr[n%b])
		n = n // b
print(s[::-1])