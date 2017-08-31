from random import randrange
class Deck(object):
    def __init__(self):
        self.cards = 13*[4]

    def cards_left(self):
        left = 0
        for number in cards:
            left += number
        return left

    def get_card(self):
        while self.cards_left > 0:
            card = randrange(0,14)
            if self.cards[card] == 0:
                continue
            else: 
                self.cards[card] += -1
                break
        else:
            print("Deck is empty")
            card = -1
        return card

    def print_deck(self):
        print()
    

class Hand(object):
    def __init__(self, deck):
       self.cards = [deck.get_card(), deck.get_card()]


deck = Deck()
print(deck.cards)
my_hand = Hand(deck)
print(my_hand.cards)
