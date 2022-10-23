package com.example.buscacep;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button btnBuscarCep;
    EditText txtCep;
    TextView lblResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCep = findViewById(R.id.txtCep);
        lblResposta = findViewById(R.id.lblResposta);
        btnBuscarCep = findViewById(R.id.btnBuscarCep);

        btnBuscarCep.setOnClickListener(v -> {
            try {
                CEP retorno = new HttpService(txtCep.getText().toString().trim()).execute().get();
                lblResposta.setText(retorno.toString());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
