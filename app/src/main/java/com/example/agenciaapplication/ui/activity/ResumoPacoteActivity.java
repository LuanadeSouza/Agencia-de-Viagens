package com.example.agenciaapplication.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenciaapplication.R;
import com.example.agenciaapplication.model.Pacote;
import com.example.agenciaapplication.util.DataUtil;
import com.example.agenciaapplication.util.DiaUtils;
import com.example.agenciaapplication.util.MoedaUtil;
import com.example.agenciaapplication.util.ResourceUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITLE_APP_BAR = "Resumo do pacote";
    private TextView dias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITLE_APP_BAR);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraLocal(pacoteSaoPaulo);
        mostraImage(pacoteSaoPaulo);
        mostraDias(pacoteSaoPaulo);
        mostraPreço(pacoteSaoPaulo);
        mostraData(pacoteSaoPaulo);


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
