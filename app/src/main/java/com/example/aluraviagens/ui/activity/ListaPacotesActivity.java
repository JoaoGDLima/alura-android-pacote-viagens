package com.example.aluraviagens.ui.activity;

import static com.example.aluraviagens.ui.activity.PacoteActivity.CHAVE_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.aluraviagens.R;
import com.example.aluraviagens.dao.PacoteDAO;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.ui.adapter.ListaPacotesAdapter;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));

        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {
                Pacote pacoteClicado = pacotes.get(posicao);
                vaiParaResumoPacote(pacoteClicado);
            }

            private void vaiParaResumoPacote(Pacote pacoteClicado) {
                Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
                intent.putExtra(CHAVE_PACOTE, pacoteClicado);
                startActivity(intent);
            }
        });
    }
}