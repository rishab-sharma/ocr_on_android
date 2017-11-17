package com.example.harshit.signature8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultdata;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        resultdata = (TextView)findViewById(R.id.resultdata);
        resultdata.setText(getIntent().getStringExtra("Result"));


        button = (Button)findViewById(R.id.backbutton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent tabi=new Intent(getApplicationContext(),SignatureActivity.class);
        tabi.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(tabi);
    }
}
