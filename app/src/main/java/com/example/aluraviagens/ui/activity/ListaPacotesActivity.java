package com.example.aluraviagens.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.aluraviagens.R;
import com.example.aluraviagens.ui.adapter.ListaPacotesAdapter;
import com.example.aluraviagens.ui.dao.PacoteDAO;
import com.example.aluraviagens.ui.model.Pacote;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        ListView listaDePacotes = findViewById(R.id.lista_pacote_listview);

        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}