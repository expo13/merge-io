package expotek.com.merge_io_android.io;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.File;
import java.nio.charset.StandardCharsets;

public class RetrieveTestOutput extends AsyncTask {

    private Context context;
    private TextView statusText;

    String host;
    int port;
    int len;
    Socket socket = new Socket();
    byte buf[]  = new byte[1024];


    public RetrieveTestOutput(Context context) {
        this.context = context;

    }

    @Override
    protected String doInBackground(Object[] objects) {
        return getMessage();
    }

    private String getMessage() {

        try {
            /**
             * Create a client socket with the host,
             * port, and timeout information.
             */
            Log.d("getMessage","TRYING");
            port = 8080;
            host = "b8:e8:56:32:5f:30";
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
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
        Log.d("async task", "We've returned a message!");
        return "Some Sort of Success";
    }
}
