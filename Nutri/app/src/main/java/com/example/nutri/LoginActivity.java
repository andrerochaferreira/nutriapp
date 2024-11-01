package com.example.nutri;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonLogin = findViewById(R.id.buttonLogin);
        String qrCodeData = getIntent().getStringExtra("qr_code_data");
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();

                // Validar se os campos estão preenchidos
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(LoginActivity.this, "Por favor, insira seu nome", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(LoginActivity.this, "Por favor, insira um e-mail válido", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Se a validação passar, redirecionar para a próxima tela
                Intent intent = new Intent(LoginActivity.this, EscolhaRefeicaoActivity.class);
                startActivity(intent);
            }
        });
    }
}