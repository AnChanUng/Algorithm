n, m = map(int, input().split())

site = {}
for i in range(n):
    site_address, password = input().split()
    site[site_address] = password

for i in range(m):
    find_address = input()

    print(site[find_address])