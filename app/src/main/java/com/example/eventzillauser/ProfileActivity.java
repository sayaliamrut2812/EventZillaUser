package com.example.eventzillauser;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    TextView userInfoEmail;
    TextView n1,txtNmae;
    Button signOutBtn;
    private ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        toolbar = getSupportActionBar();
        toolbar.setTitle("Profile Details");

        userInfoEmail = (TextView) findViewById(R.id.userNmaeTextView);
       // txtNmae=(TextView)findViewById(R.id.name) ;

        // n1=(TextView) findViewById(R.id.name1);
        signOutBtn = (Button) findViewById(R.id.signOutButton);
        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
                Toast.makeText(getApplicationContext(), "Signing Out", Toast.LENGTH_SHORT).show();
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                finish();

            }
        });
        accessUserInformation();
    }



    public void accessUserInformation(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            //String name1="Prasad";
            Uri photoUrl = user.getPhotoUrl();


            userInfoEmail.setText(email);
           // txtNmae.setText(name1);
            //n1.setText(name);
            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
        }

    }
}
