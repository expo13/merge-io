package expotek.com.merge_io_android.io;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.PeerListListener;
import android.util.Log;

import expotek.com.merge_io_android.R;

/**
 * A BroadcastReceiver that notifies of important wifi p2p events.
 */
public class WifiReceiver extends BroadcastReceiver {
    private WifiP2pManager manager;
    private Channel channel;
    private Activity activity;
    private PeerListListener myPeerListListener;
    private final String macAddress = "b8:e8:56:32:5f:30";

    WifiP2pDevice device;
    WifiP2pConfig config = new WifiP2pConfig();

    /**
     * @param manager WifiP2pManager system service
     * @param channel Wifi p2p channel
     * @param activity activity associated with the receiver
     */
    public WifiReceiver(WifiP2pManager manager, Channel channel, Activity activity) {
        super();
        this.manager = manager;
        this.channel = channel;
        this.activity = activity;
    }
    /*
     * (non-Javadoc)
     * @see android.content.BroadcastReceiver#onReceive(android.content.Context,
     * android.content.Intent)
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {

            // Check to see if Wi-Fi is enabled and notify appropriate activity

            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
            if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
                // Wifi P2P is enabled
            } else {
                // Wi-Fi P2P is not enabled
            }

            if (manager != null) {
                manager.requestPeers(channel, myPeerListListener);
            }

            device.deviceAddress=macAddress;
            device.deviceName="Craig's Phone";
            config.deviceAddress = device.deviceAddress;

            manager.connect(channel, config, new WifiP2pManager.ActionListener() {

                @Override
                public void onSuccess() {
                    Log.i("Connect", "Connection!");
                }

                @Override
                public void onFailure(int reason) {
                    //failure logic
                }
            });


        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
            // Call WifiP2pManager.requestPeers() to get a list of current peers
        } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
            // Respond to new connection or disconnections
        } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
            // Respond to this device's wifi state changing
        }

//        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
//            // UI update to indicate wifi p2p status.
//            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
//            if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
//                // Wifi Direct mode is enabled
////                activity.setIsWifiP2pEnabled(true);
//                Log.d("DEV", "WifiP2pEnabled");
//            } else {
////                activity.setIsWifiP2pEnabled(false);
////                activity.resetData();
//                Log.d("DEV", "WifiP2pDisabled");
//            }
////            Log.d(Activity.TAG, "P2P state changed - " + state);
//        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
//            // request available peers from the wifi p2p manager. This is an
//            // asynchronous call and the calling activity is notified with a
//            // callback on PeerListListener.onPeersAvailable()
//            if (manager != null) {
////                manager.requestPeers(channel, (PeerListListener) activity.getFragmentManager()
////                        .findFragmentById(R.id.frag_list));
//            }
////            Log.d(WiFiDirectActivity.TAG, "P2P peers changed");
//        } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
//            if (manager == null) {
//                return;
//            }
//            NetworkInfo networkInfo = (NetworkInfo) intent
//                    .getParcelableExtra(WifiP2pManager.EXTRA_NETWORK_INFO);
//            if (networkInfo.isConnected()) {
//                // we are connected with the other device, request connection
//                // info to find group owner IP
////                DeviceDetailFragment fragment = (DeviceDetailFragment) activity
////                        .getFragmentManager().findFragmentById(R.id.frag_detail);
////                manager.requestConnectionInfo(channel, fragment);
//            } else {
//                // It's a disconnect
////                activity.resetData();
//            }
//        } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
////            DeviceListFragment fragment = (DeviceListFragment) activity.getFragmentManager()
////                    .findFragmentById(R.id.frag_list);
////            fragment.updateThisDevice((WifiP2pDevice) intent.getParcelableExtra(
////                    WifiP2pManager.EXTRA_WIFI_P2P_DEVICE));
        }

    }

