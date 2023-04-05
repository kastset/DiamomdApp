package ua.kastset.diamomdapp.model;


import java.util.ArrayList;

import ua.kastset.diamomdapp.R;
import ua.kastset.diamomdapp.cardlist.*;

public class ArrayListCardType {

    public ArrayList<Card> setListData() {

        ArrayList<Card> arrayList = new ArrayList<>();
        arrayList.add(new LavaTrap(R.drawable.lava, "Lava"));
        arrayList.add(new SpiderTrap(R.drawable.spider, "Spider"));
        arrayList.add(new WoodTrap(R.drawable.wood, "Wood"));
        arrayList.add(new StoneTrap(R.drawable.stone, "Stone"));
        arrayList.add(new SnakeTrap(R.drawable.snake, "Snake"));
        arrayList.add(new RelicCard(R.drawable.relic, "Relic"));
        arrayList.add(new TreasureCard(R.drawable.treasure, "Treasure"));


        return arrayList;
    }

}
