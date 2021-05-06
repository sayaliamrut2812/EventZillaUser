package com.example.eventzillauser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class SignUp extends AppCompatActivity  implements View.OnClickListener{
    private EditText signUpNameEditTxt,ContactEdit;
    EditText signUpEmailEditTxt;
    EditText signUppasswordEditTxt;
    EditText signUpConfirmPasswordEditTxt;
    TextView returnToLoginTextV;
    Button signUpBtn;
    TextView message;
    DatabaseReference ref;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
            firebaseAuth = FirebaseAuth.getInstance();

            signUpNameEditTxt = (EditText) findViewById(R.id.Signup_Edittext_Name);
            ContactEdit=(EditText)findViewById(R.id.Signup_Edittext_cont) ;
            signUpEmailEditTxt = (EditText) findViewById(R.id.Signup_Edittext_email);
            signUppasswordEditTxt = (EditText) findViewById(R.id.Signup_Edittext_pass);
            signUpConfirmPasswordEditTxt = (EditText) findViewById(R.id.Signup_Edittext_confpass);
            returnToLoginTextV = (TextView) findViewById(R.id.login_textview);
            returnToLoginTextV.setOnClickListener((View.OnClickListener) this);
            signUpBtn = (Button) findViewById(R.id.Signup_button);
            signUpBtn.setOnClickListener(this);

            createAuthStateListener();
        }
        @Override
        public void onClick(View v) {
            // default method for handling onClick Events..
            switch (v.getId()) {

                case R.id.Signup_button:
                    createUserAccount();
                    break;

                case R.id.login_textview:
                    Intent i2 = new Intent(SignUp.this, LoginActivity.class);
                    startActivity(i2);
                    break;

                default:
                    break;
            }
        }


        public void createUserAccount(){
            final String createName = signUpNameEditTxt.getText().toString().trim();
            final String createEmail = signUpEmailEditTxt.getText().toString().trim();
            String createPassword = signUppasswordEditTxt.getText().toString().trim();
            String createConfirmPassword = signUpConfirmPasswordEditTxt.getText().toString().trim();
            String cont=ContactEdit.getText().toString().trim();
            if(TextUtils.isEmpty(createName)){
                Toast.makeText(this,"Please enter Name",Toast.LENGTH_LONG).show();
                return;
            }

            if(TextUtils.isEmpty(cont)){
                Toast.makeText(this,"Please enter Contact Number",Toast.LENGTH_LONG).show();
                return;
            }


            if(TextUtils.isEmpty(createEmail)){
                Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
                return;
            }

            if(TextUtils.isEmpty(createPassword)){
                Toast.makeText(this,"Please enter password", Toast.LENGTH_LONG).show();
                return;
            }

            if(TextUtils.isEmpty(createConfirmPassword)){
                Toast.makeText(this,"Please enter password", Toast.LENGTH_LONG).show();
                return;
            }



            firebaseAuth.createUserWithEmailAndPassword(createEmail, createPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                Toast.makeText(SignUp.this, "Welcome!",
                                        Toast.LENGTH_SHORT).show();

                            }

                            else if(!task.isSuccessful()){
                                FirebaseAuthException e = (FirebaseAuthException )task.getException();
                                Toast.makeText(SignUp.this, "Failed Registration: "+e.getMessage(), Toast.LENGTH_SHORT).show();

                                return;
                            }
                            else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(SignUp.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }


                        }
                    });

        }


        private void createAuthStateListener() {
            firebaseAuthListener = new FirebaseAuth.AuthStateListener() {

                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    final FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user != null) {
                        Intent intent = new Intent(SignUp.this, Events.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                }

            };
        }


        @Override
        public void onStart() {
            super.onStart();
            firebaseAuth.addAuthStateListener(firebaseAuthListener);
        }

        @Override
        public void onStop() {
            super.onStop();
            if (firebaseAuthListener != null) {
                firebaseAuth.removeAuthStateListener(firebaseAuthListener);
            }
        }
    }
