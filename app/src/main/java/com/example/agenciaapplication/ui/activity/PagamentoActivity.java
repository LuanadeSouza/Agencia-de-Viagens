package com.example.agenciaapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenciaapplication.R;
import com.example.agenciaapplication.model.Pacote;
import com.example.agenciaapplication.util.MoedaUtil;

import java.io.Serializable;
import java.math.BigDecimal;

import static com.example.agenciaapplication.ui.activity.Constantes.CHAVE_PACOTES;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITLE_PAGAMENTO = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITLE_PAGAMENTO);
        carregaPacoteRecebido();

    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTES)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTES);

            mostraPreco(pacote);

            configuraBotao(pacote);
        }
    }

    private void configuraBotao(final Pacote pacote) {
        Button buttonFinalizar = findViewById(R.id.button_finalizar);
        buttonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startResumoCompra(pacote);
            }
        });
    }

    private void startResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTES, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.getformat(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}
