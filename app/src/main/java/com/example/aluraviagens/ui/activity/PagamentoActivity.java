package com.example.aluraviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.util.MoedaUtil;

import java.math.BigDecimal;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APP_BAR);


        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp",
                2, new BigDecimal("243.99"));

        mostraPreco(pacoteSaoPaulo);


        Intent intent = new Intent(this, ResumoCompraActivity.class);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

}