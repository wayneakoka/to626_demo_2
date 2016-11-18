package com.example.panda.to626_demo_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {


    //create objects
    private Button buttonLogin;
    private EditText editTextLogin;
    private EditText editTextPassword;
    private RadioButton radioSettings;
    private RadioButton radioProfile;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link Java Objects to Widgets in the UI

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        radioSettings = (RadioButton) findViewById(R.id.radioSettings);
        radioProfile = (RadioButton) findViewById(R.id.radioProfile);
        radioSexGroup = (RadioGroup) findViewById(R.id.radioGroup);

        buttonLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Event Handdler
        //    Toast.makeText(this, "You just clicked the button - Booo!", Toast.LENGTH_SHORT);

        if (editTextLogin.getText().toString().equals("User") & editTextPassword.getText().toString().equals("1234")) {
            //Do if true
            int selectedId = radioSexGroup.getCheckedRadioButtonId();
            radioSexButton = (RadioButton) findViewById(selectedId);

            if (radioSexButton == radioSettings){
                Intent intent = new Intent(this, SettingScreen.class);
                startActivity(intent);
            } else if (radioSexButton == radioProfile){
                Intent intent = new Intent(this, ProfileScreen.class);
                startActivity(intent);
            }
        } else {
            //Do if False
            Toast.makeText(this, "Login Denied", Toast.LENGTH_SHORT).show();
            editTextLogin.setText("");
            editTextPassword.setText("");
        }
    }
}


