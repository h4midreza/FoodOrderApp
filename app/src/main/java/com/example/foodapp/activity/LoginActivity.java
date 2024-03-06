package com.example.foodapp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.example.foodapp.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariables();
    }

    private void setVariables() {
        binding.loginBtn.setOnClickListener(view -> {
            String email = binding.userEdt.getText().toString();
            String pass = binding.passEdt.getText().toString();
            if (!email.isEmpty() && !pass.isEmpty()){
                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(LoginActivity.this, task -> {
                    if (task.isSuccessful()){
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                Toast.makeText(LoginActivity.this, "Please fill username and password", Toast.LENGTH_SHORT).show();
            }
        });
    }

}