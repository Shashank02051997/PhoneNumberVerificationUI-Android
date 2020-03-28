package com.shashank.platform.phonenumberverification;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
	
	private TextView tvOtpInstruction;
	private Button btnGenerateOtp;
	private EditText etMobileNumber;
	
	private String indiaCode = "+91";
	
	public static final String MOBILE_NUMBER = "mobile_number";
	
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
		
		tvOtpInstruction = findViewById(R.id.otp);
		btnGenerateOtp = findViewById(R.id.generate_otp);
		etMobileNumber = findViewById(R.id.mobile_number);
		
		tvOtpInstruction.setText(Html.fromHtml(getResources().getString(R.string.otp)));
		
		btnGenerateOtp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (TextUtils.isEmpty(etMobileNumber.getText().toString()))
					Toast.makeText(getApplicationContext(), "Please enter the mobile no.", Toast.LENGTH_SHORT).show();
				else if (etMobileNumber.getText().length() < 10)
					Toast.makeText(getApplicationContext(), "Please enter correct mobile no.", Toast.LENGTH_SHORT).show();
				else {
					Intent intent = new Intent(MainActivity.this, Main2Activity.class);
					intent.putExtra(MOBILE_NUMBER, indiaCode + etMobileNumber.getText().toString());
					startActivity(intent);
				}
				
			}
		});
		
	}
}
