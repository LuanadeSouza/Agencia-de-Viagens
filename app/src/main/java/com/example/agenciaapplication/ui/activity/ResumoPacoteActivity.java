package com.example.agenciaapplication.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenciaapplication.R;
import com.example.agenciaapplication.model.Pacote;
import com.example.agenciaapplication.util.DataUtil;
import com.example.agenciaapplication.util.DiaUtils;
import com.example.agenciaapplication.util.MoedaUtil;
import com.example.agenciaapplication.util.ResourceUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITLE_RESUMO_PACOTE = "Resumo do pacote";
    private TextView dias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITLE_RESUMO_PACOTE);

        Intent intent = getIntent();
        if (intent.hasExtra("pacote")) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            mostraLocal(pacote);
            mostraImage(pacote);
            mostraDias(pacote);
            mostraPreço(pacote);
            mostraData(pacote);

                Button buttonPagamento = findViewById(R.id.button_realizar_pagamento);
                buttonPagamento.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
                        intent.putExtra("pacote", pacote);
                        startActivity(intent);
                    }
                });



        }

    }


    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaDaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaDaViagem);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiaUtils.getDias(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraPreço(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil.getformat(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraImage(Pacote pacote) {
        ImageView image = findViewById(R.id.resumo_pacote_image);
        Drawable drawableDoPacote = ResourceUtil.getDrawable(this, pacote.getImage());
        image.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}
