package com.shashank.platform.phonenumberverification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView otp;
    Button generate_otp;
    EditText mobile_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        otp = findViewById(R.id.otp);
        generate_otp = findViewById(R.id.generate_otp);
        mobile_number = findViewById(R.id.mobile_number);
        otp.setText(Html.fromHtml(getResources().getString(R.string.otp)));
        generate_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mobile_number.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Please enter the mobile no.",Toast.LENGTH_SHORT).show();
                else if(mobile_number.getText().length()<10)
                    Toast.makeText(getApplicationContext(),"Please enter correct mobile no.",Toast.LENGTH_SHORT).show();
                else{
                    Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(intent);
                }

            }
        });

    }
}
