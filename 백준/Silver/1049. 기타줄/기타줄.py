n, m = map(int, input().split())
package = []
per_price = []
for i in range(m):
    package_price, one_price = map(int, input().split())
    package.append(package_price)
    per_price.append(one_price)

min_package = min(package)

answer = 0
while n > 0:
    if n >= 6:
        min_price = min(per_price) * 6
        n = n - 6
    else:
        min_price = min(per_price) * n
        n = n - n
    if min_price < min_package:
        answer = answer + min_price
    else:
        answer = answer + min_package

print(answer)