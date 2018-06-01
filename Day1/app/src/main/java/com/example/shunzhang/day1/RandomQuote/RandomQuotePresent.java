package com.example.shunzhang.day1.RandomQuote;

/**
 * Created by shunzhang on 31/05/2018.
 */

public class RandomQuotePresent implements RandomQuoteContract.Presenter, RandomQuoteContract.Model.OnFinishedListener {

    RandomQuoteContract.View view;
    RandomQuoteContract.Model model;

    public RandomQuotePresent(RandomQuoteContract.View view, RandomQuoteContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onButtonClick() {
        if (view != null){
            view.showProgress();
        }
        model.getNextQuote(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onFinished(String string) {
        if (view != null){
            view.hideProgress();
            view.setQuote(string);
        }
    }
}
