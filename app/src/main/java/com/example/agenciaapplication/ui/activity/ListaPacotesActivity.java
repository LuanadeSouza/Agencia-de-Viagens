package com.example.agenciaapplication.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.agenciaapplication.R;
import com.example.agenciaapplication.dao.PacoteDao;
import com.example.agenciaapplication.model.Pacote;
import com.example.agenciaapplication.ui.adapter.ListaPacotesAdapter;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(getString(R.string.titulo_app_bar));
        configuraLista();

    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.list_view_lista_pacotes);
        List<Pacote> pacotes = new PacoteDao().lista();
        listaDePacotes.setAdapter( new ListaPacotesAdapter(pacotes, this));
    }
}
