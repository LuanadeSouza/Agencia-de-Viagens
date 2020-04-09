package com.example.agenciaapplication.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenciaapplication.R;
import com.example.agenciaapplication.model.Pacote;
import com.example.agenciaapplication.util.DiaUtils;
import com.example.agenciaapplication.util.MoedaUtil;
import com.example.agenciaapplication.util.ResourceUtil;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle("Resumo do pacote");

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacoteSaoPaulo.getLocal());

        ImageView image = findViewById(R.id.resumo_pacote_image);
        Drawable drawableDoPacote = ResourceUtil.getDrawable(this, pacoteSaoPaulo.getImage());
        image.setImageDrawable(drawableDoPacote);

        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiaUtils.getDias(pacoteSaoPaulo.getDias());
        dias.setText(diasEmTexto);
        
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil.getformat(pacoteSaoPaulo.getPreco());
        preco.setText(moedaBrasileira);

        TextView data = findViewById(R.id.resumo_pacote_data);
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, pacoteSaoPaulo.getDias());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
        String dataFormatadaIda = dateFormat.format(dataIda.getTime());
        String dataFormatadaVolta = dateFormat.format(dataVolta.getTime());
        String dataFormatadaDaViagem = dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);
        data.setText(dataFormatadaDaViagem);


    }
}
