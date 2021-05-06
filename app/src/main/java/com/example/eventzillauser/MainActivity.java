package com.example.eventzillauser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        int SPLASH_TIME = 3000; //This is 3 seconds


            //requestWindowFeature(Window.FEATURE_NO_TITLE); //remove App Title bar
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.activity_main);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do any action here. Now we are moving to next page
                    Intent mySuperIntent = new Intent(MainActivity.this,SignUp.class);
                    startActivity(mySuperIntent);

                    //This 'finish()' is for exiting the app when back button pressed from Home page which is ActivityHome
                    finish();

                }
            }, SPLASH_TIME);
    }
}
