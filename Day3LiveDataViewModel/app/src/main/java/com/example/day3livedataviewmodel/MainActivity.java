package com.example.day3livedataviewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.day3livedataviewmodel.databinding.ActivityMainBinding;
import com.example.day3livedataviewmodel.model.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        LoginViewModel viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setLoginViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getUser().observe(this,(user)->{
            if (user.getEmail().length() > 0 || user.getPassword().length() > 0)
                Toast.makeText(getApplicationContext(), "email : " + user.getEmail() + " password " + user.getPassword(), Toast.LENGTH_SHORT).show();
        });
    }
}
