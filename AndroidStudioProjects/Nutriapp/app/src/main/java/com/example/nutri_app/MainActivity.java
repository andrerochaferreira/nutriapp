package com.example.nutri_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private EditText senha;
    private  EditText confirm;
    private Button cadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editTextText5);
        email = findViewById(R.id.editTextText6);
        senha = findViewById(R.id.editTextText7);
        confirm = findViewById(R.id.editTextText8);
        cadastrar = findViewById(R.id.button);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        cadastrar.setOnClickListener(v -> {
            String Nome = nome.getText().toString();
            String Email = email.getText().toString();
            String Senha = senha.getText().toString();
            String Confirm = confirm.getText().toString();




            if (!Nome.isEmpty() && !Email.isEmpty() && !Senha.isEmpty() && !Confirm.isEmpty()) {
                Toast.makeText(MainActivity.this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            } else {
                Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
