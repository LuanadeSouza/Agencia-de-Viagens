package com.example.agenciaapplication.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.agenciaapplication.R;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITLE_PAGAMENTO = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITLE_PAGAMENTO);


    }
}
