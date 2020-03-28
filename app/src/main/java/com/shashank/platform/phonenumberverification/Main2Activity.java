package com.shashank.platform.phonenumberverification;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Main2Activity extends AppCompatActivity {
	
	
	private String verificationId;
	
	private TextView tvOtpInstruction;
	private TextView tvMobileNumber;
	
	private EditText etOtpBox1;
	private EditText etOtpBox2;
	private EditText etOtpBox3;
	private EditText etOtpBox4;
	private EditText etOtpBox5;
	private EditText etOtpBox6;
	
	private ProgressBar loadingProgressBar;
	
	private Button btnVerify;
	
	private String mobileNumber = "";
	
	private FirebaseAuth mAuth;
	private PhoneAuthProvider.OnVerificationStateChangedCallbacks
		mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
		
		@Override
		public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
			super.onCodeSent(s, forceResendingToken);
			verificationId = s;
		}
		
		@Override
		public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
			String code = phoneAuthCredential.getSmsCode();
			if (code != null) {
				setCodeToEditTexts(code);
				verifyCode(code);
			}
		}
		
		@Override
		public void onVerificationFailed(FirebaseException e) {
			Toast.makeText(Main2Activity.this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main2);
		
		getExtrasFromBundle();
		initialize();
		sendVerificationCode(mobileNumber);
		
	}
	
	
	/**
	 * Retrieves the mobile number to which the verification code is supposed to be received
	 */
	private void getExtrasFromBundle() {
		
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			mobileNumber = bundle.getString(MainActivity.MOBILE_NUMBER);
			if (mobileNumber != null) {
				//Error
			}
		}
		
	}
	
	
	
	
	/*
	 *       Initializes all widgets and variables and sets up required listeners
	 *
	 * */
	private void initialize() {
		
		mAuth = FirebaseAuth.getInstance();
		
		Toolbar toolbar = findViewById(R.id.toolbar);
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
		
		loadingProgressBar = findViewById(R.id.pbLoading);
		
		btnVerify = findViewById(R.id.verify);
		
		String promptMessage = getResources().getString(R.string.otp1);
		tvOtpInstruction.setText(Html.fromHtml(promptMessage));
		
		tvMobileNumber.setText(mobileNumber);
		
		
		btnVerify.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				String code = "";
				
				if (TextUtils.isEmpty(etOtpBox1.getText().toString())) {
					Toast.makeText(Main2Activity.this, "Please enter full code ", Toast.LENGTH_LONG)
						.show();
					return;
				} else {
					code += etOtpBox1.getText().toString();
				}
				
				if (TextUtils.isEmpty(etOtpBox2.getText().toString())) {
					Toast.makeText(Main2Activity.this, "Please enter full code ", Toast.LENGTH_LONG)
						.show();
					return;
				} else {
					code += etOtpBox2.getText().toString();
				}
				
				
				if (TextUtils.isEmpty(etOtpBox3.getText().toString())) {
					Toast.makeText(Main2Activity.this, "Please enter full code ", Toast.LENGTH_LONG)
						.show();
					return;
				} else {
					code += etOtpBox3.getText().toString();
				}
				
				
				if (TextUtils.isEmpty(etOtpBox4.getText().toString())) {
					Toast.makeText(Main2Activity.this, "Please enter full code ", Toast.LENGTH_LONG)
						.show();
					return;
				} else {
					code += etOtpBox4.getText().toString();
				}
				
				
				if (TextUtils.isEmpty(etOtpBox5.getText().toString())) {
					Toast.makeText(Main2Activity.this, "Please enter full code ", Toast.LENGTH_LONG)
						.show();
					return;
				} else {
					code += etOtpBox5.getText().toString();
				}
				
				
				if (TextUtils.isEmpty(etOtpBox6.getText().toString())) {
					Toast.makeText(Main2Activity.this, "Please enter full code ", Toast.LENGTH_LONG)
						.show();
					return;
				} else {
					code += etOtpBox6.getText().toString();
				}
				
				
				verifyCode(code);
				
			}
		});
		
		
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
	
	
	
	/**
	 * Initiates the process of sending the verification code on the mobile number entered by the user in previous activity
	 */
	private void sendVerificationCode(String number) {
		loadingProgressBar.setVisibility(View.VISIBLE);
		
		PhoneAuthProvider.getInstance().verifyPhoneNumber(
			number,
			60,
			TimeUnit.SECONDS,
			TaskExecutors.MAIN_THREAD,
			mCallBack
		);
		
	}
	
	private void verifyCode(String code) {
		PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
		signInWithCredential(credential);
	}
	
	
	private void signInWithCredential(PhoneAuthCredential credential) {
		mAuth.signInWithCredential(credential)
			.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
				@Override
				public void onComplete(@NonNull Task<AuthResult> task) {
					if (task.isSuccessful()) {
						Toast.makeText(Main2Activity.this, "Verification successful", Toast.LENGTH_LONG)
							.show();
					} else {
						Toast.makeText(Main2Activity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
					}
					
					loadingProgressBar.setVisibility(View.INVISIBLE);
				}
			});
	}
	
	
	private void setCodeToEditTexts(String code) {
		
		//Assuming code length is 6
		if (code.length() == 6) {
			
			etOtpBox1.setText(code.substring(0, 1));
			etOtpBox2.setText(code.substring(1, 2));
			etOtpBox3.setText(code.substring(2, 3));
			etOtpBox4.setText(code.substring(3, 4));
			etOtpBox5.setText(code.substring(4, 5));
			etOtpBox6.setText(code.substring(5, 6));
			
		}
		
	}
	
	
}
