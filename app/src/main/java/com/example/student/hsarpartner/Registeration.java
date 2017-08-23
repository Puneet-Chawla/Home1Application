package com.example.student.hsarpartner;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registeration extends AppCompatActivity {
    private static final String TAG = "Registeration";
    String id,title,Username,Address,Phone,Aadhar,Scope;
    TextView Title;
    EditText username,address,phone,aadhar,scope;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        getSupportActionBar().setTitle("Fill in Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        String stuff = bundle.getString("stuff");
        checkstuff(stuff);
        databaseReference= FirebaseDatabase.getInstance().getReference("partnerinfo").child(title);
        scope=(EditText)findViewById(R.id.scope);
        aadhar=(EditText)findViewById(R.id.aadhar);
        address=(EditText)findViewById(R.id.address);
        phone=(EditText)findViewById(R.id.phone);
        username=(EditText)findViewById(R.id.username);
        Title=(TextView)findViewById(R.id.title1);
        Title.setText(title);

    }
    public void checkstuff(String v)
    {
        switch(v)
        {
            case "0":
                title="Electrical";
                break;

            case "1":
                title="Plumber";
                break;

            case "2":
                title="AC Technician";
                break;

            case "3":
                title="RO";
                break;

            case "4":
                title="Electronics";
                break;

            case "5":
                title="Carpenter";
                break;

            case "6":
                title="Painter";
                break;

            case "7":
                title="Computer and Accessories";
                break;

            case "8":
                title="Packers and Movers";
                break;

            case "9":
                title="Refrigerator";
                break;
        }
    }

    public void signup(View v)
    {
        if(username.length()<=5)
        {
            Toast.makeText(this,"Enter atleast 6 characters",Toast.LENGTH_SHORT).show();
            username.setError("min 6 characters");
        }
        else if(address.length()==0)
        {
            Toast.makeText(this,"Enter your address",Toast.LENGTH_SHORT).show();
            address.setError("enter address");
        }
        else if(!(phone.length()==10))
        {
            Toast.makeText(this,"Enter 10 digit mobile number",Toast.LENGTH_SHORT).show();
            phone.setError("10 digit number");
        }
        else if(scope.length()==0)
        {
            Toast.makeText(this,"type in your work",Toast.LENGTH_SHORT).show();
            scope.setError("required");

        }
        else
        {
            Username=username.getText().toString();
            Address=address.getText().toString();
            Phone=phone.getText().toString();
            Aadhar=aadhar.getText().toString();
            Scope=scope.getText().toString();
            sendingData();

        }}
        public void sendingData()
        {
             id=databaseReference.push().getKey();
// String aadhar, String address, String phone, String scope, String title, String username
            RegisterModel registerModel=new RegisterModel(Aadhar,Address,Phone,Scope,title,Username);
            databaseReference.child(id).setValue(registerModel);
            Toast.makeText(this,"sending request...",Toast.LENGTH_SHORT).show();
            Empty();
        }
        public void Empty()

        {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("You will notified as suitable work is available \n your member id is"+id);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "GOT IT",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
            username.setText(" ");
            address.setText(" ");
            phone.setText(" ");
            aadhar.setText(" ");
            scope.setText(" ");
        }

    public ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("Member id is"+id);
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id==android.R.id.home) {
            finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
