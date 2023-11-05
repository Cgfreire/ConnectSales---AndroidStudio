package com.example.connectsales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.connectsales.DAO.BaseDados;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String nomeArquivoDB = getFilesDir().getPath() + "/baseDadosModelos.db";
        BaseDados.init(nomeArquivoDB);
    }


    public void abreTelaComunidades(View view) {
        startActivity(new Intent(this, ComunidadeActivity.class));
    }


    public void abreTelaPosts(View view) {
        startActivity(new Intent(this, PostsActivity.class));
    }
}
