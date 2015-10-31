package com.openvpn.Durai;
import android.app.AlertDialog;
import android.content.Intent;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.openvpn.Durai.Constants;
import com.openvpn.Durai.R;
import com.openvpn.Durai.core.ProfileManager;
import com.openvpn.Durai.LaunchVPN;
import com.openvpn.Durai.VpnProfile;
import com.openvpn.Durai.core.OpenVPNService;
import com.openvpn.Durai.core.OpenVPNService.LocalBinder;
import com.openvpn.Durai.core.ProfileManager;
import com.openvpn.Durai.core.ConfigParser;
import com.openvpn.Durai.core.VpnStatus;

import android.os.IBinder;
import android.content.ServiceConnection;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import android.widget.EditText;
import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import org.spongycastle.util.encoders.*;
import android.security.KeyChain;
import java.security.KeyStore;
import java.util.Enumeration;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.net.Uri;


//More functionalities can be found here https://goo.gl/7EwDJC But to access that send me a mail.


public class MainActivity_vpn extends Activity {

	//public SharedPreferences pref;

	// Editor reference for Shared preferences
	Editor editor;


	// Context
	Context _context;
	private LaunchVPN ctdata;
	// Shared preferences mode
	int PRIVATE_MODE = 0;
	// Shared preferences file name

	public static final String PREFER_NAME = "Android";

	EditText username,password;
	final TextView txtu=null,txtp=null;
	private VpnProfile mSelectedProfile;

	protected OpenVPNService mService;
	// variable to track whether the service is bound
	boolean mBound = false;
	Switch mySwitch = null;
	Switch mySwitch2 = null;
	Switch mySwitch3 = null;
	Switch mySwitch4 = null;
	Switch mySwitch5 = null;
	Switch mySwitch6 = null;
	Switch mySwitch7 = null;
	Switch mySwitch8 = null;
	String status=null;
	ImageButton mybutton ;
	Button cekaktif;
	private ServiceConnection mConnection = new ServiceConnection() {


		@Override
		public void onServiceConnected(ComponentName className,
									   IBinder service) {
			// We've bound to LocalService, cast the IBinder and get LocalService instance
			LocalBinder binder = (LocalBinder) service;
			mService = binder.getService();
			mBound = false;
			SharedPreferences pref = getSharedPreferences(PREFER_NAME, 0);
			final String sw1 =pref.getString("sw1", "");
			final String sw2 =pref.getString("sw2", "");
			final String sw3 =pref.getString("sw3", "");
			final String sw4 =pref.getString("sw4", "");
			final String sw5 =pref.getString("sw5", "");
			final String sw6 =pref.getString("sw6", "");
			final String sw7 =pref.getString("sw7", "");
			final String sw8 =pref.getString("sw8", "");
			if (Constants.isVPNConnected) {
				if (sw1=="true")
				{
					mySwitch.setChecked(true);
					mySwitch.setClickable(true);
					mySwitch7.setChecked(false);
					mySwitch7.setClickable(false);
					mySwitch2.setChecked(false);
					mySwitch2.setClickable(false);
					mySwitch3.setChecked(false);
					mySwitch3.setClickable(false);
					mySwitch4.setChecked(false);
					mySwitch4.setClickable(false);
					mySwitch5.setChecked(false);
					mySwitch5.setClickable(false);
					mySwitch6.setChecked(false);
					mySwitch6.setClickable(false);
					mySwitch8.setChecked(false);
					mySwitch8.setClickable(false);


				}
				if (sw2=="true"){
					mySwitch.setChecked(false);
					mySwitch.setClickable(false);
					mySwitch2.setChecked(true);
					mySwitch2.setClickable(true);
					mySwitch3.setChecked(false);
					mySwitch3.setClickable(false);
					mySwitch4.setChecked(false);
					mySwitch4.setClickable(false);
					mySwitch5.setChecked(false);
					mySwitch5.setClickable(false);
					mySwitch6.setChecked(false);
					mySwitch6.setClickable(false);
					mySwitch7.setChecked(false);
					mySwitch7.setClickable(false);
					mySwitch8.setChecked(false);
					mySwitch8.setClickable(false);


				}
				if (sw3=="true"){
					mySwitch.setChecked(false);
					mySwitch.setClickable(false);
					mySwitch2.setChecked(false);
					mySwitch2.setClickable(false);
					mySwitch3.setChecked(true);
					mySwitch3.setClickable(true);
					mySwitch4.setChecked(false);
					mySwitch4.setClickable(false);
					mySwitch5.setChecked(false);
					mySwitch5.setClickable(false);
					mySwitch6.setChecked(false);
					mySwitch6.setClickable(false);
					mySwitch7.setChecked(false);
					mySwitch7.setClickable(false);
					mySwitch8.setChecked(false);
					mySwitch8.setClickable(false);


				}
				if (sw4=="true"){
					mySwitch.setChecked(false);
					mySwitch.setClickable(false);
					mySwitch2.setChecked(false);
					mySwitch2.setClickable(false);
					mySwitch3.setChecked(false);
					mySwitch3.setClickable(false);
					mySwitch4.setChecked(true);
					mySwitch4.setClickable(true);
					mySwitch5.setChecked(false);
					mySwitch5.setClickable(false);
					mySwitch6.setChecked(false);
					mySwitch6.setClickable(false);
					mySwitch7.setChecked(false);
					mySwitch7.setClickable(false);
					mySwitch8.setChecked(false);
					mySwitch8.setClickable(false);


				}
				if (sw5=="true"){
					mySwitch.setChecked(false);
					mySwitch.setClickable(false);
					mySwitch2.setChecked(false);
					mySwitch2.setClickable(false);
					mySwitch3.setChecked(false);
					mySwitch3.setClickable(false);
					mySwitch4.setChecked(false);
					mySwitch4.setClickable(false);
					mySwitch5.setChecked(true);
					mySwitch5.setClickable(true);
					mySwitch6.setChecked(false);
					mySwitch6.setClickable(false);
					mySwitch7.setChecked(false);
					mySwitch7.setClickable(false);
					mySwitch8.setChecked(false);
					mySwitch8.setClickable(false);


				}
				if (sw6=="true"){
					mySwitch.setChecked(false);
					mySwitch.setClickable(false);
					mySwitch2.setChecked(false);
					mySwitch2.setClickable(false);
					mySwitch3.setChecked(false);
					mySwitch3.setClickable(false);
					mySwitch4.setChecked(false);
					mySwitch4.setClickable(false);
					mySwitch5.setChecked(false);
					mySwitch5.setClickable(false);
					mySwitch6.setChecked(true);
					mySwitch6.setClickable(true);
					mySwitch7.setChecked(false);
					mySwitch7.setClickable(false);
					mySwitch8.setChecked(false);
					mySwitch8.setClickable(false);


				}
				if (sw7=="true"){
					mySwitch.setChecked(false);
					mySwitch.setClickable(false);
					mySwitch2.setChecked(false);
					mySwitch2.setClickable(false);
					mySwitch3.setChecked(false);
					mySwitch3.setClickable(false);
					mySwitch4.setChecked(false);
					mySwitch4.setClickable(false);
					mySwitch5.setChecked(false);
					mySwitch5.setClickable(false);
					mySwitch6.setChecked(false);
					mySwitch6.setClickable(false);
					mySwitch7.setChecked(true);
					mySwitch7.setClickable(true);
					mySwitch8.setChecked(false);
					mySwitch8.setClickable(false);

				}
				if (sw8=="true"){
					mySwitch.setChecked(false);
					mySwitch.setClickable(false);
					mySwitch2.setChecked(false);
					mySwitch2.setClickable(false);
					mySwitch3.setChecked(false);
					mySwitch3.setClickable(false);
					mySwitch4.setChecked(false);
					mySwitch4.setClickable(false);
					mySwitch5.setChecked(false);
					mySwitch5.setClickable(false);
					mySwitch6.setChecked(false);
					mySwitch6.setClickable(false);
					mySwitch7.setChecked(false);
					mySwitch7.setClickable(false);
					mySwitch8.setChecked(true);
					mySwitch8.setClickable(true);

				}

			}

			if (!Constants.isVPNConnected) {
				show();


			}




		}



		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			SharedPreferences pref = getSharedPreferences(PREFER_NAME, 0);
			editor = pref.edit();


			String mmySwitch=null;
			String mmySwitch2=null;
			String mmySwitch3=null;
			String mmySwitch4=null;
			String mmySwitch5=null;
			String mmySwitch6 =null;
			String mmySwitch7=null;
			String mmySwitch8=null;

			editor.putString("sw1", mmySwitch);
			editor.putString("sw2", mmySwitch2);
			editor.putString("sw3", mmySwitch3);
			editor.putString("sw4", mmySwitch4);
			editor.putString("sw5", mmySwitch5);
			editor.putString("sw6", mmySwitch6);
			editor.putString("sw7", mmySwitch7);
			editor.putString("sw8", mmySwitch8);
			editor.commit();
			mService =null;
			mBound = false;

				mySwitch8.setChecked(false);
				mySwitch8.setClickable(true);
				mySwitch.setChecked(false);
				mySwitch.setClickable(true);
				mySwitch2.setChecked(false);
				mySwitch2.setClickable(true);
				mySwitch3.setChecked(false);
				mySwitch3.setClickable(true);
				mySwitch4.setChecked(false);
				mySwitch4.setClickable(true);
				mySwitch5.setChecked(false);
				mySwitch5.setClickable(true);
				mySwitch6.setChecked(false);
				mySwitch6.setClickable(true);
				mySwitch7.setChecked(false);
				mySwitch7.setClickable(true);


		}

	};


	protected void cekmasaaktif() {
	String url = "http://flamingo2.smartconnect.co.id/"; // You could have this at the top of the class as a constant, or pass it in as a method variable, if you wish to send to multiple websites
		Intent i = new Intent(Intent.ACTION_VIEW); // Create a new intent - stating you want to 'view something'
		i.setData(Uri.parse(url)); // Add the url data (allowing android to realise you want to open the browser)
		startActivity(i); // Go go go!
		}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_vpn);
		SharedPreferences pref = getSharedPreferences(PREFER_NAME, 0);
		cekaktif= (Button) findViewById(R.id.button1);
		cekaktif.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cekmasaaktif();
			}
		});
		mybutton = (ImageButton) findViewById(R.id.imageButton);

		mybutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				removeProfile();
			}
		});
		final String aa =pref.getString("status", "");
		final String sw1 =pref.getString("sw1", "");
		final String sw2 =pref.getString("sw2", "");
		final String sw3 =pref.getString("sw3", "");
		final String sw4 =pref.getString("sw4", "");
		final String sw5 =pref.getString("sw5", "");
		final String sw6 =pref.getString("sw6", "");
		final String sw7 =pref.getString("sw7", "");
		final String sw8 =pref.getString("sw8", "");
		Intent intent = new Intent(getBaseContext(), OpenVPNService.class);
		intent.setAction(OpenVPNService.START_SERVICE);
		bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
		registerReceiver(broadcastReceiver, new IntentFilter("com_openvpn_Durai_CONNECTION_CHANGE"));

			mySwitch = (Switch) findViewById(R.id.switch1);
			mySwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

					if (isChecked && !Constants.isVPNConnected) {
						if (aa != null) {
							Toast.makeText(getApplicationContext(), "ON",
									Toast.LENGTH_SHORT).show();
							mySwitch.setChecked(true);
							mySwitch.setClickable(true);
							mySwitch7.setChecked(false);
							mySwitch7.setClickable(false);
							mySwitch2.setChecked(false);
							mySwitch2.setClickable(false);
							mySwitch3.setChecked(false);
							mySwitch3.setClickable(false);
							mySwitch4.setChecked(false);
							mySwitch4.setClickable(false);
							mySwitch5.setChecked(false);
							mySwitch5.setClickable(false);
							mySwitch6.setChecked(false);
							mySwitch6.setClickable(false);
							mySwitch8.setChecked(false);
							mySwitch8.setClickable(false);
							configureAndStartVpn();
						} else {
							Toast.makeText(getApplicationContext(), "Need Password",
									Toast.LENGTH_SHORT).show();
							removeProfile();
						}


					}



				}
			});
			mySwitch2 = (Switch) findViewById(R.id.switch2);

			mySwitch2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked && !Constants.isVPNConnected) {
						if (aa != null) {

							Toast.makeText(getApplicationContext(), "ON",
									Toast.LENGTH_SHORT).show();
							mySwitch2.setChecked(true);
							mySwitch.setChecked(false);
							mySwitch.setClickable(false);
							mySwitch7.setChecked(false);
							mySwitch7.setClickable(false);
							mySwitch3.setChecked(false);
							mySwitch3.setClickable(false);
							mySwitch4.setChecked(false);
							mySwitch4.setClickable(false);
							mySwitch5.setChecked(false);
							mySwitch5.setClickable(false);
							mySwitch6.setChecked(false);
							mySwitch6.setClickable(false);
							mySwitch8.setChecked(false);
							mySwitch8.setClickable(false);
							configureAndStartVpn2();
						} else {
							Toast.makeText(getApplicationContext(), "Need Password",
									Toast.LENGTH_SHORT).show();
							removeProfile();
						}

					}



				}
			});
			mySwitch3 = (Switch) findViewById(R.id.switch3);

			mySwitch3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked && !Constants.isVPNConnected) {
						if (aa != null) {
							Toast.makeText(getApplicationContext(), "ON",
									Toast.LENGTH_SHORT).show();
							mySwitch3.setChecked(true);
							mySwitch.setChecked(false);
							mySwitch.setClickable(false);
							mySwitch2.setChecked(false);
							mySwitch2.setClickable(false);
							mySwitch7.setChecked(false);
							mySwitch7.setClickable(false);
							mySwitch4.setChecked(false);
							mySwitch4.setClickable(false);
							mySwitch5.setChecked(false);
							mySwitch5.setClickable(false);
							mySwitch6.setChecked(false);
							mySwitch6.setClickable(false);
							mySwitch8.setChecked(false);
							mySwitch8.setClickable(false);
							configureAndStartVpn3();
						} else {
							Toast.makeText(getApplicationContext(), "Need Password",
									Toast.LENGTH_SHORT).show();
							removeProfile();
						}

					}



				}
			});

			mySwitch4 = (Switch) findViewById(R.id.switch4);

			mySwitch4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked && !Constants.isVPNConnected) {
						if (aa != null) {
							Toast.makeText(getApplicationContext(), "ON",
									Toast.LENGTH_SHORT).show();
							mySwitch4.setChecked(true);
							mySwitch.setChecked(false);
							mySwitch.setClickable(false);
							mySwitch2.setChecked(false);
							mySwitch2.setClickable(false);
							mySwitch3.setChecked(false);
							mySwitch3.setClickable(false);
							mySwitch7.setChecked(false);
							mySwitch7.setClickable(false);
							mySwitch5.setChecked(false);
							mySwitch5.setClickable(false);
							mySwitch6.setChecked(false);
							mySwitch6.setClickable(false);
							mySwitch8.setChecked(false);
							mySwitch8.setClickable(false);
							configureAndStartVpn4();
						} else {
							Toast.makeText(getApplicationContext(), "Need Password",
									Toast.LENGTH_SHORT).show();
							removeProfile();
						}

					}


				}
			});
			mySwitch5 = (Switch) findViewById(R.id.switch5);

			mySwitch5.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked && !Constants.isVPNConnected) {
						if (aa != null) {
							Toast.makeText(getApplicationContext(), "ON",
									Toast.LENGTH_SHORT).show();
							mySwitch5.setChecked(true);
							mySwitch.setChecked(false);
							mySwitch.setClickable(false);
							mySwitch2.setChecked(false);
							mySwitch2.setClickable(false);
							mySwitch3.setChecked(false);
							mySwitch3.setClickable(false);
							mySwitch4.setChecked(false);
							mySwitch4.setClickable(false);
							mySwitch7.setChecked(false);
							mySwitch7.setClickable(false);
							mySwitch6.setChecked(false);
							mySwitch6.setClickable(false);
							mySwitch8.setChecked(false);
							mySwitch8.setClickable(false);
							configureAndStartVpn5();
						} else {
							Toast.makeText(getApplicationContext(), "Need Password",
									Toast.LENGTH_SHORT).show();
							removeProfile();
						}

					}



				}
			});

			mySwitch6 = (Switch) findViewById(R.id.switch6);

			mySwitch6.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked && !Constants.isVPNConnected) {
						if (aa != null) {
							Toast.makeText(getApplicationContext(), "ON",
									Toast.LENGTH_SHORT).show();
							mySwitch6.setChecked(true);
							mySwitch.setChecked(false);
							mySwitch.setClickable(false);
							mySwitch2.setChecked(false);
							mySwitch2.setClickable(false);
							mySwitch3.setChecked(false);
							mySwitch3.setClickable(false);
							mySwitch4.setChecked(false);
							mySwitch4.setClickable(false);
							mySwitch5.setChecked(false);
							mySwitch5.setClickable(false);
							mySwitch7.setChecked(false);
							mySwitch7.setClickable(false);
							mySwitch8.setChecked(false);
							mySwitch8.setClickable(false);
							configureAndStartVpn6();
						} else {
							Toast.makeText(getApplicationContext(), "Need Password",
									Toast.LENGTH_SHORT).show();
							removeProfile();
						}

					}


				}
			});

			mySwitch7 = (Switch) findViewById(R.id.switch7);

			mySwitch7.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked && !Constants.isVPNConnected) {
						if (aa != null) {
							Toast.makeText(getApplicationContext(), "ON",
									Toast.LENGTH_SHORT).show();
							mySwitch7.setChecked(true);
							mySwitch.setChecked(false);
							mySwitch.setClickable(false);
							mySwitch2.setChecked(false);
							mySwitch2.setClickable(false);
							mySwitch3.setChecked(false);
							mySwitch3.setClickable(false);
							mySwitch4.setChecked(false);
							mySwitch4.setClickable(false);
							mySwitch5.setChecked(false);
							mySwitch5.setClickable(false);
							mySwitch6.setChecked(false);
							mySwitch6.setClickable(false);
							mySwitch8.setChecked(false);
							mySwitch8.setClickable(false);
							configureAndStartVpn7();
						} else {
							Toast.makeText(getApplicationContext(), "Need Password",
									Toast.LENGTH_SHORT).show();
							removeProfile();
						}

					}



				}
			});

			mySwitch8 = (Switch) findViewById(R.id.switch8);

			mySwitch8.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked && !Constants.isVPNConnected) {
						if (aa != null) {
							Toast.makeText(getApplicationContext(), "ON",
									Toast.LENGTH_SHORT).show();
							mySwitch8.setChecked(true);
							mySwitch8.setClickable(true);
							mySwitch.setChecked(false);
							mySwitch.setClickable(false);
							mySwitch2.setChecked(false);
							mySwitch2.setClickable(false);
							mySwitch3.setChecked(false);
							mySwitch3.setClickable(false);
							mySwitch4.setChecked(false);
							mySwitch4.setClickable(false);
							mySwitch5.setChecked(false);
							mySwitch5.setClickable(false);
							mySwitch6.setChecked(false);
							mySwitch6.setClickable(false);
							mySwitch7.setChecked(false);
							mySwitch7.setClickable(false);
							configureAndStartVpn8();
						} else {
							Toast.makeText(getApplicationContext(), "Need Password",
									Toast.LENGTH_SHORT).show();
							removeProfile();
						}

					}



				}
			});
		if (Constants.isVPNConnected) {
			if (sw1=="true")
			{

				mySwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						if (!isChecked && Constants.isVPNConnected) {

							Toast.makeText(getApplicationContext(), "OFF",
									Toast.LENGTH_SHORT).show();
							mySwitch.setChecked(false);
							mySwitch.setClickable(true);
							show();
							stopVPN();

						}

					}
				});

			}
			if (sw2=="true"){

				mySwitch2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						if (!isChecked && Constants.isVPNConnected) {

							Toast.makeText(getApplicationContext(), "OFF",
									Toast.LENGTH_SHORT).show();
							mySwitch2.setChecked(false);
							mySwitch2.setClickable(true);
							show();
							stopVPN();

						}

					}
				});

			}
			if (sw3=="true"){

				mySwitch3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						if (!isChecked && Constants.isVPNConnected) {

							Toast.makeText(getApplicationContext(), "OFF",
									Toast.LENGTH_SHORT).show();
							mySwitch3.setChecked(false);
							mySwitch3.setClickable(true);
							show();
							stopVPN();

						}

					}
				});

			}
			if (sw4=="true"){

				mySwitch4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						if (!isChecked && Constants.isVPNConnected) {

							Toast.makeText(getApplicationContext(), "OFF",
									Toast.LENGTH_SHORT).show();
							mySwitch4.setChecked(false);
							mySwitch4.setClickable(true);
							show();
							stopVPN();

						}

					}
				});

			}
			if (sw5=="true"){

				mySwitch5.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						if (!isChecked && Constants.isVPNConnected) {

							Toast.makeText(getApplicationContext(), "OFF",
									Toast.LENGTH_SHORT).show();
							mySwitch5.setChecked(false);
							mySwitch5.setClickable(true);
							show();
							stopVPN();

						}

					}
				});

			}
			if (sw6=="true"){

				mySwitch6.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						if (!isChecked && Constants.isVPNConnected) {

							Toast.makeText(getApplicationContext(), "OFF",
									Toast.LENGTH_SHORT).show();
							mySwitch6.setChecked(false);
							mySwitch6.setClickable(true);
							show();
							stopVPN();

						}

					}
				});

			}
			if (sw7=="true"){

				mySwitch7.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						if (!isChecked && Constants.isVPNConnected) {

							Toast.makeText(getApplicationContext(), "OFF",
									Toast.LENGTH_SHORT).show();
							mySwitch7.setChecked(false);
							mySwitch7.setClickable(true);
							show();
							stopVPN();
						}

					}
				});

			}
			if (sw8=="true"){

				mySwitch8.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						if (!isChecked && Constants.isVPNConnected) {

							Toast.makeText(getApplicationContext(), "OFF",
									Toast.LENGTH_SHORT).show();
							mySwitch8.setChecked(false);
							mySwitch8.setClickable(true);
							show();
							stopVPN();

						}

					}
				});
			}

		}


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		getMenuInflater().inflate(R.menu.settingsmenu, menu);
		return true;


	}


	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		if (Constants.isVPNConnected){
			// disable connect button if VPN is connected
			menu.getItem(0).setEnabled(false);
			// enable disconnect button if VPN is connected
			menu.getItem(1).setEnabled(true);
		} else{
			// enable connect button if VPN is disconnected
			menu.getItem(0).setEnabled(true);
			// disable disconnect button if VPN is disconnected
			menu.getItem(1).setEnabled(false);
		}

		return super.onPrepareOptionsMenu(menu);
	}







    @Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
			case R.id.action_startvpn:
				configureAndStartVpn();
				mySwitch.setChecked(true);
				return true ;
			case R.id.action_stopvpn:
				stopVPN();
				mySwitch.setChecked(false);
				return true ;
			case R.id.action_removeProfile:
				removeProfile();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}



	private void show() {
	SharedPreferences pref = getSharedPreferences(PREFER_NAME, 0);
	editor = pref.edit();

		stopVPN();
		String mmySwitch="false";
		String mmySwitch2="false";
		String mmySwitch3="false";
		String mmySwitch4="false";
		String mmySwitch5="false";
		String mmySwitch6 ="false";
		String mmySwitch7="false";
		String mmySwitch8="false";

		editor.putString("sw1", mmySwitch);
		editor.putString("sw2", mmySwitch2);
		editor.putString("sw3", mmySwitch3);
		editor.putString("sw4", mmySwitch4);
		editor.putString("sw5", mmySwitch5);
		editor.putString("sw6", mmySwitch6);
		editor.putString("sw7", mmySwitch7);
		editor.putString("sw8", mmySwitch8);
		editor.commit();
		mySwitch8.setChecked(false);
		mySwitch8.setClickable(true);
		mySwitch.setChecked(false);
		mySwitch.setClickable(true);
		mySwitch2.setChecked(false);
		mySwitch2.setClickable(true);
		mySwitch3.setChecked(false);
		mySwitch3.setClickable(true);
		mySwitch4.setChecked(false);
		mySwitch4.setClickable(true);
		mySwitch5.setChecked(false);
		mySwitch5.setClickable(true);
		mySwitch6.setChecked(false);
		mySwitch6.setClickable(true);
		mySwitch7.setChecked(false);
		mySwitch7.setClickable(true);
	}




	private void removeProfile() {
		SharedPreferences pref = getSharedPreferences(PREFER_NAME, 0);


		final EditText entry = new EditText(this);
		final View userpwlayout = getLayoutInflater().inflate(R.layout.userpass, null, false);

		entry.setSingleLine();
		entry.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		entry.setTransformationMethod(new PasswordTransformationMethod());

		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		if (status!=null)
		{
			((EditText)userpwlayout.findViewById(R.id.username)).setText(pref.getString("username", ""));
			((EditText)userpwlayout.findViewById(R.id.password)).setText(pref.getString("password", ""));
		}

		((CheckBox)userpwlayout.findViewById(R.id.show_password)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked)
					((EditText) userpwlayout.findViewById(R.id.password)).setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

				else
					((EditText) userpwlayout.findViewById(R.id.password)).setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			}
		});

			dialog.setView(userpwlayout);
		editor = pref.edit();
		dialog.setPositiveButton(android.R.string.ok,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

						status = "true";
						String name = ((EditText) userpwlayout.findViewById(R.id.username)).getText().toString();
						String pas = ((EditText) userpwlayout.findViewById(R.id.password)).getText().toString();
						editor.putString("status", status);
						editor.putString("username", name);  // Saving string
						editor.putString("password", pas);  // Saving string
						editor.commit();
						Toast.makeText(getApplicationContext(), "Password Saved",
								Toast.LENGTH_SHORT).show();


					}


				});

		dialog.setNegativeButton(android.R.string.cancel,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						mySwitch.setChecked(false);
						VpnStatus.updateStateString("USER_VPN_PASSWORD_CANCELLED", "", R.string.state_user_vpn_password_cancelled,
								VpnStatus.ConnectionStatus.LEVEL_NOTCONNECTED);
						finish();
					}
				});

		dialog.create().show();

		((EditText)userpwlayout.findViewById(R.id.username)).setText(pref.getString("username", ""));
		((EditText)userpwlayout.findViewById(R.id.password)).setText(pref.getString("password", ""));

	}

	private void stopVPN() {


		try{
			ProfileManager.setConntectedVpnProfileDisconnected(MainActivity_vpn.this);
			if(mService.getManagement()!=null)
				mService.getManagement().stopVPN();

		}
		catch (Exception ex){

		}
	}

	private void configureAndStartVpn() {
		SharedPreferences pref = getSharedPreferences(PREFER_NAME, 0);
		editor = pref.edit();


		String mySwitch="true";
		String mySwitch2="false";
		String mySwitch3="false";
		String mySwitch4="false";
		String mySwitch5="false";
		String mySwitch6 ="false";
		String mySwitch7="false";
		String mySwitch8="false";

		editor.putString("sw1", mySwitch);
		editor.putString("sw2", mySwitch2);
		editor.putString("sw3", mySwitch3);
		editor.putString("sw4", mySwitch4);
		editor.putString("sw5", mySwitch5);
		editor.putString("sw6", mySwitch6);
		editor.putString("sw7", mySwitch7);
		editor.putString("sw8", mySwitch8);
		editor.commit();
		try {




					String retVal = "dev tun\n" +
							"\n" +
							"\n" +
							"#proto tcp\n" +
							"proto tcp-client\n" +
							"\n" +
							"\n" +
							"remote opx.opera.com.anjengkomsel.chickenkiller.com 442\n" +
							"\n" +
							"\n" +
							"http-proxy-retry\n" +
							"http-proxy 10.1.89.130 8000\n" +
							"route 0.0.0.0 255.255.255.255.255 vpn_gateway\n" +
							"route 10.1.89.130 255.255.255.255.255 net_gateway\n" +
							"route-method exe\n" +
							"\n" +
							"reneg-sec 0\n" +
							"cipher AES-128-CBC\n" +
							"auth SHA1\n" +
							"\n" +
							"tls-client\n" +
							"\n" +
							"pull\n" +
							"resolv-retry infinite\n" +
							"nobind\n" +
							"persist-key\n" +
							"persist-tun\n" +
							"client\n" +
							"verb 3\n" +
							"auth-user-pass\n" +
							"redirect-gateway def1\n" +
							"\n" +
							"\n" +
							"\n" +
							"<ca>\n" +
							"-----BEGIN CERTIFICATE-----\n" +
							"MIIE9zCCA9+gAwIBAgIJAL9gHjZpeK+aMA0GCSqGSIb3DQEBCwUAMIGtMQswCQYD\n" +
							"VQQGEwJJRDENMAsGA1UECBMEQUNFSDERMA8GA1UEBxMIbWV1bGFib2gxETAPBgNV\n" +
							"BAoTCEZsYW1pbmdvMRcwFQYDVQQLEw5GbGFtaW5nb09mZmljZTEUMBIGA1UEAxML\n" +
							"RmxhbWluZ28gQ0ExETAPBgNVBCkTCEZsYW1pbmdvMScwJQYJKoZIhvcNAQkBFhhn\n" +
							"YW1jaGFubWF4cm9ib0BnbWFpbC5jb20wHhcNMTUwODI5MTMxNDQyWhcNMjUwODI2\n" +
							"MTMxNDQyWjCBrTELMAkGA1UEBhMCSUQxDTALBgNVBAgTBEFDRUgxETAPBgNVBAcT\n" +
							"CG1ldWxhYm9oMREwDwYDVQQKEwhGbGFtaW5nbzEXMBUGA1UECxMORmxhbWluZ29P\n" +
							"ZmZpY2UxFDASBgNVBAMTC0ZsYW1pbmdvIENBMREwDwYDVQQpEwhGbGFtaW5nbzEn\n" +
							"MCUGCSqGSIb3DQEJARYYZ2FtY2hhbm1heHJvYm9AZ21haWwuY29tMIIBIjANBgkq\n" +
							"hkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmrtF0mhlbjhLDbC9f23GgVbLRpm95fKg\n" +
							"kfA3ojA54Foipclrukay2xt/Y6aHC5HOf0FMeFrD+iJXcbl0zYCtMGGQ7uIbAyJY\n" +
							"vSvTf8YThlk3DswIsNAO2n2ga0nwVhZT6SvfrzbRD8tT1B9QjVqQmh6eO0HLed5r\n" +
							"z0KZpRaPRBzCfhIXh704RVW/Nzmjy72l3k1kEyUc34+c8Zw57ofuAU3NVod0MYxN\n" +
							"3/RCRxXz4Dx5JbQWyEECrCyKywE1Pu3fmYElTUnK+6qZfOHMJJBBqDeKTYKVBk65\n" +
							"cDD4rxBIJ4COTaoeWMkr1qK3+3x7WnidyLmr8MrJynOCRFMU40KlVQIDAQABo4IB\n" +
							"FjCCARIwHQYDVR0OBBYEFCDMLQbKoXsdJPDJylV45v0jKtHnMIHiBgNVHSMEgdow\n" +
							"gdeAFCDMLQbKoXsdJPDJylV45v0jKtHnoYGzpIGwMIGtMQswCQYDVQQGEwJJRDEN\n" +
							"MAsGA1UECBMEQUNFSDERMA8GA1UEBxMIbWV1bGFib2gxETAPBgNVBAoTCEZsYW1p\n" +
							"bmdvMRcwFQYDVQQLEw5GbGFtaW5nb09mZmljZTEUMBIGA1UEAxMLRmxhbWluZ28g\n" +
							"Q0ExETAPBgNVBCkTCEZsYW1pbmdvMScwJQYJKoZIhvcNAQkBFhhnYW1jaGFubWF4\n" +
							"cm9ib0BnbWFpbC5jb22CCQC/YB42aXivmjAMBgNVHRMEBTADAQH/MA0GCSqGSIb3\n" +
							"DQEBCwUAA4IBAQBg8RyJvJTHxLVO+idr6qTq82iMU/AGkElmsIGVT41j1E/HEkj1\n" +
							"NODsnKMty6OjYo3lSI4QXIEtfvDpcjDpaphbG/Gi21yvwmcZKWdYrmXnQ89USqz2\n" +
							"F9GPAOWHOXtNELuwI8Avm6247BeqTaCo2R0qy/fDme9E29JP+ayNukiV8Mm/46Ew\n" +
							"S6taJVn2ZGrawQRLHd4E4r0QGXMy8BymU77O1jgt4/hjLwHmjiz6RKMusZNjOBPu\n" +
							"T3ekGJSbnvFluLp1SrBFpxPqylBolxX7uS46h+xvJJIQuPsabUOmbGIwdPxRoBbX\n" +
							"FdpC1yhE0fkNv+AdfnO2XJm/+QledWV0rw+v\n" +
							"-----END CERTIFICATE-----\n" +
							"</ca>\n" +
							"\n" +
							"\n" +
							"<cert>\n" +
							"-----BEGIN CERTIFICATE-----\n" +
							"MIIFSzCCBDOgAwIBAgIBAjANBgkqhkiG9w0BAQsFADCBrTELMAkGA1UEBhMCSUQx\n" +
							"DTALBgNVBAgTBEFDRUgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQKEwhGbGFt\n" +
							"aW5nbzEXMBUGA1UECxMORmxhbWluZ29PZmZpY2UxFDASBgNVBAMTC0ZsYW1pbmdv\n" +
							"IENBMREwDwYDVQQpEwhGbGFtaW5nbzEnMCUGCSqGSIb3DQEJARYYZ2FtY2hhbm1h\n" +
							"eHJvYm9AZ21haWwuY29tMB4XDTE1MDgyOTEzMTcwOVoXDTI1MDgyNjEzMTcwOVow\n" +
							"gagxCzAJBgNVBAYTAklEMQ0wCwYDVQQIEwRBQ0VIMREwDwYDVQQHEwhtZXVsYWJv\n" +
							"aDERMA8GA1UEChMIRmxhbWluZ28xFzAVBgNVBAsTDkZsYW1pbmdvT2ZmaWNlMQ8w\n" +
							"DQYDVQQDEwZhbnRvcGMxETAPBgNVBCkTCEZsYW1pbmdvMScwJQYJKoZIhvcNAQkB\n" +
							"FhhnYW1jaGFubWF4cm9ib0BnbWFpbC5jb20wggEiMA0GCSqGSIb3DQEBAQUAA4IB\n" +
							"DwAwggEKAoIBAQDCHSLW7zBGr3se7wehdAOUxjGI0BjatNFUY7qoILMcd6qhfsWn\n" +
							"aWj0POqgGnHhKQSew06WcA9bCIT2kPGCB/CULZ8MoQTZXy/NINztfvKUNzzIwbvW\n" +
							"UqcU3Z3Y/g2qAC+vKt2L2VC2q6YSkF8jf3uGHllwkf224nt7GSTcfJ6S5CiE8+yE\n" +
							"v9O9jMlaSSm82EZcHhrk8vPIPnvyicwdjjlEy1kj3DwOpbpFJPOdO1kK8JZvoskI\n" +
							"W9ddIVWOJ0oip+1HwLbofxMlbOrficRiE/E+XIyUnbxNg0B0h8hsUY0E6tVH/7zY\n" +
							"IbvTOs8tIwmHZBR+HO5gKwfjwHDgLZFUUwJlAgMBAAGjggF3MIIBczAJBgNVHRME\n" +
							"AjAAMC0GCWCGSAGG+EIBDQQgFh5FYXN5LVJTQSBHZW5lcmF0ZWQgQ2VydGlmaWNh\n" +
							"dGUwHQYDVR0OBBYEFGU83yNKGXLxwGGN7Chq6f5HMOemMIHiBgNVHSMEgdowgdeA\n" +
							"FCDMLQbKoXsdJPDJylV45v0jKtHnoYGzpIGwMIGtMQswCQYDVQQGEwJJRDENMAsG\n" +
							"A1UECBMEQUNFSDERMA8GA1UEBxMIbWV1bGFib2gxETAPBgNVBAoTCEZsYW1pbmdv\n" +
							"MRcwFQYDVQQLEw5GbGFtaW5nb09mZmljZTEUMBIGA1UEAxMLRmxhbWluZ28gQ0Ex\n" +
							"ETAPBgNVBCkTCEZsYW1pbmdvMScwJQYJKoZIhvcNAQkBFhhnYW1jaGFubWF4cm9i\n" +
							"b0BnbWFpbC5jb22CCQC/YB42aXivmjATBgNVHSUEDDAKBggrBgEFBQcDAjALBgNV\n" +
							"HQ8EBAMCB4AwEQYDVR0RBAowCIIGYW50b3BjMA0GCSqGSIb3DQEBCwUAA4IBAQCF\n" +
							"VkXBKjg6U3hfzh+5QzUzTNrlqpZZF7/opiduMsBI7c6zdnxxezjCJadnTu4vpgi8\n" +
							"zQFgPbAX4l+f0T4m0NlboRozIIt+RNSKJ5baObgPu7DqN7wP7HuxrZ0FvAOue08A\n" +
							"nkxucmiGxvnTMNkkkznKppgsUdy6021ZWHk3e4Jl1xHdw3eCXOdUR24NPO29eXul\n" +
							"USSW6sjpKJJtPYrMD+NmtntDJPk0xHPMoX5TW64cbe4OFyAXAzFLLhsaHBX+i/gs\n" +
							"uL78zYjIkvRCX5Ttm/+jYMOJPsr2Q3islJFjubVZVjkw9fhgEkHZFYA+sjrjvid0\n" +
							"OyGGf8E60SylVymRnFpx\n" +
							"-----END CERTIFICATE-----\n" +
							"</cert>\n" +
							"\n" +
							"<key>\n" +
							"-----BEGIN PRIVATE KEY-----\n" +
							"MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDCHSLW7zBGr3se\n" +
							"7wehdAOUxjGI0BjatNFUY7qoILMcd6qhfsWnaWj0POqgGnHhKQSew06WcA9bCIT2\n" +
							"kPGCB/CULZ8MoQTZXy/NINztfvKUNzzIwbvWUqcU3Z3Y/g2qAC+vKt2L2VC2q6YS\n" +
							"kF8jf3uGHllwkf224nt7GSTcfJ6S5CiE8+yEv9O9jMlaSSm82EZcHhrk8vPIPnvy\n" +
							"icwdjjlEy1kj3DwOpbpFJPOdO1kK8JZvoskIW9ddIVWOJ0oip+1HwLbofxMlbOrf\n" +
							"icRiE/E+XIyUnbxNg0B0h8hsUY0E6tVH/7zYIbvTOs8tIwmHZBR+HO5gKwfjwHDg\n" +
							"LZFUUwJlAgMBAAECggEBAItHvKfcGBef8gfQGvmN9MPbMc+pASxscYbLyDK6w8m5\n" +
							"U4VtIQVubRBSZUdbsjqM4/PGz6zB20LGaiFA/wj+CXFJCsZVAtW1pubYna0LWaNf\n" +
							"vw2NdOnjhF9EZO493DAO0igt6ale1Ls9jnvje2BNKKSjQimzlwiSmWdKM1jBUkay\n" +
							"jyOG4UhnVcDymkrJIfDG4QZwabAvaP9H5TQBIH90/+oejC4ynTV8G08ncAB7ms3w\n" +
							"v0gvEekqnHoaUquqCBJ14Dd/5CTL2Q52HxeZZgxIX6+IDAJqameZZ2joAbhNvRZR\n" +
							"uijEulCjwsPN10SM3EhKBh/RQ7cGsUtOIloF/f9/SEECgYEA5B1gMC0kZ9P5sA9/\n" +
							"sPlnllCLbIrTKJftbxiUbymrwJxznK21m/tXZDQeMFCGtq6q6RFmV4N58lLtvHQI\n" +
							"CsYsSNHPAoqIrTSNpfb48pwpomE3YlsyDsPwSCf7cLqe8C/aGT6v3a9Qthkic5rY\n" +
							"VAutY2CFHueSzW/Hbm9NMQHDgd8CgYEA2de8IEFC7vWi+kwTLg+by2kdhl4rJ4bO\n" +
							"dMoSK4+vQd+plH+Qkb8GeH+iVgcLw6tjIjazHKJuA9li04Q7tdeo7BMqyB0+cf4H\n" +
							"hlYYzWMPb78NUpV0fiRAOeBH0hL/D50mmFp/2Xfq9gHHYJxJT4sCeztBYjJrPLT0\n" +
							"qsT5VOHGbDsCgYEAzFdwOdfGW+fsLIXFue/AlksyihnVy/BEthdLqESo4VKE0h5d\n" +
							"qAu/njh9roQEGRNgcIWwqsZQ7/zPj9hU9+nL87NWgA0/IAEKvlf9a77uINJ7PXU5\n" +
							"4zYsQUbnm3ThOYF0GtcnzSrl3ymmze4wySDowjPNLAD/ZV4zRT8Y48STsPsCgYEA\n" +
							"n28aW80HzNZwcpoNC5AW6RfEqRvwn5w1LBrck480qJSmi22VhGX3uWdIi4fan1mn\n" +
							"U1oPWuyychS/FKlZ/iuZkTYyAIYOtuVB4prOyjsvCA0fFgsWWF/1taYlSmXm0Smm\n" +
							"HqlVmvb+OxBwOJAJw7KsnT5wCwt1mtehnf5NsUcQrxMCgYBLEFkk0Kjc5UDfS/qw\n" +
							"0hQKTf0Yo64wTSAi4LOGN0FRx/nkiv1CZEpLNf/lS6EG7oIQVM1a4/x9QEcVi09b\n" +
							"Gf9PJPq6EC+E63vrjbBzXz47/IfYh/9foh2hKi4YwyoRiidyLLIyvu5yQgfcNUbY\n" +
							"vtf6kKlS5NOTCjl1uwdq6LgG0Q==\n" +
							"-----END PRIVATE KEY-----\n" +
							"</key>\n";

					if (retVal != null && retVal.trim().length()>0) {

						byte[] buffer = retVal.getBytes() ;

						VpnProfile vp = saveProfile(buffer) ;

						if (vp != null) {
							startVPN(vp) ;
						}
					}
					else {
						int duration = Toast.LENGTH_LONG;
						Toast toast = Toast.makeText(MainActivity_vpn.this,"Connecting using the last vpn configuration", duration);
						toast.show();
						startVPN();
					}


		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}

	private void configureAndStartVpn2() {
		SharedPreferences pref = getSharedPreferences(PREFER_NAME, 0);
		editor = pref.edit();


		String mySwitch="false";
		String mySwitch2="true";
		String mySwitch3="false";
		String mySwitch4="false";
		String mySwitch5="false";
		String mySwitch6 ="false";
		String mySwitch7="false";
		String mySwitch8="false";

		editor.putString("sw1", mySwitch);
		editor.putString("sw2", mySwitch2);
		editor.putString("sw3", mySwitch3);
		editor.putString("sw4", mySwitch4);
		editor.putString("sw5", mySwitch5);
		editor.putString("sw6", mySwitch6);
		editor.putString("sw7", mySwitch7);
		editor.putString("sw8", mySwitch8);
		editor.commit();
		try {




			String retVal = "dev tun\n" +
					"proto tcp\n" +
					"remote global-4-lvs-odra-5.opera-mini.net.bembeng.chickenkiller.com 1194\n" +
					"\n" +

					"route-method exe\n" +
					"reneg-sec 0\n" +
					"tun-mtu 1500 \n" +
					"tun-mtu-extra 32\n" +
					"mssfix 1400 \n" +
					"resolv-retry infinite\n" +
					"http-proxy-retry\n" +
					"http-proxy 10.1.89.130 8000\n" +
					"route 0.0.0.0 255.255.255.255.255 vpn_gateway\n" +
					"route 10.1.89.130 255.255.255.255.255 net_gateway\n" +
					"route-method exe\n" +
					"\n" +
					"resolv-retry infinite\n" +
					"nobind\n" +
					"persist-key\n" +
					"persist-tun\n" +
					"client\n" +
					"comp-lzo\n" +
					"\n" +
					"verb 3\n" +
					"auth-user-pass\n" +
					"\n" +
					"\n" +
					"<ca>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIIDvDCCAyWgAwIBAgIJAOEiTLcBn8YGMA0GCSqGSIb3DQEBBQUAMIGbMQswCQYD\n" +
					"VQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFib2gxETAPBgNV\n" +
					"BAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2ZsYW1pbmdvIENB\n" +
					"MQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFp\n" +
					"bC5jb20wHhcNMTUwOTEyMDgwNTM1WhcNMjUwOTA5MDgwNTM1WjCBmzELMAkGA1UE\n" +
					"BhMCaWQxDTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQK\n" +
					"EwhmbGFtaW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEM\n" +
					"MAoGA1UEKRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwu\n" +
					"Y29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDC68b1/uNFGvMlJbXLSF+y\n" +
					"kuqiOa9hfRhv9zRe0/QeqIv7zNED4HbPvO5+koFHg0zu07Dvj2xx6E+9fOv7XlIx\n" +
					"cPzlTqlsBr8B+MS0KEknfrX/RTrpCGVGpiu4eMV7wlyNmAYcsd4jNJn4SO1zUrp9\n" +
					"OPEqoBwJnIEY8lQGKDuVTwIDAQABo4IBBDCCAQAwHQYDVR0OBBYEFBpo+epbnauS\n" +
					"K0Rk3W5GpBqOEgkIMIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkI\n" +
					"oYGhpIGeMIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMI\n" +
					"bWV1bGFib2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNV\n" +
					"BAMTC2ZsYW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJl\n" +
					"d2lkaWF0bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjAMBgNVHRMEBTADAQH/MA0G\n" +
					"CSqGSIb3DQEBBQUAA4GBAIKNcR0mlhGCzVX++PMu5mcvrFGZHOWuKruTcDrGsIHO\n" +
					"XFZD9D1ZTuRWiejMpUrbWM//W2rHQRECLlRoN0JzVm4PBaNiE/W+DMwtLamW/Cl2\n" +
					"dHBTKH6mD75PHz/JrhSIpf81nuhOwl9UXVTPGvzpoR8VWwpfIcIX3QByN/ghv2b5\n" +
					"-----END CERTIFICATE-----\n" +
					"</ca>\n" +
					"\n" +
					"<cert>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIID+jCCA2OgAwIBAgIBAjANBgkqhkiG9w0BAQUFADCBmzELMAkGA1UEBhMCaWQx\n" +
					"DTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQKEwhmbGFt\n" +
					"aW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEMMAoGA1UE\n" +
					"KRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwuY29tMB4X\n" +
					"DTE1MDkxMjA4MzgyNloXDTI1MDkwOTA4MzgyNlowgZMxCzAJBgNVBAYTAmlkMQ0w\n" +
					"CwYDVQQIEwRhY2VoMREwDwYDVQQHEwhtZXVsYWJvaDERMA8GA1UEChMIZmxhbWlu\n" +
					"Z28xDDAKBgNVBAsTA2ZsYTEMMAoGA1UEAxMDYWt1MQwwCgYDVQQpEwNmbGExJTAj\n" +
					"BgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFpbC5jb20wgZ8wDQYJKoZIhvcN\n" +
					"AQEBBQADgY0AMIGJAoGBAN9ptJg0uzmX2iUoSNAnYcJwPge/1pouRxzymer8pe6m\n" +
					"EoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwUUlrau3A4Ls+rDP7/C3mKVWxKbJSW\n" +
					"7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6DyJUAboYkptYugQLJBQIZdK7Va9P\n" +
					"AgMBAAGjggFSMIIBTjAJBgNVHRMEAjAAMC0GCWCGSAGG+EIBDQQgFh5FYXN5LVJT\n" +
					"QSBHZW5lcmF0ZWQgQ2VydGlmaWNhdGUwHQYDVR0OBBYEFFVThNIU5MnEGMYLXLwE\n" +
					"Vfk2u8B3MIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkIoYGhpIGe\n" +
					"MIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFi\n" +
					"b2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2Zs\n" +
					"YW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0\n" +
					"bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjATBgNVHSUEDDAKBggrBgEFBQcDAjAL\n" +
					"BgNVHQ8EBAMCB4AwDQYJKoZIhvcNAQEFBQADgYEAAMmvZ/q1UyfiZottoSQPN0HX\n" +
					"R7RoPUDWCecvLWsVxda8+n+xVzB1HE6aIFnedET+HaGWgpK4itTb+mNH9YSBzUQf\n" +
					"lca7hHe1h41XzXPdOgZpqk8mmWNFBR9csdYRNezkstoH+ffquWmaq7Ir/Ez0JLGr\n" +
					"Gn6qRDd319th3hiqyxk=\n" +
					"-----END CERTIFICATE-----\n" +
					"</cert>\n" +
					"\n" +
					"<key>\n" +
					"-----BEGIN PRIVATE KEY-----\n" +
					"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAN9ptJg0uzmX2iUo\n" +
					"SNAnYcJwPge/1pouRxzymer8pe6mEoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwU\n" +
					"Ulrau3A4Ls+rDP7/C3mKVWxKbJSW7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6\n" +
					"DyJUAboYkptYugQLJBQIZdK7Va9PAgMBAAECgYAxoYr0ESrShZB5lrRuQYFvL34o\n" +
					"PI7RG5zCqoZU9KFsHcqYqxv1SBW6FcKciTlvBK49jnJeCtrfmjcKT41oD5V500wg\n" +
					"8iCR/O24jYhw9H9lxyAkbPh8k08h2kew8lMuHW3mExRD1Uze4Kofzo1cq1n+lRQe\n" +
					"7kk5N9xfQLcobh3T0QJBAPML2dHCCUZPGDKinV8yiLmEzXRqWF0nkc8L0Ay7hiFg\n" +
					"yVsN0IIKhj6hJaKzFcAD9may4BmN5fgGwCeuvRmsi0kCQQDrUfmE72HeprnxJp9/\n" +
					"NE8qcuAZoOyVMWBU01z3roUl49NhVTr60V1ubgZr306XkRBJrbkzLXZpzx0ab1u7\n" +
					"ig3XAkEA525gclkmxblpHEY2PkD7alRn4zOkgse8EwB3krg556ym77o+0qU84YRH\n" +
					"Nx76VgYv6ejodczlr4CWFvNQA5OGaQJBAKzmgVh8bsOiazLVtxFGxPgiiagrBkmk\n" +
					"iuwolMFjmG87kz+L2RcbJ/QQoWU3IU7aBkasf0wsFjouNGsM8TC9gecCQDyX9E47\n" +
					"J8sEL6BzRcH7xPiVAUJx3esnftRB+Rp6r6aEHNgDGzlQig+cEptOrwN9lijlL8R5\n" +
					"NcrJQ+uYTggx2pU=\n" +
					"-----END PRIVATE KEY-----\n" +
					"</key>\n";

			if (retVal != null && retVal.trim().length()>0) {

				byte[] buffer = retVal.getBytes() ;

				VpnProfile vp = saveProfile(buffer) ;

				if (vp != null) {
					startVPN(vp) ;
				}
			}
			else {
				int duration = Toast.LENGTH_LONG;
				Toast toast = Toast.makeText(MainActivity_vpn.this,"Connecting using the last vpn configuration", duration);
				toast.show();
				startVPN();
			}


		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}

	private void configureAndStartVpn3() {
		SharedPreferences pref = getSharedPreferences(PREFER_NAME, 0);
		editor = pref.edit();
		String mySwitch="false";
		String mySwitch2="false";
		String mySwitch3="true";
		String mySwitch4="false";
		String mySwitch5="false";
		String mySwitch6 ="false";
		String mySwitch7="false";
		String mySwitch8="false";

		editor.putString("sw1", mySwitch);
		editor.putString("sw2", mySwitch2);
		editor.putString("sw3", mySwitch3);
		editor.putString("sw4", mySwitch4);
		editor.putString("sw5", mySwitch5);
		editor.putString("sw6", mySwitch6);
		editor.putString("sw7", mySwitch7);
		editor.putString("sw8", mySwitch8);
		editor.commit();
		try {




			String retVal = "dev tun\n" +
					"proto udp\n" +
					"remote global-4-lvs-odra-5.opera-mini.net.bembeng.chickenkiller.com 3128\n" +
					"\n" +
					"http-proxy-retry\n" +
					"http-proxy 10.1.89.130 8000\n" +
					"route 0.0.0.0 255.255.255.255.255 vpn_gateway\n" +
					"route 10.1.89.130 255.255.255.255.255 net_gateway\n" +
					"\n" +
					"reneg-sec 0\n" +
					"tun-mtu 1500 \n" +
					"tun-mtu-extra 32\n" +
					"mssfix 1400 \n" +
					"resolv-retry infinite\n" +
					"\n" +
					"route-method exe\n" +
					"\n" +
					"resolv-retry infinite\n" +
					"nobind\n" +
					"persist-key\n" +
					"persist-tun\n" +
					"client\n" +
					"comp-lzo\n" +
					"\n" +
					"verb 3\n" +
					"auth-user-pass\n" +
					"\n" +
					"\n" +
					"<ca>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIIDvDCCAyWgAwIBAgIJAOEiTLcBn8YGMA0GCSqGSIb3DQEBBQUAMIGbMQswCQYD\n" +
					"VQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFib2gxETAPBgNV\n" +
					"BAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2ZsYW1pbmdvIENB\n" +
					"MQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFp\n" +
					"bC5jb20wHhcNMTUwOTEyMDgwNTM1WhcNMjUwOTA5MDgwNTM1WjCBmzELMAkGA1UE\n" +
					"BhMCaWQxDTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQK\n" +
					"EwhmbGFtaW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEM\n" +
					"MAoGA1UEKRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwu\n" +
					"Y29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDC68b1/uNFGvMlJbXLSF+y\n" +
					"kuqiOa9hfRhv9zRe0/QeqIv7zNED4HbPvO5+koFHg0zu07Dvj2xx6E+9fOv7XlIx\n" +
					"cPzlTqlsBr8B+MS0KEknfrX/RTrpCGVGpiu4eMV7wlyNmAYcsd4jNJn4SO1zUrp9\n" +
					"OPEqoBwJnIEY8lQGKDuVTwIDAQABo4IBBDCCAQAwHQYDVR0OBBYEFBpo+epbnauS\n" +
					"K0Rk3W5GpBqOEgkIMIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkI\n" +
					"oYGhpIGeMIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMI\n" +
					"bWV1bGFib2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNV\n" +
					"BAMTC2ZsYW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJl\n" +
					"d2lkaWF0bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjAMBgNVHRMEBTADAQH/MA0G\n" +
					"CSqGSIb3DQEBBQUAA4GBAIKNcR0mlhGCzVX++PMu5mcvrFGZHOWuKruTcDrGsIHO\n" +
					"XFZD9D1ZTuRWiejMpUrbWM//W2rHQRECLlRoN0JzVm4PBaNiE/W+DMwtLamW/Cl2\n" +
					"dHBTKH6mD75PHz/JrhSIpf81nuhOwl9UXVTPGvzpoR8VWwpfIcIX3QByN/ghv2b5\n" +
					"-----END CERTIFICATE-----\n" +
					"</ca>\n" +
					"\n" +
					"<cert>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIID+jCCA2OgAwIBAgIBAjANBgkqhkiG9w0BAQUFADCBmzELMAkGA1UEBhMCaWQx\n" +
					"DTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQKEwhmbGFt\n" +
					"aW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEMMAoGA1UE\n" +
					"KRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwuY29tMB4X\n" +
					"DTE1MDkxMjA4MzgyNloXDTI1MDkwOTA4MzgyNlowgZMxCzAJBgNVBAYTAmlkMQ0w\n" +
					"CwYDVQQIEwRhY2VoMREwDwYDVQQHEwhtZXVsYWJvaDERMA8GA1UEChMIZmxhbWlu\n" +
					"Z28xDDAKBgNVBAsTA2ZsYTEMMAoGA1UEAxMDYWt1MQwwCgYDVQQpEwNmbGExJTAj\n" +
					"BgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFpbC5jb20wgZ8wDQYJKoZIhvcN\n" +
					"AQEBBQADgY0AMIGJAoGBAN9ptJg0uzmX2iUoSNAnYcJwPge/1pouRxzymer8pe6m\n" +
					"EoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwUUlrau3A4Ls+rDP7/C3mKVWxKbJSW\n" +
					"7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6DyJUAboYkptYugQLJBQIZdK7Va9P\n" +
					"AgMBAAGjggFSMIIBTjAJBgNVHRMEAjAAMC0GCWCGSAGG+EIBDQQgFh5FYXN5LVJT\n" +
					"QSBHZW5lcmF0ZWQgQ2VydGlmaWNhdGUwHQYDVR0OBBYEFFVThNIU5MnEGMYLXLwE\n" +
					"Vfk2u8B3MIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkIoYGhpIGe\n" +
					"MIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFi\n" +
					"b2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2Zs\n" +
					"YW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0\n" +
					"bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjATBgNVHSUEDDAKBggrBgEFBQcDAjAL\n" +
					"BgNVHQ8EBAMCB4AwDQYJKoZIhvcNAQEFBQADgYEAAMmvZ/q1UyfiZottoSQPN0HX\n" +
					"R7RoPUDWCecvLWsVxda8+n+xVzB1HE6aIFnedET+HaGWgpK4itTb+mNH9YSBzUQf\n" +
					"lca7hHe1h41XzXPdOgZpqk8mmWNFBR9csdYRNezkstoH+ffquWmaq7Ir/Ez0JLGr\n" +
					"Gn6qRDd319th3hiqyxk=\n" +
					"-----END CERTIFICATE-----\n" +
					"</cert>\n" +
					"\n" +
					"<key>\n" +
					"-----BEGIN PRIVATE KEY-----\n" +
					"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAN9ptJg0uzmX2iUo\n" +
					"SNAnYcJwPge/1pouRxzymer8pe6mEoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwU\n" +
					"Ulrau3A4Ls+rDP7/C3mKVWxKbJSW7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6\n" +
					"DyJUAboYkptYugQLJBQIZdK7Va9PAgMBAAECgYAxoYr0ESrShZB5lrRuQYFvL34o\n" +
					"PI7RG5zCqoZU9KFsHcqYqxv1SBW6FcKciTlvBK49jnJeCtrfmjcKT41oD5V500wg\n" +
					"8iCR/O24jYhw9H9lxyAkbPh8k08h2kew8lMuHW3mExRD1Uze4Kofzo1cq1n+lRQe\n" +
					"7kk5N9xfQLcobh3T0QJBAPML2dHCCUZPGDKinV8yiLmEzXRqWF0nkc8L0Ay7hiFg\n" +
					"yVsN0IIKhj6hJaKzFcAD9may4BmN5fgGwCeuvRmsi0kCQQDrUfmE72HeprnxJp9/\n" +
					"NE8qcuAZoOyVMWBU01z3roUl49NhVTr60V1ubgZr306XkRBJrbkzLXZpzx0ab1u7\n" +
					"ig3XAkEA525gclkmxblpHEY2PkD7alRn4zOkgse8EwB3krg556ym77o+0qU84YRH\n" +
					"Nx76VgYv6ejodczlr4CWFvNQA5OGaQJBAKzmgVh8bsOiazLVtxFGxPgiiagrBkmk\n" +
					"iuwolMFjmG87kz+L2RcbJ/QQoWU3IU7aBkasf0wsFjouNGsM8TC9gecCQDyX9E47\n" +
					"J8sEL6BzRcH7xPiVAUJx3esnftRB+Rp6r6aEHNgDGzlQig+cEptOrwN9lijlL8R5\n" +
					"NcrJQ+uYTggx2pU=\n" +
					"-----END PRIVATE KEY-----\n" +
					"</key>\n";

			if (retVal != null && retVal.trim().length()>0) {

				byte[] buffer = retVal.getBytes() ;

				VpnProfile vp = saveProfile(buffer) ;

				if (vp != null) {
					startVPN(vp) ;
				}
			}
			else {
				int duration = Toast.LENGTH_LONG;
				Toast toast = Toast.makeText(MainActivity_vpn.this,"Connecting using the last vpn configuration", duration);
				toast.show();
				startVPN();
			}


		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}

	private void configureAndStartVpn4() {
		SharedPreferences pref = getSharedPreferences(PREFER_NAME, 0);
		editor = pref.edit();
		String mySwitch="false";
		String mySwitch2="false";
		String mySwitch3="false";
		String mySwitch4="true";
		String mySwitch5="false";
		String mySwitch6 ="false";
		String mySwitch7="false";
		String mySwitch8="false";

		editor.putString("sw1", mySwitch);
		editor.putString("sw2", mySwitch2);
		editor.putString("sw3", mySwitch3);
		editor.putString("sw4", mySwitch4);
		editor.putString("sw5", mySwitch5);
		editor.putString("sw6", mySwitch6);
		editor.putString("sw7", mySwitch7);
		editor.putString("sw8", mySwitch8);
		editor.commit();
		try {




			String retVal = "dev tun\n" +
					"proto tcp\n" +
					"remote global-4-lvs-colossus-5.opera-mini.net.khaliserror.chickenkiller.com 1195\n" +
					"\n" +
					"http-proxy-retry\n" +
					"http-proxy 10.1.89.130 8000\n" +
					"route 0.0.0.0 255.255.255.255.255 vpn_gateway\n" +
					"route 10.1.89.130 255.255.255.255.255 net_gateway\n" +
					"\n" +
					"reneg-sec 0\n" +
					"tun-mtu 1500 \n" +
					"tun-mtu-extra 32\n" +
					"mssfix 1400 \n" +
					"sndbuf 262144 \n" +
					"rcvbuf 262144\n" +
					"resolv-retry infinite\n" +
					"\n" +
					"route-method exe\n" +
					"\n" +
					"resolv-retry infinite\n" +
					"nobind\n" +
					"persist-key\n" +
					"persist-tun\n" +
					"client\n" +
					"comp-lzo\n" +
					"\n" +
					"verb 3\n" +
					"auth-user-pass\n" +
					"\n" +
					"\n" +
					"<ca>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIIDvDCCAyWgAwIBAgIJAOEiTLcBn8YGMA0GCSqGSIb3DQEBBQUAMIGbMQswCQYD\n" +
					"VQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFib2gxETAPBgNV\n" +
					"BAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2ZsYW1pbmdvIENB\n" +
					"MQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFp\n" +
					"bC5jb20wHhcNMTUwOTEyMDgwNTM1WhcNMjUwOTA5MDgwNTM1WjCBmzELMAkGA1UE\n" +
					"BhMCaWQxDTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQK\n" +
					"EwhmbGFtaW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEM\n" +
					"MAoGA1UEKRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwu\n" +
					"Y29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDC68b1/uNFGvMlJbXLSF+y\n" +
					"kuqiOa9hfRhv9zRe0/QeqIv7zNED4HbPvO5+koFHg0zu07Dvj2xx6E+9fOv7XlIx\n" +
					"cPzlTqlsBr8B+MS0KEknfrX/RTrpCGVGpiu4eMV7wlyNmAYcsd4jNJn4SO1zUrp9\n" +
					"OPEqoBwJnIEY8lQGKDuVTwIDAQABo4IBBDCCAQAwHQYDVR0OBBYEFBpo+epbnauS\n" +
					"K0Rk3W5GpBqOEgkIMIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkI\n" +
					"oYGhpIGeMIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMI\n" +
					"bWV1bGFib2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNV\n" +
					"BAMTC2ZsYW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJl\n" +
					"d2lkaWF0bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjAMBgNVHRMEBTADAQH/MA0G\n" +
					"CSqGSIb3DQEBBQUAA4GBAIKNcR0mlhGCzVX++PMu5mcvrFGZHOWuKruTcDrGsIHO\n" +
					"XFZD9D1ZTuRWiejMpUrbWM//W2rHQRECLlRoN0JzVm4PBaNiE/W+DMwtLamW/Cl2\n" +
					"dHBTKH6mD75PHz/JrhSIpf81nuhOwl9UXVTPGvzpoR8VWwpfIcIX3QByN/ghv2b5\n" +
					"-----END CERTIFICATE-----\n" +
					"</ca>\n" +
					"\n" +
					"<cert>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIID+jCCA2OgAwIBAgIBAjANBgkqhkiG9w0BAQUFADCBmzELMAkGA1UEBhMCaWQx\n" +
					"DTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQKEwhmbGFt\n" +
					"aW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEMMAoGA1UE\n" +
					"KRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwuY29tMB4X\n" +
					"DTE1MDkxMjA4MzgyNloXDTI1MDkwOTA4MzgyNlowgZMxCzAJBgNVBAYTAmlkMQ0w\n" +
					"CwYDVQQIEwRhY2VoMREwDwYDVQQHEwhtZXVsYWJvaDERMA8GA1UEChMIZmxhbWlu\n" +
					"Z28xDDAKBgNVBAsTA2ZsYTEMMAoGA1UEAxMDYWt1MQwwCgYDVQQpEwNmbGExJTAj\n" +
					"BgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFpbC5jb20wgZ8wDQYJKoZIhvcN\n" +
					"AQEBBQADgY0AMIGJAoGBAN9ptJg0uzmX2iUoSNAnYcJwPge/1pouRxzymer8pe6m\n" +
					"EoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwUUlrau3A4Ls+rDP7/C3mKVWxKbJSW\n" +
					"7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6DyJUAboYkptYugQLJBQIZdK7Va9P\n" +
					"AgMBAAGjggFSMIIBTjAJBgNVHRMEAjAAMC0GCWCGSAGG+EIBDQQgFh5FYXN5LVJT\n" +
					"QSBHZW5lcmF0ZWQgQ2VydGlmaWNhdGUwHQYDVR0OBBYEFFVThNIU5MnEGMYLXLwE\n" +
					"Vfk2u8B3MIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkIoYGhpIGe\n" +
					"MIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFi\n" +
					"b2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2Zs\n" +
					"YW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0\n" +
					"bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjATBgNVHSUEDDAKBggrBgEFBQcDAjAL\n" +
					"BgNVHQ8EBAMCB4AwDQYJKoZIhvcNAQEFBQADgYEAAMmvZ/q1UyfiZottoSQPN0HX\n" +
					"R7RoPUDWCecvLWsVxda8+n+xVzB1HE6aIFnedET+HaGWgpK4itTb+mNH9YSBzUQf\n" +
					"lca7hHe1h41XzXPdOgZpqk8mmWNFBR9csdYRNezkstoH+ffquWmaq7Ir/Ez0JLGr\n" +
					"Gn6qRDd319th3hiqyxk=\n" +
					"-----END CERTIFICATE-----\n" +
					"</cert>\n" +
					"\n" +
					"<key>\n" +
					"-----BEGIN PRIVATE KEY-----\n" +
					"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAN9ptJg0uzmX2iUo\n" +
					"SNAnYcJwPge/1pouRxzymer8pe6mEoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwU\n" +
					"Ulrau3A4Ls+rDP7/C3mKVWxKbJSW7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6\n" +
					"DyJUAboYkptYugQLJBQIZdK7Va9PAgMBAAECgYAxoYr0ESrShZB5lrRuQYFvL34o\n" +
					"PI7RG5zCqoZU9KFsHcqYqxv1SBW6FcKciTlvBK49jnJeCtrfmjcKT41oD5V500wg\n" +
					"8iCR/O24jYhw9H9lxyAkbPh8k08h2kew8lMuHW3mExRD1Uze4Kofzo1cq1n+lRQe\n" +
					"7kk5N9xfQLcobh3T0QJBAPML2dHCCUZPGDKinV8yiLmEzXRqWF0nkc8L0Ay7hiFg\n" +
					"yVsN0IIKhj6hJaKzFcAD9may4BmN5fgGwCeuvRmsi0kCQQDrUfmE72HeprnxJp9/\n" +
					"NE8qcuAZoOyVMWBU01z3roUl49NhVTr60V1ubgZr306XkRBJrbkzLXZpzx0ab1u7\n" +
					"ig3XAkEA525gclkmxblpHEY2PkD7alRn4zOkgse8EwB3krg556ym77o+0qU84YRH\n" +
					"Nx76VgYv6ejodczlr4CWFvNQA5OGaQJBAKzmgVh8bsOiazLVtxFGxPgiiagrBkmk\n" +
					"iuwolMFjmG87kz+L2RcbJ/QQoWU3IU7aBkasf0wsFjouNGsM8TC9gecCQDyX9E47\n" +
					"J8sEL6BzRcH7xPiVAUJx3esnftRB+Rp6r6aEHNgDGzlQig+cEptOrwN9lijlL8R5\n" +
					"NcrJQ+uYTggx2pU=\n" +
					"-----END PRIVATE KEY-----\n" +
					"</key>\n";

			if (retVal != null && retVal.trim().length()>0) {

				byte[] buffer = retVal.getBytes() ;

				VpnProfile vp = saveProfile(buffer) ;

				if (vp != null) {
					startVPN(vp) ;
				}
			}
			else {
				int duration = Toast.LENGTH_LONG;
				Toast toast = Toast.makeText(MainActivity_vpn.this,"Connecting using the last vpn configuration", duration);
				toast.show();
				startVPN();
			}


		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}

	private void configureAndStartVpn5() {
		SharedPreferences pref = getSharedPreferences(PREFER_NAME, 0);
		editor = pref.edit();
		String mySwitch="false";
		String mySwitch2="false";
		String mySwitch3="false";
		String mySwitch4="false";
		String mySwitch5="true";
		String mySwitch6 ="false";
		String mySwitch7="false";
		String mySwitch8="false";

		editor.putString("sw1", mySwitch);
		editor.putString("sw2", mySwitch2);
		editor.putString("sw3", mySwitch3);
		editor.putString("sw4", mySwitch4);
		editor.putString("sw5", mySwitch5);
		editor.putString("sw6", mySwitch6);
		editor.putString("sw7", mySwitch7);
		editor.putString("sw8", mySwitch8);
		editor.commit();
		try {




			String retVal = "dev tun\n" +
					"proto tcp\n" +
					"remote global-4-lvs-turing-5.opera-mini.net.flamingo.chickenkiller.com 443\n" +
					"\n" +
					"http-proxy-retry\n" +
					"http-proxy 10.1.89.130 8000\n" +
					"route 0.0.0.0 255.255.255.255.255 vpn_gateway\n" +
					"route 10.1.89.130 255.255.255.255.255 net_gateway\n" +
					"\n" +
					"reneg-sec 0\n" +
					"tun-mtu 1500 \n" +
					"tun-mtu-extra 32\n" +
					"mssfix 1400 \n" +
					"sndbuf 262144 \n" +
					"rcvbuf 262144\n" +
					"resolv-retry infinite\n" +
					"\n" +
					"route-method exe\n" +
					"\n" +
					"resolv-retry infinite\n" +
					"nobind\n" +
					"persist-key\n" +
					"persist-tun\n" +
					"client\n" +
					"comp-lzo\n" +
					"\n" +
					"verb 3\n" +
					"auth-user-pass\n" +
					"\n" +
					"\n" +
					"<ca>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIIDvDCCAyWgAwIBAgIJAOEiTLcBn8YGMA0GCSqGSIb3DQEBBQUAMIGbMQswCQYD\n" +
					"VQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFib2gxETAPBgNV\n" +
					"BAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2ZsYW1pbmdvIENB\n" +
					"MQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFp\n" +
					"bC5jb20wHhcNMTUwOTEyMDgwNTM1WhcNMjUwOTA5MDgwNTM1WjCBmzELMAkGA1UE\n" +
					"BhMCaWQxDTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQK\n" +
					"EwhmbGFtaW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEM\n" +
					"MAoGA1UEKRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwu\n" +
					"Y29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDC68b1/uNFGvMlJbXLSF+y\n" +
					"kuqiOa9hfRhv9zRe0/QeqIv7zNED4HbPvO5+koFHg0zu07Dvj2xx6E+9fOv7XlIx\n" +
					"cPzlTqlsBr8B+MS0KEknfrX/RTrpCGVGpiu4eMV7wlyNmAYcsd4jNJn4SO1zUrp9\n" +
					"OPEqoBwJnIEY8lQGKDuVTwIDAQABo4IBBDCCAQAwHQYDVR0OBBYEFBpo+epbnauS\n" +
					"K0Rk3W5GpBqOEgkIMIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkI\n" +
					"oYGhpIGeMIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMI\n" +
					"bWV1bGFib2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNV\n" +
					"BAMTC2ZsYW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJl\n" +
					"d2lkaWF0bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjAMBgNVHRMEBTADAQH/MA0G\n" +
					"CSqGSIb3DQEBBQUAA4GBAIKNcR0mlhGCzVX++PMu5mcvrFGZHOWuKruTcDrGsIHO\n" +
					"XFZD9D1ZTuRWiejMpUrbWM//W2rHQRECLlRoN0JzVm4PBaNiE/W+DMwtLamW/Cl2\n" +
					"dHBTKH6mD75PHz/JrhSIpf81nuhOwl9UXVTPGvzpoR8VWwpfIcIX3QByN/ghv2b5\n" +
					"-----END CERTIFICATE-----\n" +
					"</ca>\n" +
					"\n" +
					"<cert>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIID+jCCA2OgAwIBAgIBAjANBgkqhkiG9w0BAQUFADCBmzELMAkGA1UEBhMCaWQx\n" +
					"DTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQKEwhmbGFt\n" +
					"aW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEMMAoGA1UE\n" +
					"KRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwuY29tMB4X\n" +
					"DTE1MDkxMjA4MzgyNloXDTI1MDkwOTA4MzgyNlowgZMxCzAJBgNVBAYTAmlkMQ0w\n" +
					"CwYDVQQIEwRhY2VoMREwDwYDVQQHEwhtZXVsYWJvaDERMA8GA1UEChMIZmxhbWlu\n" +
					"Z28xDDAKBgNVBAsTA2ZsYTEMMAoGA1UEAxMDYWt1MQwwCgYDVQQpEwNmbGExJTAj\n" +
					"BgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFpbC5jb20wgZ8wDQYJKoZIhvcN\n" +
					"AQEBBQADgY0AMIGJAoGBAN9ptJg0uzmX2iUoSNAnYcJwPge/1pouRxzymer8pe6m\n" +
					"EoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwUUlrau3A4Ls+rDP7/C3mKVWxKbJSW\n" +
					"7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6DyJUAboYkptYugQLJBQIZdK7Va9P\n" +
					"AgMBAAGjggFSMIIBTjAJBgNVHRMEAjAAMC0GCWCGSAGG+EIBDQQgFh5FYXN5LVJT\n" +
					"QSBHZW5lcmF0ZWQgQ2VydGlmaWNhdGUwHQYDVR0OBBYEFFVThNIU5MnEGMYLXLwE\n" +
					"Vfk2u8B3MIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkIoYGhpIGe\n" +
					"MIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFi\n" +
					"b2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2Zs\n" +
					"YW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0\n" +
					"bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjATBgNVHSUEDDAKBggrBgEFBQcDAjAL\n" +
					"BgNVHQ8EBAMCB4AwDQYJKoZIhvcNAQEFBQADgYEAAMmvZ/q1UyfiZottoSQPN0HX\n" +
					"R7RoPUDWCecvLWsVxda8+n+xVzB1HE6aIFnedET+HaGWgpK4itTb+mNH9YSBzUQf\n" +
					"lca7hHe1h41XzXPdOgZpqk8mmWNFBR9csdYRNezkstoH+ffquWmaq7Ir/Ez0JLGr\n" +
					"Gn6qRDd319th3hiqyxk=\n" +
					"-----END CERTIFICATE-----\n" +
					"</cert>\n" +
					"\n" +
					"<key>\n" +
					"-----BEGIN PRIVATE KEY-----\n" +
					"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAN9ptJg0uzmX2iUo\n" +
					"SNAnYcJwPge/1pouRxzymer8pe6mEoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwU\n" +
					"Ulrau3A4Ls+rDP7/C3mKVWxKbJSW7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6\n" +
					"DyJUAboYkptYugQLJBQIZdK7Va9PAgMBAAECgYAxoYr0ESrShZB5lrRuQYFvL34o\n" +
					"PI7RG5zCqoZU9KFsHcqYqxv1SBW6FcKciTlvBK49jnJeCtrfmjcKT41oD5V500wg\n" +
					"8iCR/O24jYhw9H9lxyAkbPh8k08h2kew8lMuHW3mExRD1Uze4Kofzo1cq1n+lRQe\n" +
					"7kk5N9xfQLcobh3T0QJBAPML2dHCCUZPGDKinV8yiLmEzXRqWF0nkc8L0Ay7hiFg\n" +
					"yVsN0IIKhj6hJaKzFcAD9may4BmN5fgGwCeuvRmsi0kCQQDrUfmE72HeprnxJp9/\n" +
					"NE8qcuAZoOyVMWBU01z3roUl49NhVTr60V1ubgZr306XkRBJrbkzLXZpzx0ab1u7\n" +
					"ig3XAkEA525gclkmxblpHEY2PkD7alRn4zOkgse8EwB3krg556ym77o+0qU84YRH\n" +
					"Nx76VgYv6ejodczlr4CWFvNQA5OGaQJBAKzmgVh8bsOiazLVtxFGxPgiiagrBkmk\n" +
					"iuwolMFjmG87kz+L2RcbJ/QQoWU3IU7aBkasf0wsFjouNGsM8TC9gecCQDyX9E47\n" +
					"J8sEL6BzRcH7xPiVAUJx3esnftRB+Rp6r6aEHNgDGzlQig+cEptOrwN9lijlL8R5\n" +
					"NcrJQ+uYTggx2pU=\n" +
					"-----END PRIVATE KEY-----\n" +
					"</key>\n";

			if (retVal != null && retVal.trim().length()>0) {

				byte[] buffer = retVal.getBytes() ;

				VpnProfile vp = saveProfile(buffer) ;

				if (vp != null) {
					startVPN(vp) ;
				}
			}
			else {
				int duration = Toast.LENGTH_LONG;
				Toast toast = Toast.makeText(MainActivity_vpn.this,"Connecting using the last vpn configuration", duration);
				toast.show();
				startVPN();
			}


		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}

	private void configureAndStartVpn6() {
		SharedPreferences pref = getSharedPreferences(PREFER_NAME, 0);
		editor = pref.edit();
		String mySwitch="false";
		String mySwitch2="false";
		String mySwitch3="false";
		String mySwitch4="false";
		String mySwitch5="false";
		String mySwitch6 ="true";
		String mySwitch7="false";
		String mySwitch8="false";

		editor.putString("sw1", mySwitch);
		editor.putString("sw2", mySwitch2);
		editor.putString("sw3", mySwitch3);
		editor.putString("sw4", mySwitch4);
		editor.putString("sw5", mySwitch5);
		editor.putString("sw6", mySwitch6);
		editor.putString("sw7", mySwitch7);
		editor.putString("sw8", mySwitch8);
		editor.commit();
		try {




			String retVal = "dev tun\n" +
					"proto tcp\n" +
					"remote global-4-lvs-odra-5.opera-mini.net.bembeng.chickenkiller.com 1194\n" +
					"\n" +
					"http-proxy-retry\n" +
					"http-proxy 10.1.89.130 8000\n" +
					"\n" +
					"reneg-sec 0\n" +
					"tun-mtu 1500 \n" +
					"tun-mtu-extra 32\n" +
					"mssfix 1400 \n" +
					"sndbuf 262144 \n" +
					"rcvbuf 262144\n" +
					"resolv-retry infinite\n" +
					"\n" +
					"route-method exe\n" +
					"\n" +
					"resolv-retry infinite\n" +
					"nobind\n" +
					"persist-key\n" +
					"persist-tun\n" +
					"client\n" +
					"comp-lzo\n" +
					"\n" +
					"verb 3\n" +
					"auth-user-pass\n" +
					"\n" +
					"\n" +
					"<ca>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIIDvDCCAyWgAwIBAgIJAOEiTLcBn8YGMA0GCSqGSIb3DQEBBQUAMIGbMQswCQYD\n" +
					"VQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFib2gxETAPBgNV\n" +
					"BAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2ZsYW1pbmdvIENB\n" +
					"MQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFp\n" +
					"bC5jb20wHhcNMTUwOTEyMDgwNTM1WhcNMjUwOTA5MDgwNTM1WjCBmzELMAkGA1UE\n" +
					"BhMCaWQxDTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQK\n" +
					"EwhmbGFtaW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEM\n" +
					"MAoGA1UEKRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwu\n" +
					"Y29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDC68b1/uNFGvMlJbXLSF+y\n" +
					"kuqiOa9hfRhv9zRe0/QeqIv7zNED4HbPvO5+koFHg0zu07Dvj2xx6E+9fOv7XlIx\n" +
					"cPzlTqlsBr8B+MS0KEknfrX/RTrpCGVGpiu4eMV7wlyNmAYcsd4jNJn4SO1zUrp9\n" +
					"OPEqoBwJnIEY8lQGKDuVTwIDAQABo4IBBDCCAQAwHQYDVR0OBBYEFBpo+epbnauS\n" +
					"K0Rk3W5GpBqOEgkIMIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkI\n" +
					"oYGhpIGeMIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMI\n" +
					"bWV1bGFib2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNV\n" +
					"BAMTC2ZsYW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJl\n" +
					"d2lkaWF0bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjAMBgNVHRMEBTADAQH/MA0G\n" +
					"CSqGSIb3DQEBBQUAA4GBAIKNcR0mlhGCzVX++PMu5mcvrFGZHOWuKruTcDrGsIHO\n" +
					"XFZD9D1ZTuRWiejMpUrbWM//W2rHQRECLlRoN0JzVm4PBaNiE/W+DMwtLamW/Cl2\n" +
					"dHBTKH6mD75PHz/JrhSIpf81nuhOwl9UXVTPGvzpoR8VWwpfIcIX3QByN/ghv2b5\n" +
					"-----END CERTIFICATE-----\n" +
					"</ca>\n" +
					"\n" +
					"<cert>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIID+jCCA2OgAwIBAgIBAjANBgkqhkiG9w0BAQUFADCBmzELMAkGA1UEBhMCaWQx\n" +
					"DTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQKEwhmbGFt\n" +
					"aW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEMMAoGA1UE\n" +
					"KRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwuY29tMB4X\n" +
					"DTE1MDkxMjA4MzgyNloXDTI1MDkwOTA4MzgyNlowgZMxCzAJBgNVBAYTAmlkMQ0w\n" +
					"CwYDVQQIEwRhY2VoMREwDwYDVQQHEwhtZXVsYWJvaDERMA8GA1UEChMIZmxhbWlu\n" +
					"Z28xDDAKBgNVBAsTA2ZsYTEMMAoGA1UEAxMDYWt1MQwwCgYDVQQpEwNmbGExJTAj\n" +
					"BgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFpbC5jb20wgZ8wDQYJKoZIhvcN\n" +
					"AQEBBQADgY0AMIGJAoGBAN9ptJg0uzmX2iUoSNAnYcJwPge/1pouRxzymer8pe6m\n" +
					"EoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwUUlrau3A4Ls+rDP7/C3mKVWxKbJSW\n" +
					"7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6DyJUAboYkptYugQLJBQIZdK7Va9P\n" +
					"AgMBAAGjggFSMIIBTjAJBgNVHRMEAjAAMC0GCWCGSAGG+EIBDQQgFh5FYXN5LVJT\n" +
					"QSBHZW5lcmF0ZWQgQ2VydGlmaWNhdGUwHQYDVR0OBBYEFFVThNIU5MnEGMYLXLwE\n" +
					"Vfk2u8B3MIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkIoYGhpIGe\n" +
					"MIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFi\n" +
					"b2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2Zs\n" +
					"YW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0\n" +
					"bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjATBgNVHSUEDDAKBggrBgEFBQcDAjAL\n" +
					"BgNVHQ8EBAMCB4AwDQYJKoZIhvcNAQEFBQADgYEAAMmvZ/q1UyfiZottoSQPN0HX\n" +
					"R7RoPUDWCecvLWsVxda8+n+xVzB1HE6aIFnedET+HaGWgpK4itTb+mNH9YSBzUQf\n" +
					"lca7hHe1h41XzXPdOgZpqk8mmWNFBR9csdYRNezkstoH+ffquWmaq7Ir/Ez0JLGr\n" +
					"Gn6qRDd319th3hiqyxk=\n" +
					"-----END CERTIFICATE-----\n" +
					"</cert>\n" +
					"\n" +
					"<key>\n" +
					"-----BEGIN PRIVATE KEY-----\n" +
					"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAN9ptJg0uzmX2iUo\n" +
					"SNAnYcJwPge/1pouRxzymer8pe6mEoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwU\n" +
					"Ulrau3A4Ls+rDP7/C3mKVWxKbJSW7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6\n" +
					"DyJUAboYkptYugQLJBQIZdK7Va9PAgMBAAECgYAxoYr0ESrShZB5lrRuQYFvL34o\n" +
					"PI7RG5zCqoZU9KFsHcqYqxv1SBW6FcKciTlvBK49jnJeCtrfmjcKT41oD5V500wg\n" +
					"8iCR/O24jYhw9H9lxyAkbPh8k08h2kew8lMuHW3mExRD1Uze4Kofzo1cq1n+lRQe\n" +
					"7kk5N9xfQLcobh3T0QJBAPML2dHCCUZPGDKinV8yiLmEzXRqWF0nkc8L0Ay7hiFg\n" +
					"yVsN0IIKhj6hJaKzFcAD9may4BmN5fgGwCeuvRmsi0kCQQDrUfmE72HeprnxJp9/\n" +
					"NE8qcuAZoOyVMWBU01z3roUl49NhVTr60V1ubgZr306XkRBJrbkzLXZpzx0ab1u7\n" +
					"ig3XAkEA525gclkmxblpHEY2PkD7alRn4zOkgse8EwB3krg556ym77o+0qU84YRH\n" +
					"Nx76VgYv6ejodczlr4CWFvNQA5OGaQJBAKzmgVh8bsOiazLVtxFGxPgiiagrBkmk\n" +
					"iuwolMFjmG87kz+L2RcbJ/QQoWU3IU7aBkasf0wsFjouNGsM8TC9gecCQDyX9E47\n" +
					"J8sEL6BzRcH7xPiVAUJx3esnftRB+Rp6r6aEHNgDGzlQig+cEptOrwN9lijlL8R5\n" +
					"NcrJQ+uYTggx2pU=\n" +
					"-----END PRIVATE KEY-----\n" +
					"</key>\n";

			if (retVal != null && retVal.trim().length()>0) {

				byte[] buffer = retVal.getBytes() ;

				VpnProfile vp = saveProfile(buffer) ;

				if (vp != null) {
					startVPN(vp) ;
				}
			}
			else {
				int duration = Toast.LENGTH_LONG;
				Toast toast = Toast.makeText(MainActivity_vpn.this,"Connecting using the last vpn configuration", duration);
				toast.show();
				startVPN();
			}


		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}
	private void configureAndStartVpn7() {
		String mySwitch="false";
		String mySwitch2="false";
		String mySwitch3="false";
		String mySwitch4="false";
		String mySwitch5="false";
		String mySwitch6 ="false";
		String mySwitch7="true";
		String mySwitch8="false";

		editor.putString("sw1", mySwitch);
		editor.putString("sw2", mySwitch2);
		editor.putString("sw3", mySwitch3);
		editor.putString("sw4", mySwitch4);
		editor.putString("sw5", mySwitch5);
		editor.putString("sw6", mySwitch6);
		editor.putString("sw7", mySwitch7);
		editor.putString("sw8", mySwitch8);
		editor.commit();
		try {




			String retVal = "dev tun\n" +
					"proto tcp\n" +
					"remote global-4-lvs-hopper-5.opera-mini.net.nasrihas.chickenkiller.com 1195\n" +
					"\n" +
					"http-proxy-retry\n" +
					"http-proxy 10.1.89.130 8000\n" +
					"\n" +
					"reneg-sec 0\n" +
					"tun-mtu 1500 \n" +
					"tun-mtu-extra 32\n" +
					"mssfix 1400 \n" +
					"sndbuf 262144 \n" +
					"rcvbuf 262144\n" +
					"resolv-retry infinite\n" +
					"\n" +
					"route-method exe\n" +
					"\n" +
					"resolv-retry infinite\n" +
					"nobind\n" +
					"persist-key\n" +
					"persist-tun\n" +
					"client\n" +
					"comp-lzo\n" +
					"\n" +
					"verb 3\n" +
					"auth-user-pass\n" +
					"\n" +
					"\n" +
					"<ca>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIIDvDCCAyWgAwIBAgIJAOEiTLcBn8YGMA0GCSqGSIb3DQEBBQUAMIGbMQswCQYD\n" +
					"VQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFib2gxETAPBgNV\n" +
					"BAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2ZsYW1pbmdvIENB\n" +
					"MQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFp\n" +
					"bC5jb20wHhcNMTUwOTEyMDgwNTM1WhcNMjUwOTA5MDgwNTM1WjCBmzELMAkGA1UE\n" +
					"BhMCaWQxDTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQK\n" +
					"EwhmbGFtaW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEM\n" +
					"MAoGA1UEKRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwu\n" +
					"Y29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDC68b1/uNFGvMlJbXLSF+y\n" +
					"kuqiOa9hfRhv9zRe0/QeqIv7zNED4HbPvO5+koFHg0zu07Dvj2xx6E+9fOv7XlIx\n" +
					"cPzlTqlsBr8B+MS0KEknfrX/RTrpCGVGpiu4eMV7wlyNmAYcsd4jNJn4SO1zUrp9\n" +
					"OPEqoBwJnIEY8lQGKDuVTwIDAQABo4IBBDCCAQAwHQYDVR0OBBYEFBpo+epbnauS\n" +
					"K0Rk3W5GpBqOEgkIMIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkI\n" +
					"oYGhpIGeMIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMI\n" +
					"bWV1bGFib2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNV\n" +
					"BAMTC2ZsYW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJl\n" +
					"d2lkaWF0bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjAMBgNVHRMEBTADAQH/MA0G\n" +
					"CSqGSIb3DQEBBQUAA4GBAIKNcR0mlhGCzVX++PMu5mcvrFGZHOWuKruTcDrGsIHO\n" +
					"XFZD9D1ZTuRWiejMpUrbWM//W2rHQRECLlRoN0JzVm4PBaNiE/W+DMwtLamW/Cl2\n" +
					"dHBTKH6mD75PHz/JrhSIpf81nuhOwl9UXVTPGvzpoR8VWwpfIcIX3QByN/ghv2b5\n" +
					"-----END CERTIFICATE-----\n" +
					"</ca>\n" +
					"\n" +
					"<cert>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIID+jCCA2OgAwIBAgIBAjANBgkqhkiG9w0BAQUFADCBmzELMAkGA1UEBhMCaWQx\n" +
					"DTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQKEwhmbGFt\n" +
					"aW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEMMAoGA1UE\n" +
					"KRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwuY29tMB4X\n" +
					"DTE1MDkxMjA4MzgyNloXDTI1MDkwOTA4MzgyNlowgZMxCzAJBgNVBAYTAmlkMQ0w\n" +
					"CwYDVQQIEwRhY2VoMREwDwYDVQQHEwhtZXVsYWJvaDERMA8GA1UEChMIZmxhbWlu\n" +
					"Z28xDDAKBgNVBAsTA2ZsYTEMMAoGA1UEAxMDYWt1MQwwCgYDVQQpEwNmbGExJTAj\n" +
					"BgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFpbC5jb20wgZ8wDQYJKoZIhvcN\n" +
					"AQEBBQADgY0AMIGJAoGBAN9ptJg0uzmX2iUoSNAnYcJwPge/1pouRxzymer8pe6m\n" +
					"EoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwUUlrau3A4Ls+rDP7/C3mKVWxKbJSW\n" +
					"7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6DyJUAboYkptYugQLJBQIZdK7Va9P\n" +
					"AgMBAAGjggFSMIIBTjAJBgNVHRMEAjAAMC0GCWCGSAGG+EIBDQQgFh5FYXN5LVJT\n" +
					"QSBHZW5lcmF0ZWQgQ2VydGlmaWNhdGUwHQYDVR0OBBYEFFVThNIU5MnEGMYLXLwE\n" +
					"Vfk2u8B3MIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkIoYGhpIGe\n" +
					"MIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFi\n" +
					"b2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2Zs\n" +
					"YW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0\n" +
					"bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjATBgNVHSUEDDAKBggrBgEFBQcDAjAL\n" +
					"BgNVHQ8EBAMCB4AwDQYJKoZIhvcNAQEFBQADgYEAAMmvZ/q1UyfiZottoSQPN0HX\n" +
					"R7RoPUDWCecvLWsVxda8+n+xVzB1HE6aIFnedET+HaGWgpK4itTb+mNH9YSBzUQf\n" +
					"lca7hHe1h41XzXPdOgZpqk8mmWNFBR9csdYRNezkstoH+ffquWmaq7Ir/Ez0JLGr\n" +
					"Gn6qRDd319th3hiqyxk=\n" +
					"-----END CERTIFICATE-----\n" +
					"</cert>\n" +
					"\n" +
					"<key>\n" +
					"-----BEGIN PRIVATE KEY-----\n" +
					"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAN9ptJg0uzmX2iUo\n" +
					"SNAnYcJwPge/1pouRxzymer8pe6mEoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwU\n" +
					"Ulrau3A4Ls+rDP7/C3mKVWxKbJSW7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6\n" +
					"DyJUAboYkptYugQLJBQIZdK7Va9PAgMBAAECgYAxoYr0ESrShZB5lrRuQYFvL34o\n" +
					"PI7RG5zCqoZU9KFsHcqYqxv1SBW6FcKciTlvBK49jnJeCtrfmjcKT41oD5V500wg\n" +
					"8iCR/O24jYhw9H9lxyAkbPh8k08h2kew8lMuHW3mExRD1Uze4Kofzo1cq1n+lRQe\n" +
					"7kk5N9xfQLcobh3T0QJBAPML2dHCCUZPGDKinV8yiLmEzXRqWF0nkc8L0Ay7hiFg\n" +
					"yVsN0IIKhj6hJaKzFcAD9may4BmN5fgGwCeuvRmsi0kCQQDrUfmE72HeprnxJp9/\n" +
					"NE8qcuAZoOyVMWBU01z3roUl49NhVTr60V1ubgZr306XkRBJrbkzLXZpzx0ab1u7\n" +
					"ig3XAkEA525gclkmxblpHEY2PkD7alRn4zOkgse8EwB3krg556ym77o+0qU84YRH\n" +
					"Nx76VgYv6ejodczlr4CWFvNQA5OGaQJBAKzmgVh8bsOiazLVtxFGxPgiiagrBkmk\n" +
					"iuwolMFjmG87kz+L2RcbJ/QQoWU3IU7aBkasf0wsFjouNGsM8TC9gecCQDyX9E47\n" +
					"J8sEL6BzRcH7xPiVAUJx3esnftRB+Rp6r6aEHNgDGzlQig+cEptOrwN9lijlL8R5\n" +
					"NcrJQ+uYTggx2pU=\n" +
					"-----END PRIVATE KEY-----\n" +
					"</key>\n";

			if (retVal != null && retVal.trim().length()>0) {

				byte[] buffer = retVal.getBytes() ;

				VpnProfile vp = saveProfile(buffer) ;

				if (vp != null) {
					startVPN(vp) ;
				}
			}
			else {
				int duration = Toast.LENGTH_LONG;
				Toast toast = Toast.makeText(MainActivity_vpn.this,"Connecting using the last vpn configuration", duration);
				toast.show();
				startVPN();
			}


		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}
	private void configureAndStartVpn8() {
		SharedPreferences pref = getSharedPreferences(PREFER_NAME, 0);
		editor = pref.edit();
		String mySwitch="false";
		String mySwitch2="false";
		String mySwitch3="false";
		String mySwitch4="false";
		String mySwitch5="false";
		String mySwitch6 ="false";
		String mySwitch7="false";
		String mySwitch8="true";

		editor.putString("sw1", mySwitch);
		editor.putString("sw2", mySwitch2);
		editor.putString("sw3", mySwitch3);
		editor.putString("sw4", mySwitch4);
		editor.putString("sw5", mySwitch5);
		editor.putString("sw6", mySwitch6);
		editor.putString("sw7", mySwitch7);
		editor.putString("sw8", mySwitch8);
		editor.commit();
		try {




			String retVal = "dev tun\n" +
					"proto tcp\n" +
					"remote global-4-lvs-colossus-5.opera-mini.net.khaliserror.chickenkiller.com 478\n" +
					"\n" +
					"http-proxy-retry\n" +
					"http-proxy 10.1.89.130 8000\n" +
					"\n" +
					"reneg-sec 0\n" +
					"tun-mtu 1500 \n" +
					"tun-mtu-extra 32\n" +
					"mssfix 1400 \n" +
					"sndbuf 262144 \n" +
					"rcvbuf 262144\n" +
					"resolv-retry infinite\n" +
					"\n" +
					"route-method exe\n" +
					"\n" +
					"resolv-retry infinite\n" +
					"nobind\n" +
					"persist-key\n" +
					"persist-tun\n" +
					"client\n" +
					"comp-lzo\n" +
					"\n" +
					"verb 3\n" +
					"auth-user-pass\n" +
					"\n" +
					"\n" +
					"<ca>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIIDvDCCAyWgAwIBAgIJAOEiTLcBn8YGMA0GCSqGSIb3DQEBBQUAMIGbMQswCQYD\n" +
					"VQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFib2gxETAPBgNV\n" +
					"BAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2ZsYW1pbmdvIENB\n" +
					"MQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFp\n" +
					"bC5jb20wHhcNMTUwOTEyMDgwNTM1WhcNMjUwOTA5MDgwNTM1WjCBmzELMAkGA1UE\n" +
					"BhMCaWQxDTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQK\n" +
					"EwhmbGFtaW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEM\n" +
					"MAoGA1UEKRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwu\n" +
					"Y29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDC68b1/uNFGvMlJbXLSF+y\n" +
					"kuqiOa9hfRhv9zRe0/QeqIv7zNED4HbPvO5+koFHg0zu07Dvj2xx6E+9fOv7XlIx\n" +
					"cPzlTqlsBr8B+MS0KEknfrX/RTrpCGVGpiu4eMV7wlyNmAYcsd4jNJn4SO1zUrp9\n" +
					"OPEqoBwJnIEY8lQGKDuVTwIDAQABo4IBBDCCAQAwHQYDVR0OBBYEFBpo+epbnauS\n" +
					"K0Rk3W5GpBqOEgkIMIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkI\n" +
					"oYGhpIGeMIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMI\n" +
					"bWV1bGFib2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNV\n" +
					"BAMTC2ZsYW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJl\n" +
					"d2lkaWF0bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjAMBgNVHRMEBTADAQH/MA0G\n" +
					"CSqGSIb3DQEBBQUAA4GBAIKNcR0mlhGCzVX++PMu5mcvrFGZHOWuKruTcDrGsIHO\n" +
					"XFZD9D1ZTuRWiejMpUrbWM//W2rHQRECLlRoN0JzVm4PBaNiE/W+DMwtLamW/Cl2\n" +
					"dHBTKH6mD75PHz/JrhSIpf81nuhOwl9UXVTPGvzpoR8VWwpfIcIX3QByN/ghv2b5\n" +
					"-----END CERTIFICATE-----\n" +
					"</ca>\n" +
					"\n" +
					"<cert>\n" +
					"-----BEGIN CERTIFICATE-----\n" +
					"MIID+jCCA2OgAwIBAgIBAjANBgkqhkiG9w0BAQUFADCBmzELMAkGA1UEBhMCaWQx\n" +
					"DTALBgNVBAgTBGFjZWgxETAPBgNVBAcTCG1ldWxhYm9oMREwDwYDVQQKEwhmbGFt\n" +
					"aW5nbzEMMAoGA1UECxMDZmxhMRQwEgYDVQQDEwtmbGFtaW5nbyBDQTEMMAoGA1UE\n" +
					"KRMDZmxhMSUwIwYJKoZIhvcNAQkBFhZiZXdpZGlhdG1va29AZ21haWwuY29tMB4X\n" +
					"DTE1MDkxMjA4MzgyNloXDTI1MDkwOTA4MzgyNlowgZMxCzAJBgNVBAYTAmlkMQ0w\n" +
					"CwYDVQQIEwRhY2VoMREwDwYDVQQHEwhtZXVsYWJvaDERMA8GA1UEChMIZmxhbWlu\n" +
					"Z28xDDAKBgNVBAsTA2ZsYTEMMAoGA1UEAxMDYWt1MQwwCgYDVQQpEwNmbGExJTAj\n" +
					"BgkqhkiG9w0BCQEWFmJld2lkaWF0bW9rb0BnbWFpbC5jb20wgZ8wDQYJKoZIhvcN\n" +
					"AQEBBQADgY0AMIGJAoGBAN9ptJg0uzmX2iUoSNAnYcJwPge/1pouRxzymer8pe6m\n" +
					"EoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwUUlrau3A4Ls+rDP7/C3mKVWxKbJSW\n" +
					"7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6DyJUAboYkptYugQLJBQIZdK7Va9P\n" +
					"AgMBAAGjggFSMIIBTjAJBgNVHRMEAjAAMC0GCWCGSAGG+EIBDQQgFh5FYXN5LVJT\n" +
					"QSBHZW5lcmF0ZWQgQ2VydGlmaWNhdGUwHQYDVR0OBBYEFFVThNIU5MnEGMYLXLwE\n" +
					"Vfk2u8B3MIHQBgNVHSMEgcgwgcWAFBpo+epbnauSK0Rk3W5GpBqOEgkIoYGhpIGe\n" +
					"MIGbMQswCQYDVQQGEwJpZDENMAsGA1UECBMEYWNlaDERMA8GA1UEBxMIbWV1bGFi\n" +
					"b2gxETAPBgNVBAoTCGZsYW1pbmdvMQwwCgYDVQQLEwNmbGExFDASBgNVBAMTC2Zs\n" +
					"YW1pbmdvIENBMQwwCgYDVQQpEwNmbGExJTAjBgkqhkiG9w0BCQEWFmJld2lkaWF0\n" +
					"bW9rb0BnbWFpbC5jb22CCQDhIky3AZ/GBjATBgNVHSUEDDAKBggrBgEFBQcDAjAL\n" +
					"BgNVHQ8EBAMCB4AwDQYJKoZIhvcNAQEFBQADgYEAAMmvZ/q1UyfiZottoSQPN0HX\n" +
					"R7RoPUDWCecvLWsVxda8+n+xVzB1HE6aIFnedET+HaGWgpK4itTb+mNH9YSBzUQf\n" +
					"lca7hHe1h41XzXPdOgZpqk8mmWNFBR9csdYRNezkstoH+ffquWmaq7Ir/Ez0JLGr\n" +
					"Gn6qRDd319th3hiqyxk=\n" +
					"-----END CERTIFICATE-----\n" +
					"</cert>\n" +
					"\n" +
					"<key>\n" +
					"-----BEGIN PRIVATE KEY-----\n" +
					"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAN9ptJg0uzmX2iUo\n" +
					"SNAnYcJwPge/1pouRxzymer8pe6mEoGNDJ1EyYvnZSnvHoMJAeK3v18GnCaP/GwU\n" +
					"Ulrau3A4Ls+rDP7/C3mKVWxKbJSW7qZP+Odu8JuDSkOcy9EWWcGyP0K6U3qNjKg6\n" +
					"DyJUAboYkptYugQLJBQIZdK7Va9PAgMBAAECgYAxoYr0ESrShZB5lrRuQYFvL34o\n" +
					"PI7RG5zCqoZU9KFsHcqYqxv1SBW6FcKciTlvBK49jnJeCtrfmjcKT41oD5V500wg\n" +
					"8iCR/O24jYhw9H9lxyAkbPh8k08h2kew8lMuHW3mExRD1Uze4Kofzo1cq1n+lRQe\n" +
					"7kk5N9xfQLcobh3T0QJBAPML2dHCCUZPGDKinV8yiLmEzXRqWF0nkc8L0Ay7hiFg\n" +
					"yVsN0IIKhj6hJaKzFcAD9may4BmN5fgGwCeuvRmsi0kCQQDrUfmE72HeprnxJp9/\n" +
					"NE8qcuAZoOyVMWBU01z3roUl49NhVTr60V1ubgZr306XkRBJrbkzLXZpzx0ab1u7\n" +
					"ig3XAkEA525gclkmxblpHEY2PkD7alRn4zOkgse8EwB3krg556ym77o+0qU84YRH\n" +
					"Nx76VgYv6ejodczlr4CWFvNQA5OGaQJBAKzmgVh8bsOiazLVtxFGxPgiiagrBkmk\n" +
					"iuwolMFjmG87kz+L2RcbJ/QQoWU3IU7aBkasf0wsFjouNGsM8TC9gecCQDyX9E47\n" +
					"J8sEL6BzRcH7xPiVAUJx3esnftRB+Rp6r6aEHNgDGzlQig+cEptOrwN9lijlL8R5\n" +
					"NcrJQ+uYTggx2pU=\n" +
					"-----END PRIVATE KEY-----\n" +
					"</key>\n";

			if (retVal != null && retVal.trim().length()>0) {

				byte[] buffer = retVal.getBytes() ;

				VpnProfile vp = saveProfile(buffer) ;

				if (vp != null) {
					startVPN(vp) ;
				}
			}
			else {
				int duration = Toast.LENGTH_LONG;
				Toast toast = Toast.makeText(MainActivity_vpn.this,"Connecting using the last vpn configuration", duration);
				toast.show();
				startVPN();
			}


		} catch (Exception e) {
			e.printStackTrace() ;
		}
	}


	private VpnProfile saveProfile(byte [] data) {

		ConfigParser cp = new ConfigParser();
		try {

			InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(data));

			cp.parseConfig(isr);
			VpnProfile vp = cp.convertProfile();

			ProfileManager vpl = ProfileManager.getInstance(this);

			vp.mName = Constants.VPN_PROFILE_NAME ;
			vpl.addProfile(vp);
			vpl.saveProfile(this, vp);
			vpl.saveProfileList(this);

			return vp ;
		} catch(Exception e) {
			return null ;
		}
	}

	public void startVPN(VpnProfile vp) {

		Intent intent = new Intent(getApplicationContext(),LaunchVPN.class);
		intent.putExtra(LaunchVPN.EXTRA_KEY, vp.getUUID().toString());
		intent.setAction(Intent.ACTION_MAIN);
		startActivity(intent);
	}

	private void startVPN() {

		ProfileManager pm = ProfileManager.getInstance(this) ;
		VpnProfile profile = pm.getProfileByName(Constants.VPN_PROFILE_NAME) ;

		if (profile == null) {
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(MainActivity_vpn.this,"There are no VPN Configurations.So paste the .OVPN and try", duration);
			toast.show();
			return ;
		}

		Intent intent = new Intent(this,LaunchVPN.class);
		intent.putExtra(LaunchVPN.EXTRA_KEY, profile.getUUID().toString());
		intent.setAction(Intent.ACTION_MAIN);
		startActivity(intent);
	}


	BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			stopVPN();
			startVPN();
		}
	};




	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(broadcastReceiver);
	}
}
