package com.example.bmi;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bmi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt=Integer.parseInt(binding.edtWeight.getText().toString());
                int ft=Integer.parseInt(binding.edtHeightFt.getText().toString());
                int in=Integer.parseInt(binding.edtHeightIn.getText().toString());

                int totalIn=ft*12+in;
                double totalCm=totalIn*2.53;
                double totalM=totalCm/100;

                double bmi=wt/(totalM*totalM);

                if (bmi>25)
                {
                    binding.txtResult.setText("You are Overweight");
                } else if (bmi<18) {
                    binding.txtResult.setText("You are underweight");
                }
                else {
                    binding.txtResult.setText("You are healthy");
                }
            }
        });

    }
}