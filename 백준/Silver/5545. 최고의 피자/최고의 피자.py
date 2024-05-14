n = int(input())
dow_price, topping_price = map(int, input().split())
dow_calorie = int(input())
topping_calorie = []
for _ in range(n):
    topping_calorie.append(int(input()))

topping_calorie.sort(reverse=True)

answer = dow_calorie / dow_price

for i in range(1, len(topping_calorie)+1):
    pizza_price = dow_price + topping_price * len(topping_calorie[:i])
    cal = dow_calorie + sum(topping_calorie[:i])
    if cal / pizza_price > answer:
        answer = cal / pizza_price
    else:
        break

print(int(answer))
