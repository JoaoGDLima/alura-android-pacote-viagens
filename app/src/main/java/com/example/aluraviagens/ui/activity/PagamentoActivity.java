package com.example.aluraviagens.ui.activity;

import static com.example.aluraviagens.ui.activity.PacoteActivity.CHAVE_PACOTE;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            mostraPreco(pacote);
            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button button = findViewById(R.id.pagamento_botao_finaliza_compra);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaiParaResumoCompra();
            }

            private void vaiParaResumoCompra() {
                Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                intent.putExtra(CHAVE_PACOTE, pacote);
                startActivity(intent);
            }
        });
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

}