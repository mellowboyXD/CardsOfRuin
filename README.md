# Cards Of Ruin

A simple roguelike card game implemented in Java.

### Game Rules

The game is played in phases as described below: 
1. Initialization phase 
   - Sets up the cards, generates hands and decks, and initializes the monster’s health, attack, and shield.
2. Draw phase
   - The player draws a card from the deck to place into their hand.
3. Apply phase
   - The player then chooses a card to apply to their character. If any monster attributes need to be modified, it is done here.
4. Combat phase
   - The player initiates a fight sequence. Player attacks first. If the monster is not dead, the monster attacks.
5. Reward phase
   - Any rewards gained are applied to the player.

### Card Classes

1. Heart Class
2. Diamond Class
3. Club Class
4. Spade Class

Each class applies differently to the player. For example, the **Heart Class** increases the player's health while the **Spade Class**
increases the player's attack. The **Club Class** boosts the player's shield whilst the **Diamond Class** is special. The latter 
applies 3/4 of the card's value to the player's attack and 1/4 to the monster's shield. So it is a tradeoff. 

*Have fun!*
