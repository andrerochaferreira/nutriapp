package com.example.nutri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class MainActivity extends AppCompatActivity {

    private CodeScanner mCodeScanner;
    private EditText editTextNome;
    private EditText editTextEmail;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Primeira vez que a atividade é iniciada, exibimos o scanner de QR code
        if (getIntent().getBooleanExtra("show_login", false)) {
            setContentView(R.layout.login_main);
            configureLoginScreen();
        } else {
            setContentView(R.layout.activity_main);
            configureScannerScreen();
        }
    }

    private void configureScannerScreen() {
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Exibe o valor do QR code (opcional)
                        Toast.makeText(MainActivity.this, result.getText(), Toast.LENGTH_SHORT).show();

                        // Inicia a tela de login após o QR code ser escaneado
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        intent.putExtra("show_login", true); // Passa um sinal para exibir a tela de login
                        startActivity(intent);
                        finish(); // Encerra a tela de scanner para evitar voltar a ela
                    }
                });
            }
        });

        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });
    }

    private void configureLoginScreen() {
        editTextNome = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();

                if (!nome.isEmpty() && !email.isEmpty()) {
                    // Iniciar a atividade de escolha de refeição
                    Intent intent = new Intent(MainActivity.this, EscolhaRefeicaoActivity.class);
                    startActivity(intent);
                    finish(); // Finaliza a atividade de login
                } else {
                    // Mensagem de erro se algum campo estiver vazio
                    Toast.makeText(MainActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mCodeScanner != null) {
            mCodeScanner.startPreview();
        }
    }

    @Override
    protected void onPause() {
        if (mCodeScanner != null) {
            mCodeScanner.releaseResources();
        }
        super.onPause();
    }
}