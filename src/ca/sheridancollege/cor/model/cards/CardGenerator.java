package ca.sheridancollege.cor.model.cards;

import java.util.Random;

public class CardGenerator {
    private static final Random random = new Random();

    /**
     * Generates a random card
     * @return a Card child randomly depending on the suitValue that is randomly generated
     */
    public static Card generateCard() {
        int suitValue = random.nextInt(Suit.MAX_SUITS) + 1;
        return switch (suitValue) {
            case 1 -> new HeartCard(generateRandomValue());
            case 2 -> new DiamondCard(generateRandomValue());
            case 3 -> new ClubCard(generateRandomValue());
            default -> new SpadeCard(generateRandomValue());
        };
    }

    /**
     * Generates a random value between MIN_VALUE and MAX_VALUE
     *
     * @return random integer between 0-13
     */
    private static int generateRandomValue() {
        int min_val = Card.getMinValue();
        int max_val = Card.getMaxValue();
        return random.nextInt(max_val- min_val) + min_val;
    }

}
