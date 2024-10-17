def solution(bridge_length, weight, truck_weights):
    
    bridge = [0] * bridge_length
    time = 0
    current_weight = 0
    
    while True:
        current_weight -= bridge.pop(0)
        
        if truck_weights:
            if current_weight + truck_weights[0] <= weight:
                bridge.append(truck_weights[0])
                current_weight += truck_weights[0]
                truck_weights.pop(0)
            else:
                bridge.append(0)
        
        time += 1
        
        if not bridge:
            break
        
    return time