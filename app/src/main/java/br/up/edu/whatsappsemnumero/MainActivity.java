package br.up.edu.whatsappsemnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText numero;
    private TextInputEditText mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = findViewById(R.id.numero);
        mensagem = findViewById(R.id.mensagem);

        this.registerEvents(findViewById(R.id.btn));
    }

    private void registerEvents(View btn) {
        btn.setOnClickListener(v -> {
            String num = Objects.requireNonNull(numero.getText()).toString();
            String msg = Objects.requireNonNull(mensagem.getText()).toString();
            Uri link = Uri.parse("https://wa.me/55" + num + "?text=" + msg);
            Intent callIntent = new Intent(Intent.ACTION_VIEW, link);
            startActivity(callIntent);
        });
    }
}