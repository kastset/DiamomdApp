package ua.kastset.diamomdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import ua.kastset.diamomdapp.cardmechanik.*;
import ua.kastset.diamomdapp.design.GridViewAdapter;
import ua.kastset.diamomdapp.model.ArrayListCardType;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static int entireDeckOfCards = 35;
    private static int allCardsPlayed = entireDeckOfCards;
    private static int badNumber = 2;
    private static int amountRelic = 0;
    public static double losingChance;
    List<Card> gameBoard = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayListCardType listCards = new ArrayListCardType();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.grid_view_item_list);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(MainActivity.this,
                listCards.setListData());
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(this);
        createNewRound();
        badNumber = 2;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Card playerAction = (Card) parent.getItemAtPosition(position);
        if (!playerAction.isDead) {
            --allCardsPlayed;
            if (playerAction.getCards().equals("Treasure")) {
                Toast.makeText(MainActivity.this, playerAction.playCard(), Toast.LENGTH_SHORT).show();
                losingChance = ((double) (badNumber) / allCardsPlayed) * 100;
                String mistakeToLose = String.format("%.1f", losingChance) ;
                Toast.makeText(MainActivity.this, mistakeToLose + "%", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, playerAction.playCard(), Toast.LENGTH_SHORT).show();
                for (Card card : gameBoard) {
                    if(card.getCards().equals(playerAction.getCards())) {
                        Toast.makeText(MainActivity.this, "you dead", Toast.LENGTH_SHORT).show();
                    }
                }
                losingChance = ((double) (badNumber) / allCardsPlayed) * 100;
                String mistakeToLose = String.format("%.1f", losingChance);
                Toast.makeText(MainActivity.this, mistakeToLose + "%", Toast.LENGTH_SHORT).show();
                badNumber +=2 ;
                gameBoard.add(playerAction);
            }
        }
    }

    public void createNewRound () {
        allCardsPlayed = entireDeckOfCards - amountRelic;
        gameBoard.clear();
    }
}