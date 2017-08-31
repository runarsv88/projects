def check_win(pos):
    a = pos[0:3]
    b = pos[3:6]
    c = pos[6:9]
    matrix = [a,b,c]
    for i in matrix:
        if i[0]==i[1]==i[2]:
            return i[0]

    for i in range(0,3):
        if a[i]==b[i]==c[i]:
            return a[i]
    if a[0]==b[1]==c[2] or c[0]==b[1]==a[2]:
       return b[1]
    
    return 'no'

def print_board(pos, player):
    board = "{0}|{1}|{2}\n-----\n{3}|{4}|{5}\n-----\n{6}|{7}|{8}"
    print('\n')
    print(board.format(*pos))

def switch_player(player):
    if player == 'x':
        return 'o'
    else:
        return 'x'

pos = ["0","1","2","3","4","5","6","7","8"]
player = "start"
winner = 'no'
counter = 0
max = 9
print_board(pos, player)
while winner == 'no' and counter < max:
    counter += 1
    selecting = True
    player = switch_player(player)
    print("\nPlayer {0} turn.".format(player))
    while selecting:
        pos_new  = raw_input("Select: ")
        if pos_new not in pos and pos_new !='x' and pos_new != 'o':
             print("Not a valid square. Select again.")
        else:
            pos[int(pos_new)] = player
            print_board(pos,player)
            selecting = False
    winner = check_win(pos)
if winner == 'no':
    print('Draw...')
else: 
    print('Player {0} won! Congrats!'.format(player))
