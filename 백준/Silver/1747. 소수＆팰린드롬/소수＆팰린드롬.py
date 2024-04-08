n = int(input())

def is_prime(num):
    if num < 2:
        return False
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True

def is_palindrome(num):
    return str(num) == str(num)[::-1]

def find_next_palindrome_prime(n):
    while True:
        if is_prime(n) and is_palindrome(n):
            return n
        n += 1

result = find_next_palindrome_prime(n)
print(result)