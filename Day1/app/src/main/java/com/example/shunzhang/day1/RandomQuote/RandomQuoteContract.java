package com.example.shunzhang.day1.RandomQuote;

/**
 * Created by shunzhang on 31/05/2018.
 */

public interface RandomQuoteContract {
    interface View{

        void showProgress();

        void hideProgress();

        void setQuote(String string);
    }

    interface Model{

        interface OnFinishedListener {
            void onFinished(String string);
        }

        void getNextQuote(OnFinishedListener onFinishedListener);
    }

    interface Presenter{

        void onButtonClick();

        void onDestroy();
    }
}
