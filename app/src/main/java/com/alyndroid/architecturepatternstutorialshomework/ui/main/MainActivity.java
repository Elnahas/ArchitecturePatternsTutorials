package com.alyndroid.architecturepatternstutorialshomework.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.database.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class MainActivity extends AppCompatActivity implements MainView {

    DataBase dataBase = new DataBase();

    //For MVP
    MainPresenter presenter;
    //For MVVM
    MainViewModel mainViewModel;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main);

        //For MVVM
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        binding.setViewModel(mainViewModel);
        binding.setData(getNumberModel());
        binding.setLifecycleOwner(this);


        //For MVP
        presenter = new MainPresenter(this);

        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.plusResultTextView.setText(new StringBuilder().append(getSum()));
            }
        });

        binding.divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getDivNumber(dataBase.getNumbers().getFirstNum() , dataBase.getNumbers().getSecondNum());
            }
        });


    }


    //-------------- MVC plus --------------
    private NumberModel getNumberModel(){return dataBase.getNumbers();}

    private int getSum(){return getNumberModel().getFirstNum() + getNumberModel().getSecondNum();}

    //-------------- MVP --------------
    @Override
    public void getDivNumber(int result) {
        binding.divResultTextView.setText(new StringBuilder().append(result));
    }

}
