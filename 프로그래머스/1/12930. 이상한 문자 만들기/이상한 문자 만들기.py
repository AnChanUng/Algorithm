def solution(s):
    words = s.split(" ")
    
    modified_words = []
    for word in words:
        modified_word = ""
        for i in range(len(word)):
            if i % 2 == 0:
                modified_word += word[i].upper()
            else:
                modified_word += word[i].lower()
        modified_words.append(modified_word)
    
    return " ".join(modified_words)