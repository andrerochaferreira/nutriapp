package com.example.nutri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText editTextNome;
    private EditText editTextEmail;
    private Button buttonLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);  // Certifique-se de que o layout está correto

        editTextNome = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                Intent intent = new Intent(MainActivity.this, EscolhaRefeicaoActivity.class);
                startActivity(intent);
                finish(); // Finaliza a atividade de login

                // Aqui você pode validar os campos, se necessário
                if (!nome.isEmpty() && !email.isEmpty()) {
                    // Iniciar a atividade de escolha de refeição
                    intent = new Intent(MainActivity.this, EscolhaRefeicaoActivity.class);
                    startActivity(intent);
                } else {
                    // Mensagem de erro se algum campo estiver vazio
                    Toast.makeText(MainActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}