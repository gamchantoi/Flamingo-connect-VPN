package com.openvpn.Durai;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.VpnService;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.openvpn.Durai.core.ProfileManager;
import com.openvpn.Durai.core.VPNLaunchHelper;
import com.openvpn.Durai.core.VpnStatus;
import com.openvpn.Durai.core.VpnStatus.ConnectionStatus;
import android.widget.CheckBox;         // <--- Add
import android.content.SharedPreferences;   // <--- Add
import android.widget.EditText; // <--- Add

/**
 * This Activity actually handles two stages of a launcher shortcut's life cycle.
 * 
 * 1. Your application offers to provide shortcuts to the launcher.  When
 *    the user installs a shortcut, an activity within your application
 *    generates the actual shortcut and returns it to the launcher, where it
 *    is shown to the user as an icon.
 *
 * 2. Any time the user clicks on an installed shortcut, an intent is sent.
 *    Typically this would then be handled as necessary by an activity within
 *    your application.
 *    
 * We handle stage 1 (creating a shortcut) by simply sending back the information (in the form
 * of an {@link android.content.Intent} that the launcher will use to create the shortcut.
 * 
 * You can also implement this in an interactive way, by having your activity actually present
 * UI for the user to select the specific nature of the shortcut, such as a contact, picture, URL,
 * media item, or action.
 * 
 * We handle stage 2 (responding to a shortcut) in this sample by simply displaying the contents
 * of the incoming {@link android.content.Intent}.
 * 
 * In a real application, you would probably use the shortcut intent to display specific content
 * or start a particular operation.
 */
public class LaunchVPN extends Activity {

	public static final String EXTRA_KEY = "com.openvpn.Durai.shortcutProfileUUID";
	public static final String EXTRA_NAME = "com.openvpn.Durai.shortcutProfileName";
	public static final String EXTRA_HIDELOG =  "com.openvpn.Durai.showNoLogWindow";

	private static final int START_VPN_PROFILE= 70;
	//public static android.content.SharedPreferences pref;
	//private static final String PREFER_NAME = null;
	CheckBox chkRememberMe; //      <--- You even not taken CheckBox, SILLY WORKER
	EditText etUserName, etPassword;    //      <--- You even not taken CheckBox,     SILLY WORKER

	// pref;

	// Editor reference for Shared preferences
	SharedPreferences.Editor editor;

	// Context
	Context _context;

	// Shared preferences mode
	int PRIVATE_MODE = 0;
	// Shared preferences file name

	public static final String PREFER_NAME = "Android";



	EditText username,password;
	private ProfileManager mPM;
	private VpnProfile mSelectedProfile;
	private boolean mhideLog=false;
	private MainActivity_vpn ctdata;
	private boolean mCmfixed=false;


	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		ctdata = new MainActivity_vpn();
		mPM =ProfileManager.getInstance(this);


	}

	@Override
	protected void onStart() {
		super.onStart();
		// Resolve the intent

		final Intent intent = getIntent();
		final String action = intent.getAction();

		// If the intent is a request to create a shortcut, we'll do that and exit


		if(Intent.ACTION_MAIN.equals(action)) {
			// we got called to be the starting point, most likely a shortcut
			String shortcutUUID = intent.getStringExtra( EXTRA_KEY);
			String shortcutName = intent.getStringExtra( EXTRA_NAME);
			mhideLog = intent.getBooleanExtra(EXTRA_HIDELOG, false);

			VpnProfile profileToConnect = ProfileManager.get(this,shortcutUUID);
			if(shortcutName != null && profileToConnect ==null)
				profileToConnect = ProfileManager.getInstance(this).getProfileByName(shortcutName);

			if(profileToConnect ==null) {
				VpnStatus.logError(R.string.shortcut_profile_notfound);
				// show Log window to display error
				showLogWindow();
				finish();
				return;
			}

			mSelectedProfile = profileToConnect;
			launchVPN();

		}
	}
	public Set<String> getuser() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(_context);
		return prefs.getStringSet("username", new HashSet<String>());
	}
	public Set<String> getpass() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(_context);
		return prefs.getStringSet("password", new HashSet<String>());
	}

	private void askForPW(final int type) {




		//username = (EditText) findViewById(R.id.username);
		//password = (EditText) findViewById(R.id.password);

		SharedPreferences pref = getSharedPreferences(PREFER_NAME, 0);
			final EditText entry = new EditText(this);
			final View userpwlayout = getLayoutInflater().inflate(R.layout.userpass, null, false);

			entry.setSingleLine();
			entry.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			entry.setTransformationMethod(new PasswordTransformationMethod());
			AlertDialog.Builder dialog = new AlertDialog.Builder(this);
			dialog.setTitle("Need " + getString(type));
			dialog.setMessage("Enter the password for profile " + mSelectedProfile.mName);
			if (type == R.string.password) {


					mSelectedProfile.mUsername = pref.getString("username", "");
					mSelectedProfile.mPassword = pref.getString("password", "");
					onActivityResult(START_VPN_PROFILE, Activity.RESULT_OK, null);


				}

		}



	@Override
	protected void onActivityResult (int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode==START_VPN_PROFILE) {
			if(resultCode == Activity.RESULT_OK) {

					int needpw = mSelectedProfile.needUserPWInput(false);
					if (needpw != 0) {
						VpnStatus.updateStateString("USER_VPN_PASSWORD", "", R.string.state_user_vpn_password,
								ConnectionStatus.LEVEL_WAITING_FOR_USER_INPUT);
						askForPW(needpw);
					} else {
						SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
						boolean showLogWindow = prefs.getBoolean("showlogwindow", true);

						if (!mhideLog && showLogWindow)
							showLogWindow();
						new startOpenVpnThread().start();
					}

			} else if (resultCode == Activity.RESULT_CANCELED) {
				// User does not want us to start, so we just vanish
				VpnStatus.updateStateString("USER_VPN_PERMISSION_CANCELLED", "", R.string.state_user_vpn_permission_cancelled,
                        ConnectionStatus.LEVEL_NOTCONNECTED);

				finish();
			}
		}
	}
	void showLogWindow() {

		//Durai:Hiding LogWindow
//		Intent startLW = new Intent(getBaseContext(),LogWindow.class);
//		startLW.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//		startActivity(startLW);

	}

	void showConfigErrorDialog(int vpnok) {
		AlertDialog.Builder d = new AlertDialog.Builder(this);
		d.setTitle(R.string.config_error_found);
		d.setMessage(vpnok);
		d.setPositiveButton(android.R.string.ok, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();

			}
		});
		d.show();
	}

	void launchVPN () {
		int vpnok = mSelectedProfile.checkProfile(this);
		if(vpnok!= R.string.no_error_found) {
			showConfigErrorDialog(vpnok);
			return;
		}

		Intent intent = VpnService.prepare(this);
		// Check if we want to fix /dev/tun
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);        
		boolean usecm9fix = prefs.getBoolean("useCM9Fix", false);
		boolean loadTunModule = prefs.getBoolean("loadTunModule", false);

		if(loadTunModule)
			execeuteSUcmd("insmod /system/lib/modules/tun.ko");

		if(usecm9fix && !mCmfixed ) {
			execeuteSUcmd("chown system /dev/tun");
		}


		if (intent != null) {
			VpnStatus.updateStateString("USER_VPN_PERMISSION", "", R.string.state_user_vpn_permission,
                    ConnectionStatus.LEVEL_WAITING_FOR_USER_INPUT);
			// Start the query
			try {
				startActivityForResult(intent, START_VPN_PROFILE);
			} catch (ActivityNotFoundException ane) {
				// Shame on you Sony! At least one user reported that 
				// an official Sony Xperia Arc S image triggers this exception
				VpnStatus.logError(R.string.no_vpn_support_image);


				showLogWindow();
			}
		} else {
			onActivityResult(START_VPN_PROFILE, Activity.RESULT_OK, null);
		}

	}

	private void execeuteSUcmd(String command) {
		ProcessBuilder pb = new ProcessBuilder("su","-c",command);
		try {
			Process p = pb.start();
			int ret = p.waitFor();
			if(ret ==0)
				mCmfixed=true;
		} catch (InterruptedException e) {
            VpnStatus.logException("SU command", e);

		} catch (IOException e) {
            VpnStatus.logException("SU command", e);
		}
	}

	private class startOpenVpnThread extends Thread {

		@Override
		public void run() {
			VPNLaunchHelper.startOpenVpn(mSelectedProfile, getBaseContext());
			finish();

		}

	}


}
