alphabet = 'abcdefghijklmnopqrstuvwxyz'
mess_file = open('2_text.txt')
sense = ''
for line in mess_file: 
    for letter in line:
        if letter in alphabet:
            sense += letter
print(sense)
