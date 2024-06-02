def solution(phone_number):
    
    phone_number = list(phone_number)
    
    for i in range(len(phone_number)):
        if i == len(phone_number)-4:
            break
        else:
            phone_number[i] = '*'
    
    return ''.join(phone_number)