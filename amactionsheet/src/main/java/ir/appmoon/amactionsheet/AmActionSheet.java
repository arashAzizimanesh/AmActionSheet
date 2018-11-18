package ir.appmoon.amactionsheet;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.List;

import ir.appmoon.amactionsheet.dao.OnClickActionSheetListener;

public class AmActionSheet {
    boolean isView = false;
    Context context;
    View layout;
    Snackbar thesnackbar;
    LinearLayout layoutAdd;
    LinearLayout.LayoutParams params;
    Snackbar.SnackbarLayout snackbarLayout;
    View snackView;


    DisplayMetrics displayMetrics;


    String cancelTitle;
    List<String> buttonsNameList;
    private Button cancelButton;
    private Typeface typeface;
    private String cancelColor;
    private String buttonColor;
    private float textSizeButton;
    private float textSizeCancel;

    private View view;
    private RelativeLayout layoutCustomView;
    private int margin = 20;

    public void setView(View view) {
        this.view = view;
    }

    public void setTextSizeButton(float textSizeButton) {
        this.textSizeButton = textSizeButton;
    }

    OnClickActionSheetListener onClickActionSheetListener;

    public void setOnClickActionSheetListener(OnClickActionSheetListener onClickActionSheetListener) {
        this.onClickActionSheetListener = onClickActionSheetListener;
    }

    public void setCancelColor(String cancelColor) {
        this.cancelColor = cancelColor;
    }

    public void setButtonColor(String buttonColor) {
        this.buttonColor = buttonColor;
    }

    public void setButtonsNameList(List<String> buttonsNameList) {
        this.buttonsNameList = buttonsNameList;

    }

    public void setCancelTitle(String cancelTitle) {
        this.cancelTitle = cancelTitle;

    }

    public AmActionSheet(Context context, View layout) {
        this.context = context;
        displayMetrics = context.getResources().getDisplayMetrics();
        this.layout = layout;


    }

    public void setFont(Typeface typeface) {
        this.typeface = typeface;

    }


    public void initAmActionSheet() {

        thesnackbar = Snackbar.make(layout, "", Snackbar.LENGTH_INDEFINITE);

        snackbarLayout = (Snackbar.SnackbarLayout) thesnackbar.getView();


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        snackView = inflater.inflate(R.layout.layout_action_sheet, null);
        layoutAdd = snackView.findViewById(R.id.action_sheet_layout);
//        layoutCustomView = snackView.findViewById(R.id.add_custom_view);
//        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,MainActivity.displayheight* 4/ 10));

        final LinearLayout linearLayoutCancel = (LinearLayout) snackView.findViewById(R.id.action_sheet_layout_cancel);
        params = new LinearLayout.LayoutParams((int) (displayMetrics.widthPixels * 0.87), (int) (displayMetrics.widthPixels * 0.12));

        params.bottomMargin = margin;

        params.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL;


        cancelButton = new Button(context);

        if (cancelColor != null)
            cancelButton.setTextColor(Color.parseColor(cancelColor));
        if (cancelTitle != null)
            this.cancelButton.setText(cancelTitle);

        cancelButton.setBackgroundResource(R.drawable.border_button);

        cancelButton.setLayoutParams(params);

        cancelButton.setTextSize(Typeface.BOLD, 20);
        if (textSizeCancel > 0) {
            cancelButton.setTextSize(Typeface.BOLD, textSizeCancel);


        }

        if (typeface != null)
            cancelButton.setTypeface(typeface);


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thesnackbar.dismiss();

//
            }
        });


        LinearLayout.LayoutParams paramsCancel = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsCancel.topMargin = margin;
        paramsCancel.bottomMargin = margin;


        linearLayoutCancel.setLayoutParams(paramsCancel);
        linearLayoutCancel.addView(cancelButton);
        if (view != null) {

            LinearLayout.LayoutParams layoutParamsCustom = new LinearLayout.LayoutParams((int) (displayMetrics.widthPixels*0.87), ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParamsCustom.bottomMargin = margin;

            layoutParamsCustom.gravity = Gravity.CENTER_HORIZONTAL;
            view.setLayoutParams(layoutParamsCustom);

            layoutAdd.addView(view);
        }

        if (buttonsNameList != null) {
            ButtonAdapter buttonAdapter = new ButtonAdapter(context, thesnackbar, layoutAdd, buttonsNameList);

            if (onClickActionSheetListener != null) {
                buttonAdapter.setOnClickActionSheetListener(onClickActionSheetListener);

            }

            buttonAdapter.setTextColor(buttonColor);
            buttonAdapter.setTextSize(textSizeButton);
            buttonAdapter.setTypeface(typeface);

        }


        snackbarLayout.setBackgroundColor(Color.TRANSPARENT);

        snackbarLayout.addView(snackView, 0);




    }

    public void showAmActionSheet() {


        thesnackbar.show();


    }

    public void dissmissAmActionSheet() {

        thesnackbar.dismiss();
    }


}
