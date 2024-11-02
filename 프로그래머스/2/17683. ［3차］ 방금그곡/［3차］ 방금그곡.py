def handle_m(m):
    return m.replace('A#','a').replace('B#','b').replace('C#','c').replace('D#','d').replace('E#','e').replace('F#','f').replace('G#','g')

def solution(m, musicinfos):
    m = handle_m(m)
    info = []
    
    for musicinfo in musicinfos:
        start_time, end_time, title, melody = musicinfo.split(',')
        
        # 재생된 시간(분)
        s_h, s_m = map(int, start_time.split(':'))
        e_h, e_m = map(int, end_time.split(':'))
        time = (60 * (e_h - s_h))  + (e_m - s_m)
        
        # 재생된 멜로디
        melody = handle_m(melody)
        len_melody = len(melody)
        melody = (melody*((time//len_melody)+1))[:time]
        
        # 재생된 멜로디가 포함된 음악
        if m in melody:
            info.append([title, time, melody])
        
    # 조건에 일치하는 음악이 없을 경우 (조건: 재생된 멜로디가 포함된 음악)
    if not info:
        return "(None)"
    
    # 조건에 만족하는 음악이 여러개일 경우
    if len(info) > 0:
        info.sort(key = lambda item: item[1], reverse = True)
    
    return info[0][0]

