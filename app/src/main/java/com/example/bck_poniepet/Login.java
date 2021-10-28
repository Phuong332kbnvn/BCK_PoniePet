package com.example.bck_poniepet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bck_poniepet.databinding.ActivityLoginBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    AlertDialog.Builder builder;
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        builder = new AlertDialog.Builder(this);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!valUser() | !valPass())
                    return;
                else{
                    isUser();
                }
            }

            private void isUser() {
                String user = binding.username.getEditText().getText().toString();
                String pass = binding.password.getEditText().getText().toString();

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("accounts");

                Query checkUser = reference.orderByChild("username").equalTo(user);
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            binding.username.setError(null);
                            binding.username.setErrorEnabled(false);

                            String passwordFromFB = snapshot.child(user).child("password").getValue(String.class);

                            if (passwordFromFB.equals(pass)){
                                Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),AppActivity.class));
                                /*
                                String fullNameFromFB = snapshot.child(user).child("fullName").getValue(String.class);
                                String usernameFromFB = snapshot.child(user).child("username").getValue(String.class);
                                String emailFromFB = snapshot.child(user).child("email").getValue(String.class);
                                Intent intent = new Intent();
                                intent.putExtra("fullName",fullNameFromFB);
                                intent.putExtra("username",usernameFromFB);
                                intent.putExtra("email",emailFromFB);
                                intent.putExtra("password",passwordFromFB);
                                startActivity(intent);
                                */
                            }else{
                                binding.password.setError("Wrong password");
                                binding.password.requestFocus();
                            }

                        }else{
                            binding.username.setError("Username is not exist");
                            binding.username.requestFocus();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        binding.btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setView(R.layout.forget_password_dialog);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        binding.tvSignUp.setPaintFlags(binding.tvSignUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,SignUp.class);
                startActivity(intent);
            }
        });
    }

    public Boolean valUser(){
        String user = binding.username.getEditText().getText().toString().trim();
        if (user.isEmpty()){
            binding.username.setError("Username is requried");
            return false;
        }else {
            binding.username.setError(null);
            binding.username.setErrorEnabled(false);
            return true;
        }
    }

    public Boolean valPass(){
        String pass = binding.password.getEditText().getText().toString().trim();
        if (pass.isEmpty()){
            binding.password.setError("Password is requried");
            return false;
        }else {
            binding.password.setError(null);
            binding.password.setErrorEnabled(false);
            return true;
        }
    }


}