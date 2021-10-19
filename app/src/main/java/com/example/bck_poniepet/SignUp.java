package com.example.bck_poniepet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bck_poniepet.Objects.Account;
import com.example.bck_poniepet.databinding.ActivitySignUpBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    ActivitySignUpBinding binding;
    AlertDialog.Builder builder;

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
        builder = new AlertDialog.Builder(this);
        binding.tvLogin.setPaintFlags(binding.tvLogin.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //startActivity(new Intent(SignUp.this, Login.class));
            }
        });
/*
        binding.tvFullname.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (binding.tvFullname.getEditText().getText().toString().trim().isEmpty()){
                    binding.tvFullname.setError("Full name is required");
                    binding.tvFullname.setErrorEnabled(true);
                }
                else if (s.length() < 2) {
                    binding.tvFullname.setError("At least 2 charaters");
                    binding.tvFullname.setErrorEnabled(true);
                } else {
                    binding.tvFullname.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
*/

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!valFullname() | !valUsername() | !valEmail() | !valPassword() | !valConfirmPassword()){
                    return;
                }
                else {
                    database = FirebaseDatabase.getInstance();
                    reference = database.getReference("accounts");

                    String name = binding.tvFullname.getEditText().getText().toString();
                    String user = binding.tvUsername.getEditText().getText().toString();
                    String email = binding.tvEmail.getEditText().getText().toString();
                    String pass = binding.tvPassword.getEditText().getText().toString();
                    String rePass = binding.tvConfirmPassword.getEditText().getText().toString();
                    Account account = new Account(name,user,email,pass,rePass);
                    reference.child(user).setValue(account);

                    builder.setTitle("Success! Login now").setCancelable(false)
                            .setIcon(R.drawable.ic_signup_success)
                            .setPositiveButtonIcon(getBaseContext().getResources().getDrawable(R.drawable.img_next))
                            .setPositiveButton("", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish(); // close Activity
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });
    }

    public boolean valFullname(){
        String name = binding.tvFullname.getEditText().getText().toString().trim();
        if (name.isEmpty()){
            binding.tvFullname.setError("Full name is requried");
            return false;
        }else {
            binding.tvFullname.setError(null);
            binding.tvFullname.setErrorEnabled(false);
            return true;
        }
    }

    public boolean valUsername(){
        String user = binding.tvUsername.getEditText().getText().toString().trim();
        String val = "[a-zA-Z][a-zA-Z0-9].{3,30}";
        if (user.isEmpty()){
            binding.tvUsername.setError("Username is requried");
            return false;
        }else if (!user.matches(val)){
            binding.tvUsername.setError("Username is not validate");
            return false;
        }else {
            binding.tvUsername.setError(null);
            binding.tvUsername.setErrorEnabled(false);
            return true;
        }
    }

    public boolean valEmail(){
        String email = binding.tvEmail.getEditText().getText().toString().trim();
        String val = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.isEmpty()){
            binding.tvEmail.setError("Email is requried");
            return false;
        }else if (!email.matches(val)){
            binding.tvEmail.setError("Username is not validate");
            return false;
        }else {
            binding.tvEmail.setError(null);
            binding.tvEmail.setErrorEnabled(false);
            return true;
        }
    }

    public boolean valPassword(){
        String pass = binding.tvPassword.getEditText().getText().toString().trim();
        String val = "[a-zA-Z0-9._-].{7,30}";
        if (pass.isEmpty()){
            binding.tvPassword.setError("Password is requried");
            return false;
        }else if (!pass.matches(val)){
            binding.tvPassword.setError("Password is not validate");
            return false;
        }else {
            binding.tvPassword.setError(null);
            binding.tvPassword.setErrorEnabled(false);
            return true;
        }
    }

    public boolean valConfirmPassword(){
        String cfpass = binding.tvConfirmPassword.getEditText().getText().toString().trim();
        String pass = binding.tvPassword.getEditText().getText().toString().trim();
        if (cfpass.isEmpty()){
            binding.tvConfirmPassword.setError("Password is requried");
            return false;
        }else if (!cfpass.equals(pass)){
            binding.tvConfirmPassword.setError("Wrong password");
            return false;
        }else {
            binding.tvConfirmPassword.setError(null);
            binding.tvConfirmPassword.setErrorEnabled(false);
            return true;
        }
    }
}