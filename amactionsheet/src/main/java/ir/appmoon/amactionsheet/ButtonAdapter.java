package ir.appmoon.amactionsheet;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

import ir.appmoon.amactionsheet.dao.OnClickActionSheetListener;

public class ButtonAdapter {

    private final DisplayMetrics displayMetrics;
    private final LinearLayout layoutAdd;
    Context context;
    List<String> buttonNamesList;

    Typeface typeface;
    float textSize;
    String textColor;
    private LinearLayout.LayoutParams params;
    private Snackbar snackbar;
    OnClickActionSheetListener onClickActionSheetListener;
    private int margin = 20;

    public void setOnClickActionSheetListener(OnClickActionSheetListener onClickActionSheetListener) {
        this.onClickActionSheetListener = onClickActionSheetListener;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }

    public ButtonAdapter(Context context, Snackbar snackbar, LinearLayout layoutAdd, List<String> buttonNamesList) {
        this.context = context;
        this.snackbar = snackbar;
        this.buttonNamesList = buttonNamesList;
        this.layoutAdd = layoutAdd;
        displayMetrics = context.getResources().getDisplayMetrics();
        initButtons();
    }


    private void initButtons() {


        params = new LinearLayout.LayoutParams((int) (displayMetrics.widthPixels*0.87), (int) (displayMetrics.widthPixels * 0.12));
        params.rightMargin = margin;
        params.leftMargin = margin;
        params.bottomMargin = margin;
        params.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL;

        for (int i = 0; i < buttonNamesList.size(); i++) {
            String name = buttonNamesList.get(i);

            final Button button = new Button(context);

            if (textColor != null) {
                button.setTextColor(Color.parseColor(textColor));

            }

            if (textSize > 0) {
                button.setTextSize(Typeface.BOLD, textSize);

            } else {

                button.setTextSize(Typeface.BOLD, 18);
            }

            if (typeface != null) {
                button.setTypeface(typeface);

            }

            button.setText(name);
            button.setId(i);

            button.setLayoutParams(params);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (onClickActionSheetListener != null)
                        onClickActionSheetListener.onButtonClick(button.getId());
                    snackbar.dismiss();

                }
            });
            button.setBackgroundResource(R.drawable.border_button);
            layoutAdd.addView(button);
        }


    }


}
