package com.example.drawablesstylesandthemes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

        if (savedInstanceState != null) {
            punto1 = savedInstanceState.getInt("point1");
            punto2 = savedInstanceState.getInt("point2");

            //Set the score text views
            binding.point1.setText(String.valueOf(punto1));
            binding.point2.setText(String.valueOf(punto2));
        }

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        recreate();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("point1",punto1);
        outState.putInt("point2",punto2);
        super.onSaveInstanceState(outState);
    }
}