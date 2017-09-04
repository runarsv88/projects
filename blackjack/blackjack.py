from random import randrange
class Deck(object):
    def __init__(self):
        self.cards = 13*[4]

    def cards_left(self):
        left = 0
        for number in self.cards:
            left += number
        return left

    def get_card(self):
        while self.cards_left() > 0:
            card = randrange(0,13)
            if self.cards[card] == 0:
                continue
            else: 
                self.cards[card] += -1
                break
        else:
            print("Deck is empty")
            card = -1
        return card


class Hand(object):
    def __init__(self, deck):
       self.cards = [deck.get_card(), deck.get_card()]

    def sum(self):
        value = 0
        aces = self.cards.count(1)
        for card in self.cards:
            if card > 10 or card == 0:
                value += 10
            else:
                value += card
        while aces > 0: 
            aces += -1 
            if value < 11:
               value += 10
        return value
    
    def draw_card(self, deck):
        self.cards.append(deck.get_card())

    def printer(self, player):
        print("{}: {} with {} points".format(player, self.cards, self.sum()))

while True:
    cont = input("Continue to play (y/n)")  
    if cont == 'y':
        print("++++++++++++++++++++++++++++")
    else:
        break
    deck = Deck()
    my_hand = Hand(deck)
    dealer_hand = Hand(deck)
    my_hand.printer("My hand")
    dealer_hand.printer("Dealer")
    while my_hand.sum() < 22:
        get_card = input("Get another card (y/n)?")
        if get_card == 'y':
            my_hand.draw_card(deck)
            my_hand.printer("My hand")
        else:
            break
    else: 
        print("Busted! You have {}".format(my_hand.sum()))
        print("House wins")
        continue
    while dealer_hand.sum() < 21 and dealer_hand.sum() <  my_hand.sum() and my_hand.sum() < 22:
        dealer_hand.draw_card(deck)
        dealer_hand.printer("Dealer")
    if dealer_hand.sum() > 21:
        print("House is bust! You Win!")
    elif dealer_hand.sum() > my_hand.sum():
        print("You lose!")
    elif dealer_hand.sum() == my_hand.sum():
        print("Draw, no winner")






