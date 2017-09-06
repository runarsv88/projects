import string

guards = 3
upper_letters = string.ascii_uppercase
lower_letters = string.ascii_lowercase
print(upper_letters)
text = open('3_text.txt')
for line in text:
    for letter in enumerate(line):
        if letter[0] > guards-1  and letter[0] < len(line)-guards+1 and letter[1] in lower_letters: 
            guard_list = line[letter[0]-guards:letter[0]] + line[letter[0]+1:letter[0]+1+guards]
            #print(guard_list)
            if all(g in upper_letters for g in guard_list):
                if letter[0]>guards and letter[0]<len(line)+guards and line[letter[0]-guards-1] not in upper_letters and line[letter[0]+guards+1] not in upper_letters:
                    print(letter[1])
