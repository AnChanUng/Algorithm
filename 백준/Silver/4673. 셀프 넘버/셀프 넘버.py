array = set(range(1, 10001))
numbers = set()

for i in range(1, 10001):
	for j in str(i):
		i += int(j)
	numbers.add(i)

generated_number = sorted(array - numbers)
for i in generated_number:
    print(i)