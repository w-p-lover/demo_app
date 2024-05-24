package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void buttonsave_Click(View view) {
        getUserName = (EditText) findViewById(R.id.editUserName);
        getUserPassword = (EditText) findViewById(R.id.editPassword);
        getUserTel = (EditText) findViewById(R.id.editTel);
        getUserEmail = (EditText) findViewById(R.id.editEmail);
        getUserSex = (Spinner) findViewById(R.id.choosesex);
        
        SharedPreferences pref = getSharedPreferences("user_info",MODE_PRIVATE);
        SharedPreferences.Editor editor =pref.edit();
        editor.putString("username",getUserName.getText().toString());
        editor.putString("userpassword",getUserPassword.getText().toString());
        editor.putString("usertel",getUserTel.getText().toString());
        editor.putString("useremail",getUserEmail.getText().toString());
        editor.putString("usersex",getUserSex.getSelectedItem().toString());
        editor.apply();
        Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_LONG).show();
    }
 
    public void buttonread__Click(View view)
    {
        getUserName = (EditText) findViewById(R.id.editUserName);
        getUserPassword = (EditText) findViewById(R.id.editPassword);
        getUserTel = (EditText) findViewById(R.id.editTel);
        getUserEmail = (EditText) findViewById(R.id.editEmail);
        getUserSex = (Spinner) findViewById(R.id.choosesex);
 
        SharedPreferences pref = getSharedPreferences("user_info",MODE_PRIVATE);
        getUserName.setText(pref.getString("username",""));
        getUserPassword.setText(pref.getString("userpassword",""));
        getUserTel.setText(pref.getString("usertel",""));
        getUserEmail.setText(pref.getString("useremail",""));
        SpinnerAdapter spAdapter = getUserSex.getAdapter();
        int k = spAdapter.getCount();
        for (int i=0;i<k;i++)
        {
            if(pref.getString("usersex","").equals(spAdapter.getItem(i)))
            {
                getUserSex.setSelection(i);
                break;
            }
        }
        Toast.makeText(MainActivity.this,"读取成功",Toast.LENGTH_LONG).show();
    }
 
    public void buttonclean__Click(View view)
    {
        getUserName = (EditText) findViewById(R.id.editUserName);
        getUserPassword = (EditText) findViewById(R.id.editPassword);
        getUserTel = (EditText) findViewById(R.id.editTel);
        getUserEmail = (EditText) findViewById(R.id.editEmail);
        getUserSex = (Spinner) findViewById(R.id.choosesex);
 
        getUserSex.setSelection(0);
        getUserName.setText("");
        getUserPassword.setText("");
        getUserEmail.setText("");
        getUserTel.setText("");
        Toast.makeText(MainActivity.this,"清空成功",Toast.LENGTH_LONG).show();
    }
}
