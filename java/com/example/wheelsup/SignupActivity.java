package com.example.wheelsup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    private FirebaseAuth fAuth;
    Button btnSignUP,login;
    EditText name,email,passwordn, confirmPassword,phonenumber;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_signup);
        super.onCreate(savedInstanceState);


        login=(Button)findViewById(R.id.loginpage);
        name=(EditText)findViewById(R.id.enterName);
        email = (EditText)findViewById(R.id.enterEmail);
        passwordn = (EditText)findViewById(R.id.enterpassword);
        confirmPassword=(EditText)findViewById(R.id.confirmpassword);
        phonenumber= (EditText)findViewById(R.id.phoneno);
        btnSignUP = (Button)findViewById(R.id.Sign_Up);

        fAuth=FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser()!= null){
            Toast.makeText(SignupActivity.this,"You have already registered",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),Loginactivity.class));
            finish();
        }


        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString().trim();
                String Password=passwordn.getText().toString().trim();


                if(TextUtils.isEmpty(Email)){
                    email.setError("Email is required");
                    return;
                }
                 if(TextUtils.isEmpty(Password)){
                    passwordn.setError("Password is required");
                    return;
                }

                if(Password.length()<6){
                    passwordn.setError("Password must be greater than 6 character ");
                    return;
                }



                fAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                        Toast.makeText(SignupActivity.this,"User Created",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Options.class));}

                        else{
                            Toast.makeText(SignupActivity.this,"Error ! "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }

                });

            }


        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOptionsM();
            }
        });
    }

    private void openOptionsM() {
        Intent intent = new Intent(this, Loginactivity.class);
        startActivity(intent);
    }




}





