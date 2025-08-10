package com.ritesh.contactsharing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editName, editPhone, editEmail;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        editEmail = findViewById(R.id.editEmail);
        btn = findViewById(R.id.btnShare);

        btn.setOnClickListener((v) -> {
            String name = editName.getText().toString();
            String phone = editPhone.getText().toString();
            String email = editEmail.getText().toString();

//            Intent i = new Intent(this, ConfirmationActivity.class);
//            i.putExtra("username", name);
//            i.putExtra("phone", phone);
//            i.putExtra("email", email);
//            startActivity(i);
            String message = "Name: "+ name +"\nphone: " + phone +"\nemail"+email;
            Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT,message);
            startActivity(Intent.createChooser(i,"share contect via"));
        });
    }
}
