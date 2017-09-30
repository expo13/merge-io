package expotek.com.merge_io_android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Main extends Activity {


    private Button button_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_test = (Button) findViewById(R.id.activity_main_button_test);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.activity_main_button_test:
                    sendWifiMessage();
                break;
            }
        }
    };

    private boolean sendWifiMessage(){
        boolean success;

        return success;
    }
}
