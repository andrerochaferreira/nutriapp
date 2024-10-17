package com.example.nutri;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EscolhaRefeicaoActivity extends AppCompatActivity {

    private CheckBox checkBoxCafeManha, checkBoxAlmoco, checkBoxCafeTarde;
    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escolha_aluno);

        checkBoxCafeManha = findViewById(R.id.checkBoxCafeManha);
        checkBoxAlmoco = findViewById(R.id.checkBoxAlmoco);
        checkBoxCafeTarde = findViewById(R.id.checkBoxCafeTarde);
        buttonEnviar = findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar quais opções foram selecionadas
                StringBuilder resultado = new StringBuilder();

                if (checkBoxCafeManha.isChecked()) {
                    resultado.append("Café da manhã ");
                }
                if (checkBoxAlmoco.isChecked()) {
                    resultado.append("Almoço ");
                }
                if (checkBoxCafeTarde.isChecked()) {
                    resultado.append("Café da tarde ");
                }

                if (resultado.length() == 0) {
                    Toast.makeText(EscolhaRefeicaoActivity.this, "Nenhuma refeição selecionada", Toast.LENGTH_SHORT).show();
                } else {
                    // Aqui você pode enviar os dados para o servidor via Retrofit
                    Toast.makeText(EscolhaRefeicaoActivity.this, "Refeições: " + resultado.toString(), Toast.LENGTH_SHORT).show();

                    // TODO: Implementar envio via API com Retrofit
                }
            }
        });
    }
}
