package com.shashank.platform.phonenumberverification;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Main2Activity extends AppCompatActivity {
	
	//Instance variables prefixed which tells what the component actually is, which other would be confusing
	
	private TextView tvOtpInstruction;
	private TextView tvMobileNumber;
	
	private EditText etOtpBox1;
	private EditText etOtpBox2;
	private EditText etOtpBox3;
	private EditText etOtpBox4;
	private EditText etOtpBox5;
	private EditText etOtpBox6;
	
	private String mobileNumber = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main2);
		
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			mobileNumber = bundle.getString(MainActivity.MOBILE_NUMBER);
			if (mobileNumber != null) {
				//Error
			}
		}
		
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
		tvMobileNumber = findViewById(R.id.tvMobileNumber);
		
		etOtpBox1 = findViewById(R.id.otp_box_1);
		etOtpBox2 = findViewById(R.id.otp_box_2);
		etOtpBox3 = findViewById(R.id.otp_box_3);
		etOtpBox4 = findViewById(R.id.otp_box_4);
		etOtpBox5 = findViewById(R.id.otp_box_5);
		etOtpBox6 = findViewById(R.id.otp_box_6);
		
		String promptMessage = getResources().getString(R.string.otp1);
		tvOtpInstruction.setText(Html.fromHtml(promptMessage));
		
		tvMobileNumber.setText(mobileNumber);
		
		etOtpBox1.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			
			}
			
			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			
			}
			
			@Override
			public void afterTextChanged(Editable editable) {
				
				if (editable != null) {
					if (editable.length() == 1)
						etOtpBox2.requestFocus();
				}
			}
		});
		etOtpBox2.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			
			}
			
			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			
			}
			
			@Override
			public void afterTextChanged(Editable editable) {
				if (editable != null) {
					if (editable.length() == 1)
						etOtpBox3.requestFocus();
				}
			}
		});
		etOtpBox3.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			
			}
			
			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			
			}
			
			@Override
			public void afterTextChanged(Editable editable) {
				if (editable != null) {
					if (editable.length() == 1)
						etOtpBox4.requestFocus();
				}
			}
		});
		etOtpBox4.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			
			}
			
			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			
			}
			
			@Override
			public void afterTextChanged(Editable editable) {
				if (editable != null) {
					if (editable.length() == 1)
						etOtpBox5.requestFocus();
				}
			}
		});
		etOtpBox5.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			
			}
			
			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			
			}
			
			@Override
			public void afterTextChanged(Editable editable) {
				if (editable != null) {
					if (editable.length() == 1)
						etOtpBox6.requestFocus();
				}
			}
		});
		
	}
}
