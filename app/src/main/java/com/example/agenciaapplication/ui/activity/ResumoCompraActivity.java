package com.example.agenciaapplication.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.agenciaapplication.R;
import com.example.agenciaapplication.model.Pacote;
import com.example.agenciaapplication.util.DataUtil;
import com.example.agenciaapplication.util.MoedaUtil;
import com.example.agenciaapplication.util.ResourceUtil;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.math.BigDecimal;

import static com.example.agenciaapplication.ui.activity.Constantes.CHAVE_PACOTES;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITLE_RESUMO = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITLE_RESUMO);

        carregaPacoteRecebido();
        startBack();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTES)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTES);

            initView(pacote);
        }
    }

    private void initView(Pacote pacote) {
        mostraLocal(pacote);
        mostraImage(pacote);
        mostraDate(pacote);
        mostraPreco(pacote);
    }

    private void startBack() {
        Button buttonVoltar = findViewById(R.id.button_voltar);
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoCompraActivity.this, ListaPacotesActivity.class);
                startActivity(intent);
            }
        });
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_valor);
        String moedaBrasileira = MoedaUtil.getformat(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraDate(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data);
        String periodoEmTexto = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(periodoEmTexto);
    }

    private void mostraImage(Pacote pacote) {
        ImageView image = findViewById(R.id.resumo_compra_image);
        Drawable drawableDoPacote = ResourceUtil.getDrawable(this, pacote.getImage());
        image.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText(pacote.getLocal());
    }
}
