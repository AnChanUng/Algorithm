def solution(array, commands):
    result = []
    total = []
    for i in range(len(commands)):
        result = array[commands[i][0]-1:commands[i][1]]
        result.sort()
        total.append(result[commands[i][2]-1])
    
    return total