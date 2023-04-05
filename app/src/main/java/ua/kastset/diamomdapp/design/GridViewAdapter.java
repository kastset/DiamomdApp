package ua.kastset.diamomdapp.design;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import ua.kastset.diamomdapp.R;
import ua.kastset.diamomdapp.cardlist.Card;

public class GridViewAdapter extends ArrayAdapter<Card> {


    public GridViewAdapter(@NonNull Context context, ArrayList<Card> cardTypes) {
        super(context, 0, cardTypes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HolderView holderView;

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.grid_view_item_list , parent, false);
            holderView = new HolderView(convertView);
            convertView.setTag(holderView);
        }

        else {
            holderView = (HolderView) convertView.getTag();
        }

        Card type = getItem(position);
        holderView.icons.setImageResource(type.getIconId());
        holderView.tv.setText(type.getCards());

        return convertView;
    }

    private static class HolderView {
        private final ImageView icons;
        private final TextView  tv;

        public HolderView(View view) {
            icons = view.findViewById(R.id.card_icon);
            tv = view.findViewById(R.id.textview);
        }
    }
}
