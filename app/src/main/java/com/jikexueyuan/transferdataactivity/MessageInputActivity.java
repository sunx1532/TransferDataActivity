package com.jikexueyuan.transferdataactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MessageInputActivity extends Activity implements View.OnClickListener {

    private String etData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_input);

        findViewById(R.id.btnOk).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOk:

                etData = ((EditText) findViewById(R.id.etMsgInput)).getText().toString();

                Intent intentOk = new Intent(MessageInputActivity.this, MainActivity.class);

                intentOk.putExtra("Msg",etData);

                MessageInputActivity.this.setResult(RESULT_OK,intentOk);

                MessageInputActivity.this.finish();

                break;
            case R.id.btnCancel:

                Intent intentCancel = new Intent(MessageInputActivity.this, MainActivity.class);

                intentCancel.putExtra("Cancel",true);

                MessageInputActivity.this.setResult(RESULT_CANCELED,intentCancel);

                MessageInputActivity.this.finish();

                break;

        }
    }
}
