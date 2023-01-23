package com.example.drawablesstylesandthemes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.drawablesstylesandthemes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int punto1=0;
    private int punto2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.team1minus.setOnClickListener(this::decrementar);
        binding.team2minus.setOnClickListener(this::decrementar);
        binding.team1plus.setOnClickListener(this::aumentar);
        binding.team2plus.setOnClickListener(this::aumentar);

    }

    public void decrementar(View view){
        int id = view.getId();
        switch (id){
            case R.id.team1minus:
                punto1--;
                binding.point1.setText(String.valueOf(punto1));
                break;
            case R.id.team2minus:
                punto2--;
                binding.point2.setText(String.valueOf(punto2));
                break;
        }
    }
    public void aumentar(View view){
        int id = view.getId();
        switch (id){
            case R.id.team1plus:
                punto1++;
                binding.point1.setText(String.valueOf(punto1));
                break;
            case R.id.team2plus:
                punto2++;
                binding.point2.setText(String.valueOf(punto2));
                break;
        }
    }
}