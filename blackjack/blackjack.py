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

deck = Deck()
my_hand = Hand(deck)
print(my_hand.cards)
print(my_hand.sum())
