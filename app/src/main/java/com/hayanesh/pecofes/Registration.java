package com.hayanesh.pecofes;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.opengl.Visibility;
import android.os.AsyncTask;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;
import butterknife.Bind;
import butterknife.ButterKnife;

public class Registration extends MainActivity{
    GMailSender sender;
    private static final String TAG = "SignupActivity";

    @Bind(R.id.input_name) EditText _nameText;
    @Bind(R.id.input_email) EditText _emailText;
    @Bind(R.id.input_number) EditText _numberText;
    @Bind(R.id.btn_signup) Button _signupButton;
    @Bind(R.id.switch1) Switch _switch;
    @Bind(R.id.team) LinearLayout _team;
    CoordinatorLayout coordinatorLayout;
    String name,email,phone_num,message;
    MaterialBetterSpinner materialDesignSpinner;
    Snackbar snackbar;
    String[] events;
    String event,team="NIL";
    static int position;
    static int editview_counter = 0;
    final int N = 10; // total number of textviews to add
    final EditText[] myTextViews = new EditText[N];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout r = (RelativeLayout)findViewById(R.id.test);
        r.setVisibility(RelativeLayout.GONE);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_registration, null, false);
        drawer.addView(contentView, 0);
        ButterKnife.bind(this);

        sender = new GMailSender("pecofes16@gmail.com", "pecian16");

        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinatorlayout);
        snackbar = Snackbar.make(coordinatorLayout,"Registraion Successful",Snackbar.LENGTH_LONG);
        View sb = snackbar.getView();
        TextView tw= (TextView)sb.findViewById(android.support.design.R.id.snackbar_text);
        tw.setTextColor(Color.YELLOW);

        events = getResources().getStringArray(R.array.event_array);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,events);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        materialDesignSpinner = (MaterialBetterSpinner)
                findViewById(R.id.events_name);
        materialDesignSpinner.setAdapter(arrayAdapter);


        _switch.setChecked(false);
        _switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked)
                {
                    _team.setVisibility(LinearLayout.VISIBLE);
                    _team.removeAllViews();
                     EditText rowTextView = new EditText(Registration.this);
                     rowTextView.setHint("Team members name");
                    _team.addView(rowTextView);
                    myTextViews[editview_counter]=rowTextView;
                    myTextViews[editview_counter].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View view, boolean b) {
                            ++editview_counter;
                            EditText rowTextView = new EditText(Registration.this);
                            _team.addView(rowTextView);
                            myTextViews[editview_counter]=rowTextView;
                        }
                    });
                }
                else
                {
                    _team.setVisibility(LinearLayout.GONE);
                    editview_counter=0;
                }

            }
        });

        materialDesignSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = adapterView.getSelectedItemPosition();
                System.out.println(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isNetworkConnected()){
                if (validate()) {
                    message = "Event Name:" + event + "\n" + "Name: " + name + "\n" + "Email: " + email + "\n" + "Phone Number: " + phone_num+"\n"+"Team: "+estimateTeam();;
                    try {
                        new MyAsyncClass().execute();
                    } catch (Exception e) {
                        Log.e("Message", e.toString());
                    }
                }}
                else
                {
                    snackbar.setText("No Internet connection!");
                    snackbar.show();
                }

            }

        });

    }
    private String estimateTeam()
    {
        String[] t = new String[10];
        StringBuffer stringBuffer = new StringBuffer();
        if(editview_counter>0){
            for(int i=0;i<editview_counter;i++)
            {
                t[i]=myTextViews[i].getText().toString();
                stringBuffer.append(t[i]+"\n");
            }
            team = stringBuffer.toString();
        }
        return team;
    }
    private boolean isNetworkConnected(){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    class MyAsyncClass extends AsyncTask<Void, Void, Void> {

        final ProgressDialog progressDialog = new ProgressDialog(Registration.this,
                R.style.AppTheme_Dark_Dialog);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Please wait...");
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... mApi) {
            try {
                // Add subject, Body, your mail Id, and receiver mail Id.
                sender.sendMail("Registeration Details", message,email, "pecofes2k16@gmail.com");
            }

            catch (Exception ex) {
                Log.e("Message Failde", ex.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            snackbar.show();

        }
    }


    public boolean validate() {
        boolean valid = true;

        name = _nameText.getText().toString();
        email = _emailText.getText().toString();
        phone_num = _numberText.getText().toString();
        event = materialDesignSpinner.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (phone_num.isEmpty()) {
            _numberText.setError("enter a valid phone number");
            valid = false;
        } else {
            _numberText.setError(null);
        }

        return valid;
    }
}
