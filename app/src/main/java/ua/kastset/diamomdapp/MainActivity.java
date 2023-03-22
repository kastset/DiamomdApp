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
    private static int allCard = 35;
    private static int allUseCard = allCard;
    private static int badNumber = 2;
    private static int amountRelic = 0;
    public static double probability;
    List<Card> board = new ArrayList<>();
    boolean isEnd;

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
        Card type = (Card) parent.getItemAtPosition(position);
        if (!type.isDead) {
            --allUseCard;
            if (type.getCards().equals("Treasure")) {
                probability = ((double) (badNumber) / allUseCard);
                String mistakeToLose = String.valueOf(probability);
                Toast.makeText(MainActivity.this, type.playCard() + mistakeToLose, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, type.playCard(), Toast.LENGTH_SHORT).show();
                for (Card card : board) {
                    if(card.getCards().equals(type.getCards())) {
                        Toast.makeText(MainActivity.this, "you dead", Toast.LENGTH_SHORT).show();
                        isEnd = true;
                    }
                }
                probability = ((double) (badNumber) / allUseCard);
                String mistakeToLose = String.valueOf(probability);
                Toast.makeText(MainActivity.this, mistakeToLose, Toast.LENGTH_SHORT).show();
                badNumber +=2 ;
                board.add(type);
            }
        }
    }

    public void createNewRound () {
        allUseCard = allCard - amountRelic;
        board.clear();
        isEnd = false;
    }
}