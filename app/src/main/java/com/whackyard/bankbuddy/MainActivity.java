package com.whackyard.bankbuddy;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String[] STORED_BANK_LIST = {"- - - - - Select Bank - - - - -","ABHYUDAYA COOPERATIVE BANK LIMITED", "ABU DHABI COMMERCIAL BANK", "AHMEDABAD MERCANTILE COOPERATIVE BANK", "AKOLA JANATA COMMERCIAL COOPERATIVE BANK", "ALLAHABAD BANK", "ALMORA URBAN COOPERATIVE BANK LIMITED", "ANDHRA BANK", "ANDHRA PRAGATHI GRAMEENA BANK", "APNA SAHAKARI BANK LIMITED", "AUSTRALIA AND NEW ZEALAND BANKING GROUP LIMITED", "AXIS BANK", "B N P PARIBAS", "BANDHAN BANK LIMITED", "BANK INTERNASIONAL INDONESIA", "BANK OF AMERICA", "BANK OF BAHARAIN AND KUWAIT BSC", "BANK OF BARODA", "BANK OF CEYLON", "BANK OF INDIA", "BANK OF MAHARASHTRA", "BANK OF TOKYO MITSUBISHI LIMITED", "BARCLAYS BANK", "BASSEIN CATHOLIC COOPERATIVE BANK LIMITED", "BHARAT COOPERATIVE BANK MUMBAI LIMITED", "BHARATIYA MAHILA BANK LIMITED", "CANARA BANK", "CAPITAL LOCAL AREA BANK LIMITED", "CATHOLIC SYRIAN BANK LIMITED", "CENTRAL BANK OF INDIA", "CHINATRUST COMMERCIAL BANK LIMITED", "CITI BANK", "CITIZEN CREDIT COOPERATIVE BANK LIMITED", "CITY UNION BANK LIMITED", "COMMONWEALTH BANK OF AUSTRALIA", "CORPORATION BANK", "CREDIT AGRICOLE CORPORATE AND INVESTMENT BANK CALYON BANK", "CREDIT SUISEE AG", "DCB BANK LIMITED", "DENA BANK", "DEPOSIT INSURANCE AND CREDIT GUARANTEE CORPORATION", "DEUSTCHE BANK", "DEVELOPMENT BANK OF SINGAPORE", "DHANALAKSHMI BANK", "DOHA BANK", "DOHA BANK QSC", "DOMBIVLI NAGARI SAHAKARI BANK LIMITED", "EXPORT IMPORT BANK OF INDIA", "FEDERAL BANK", "FIRSTRAND BANK LIMITED", "G P PARSIK BANK", "GURGAON GRAMIN BANK", "HDFC BANK", "HSBC BANK", "HSBC BANK OMAN SAOG", "ICICI BANK LIMITED", "IDBI BANK", "IDFC BANK LIMITED", "INDIAN BANK", "INDIAN OVERSEAS BANK", "INDUSIND BANK", "INDUSTRIAL AND COMMERCIAL BANK OF CHINA LIMITED", "INDUSTRIAL BANK OF KOREA", "ING VYSYA BANK", "JALGAON JANATA SAHAKARI BANK LIMITED", "JAMMU AND KASHMIR BANK LIMITED", "JANAKALYAN SAHAKARI BANK LIMITED", "JANASEVA SAHAKARI BANK BORIVLI LIMITED", "JANASEVA SAHAKARI BANK LIMITED", "JANATA SAHAKARI BANK LIMITED", "JP MORGAN BANK", "KALLAPPANNA AWADE ICHALKARANJI JANATA SAHAKARI BANK LIMITED", "KALUPUR COMMERCIAL COOPERATIVE BANK", "KALYAN JANATA SAHAKARI BANK", "KAPOL COOPERATIVE BANK LIMITED", "KARNATAKA BANK LIMITED", "KARNATAKA VIKAS GRAMEENA BANK", "KARUR VYSYA BANK", "KERALA GRAMIN BANK", "KOTAK MAHINDRA BANK LIMITED", "LAXMI VILAS BANK", "MAHANAGAR COOPERATIVE BANK", "MAHARASHTRA STATE COOPERATIVE BANK", "MASHREQBANK PSC", "MIZUHO CORPORATE BANK LIMITED", "NAGAR URBAN CO OPERATIVE BANK", "NAGPUR NAGARIK SAHAKARI BANK LIMITED", "NATIONAL AUSTRALIA BANK LIMITED", "NATIONAL BANK OF ABU DHABI PJSC", "NEW INDIA COOPERATIVE BANK LIMITED", "NKGSB COOPERATIVE BANK LIMITED", "NUTAN NAGARIK SAHAKARI BANK LIMITED", "OMAN INTERNATIONAL BANK SAOG", "ORIENTAL BANK OF COMMERCE", "PRAGATHI KRISHNA GRAMIN BANK", "PRATHAMA BANK", "PRIME COOPERATIVE BANK LIMITED", "PUNJAB AND MAHARSHTRA COOPERATIVE BANK", "PUNJAB AND SIND BANK", "PUNJAB NATIONAL BANK", "RABOBANK INTERNATIONAL", "RAJGURUNAGAR SAHAKARI BANK LIMITED", "RAJKOT NAGRIK SAHAKARI BANK LIMITED", "RBL BANK LIMITED", "RESERVE BANK OF INDIA", "SAHEBRAO DESHMUKH COOPERATIVE BANK LIMITED", "SARASWAT COOPERATIVE BANK LIMITED", "SBER BANK", "SBM BANK MAURITIUS LIMITED", "SHIKSHAK SAHAKARI BANK LIMITED", "SHINHAN BANK", "SHRI CHHATRAPATI RAJASHRI SHAHU URBAN COOPERATIVE BANK LIMITED", "SOCIETE GENERALE", "SOLAPUR JANATA SAHAKARI BANK LIMITED", "SOUTH INDIAN BANK", "STANDARD CHARTERED BANK", "STATE BANK OF BIKANER AND JAIPUR", "STATE BANK OF HYDERABAD", "STATE BANK OF INDIA", "STATE BANK OF MAURITIUS LIMITED", "STATE BANK OF MYSORE", "STATE BANK OF PATIALA", "STATE BANK OF TRAVANCORE", "SUMITOMO MITSUI BANKING CORPORATION", "SURAT NATIONAL COOPERATIVE BANK LIMITED", "SUTEX COOPERATIVE BANK LIMITED", "SYNDICATE BANK", "TAMILNAD MERCANTILE BANK LIMITED", "THE A.P. MAHESH COOPERATIVE URBAN BANK LIMITED", "THE AKOLA DISTRICT CENTRAL COOPERATIVE BANK", "THE ANDHRA PRADESH STATE COOPERATIVE BANK LIMITED", "THE BANK OF NOVA SCOTIA", "THE COSMOS CO OPERATIVE BANK LIMITED", "THE DELHI STATE COOPERATIVE BANK LIMITED", "THE GADCHIROLI DISTRICT CENTRAL COOPERATIVE BANK LIMITED", "THE GREATER BOMBAY COOPERATIVE BANK LIMITED", "THE GUJARAT STATE COOPERATIVE BANK LIMITED", "THE HASTI COOP BANK LTD", "THE JALGAON PEOPELS COOPERATIVE BANK LIMITED", "THE KANGRA CENTRAL COOPERATIVE BANK LIMITED", "THE KANGRA COOPERATIVE BANK LIMITED", "THE KARAD URBAN COOPERATIVE BANK LIMITED", "THE KARANATAKA STATE COOPERATIVE APEX BANK LIMITED", "THE KURMANCHAL NAGAR SAHAKARI BANK LIMITED", "THE MEHSANA URBAN COOPERATIVE BANK", "THE MUMBAI DISTRICT CENTRAL COOPERATIVE BANK LIMITED", "THE MUNICIPAL COOPERATIVE BANK LIMITED", "THE NAINITAL BANK LIMITED", "THE NASIK MERCHANTS COOPERATIVE BANK LIMITED", "THE RAJASTHAN STATE COOPERATIVE BANK LIMITED", "THE ROYAL BANK OF SCOTLAND N V", "THE SEVA VIKAS COOPERATIVE BANK LIMITED", "THE SHAMRAO VITHAL COOPERATIVE BANK", "THE SURAT DISTRICT COOPERATIVE BANK LIMITED", "THE SURATH PEOPLES COOPERATIVE BANK LIMITED", "THE TAMIL NADU STATE APEX COOPERATIVE BANK", "THE THANE BHARAT SAHAKARI BANK LIMITED", "THE THANE DISTRICT CENTRAL COOPERATIVE BANK LIMITED", "THE VARACHHA COOPERATIVE BANK LIMITED", "THE VISHWESHWAR SAHAKARI BANK LIMITED", "THE WEST BENGAL STATE COOPERATIVE BANK", "THE ZOROASTRIAN COOPERATIVE BANK LIMITED", "TJSB SAHAKARI BANK LIMITED", "TJSB SAHAKARI BANK LTD", "TUMKUR GRAIN MERCHANTS COOPERATIVE BANK LIMITED", "UCO BANK", "UNION BANK OF INDIA", "UNITED BANK OF INDIA", "UNITED OVERSEAS BANK LIMITED", "VASAI VIKAS SAHAKARI BANK LIMITED", "VIJAYA BANK", "WESTPAC BANKING CORPORATION", "WOORI BANK", "YES BANK", "ZILA SAHAKRI BANK LIMITED GHAZIABAD"};
    private String[] STORED_STATE_LIST = {"- - - - - Select State - - - - -","ANDHRA PRADESH","ARUNACHAL PRADESH", "ASSAM", "BIHAR", "CHANDIGARH", "CHHATTISGARH", "GOA", "GUJARAT", "HARYANA", "HIMACHAL PRADESH", "JAMMU AND KASHMIR", "JHARKHAND", "KARNATAKA", "KERALA","LAKSHADWEEP", "MADHYA PRADESH", "MAHARASHTRA", "MANIPUR", "MEGHALAYA", "MIZORAM", "NAGALAND", "ODISHA", "PUDUCHERRY", "PUNJAB", "RAJASTHAN", "SIKKIM", "TAMIL NADU", "TELANGANA", "TRIPURA", "UTTAR PRADESH", "UTTARAKHAND", "WEST BENGAL"};
    private String[] STORED_DIST_LIST = {"- - - - - Select District - - - -"};
    private String[] STORED_BRANCH_LIST = {"- - - - - Select Branch - - - -"};
    private String myBank;
    private String state;
    private String district;
    private String branch;
    private String URL_STATE;
    private String URL_DISTRICT;
    private String URL_BRANCH;
    private List<String> distList;
    private List<String> branchList;
    private Button mFind;
    private String IFSC;
    private TextView mResultIfsc;
    private CardView mCardIfsc;
    private ImageButton mClipb;
    private LinearLayout mRoot;

    private ClipboardManager myClipboard;
    private ClipData myClip;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        distList = new ArrayList<String>();
        branchList = new ArrayList<String>();
        mFind = (Button) findViewById(R.id.btnFindIfsc);
        mResultIfsc = (TextView) findViewById(R.id.tvResultIfsc);
        mCardIfsc = (CardView) findViewById(R.id.cvIfsc);
        mClipb = (ImageButton) findViewById(R.id.ibClipboard);
        mRoot = (LinearLayout) findViewById(R.id.activity_main);

        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);

        spinnerInflater();

    }

    public void spinnerInflater(){
        Spinner spinnerBank = (Spinner) findViewById(R.id.spBank);
        spinnerBank.setOnItemSelectedListener(this);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, STORED_BANK_LIST);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBank.setAdapter(spinnerArrayAdapter);

        Spinner spinnerState = (Spinner) findViewById(R.id.spState);
        spinnerState.setOnItemSelectedListener(this);

        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, STORED_STATE_LIST);
        spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerState.setAdapter(spinnerArrayAdapter2);

        Spinner spinnerDistrict = (Spinner) findViewById(R.id.spDistrict);
        spinnerDistrict.setOnItemSelectedListener(this);

        ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, STORED_DIST_LIST);
        spinnerArrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDistrict.setAdapter(spinnerArrayAdapter3);

        Spinner spinnerBranch = (Spinner) findViewById(R.id.spBranch);
        spinnerBranch.setOnItemSelectedListener(this);

        ArrayAdapter<String> spinnerArrayAdapter4 = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, STORED_BRANCH_LIST);
        spinnerArrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBranch.setAdapter(spinnerArrayAdapter4);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIfscCode();

                mCardIfsc.setVisibility(View.VISIBLE);

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        mClipb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = mResultIfsc.getText().toString();
                myClip = ClipData.newPlainText("text", text);
                myClipboard.setPrimaryClip(myClip);

                Snackbar snackbar = Snackbar
                        .make(mRoot, "IFSC copied to Clipboard", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        if(spinner.getId() == R.id.spBank)
        {
            myBank = parent.getItemAtPosition(position).toString();
        }
        else if(spinner.getId() == R.id.spState)
        {
            state = parent.getItemAtPosition(position).toString();
            getDistrict();
        }
        else if(spinner.getId() == R.id.spDistrict)
        {
            district = parent.getItemAtPosition(position).toString();
            getBranch();
        }
        else if(spinner.getId() == R.id.spBranch)
        {
            branch = parent.getItemAtPosition(position).toString();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void getDistrict(){
        URL_STATE = "http://api.techm.co.in/api/state/"+state;

        progressDialog = new ProgressDialog(this);
        //progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading Details \n\n Please wait...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(URL_STATE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject bank = null;
                        hidePDialog();
                        try {
                            //Parsing the fetched Json String to JSON Object
                            bank = new JSONObject(response);
                            JSONArray districtList = bank.getJSONArray("data");

                            for(int i = 0; i < districtList.length(); i++){
                                JSONObject dist = districtList.getJSONObject(i);
                                String dBank = dist.getString("BANK");
                                String dState = dist.getString("STATE");
                                if(dBank.equals(myBank) && dState.equals(state)) {
                                    String district = dist.getString("DISTRICT");
                                    distList.add(district);
                                }
                            }

                            String[] distArr = new String[distList.size()];
                            distArr = distList.toArray(distArr);

                            List<String> list = Arrays.asList(distArr);
                            Set<String> set = new HashSet<String>(list);

                            String[] result = new String[set.size()];
                            set.toArray(result);

                            inflateDistSpinner(result);

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

        //Adding request to the queue
        requestQueue.add(stringRequest);

    }

    public void inflateDistSpinner(String[] distArr){
        Spinner spinnerDistrict = (Spinner) findViewById(R.id.spDistrict);
        spinnerDistrict.setOnItemSelectedListener(this);

        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, distArr);
        spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDistrict.setAdapter(spinnerArrayAdapter2);
    }

    public void getBranch(){
        URL_DISTRICT = "http://api.techm.co.in/api/district/"+district;

        progressDialog = new ProgressDialog(this);
        //progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading Details \n\n Please wait...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(URL_STATE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject bank = null;
                        hidePDialog();
                        try {
                            //Parsing the fetched Json String to JSON Object
                            bank = new JSONObject(response);
                            JSONArray districtList = bank.getJSONArray("data");

                            for(int i = 0; i < districtList.length(); i++){
                                JSONObject dist = districtList.getJSONObject(i);
                                String dBank = dist.getString("BANK");
                                String dDistrict = dist.getString("DISTRICT");
                                if(dBank.equals(myBank) && dDistrict.equals(district)){
                                    String dBranch = dist.getString("BRANCH");
                                    branchList.add(dBranch);
                                }
                            }

                            String[] distArr = new String[branchList.size()];
                            distArr = branchList.toArray(distArr);

                            List<String> list = Arrays.asList(distArr);
                            Set<String> set = new HashSet<String>(list);

                            String[] result = new String[set.size()];
                            set.toArray(result);

                            inflateBranchSpinner(result);

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

        //Adding request to the queue
        requestQueue.add(stringRequest);

    }

    public void inflateBranchSpinner(String[] branchArr){
        Spinner spinnerBranch = (Spinner) findViewById(R.id.spBranch);
        spinnerBranch.setOnItemSelectedListener(this);

        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, branchArr);
        spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBranch.setAdapter(spinnerArrayAdapter2);

    }

    public void getIfscCode(){
        URL_BRANCH = "http://api.techm.co.in/api/getbank/"+myBank+"/"+branch;
        //Toast.makeText(getBaseContext(), URL_BRANCH, Toast.LENGTH_LONG).show();

        StringRequest stringRequest = new StringRequest(URL_BRANCH,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject bank = null;
                        hidePDialog();
                        try {
                            //Parsing the fetched Json String to JSON Object
                            bank = new JSONObject(response);
                            JSONObject bankData = bank.getJSONObject("data");

                            IFSC = bankData.getString("IFSC");
                            mResultIfsc.setText(IFSC);

                            /*ADDRESS = bankData.getString("ADDRESS");
                            BANK = bankData.getString("BANK");
                            STATE = bankData.getString("STATE");
                            MICRCODE = bankData.getString("MICRCODE");
                            BRANCH = bankData.getString("BRANCH");
                            CONTACT = bankData.getString("CONTACT");
                            CITY = bankData.getString("CITY");
                            DISTRICT = bankData.getString("DISTRICT");

                            mBranch.setText(BRANCH);
                            mBank.setText(BANK);
                            mState.setText(STATE);
                            mMicrCode.setText(MICRCODE);
                            mContact.setText(CONTACT);
                            mAddress.setText(ADDRESS);
                            mCity.setText(CITY);
                            mDistrict.setText(DISTRICT);*/

                            //Toast.makeText(ValidateIfscActivity.this, URL_IFSC, Toast.LENGTH_LONG).show();
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

        //Adding request to the queue
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
