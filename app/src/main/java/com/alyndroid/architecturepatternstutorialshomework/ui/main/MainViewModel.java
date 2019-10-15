package com.alyndroid.architecturepatternstutorialshomework.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

     public MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();


    public void setMulNumber(int firstNum , int secondNum){
        mutableLiveData.setValue(getMulNumber(firstNum , secondNum));
    }

    private int getMulNumber(int firstNum , int secondNum){
        return firstNum*secondNum;
    }

}
