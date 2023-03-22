package ua.kastset.diamomdapp.cardmechanik;

public class Card {
    public boolean isDead = false;

    public void kill() {}

    private final Integer iconId;
    private final String cards;

    public String getCards() {
        return cards;
    }

    public Integer getIconId() {
        return iconId;
    }

    public Card(Integer iconId, String cards) {
        this.iconId = iconId;
        this.cards = cards;
    }

    public String playCard() {
        return "You play a card";
    }
}
