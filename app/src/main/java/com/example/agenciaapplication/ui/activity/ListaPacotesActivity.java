package com.example.agenciaapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenciaapplication.R;
import com.example.agenciaapplication.dao.PacoteDao;
import com.example.agenciaapplication.model.Pacote;
import com.example.agenciaapplication.ui.adapter.ListaPacotesAdapter;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {


    public static final String TITLE_APP = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITLE_APP);
        configuraLista();

        Intent intent = new Intent(this, ResumoPacoteActivity.class);
        startActivity(intent);

    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.list_view_lista_pacotes);
        List<Pacote> pacotes = new PacoteDao().lista();
        listaDePacotes.setAdapter( new ListaPacotesAdapter(pacotes, this));
    }
}
