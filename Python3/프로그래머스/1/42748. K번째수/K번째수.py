def solution(array, commands):
    
    result = []
    for i in range(len(commands)):
        array1 = array[commands[i][0]-1:commands[i][1]]
        array1.sort()
        result.append(array1[commands[i][2]-1])
    
    return result