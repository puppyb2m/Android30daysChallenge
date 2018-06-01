package com.example.shunzhang.day1.RandomQuote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shunzhang.day1.Base.BaseActivity;
import com.example.shunzhang.day1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by shunzhang on 31/05/2018.
 */

public class RandomQuoteActivity extends BaseActivity implements RandomQuoteContract.View {
    @BindView(R.id.textView)
    TextView textView;

    @BindView(R.id.button)
    Button button;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private RandomQuotePresent present;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_quote);

        present = new RandomQuotePresent(this, new RandomQuoteModel());
        ButterKnife.bind(this);
    }

    public static Intent getCallingIntent(Context context){
        Intent callingIntent = new Intent(context, RandomQuoteActivity.class);
        return callingIntent;
    }

    @OnClick(R.id.button)
    public void submit(View view) {

        present.onButtonClick();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuote(String string) {
        textView.setText(string);
    }
}
