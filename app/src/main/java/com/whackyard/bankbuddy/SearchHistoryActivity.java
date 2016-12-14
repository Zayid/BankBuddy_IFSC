package com.whackyard.bankbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class SearchHistoryActivity extends AppCompatActivity {

    private DatabaseHelper db;
    private String [] listName;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_history);

        db = new DatabaseHelper(this);
        final List<Bank> banks = db.getAllContacts();
        listName = new String[banks.size()];

        for (int i = 0; i < listName.length; i++) {
            listName[i] = "Bank : "+(String) banks.get(i).get_bank()+"\n"+ "IFSC : "+ (String) banks.get(i).get_ifsc()
                    +"\n"+ "Address : "+ (String) banks.get(i).get_address()+"\n"+ "Contact : "+ (String) banks.get(i).get_contact()
                    +"\n"+ "Bracnch : "+ (String) banks.get(i).get_branch()+"\n"+ "City : "+ (String) banks.get(i).get_city()
                    + "\n"+"MICR : "+ (String) banks.get(i).get_micr();
        }
        if (listName != null && listName.length > 0 ) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview_bank_row, listName);
            listView = (ListView) findViewById(R.id.lvContactsSql);
            listView.setAdapter(adapter);
        }

    }
}

