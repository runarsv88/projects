# Challenge 2
numberOfLetters = 26
alphabet = 'abcdefghijklmnopqrstuvwxyz'
encrypted = "g fmnc wms bgblr rpylqjyrc gr zw fylb. rfyrq ufyr amknsrcpq ypc dmp. bmgle gr gl zw fylb gq glcddgagclr ylb rfyr'q ufw rfgq rcvr gq qm jmle. sqgle qrpgle.kyicrpylq() gq pcamkkclbcb. lmu ynnjw ml rfc spj." 
encrypted = 'map'
decrypted = ''
for letter in encrypted:
    addLetter = letter
    number = alphabet.find(letter)
    if number != -1:
        number = ( number + 2 ) % numberOfLetters
        addLetter = alphabet[number]
    decrypted += (addLetter)

print(decrypted)

