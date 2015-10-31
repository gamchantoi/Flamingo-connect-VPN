package com.openvpn.Durai;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.os.IBinder;

import com.openvpn.Durai.core.OpenVPNService;
import com.openvpn.Durai.core.ProfileManager;


public class DisconnectVPN extends Activity implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
    protected OpenVPNService mService;

    private ServiceConnection mConnection = new ServiceConnection() {


        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            OpenVPNService.LocalBinder binder = (OpenVPNService.LocalBinder) service;
            mService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mService =null;
        }

    };

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, OpenVPNService.class);
        intent.setAction(OpenVPNService.START_SERVICE);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        showDisconnectDialog();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(mConnection);
    }

    //    if (getIntent() !=null && OpenVpnService.DISCONNECT_VPN.equals(getIntent().getAction()))

  //      setIntent(null);

        /*
        @Override
        protected void onNewIntent(Intent intent) {
            super.onNewIntent(intent);
            setIntent(intent);
        }
     */

    private void showDisconnectDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(com.openvpn.Durai.R.string.title_cancel);
        builder.setMessage(com.openvpn.Durai.R.string.cancel_connection_query);
        builder.setNegativeButton(android.R.string.no, this);
        builder.setPositiveButton(android.R.string.yes,this);
        builder.setOnCancelListener(this);

        builder.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            ProfileManager.setConntectedVpnProfileDisconnected(this);
            if (mService != null && mService.getManagement() != null)
                mService.getManagement().stopVPN();
        }
        finish();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        finish();
    }
}
