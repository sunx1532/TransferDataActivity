package com.jikexueyuan.transferdataactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnGetMsg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGetMsg = new Intent(MainActivity.this, MessageInputActivity.class);

                startActivityForResult(intentGetMsg,1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            switch (resultCode){
                case RESULT_OK:

                    String str = data.getStringExtra("Msg");

                    if (str != null){

                        TextView tvShow = (TextView) findViewById(R.id.tvMsg);

                        tvShow.setText("您今天的愿望是:" + str);
                    }

                    break;
                case RESULT_CANCELED:
                    Toast.makeText(MainActivity.this, "您取消了许愿操作", Toast.LENGTH_SHORT).show();
                    break;
            }
    }
}
