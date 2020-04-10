package com.example.agenciaapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenciaapplication.R;
import com.example.agenciaapplication.dao.PacoteDao;
import com.example.agenciaapplication.model.Pacote;
import com.example.agenciaapplication.ui.adapter.ListaPacotesAdapter;

import java.util.List;

import static com.example.agenciaapplication.ui.activity.Constantes.CHAVE_PACOTES;

public class ListaPacotesActivity extends AppCompatActivity {


    public static final String TITLE_PACOTES = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITLE_PACOTES);
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.list_view_lista_pacotes);
        final List<Pacote> pacotes = new PacoteDao().lista();
        listaDePacotes.setAdapter( new ListaPacotesAdapter(pacotes, this));
        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pacote pacoteClicado = pacotes.get(position);
                startPacote(pacoteClicado);

            }
        });
    }

    private void startPacote(Pacote pacoteClicado) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTES,pacoteClicado);
        startActivity(intent);
    }
}
