package com.whackyard.bankbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NavigatorActivity extends AppCompatActivity {

    private Button mGetIfsc;
    private Button mValidateIfsc;
    private Button mSearchByMicr;
    private Button mHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);

        mGetIfsc = (Button) findViewById(R.id.btnGetIfsc);
        mValidateIfsc = (Button) findViewById(R.id.btnValidateIfsc);
        mSearchByMicr = (Button) findViewById(R.id.btnMicr);
        mHistory =(Button) findViewById(R.id.btnSearchHistory);

        mGetIfsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent findIfsc = new Intent(getBaseContext(), MainActivity.class);
                startActivity(findIfsc);
            }
        });

        mValidateIfsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent validateIfsc = new Intent(getBaseContext(), ValidateIfscActivity.class);
                startActivity(validateIfsc);
            }
        });

        mSearchByMicr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent validateMicr = new Intent(getBaseContext(), SearchMicrActivity.class);
                startActivity(validateMicr);
            }
        });

        mHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent history = new Intent(getBaseContext(), SearchHistoryActivity.class);
                startActivity(history);
            }
        });
    }

}
