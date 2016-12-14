package com.whackyard.bankbuddy;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SearchMicrActivity extends AppCompatActivity {

    private String URL_MICR;
    private RequestQueue requestQueue;
    private Button btnValidateMicr;
    private EditText mMicr;
    private ProgressDialog progressDialog;
    private CardView mCvBranch;
    private CardView mCvIfscDetails;
    private LinearLayout mButtons;

    private TextView mBranch;
    private TextView mBank;
    private TextView mState;
    private TextView mIfscCode;
    private TextView mContact;
    private TextView mAddress;
    private TextView mCity;
    private TextView mDistrict;

    private String STATE;
    private String BANK;
    private String BRANCH;
    private String CONTACT;
    private String ADDRESS;
    private String CITY;
    private String DISTRICT;
    private String IFSC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_micr);

        btnValidateMicr = (Button) findViewById(R.id.btnValidateMicr);
        mMicr = (EditText) findViewById(R.id.etMicr);
        requestQueue = Volley.newRequestQueue(this);

        mBranch = (TextView) findViewById(R.id.tvBranchMicr);
        mBank = (TextView) findViewById(R.id.tvBankMicr);
        mState = (TextView) findViewById(R.id.tvStateMicr);
        mIfscCode = (TextView) findViewById(R.id.tvMicrMicr);
        mContact = (TextView) findViewById(R.id.tvContactMicr);
        mAddress = (TextView) findViewById(R.id.tvAddressMicr);
        mCity = (TextView) findViewById(R.id.tvCityMicr);
        mDistrict = (TextView) findViewById(R.id.tvDistrictMicr);

        mCvIfscDetails = (CardView) findViewById(R.id.MicrDetails);
        mCvBranch = (CardView) findViewById(R.id.branchMicr);
        mButtons = (LinearLayout) findViewById(R.id.llButtonsMicr);

        btnValidateMicr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ed_text = mMicr.getText().toString().trim();

                if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
                {
                    mMicr.setError("Enter the MICR Code");
                }
                else
                {
                    getDetails();
                    mCvIfscDetails.setVisibility(View.VISIBLE);
                    mCvBranch.setVisibility(View.VISIBLE);
                    mButtons.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void getDetails(){
        String micrCode = mMicr.getText().toString().toUpperCase();
        URL_MICR = "http://api.techm.co.in/api/v1/micr/"+micrCode;

        progressDialog = new ProgressDialog(this);
        //progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading Details \n\n Please wait...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(URL_MICR,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject bank = null;
                        hidePDialog();
                        try {
                            bank = new JSONObject(response);
                            JSONObject bankData = bank.getJSONObject("data");

                            ADDRESS = bankData.getString("ADDRESS");
                            BANK = bankData.getString("BANK");
                            STATE = bankData.getString("STATE");
                            BRANCH = bankData.getString("BRANCH");
                            CONTACT = bankData.getString("CONTACT");
                            CITY = bankData.getString("CITY");
                            DISTRICT = bankData.getString("DISTRICT");
                            IFSC = bankData.getString("IFSC");

                            mBranch.setText(BRANCH);
                            mBank.setText(BANK);
                            mState.setText(STATE);
                            mIfscCode.setText(IFSC);
                            mContact.setText(CONTACT);
                            mAddress.setText(ADDRESS);
                            mCity.setText(CITY);
                            mDistrict.setText(DISTRICT);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}

