package com.alyndroid.architecturepatternstutorialshomework.ui.main;

public class MainPresenter {

    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void getDivNumber(int firstNum , int secondNum){
        view.getDivNumber(firstNum/secondNum);
    }
}
