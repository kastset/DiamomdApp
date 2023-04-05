package ua.kastset.diamomdapp;

import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class PopupWindow {

    public void onButtonShowPopupWindowClick(View view, PlayerActions playerActions) {
        LayoutInflater inflater = (LayoutInflater) view.getContext()
                .getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popwindow, null);

        EditText relicText = popupView.findViewById(R.id.relicValue_id);
        Button confirmButton = (Button) popupView.findViewById(R.id.confirm_button);


        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        final android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(popupView, width, height);

        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);


        confirmButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = relicText.getText().toString();
                relicText.setText(text);
                if (text.isEmpty()) {
                    relicText.setError("Введите количество реликвий которые забрали игроки");
                    relicText.setText(null);
                } else {
                    int num = Integer.MAX_VALUE;
                    try {
                        int valueRelic = Integer.parseInt(text);
                        if (num != valueRelic) {
                            if(valueRelic > playerActions.getAmountRelic()) {
                                relicText.setError("Введите количество реликвий меньше чем " + playerActions.getAmountRelic());
                                relicText.setText(null);
                            } else {
                                popupWindow.dismiss();
                                playerActions.playNumbersRelic(valueRelic);
                                playerActions.setEntireDeckOfCards(playerActions.getEntireDeckOfCards() - valueRelic);
                                playerActions.setAllCardsWasPlayed(playerActions.getEntireDeckOfCards());
                            }
                        }
                    } catch (NumberFormatException e) {
                        relicText.setError("Введите число реликвий");
                        relicText.setText(null);
                    }
                }
            }

        });

        relicText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode != KeyEvent.KEYCODE_BACK) {
                    relicText.setError(null);
                }
                return false;
            }
        });
    }
}
