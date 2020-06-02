package com.ppapps.compoundview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class QuantityCounterView extends ConstraintLayout {

    private TextView mQuantityTextView;
    private int mQuantity = 1;

    public QuantityCounterView(Context context) {
        super(context);
        init();
    }

    public QuantityCounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.quantity_counter_layout, this);

        mQuantityTextView = findViewById(R.id.tv_quantity);
        initQuantityText();

        ImageButton btnPlus = findViewById(R.id.btn_plus);
        btnPlus.setOnClickListener(v -> {
            mQuantity = parseQuantity();
            mQuantity++;
            initQuantityText();
        });

        ImageButton btnMinus = findViewById(R.id.btn_minus);
        btnMinus.setOnClickListener(v -> {
            mQuantity = parseQuantity();
            mQuantity--;
            initQuantityText();
        });
    }

    private int parseQuantity() {
        String string = mQuantityTextView.getText().toString();

        int quantity = 0;
        try {
            quantity = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return quantity;
    }

    private void initQuantityText() {
        mQuantityTextView.setText(String.valueOf(mQuantity));
    }
}
