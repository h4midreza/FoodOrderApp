package com.example.foodapp.activity;

import android.content.Intent;
import android.os.Bundle;
import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
    ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setStatusBarColor(getResources().getColor(R.color.yellow));

        setVariables();
    }

    private void setVariables() {
        binding.loginBtn.setOnClickListener(view -> {
            if (mAuth.getCurrentUser() != null) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            } else {
                startActivity(new Intent(IntroActivity.this, SignupActivity.class));
            }
        });

        binding.signupBtn.setOnClickListener(view ->
                startActivity(new Intent(IntroActivity.this, LoginActivity.class)));
    }
}