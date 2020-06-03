class Main() {

/*
author : Amr Mekhemar
 */

    fun createDeck(): MutableSet<Card> {
        var cards: MutableSet<Card>? = null
        val suits = setOf('\u2663', '\u2660', '\u2666', '\u2665')
        val pips = setOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
        for (suit in suits) {
            for (pip in pips)
                if (cards == null)
                    cards = mutableSetOf(Card(pip, suit))
                else
                    cards.add(Card(pip, suit))
        }
        return cards!!
    }

    fun dealHand(deck: MutableSet<Card>, numOfCards: Int = 2): MutableSet<Card>? {
        var receivedCards: MutableSet<Card>? = null
        var card: Card?
        for (x in 1..numOfCards) {
            card = deck.random()
            if (receivedCards == null){
                receivedCards = mutableSetOf(card)
            }
            else receivedCards.add(card)
            deck.remove(card)
        }
        return receivedCards
    }

    fun evaluateHand(hand: Set<Card>): Int {
        var sum = 0
        for (card in hand) {
            when (card.pip) {
                "1" -> sum += 11
                "2" -> sum += 2
                "3" -> sum += 3
                "4" -> sum += 4
                "5" -> sum += 5
                "6" -> sum += 6
                "7" -> sum += 7
                "8" -> sum += 8
                "9" -> sum += 9
                "10" -> sum += 10
                "J" -> sum += 10
                "Q" -> sum += 10
                "K" -> sum += 10
            }
        }
        return sum
    }

    fun printResults(total: Int, hand: Set<Card>) {

        print("Your Hand was:")
        for (card in hand) {
            print("\n${card.pip} ${card.suit}")
        }
        print("\nFor a total of: $total")
    }
}

fun main() {
    val mainObject = Main()
    val deck = mainObject.createDeck()
//    for (card in deck)
//        print("${card.pip} ${card.suit}")
    val hand = mainObject.dealHand(deck)
    val total = mainObject.evaluateHand(hand!!)
    mainObject.printResults(total, hand)

}




