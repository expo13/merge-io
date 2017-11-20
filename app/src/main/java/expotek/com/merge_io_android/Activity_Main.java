package expotek.com.merge_io_android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import expotek.com.merge_io_android.io.WifiReceiver;


public class Activity_Main extends Activity {

    private IntentFilter mIntentFilter;
    private WifiP2pManager mManager;
    private WifiP2pManager.Channel mChannel;
    private BroadcastReceiver mReceiver;
    private Button button_test;
    Context context = this.getApplicationContext();
    String host;
    int port;
    int len;
    Socket socket = new Socket();
    byte buf[]  = new byte[1024];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

        button_test = (Button) findViewById(R.id.activity_main_button_test);

        initializeWifi();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.activity_main_button_test:
                    printToast();
                break;
            }
        }
    };

    private void initializeWifi() {
        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), null);
        mReceiver = new WifiReceiver(mManager, mChannel, this);

        mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {
                Log.i("discoverPeers", "FOUND PEERS!");
            }

            @Override
            public void onFailure(int reasonCode) {

            }
        });
    }

    private void printToast(){
        Toast.makeText(this, getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);


    }
    /* unregister the broadcast receiver */
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }

    private String getMessage() {

        try {
            /**
             * Create a client socket with the host,
             * port, and timeout information.
             */
            port = 8080;
            socket.bind(null);
            socket.connect((new InetSocketAddress(host, port)), 500);

            /**
             * Create a byte stream from a JPEG file and pipe it to the output stream
             * of the socket. This data will be retrieved by the server device.
             */
            OutputStream outputStream = socket.getOutputStream();
            ContentResolver cr = context.getContentResolver();
            InputStream inputStream = null;
            String s = "Hello Server!";
            inputStream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8.name()));
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            //catch logic
        } catch (IOException e) {
            //catch logic
        }
        finally {
            if (socket != null) {
                if (socket.isConnected()) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        //catch logic
                    }
                }
            }
        }
        return "Some Sort of Success";
    }



}

