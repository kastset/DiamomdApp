package ua.kastset.diamomdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


import ua.kastset.diamomdapp.cardlist.*;
import ua.kastset.diamomdapp.design.GridViewAdapter;
import ua.kastset.diamomdapp.model.ArrayListCardType;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    PlayerActions player = new PlayerActions();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = findViewById(R.id.grid_view_item_list);
        TextView textView = findViewById(R.id.text_view_id);
        Button buttonCamp = findViewById(R.id.button_camp);
        Button buttonNewGame = findViewById(R.id.button_new_game);
        PopupWindow popupWindow = new PopupWindow();
        player = new PlayerActions(this);

        ArrayListCardType listCards = new ArrayListCardType();

        GridViewAdapter gridViewAdapter = new GridViewAdapter(MainActivity.this,
                listCards.setListData());

        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(this);
        buttonCamp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(R.string.chouseCard);
                if (player.getAmountRelic() != 0) {
                    popupWindow.onButtonShowPopupWindowClick(v,player);
                } else {
                    player.setAllCardsWasPlayed(player.getEntireDeckOfCards());
                }
                player.createNewRound();
            }
        });
        buttonNewGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(R.string.youStartedNewGameMessage);
                player.createNewGame();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Card card = (Card) parent.getItemAtPosition(position);
        if(!player.isDead()) {
                Toast.makeText(MainActivity.this, card.playCard(), Toast.LENGTH_SHORT).show();
                player.playCard(card);
        }
    }
}
