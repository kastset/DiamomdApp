package ua.kastset.diamomdapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ua.kastset.diamomdapp.cardlist.Card;

public class PlayerActions {
    private int entireDeckOfCards = 35;

    private int allCardsWasPlayed = entireDeckOfCards;

    private int badCardThatCanKill = 0;
    private int maxNumberOfRelic = 5;
    private int amountRelic = 0;
    private int howMuсhPlayerUseRelic = 0;
    private double losingChance;
    private int deathCount = 5;
    private boolean playerIsDead = false;
    private int amountTreasure = 0;
    private List<Card> gameBoard = new ArrayList<>();
    private TextView textView;

    public PlayerActions() {}

    public PlayerActions(Activity activity) {
        textView = activity.findViewById(R.id.text_view_id);
    }

    public int getEntireDeckOfCards() {
        return entireDeckOfCards;
    }

    public void setEntireDeckOfCards(int entireDeckOfCards) {
        this.entireDeckOfCards = entireDeckOfCards;
    }

    public void setAllCardsWasPlayed(int allCardsWasPlayed) {
        this.allCardsWasPlayed = allCardsWasPlayed;
    }

    public void playedOneCard() {
        allCardsWasPlayed--;
    }

    public double getLosingChance() {
        return losingChance;
    }

    public void countLosingChance() {
        losingChance = ((double) (badCardThatCanKill) / allCardsWasPlayed) * 100;
    }

    public int getAmountRelic() {
        return amountRelic;
    }

    public void playNumbersRelic(int amountRelic) {
        this.howMuсhPlayerUseRelic += amountRelic;
        maxNumberOfRelic = 5 - howMuсhPlayerUseRelic;
        this.amountRelic = 0;
    }

    public void playedOneRelic() {
        amountRelic++;
    }

    public void putBadCardThatCanKill() {
        badCardThatCanKill += 2;
    }

    public boolean isDead() {
        return playerIsDead;
    }

    @SuppressLint("SetTextI18n")
    public void installMistakeToLose() {
        String mistakeToLose = String.format(Locale.ROOT, "%.1f", getLosingChance());
        textView.setText("Шанс на поражение " + mistakeToLose + "%");
    }

    public void playCard(Card card) {
        if (!playerIsDead || allCardsWasPlayed == 0) {
            if (card.getCards().equals("Treasure")) {
                if(amountTreasure < 15){
                    playedOneCard();
                    countLosingChance();
                    installMistakeToLose();
                    amountTreasure++;
                }
            } else if (card.getCards().equals("Relic")) {
                if (amountRelic < maxNumberOfRelic) {
                    playedOneCard();
                    playedOneRelic();
                    countLosingChance();
                    installMistakeToLose();
                }
            } else {
                for (Card cards : gameBoard) {
                    if (cards.getCards().equals(card.getCards())) {
                        textView.setText("Возвращайтесь в лагерь");
                        playerIsDead = true;
                        deathCount--;
                        return;
                    }
                }
                playedOneCard();
                putBadCardThatCanKill();
                countLosingChance();
                installMistakeToLose();
                gameBoard.add(card);
            }
        }
    }

    public void createNewRound() {
        if (deathCount != 0) {
            losingChance = 0;
            badCardThatCanKill = 0;
            playerIsDead = false;
            gameBoard.clear();
        } else {
            playerIsDead = true;
            textView.setText("Начните игру с начала");
        }
    }

    public void createNewGame() {
        entireDeckOfCards = 35;
        allCardsWasPlayed = entireDeckOfCards;
        playerIsDead = false;
        deathCount = 5;
        losingChance = 0;
        howMuсhPlayerUseRelic = 0;
        badCardThatCanKill = 0;
        maxNumberOfRelic = 5;
        gameBoard.clear();
    }
}
