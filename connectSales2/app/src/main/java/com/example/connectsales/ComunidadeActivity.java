package com.example.connectsales;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import com.example.connectsales.DAO.BaseDados;
import com.example.connectsales.models.Comunidade;
import java.util.List;

public class ComunidadeActivity extends AppCompatActivity {
    //modelo
    Comunidade comunidade = new Comunidade();


    //componentes visuais
    EditText edtNomeComunidade;
    ListView listaViewComunidade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Comunidade");
        setContentView(R.layout.activity_comunidade);
        edtNomeComunidade = findViewById(R.id.edtNomeComunidade);
        listaViewComunidade = findViewById(R.id.listaViewComunidade);
    }


    public void salvarComunidade(View view) {
        try {
            this.comunidade.nome = "" + edtNomeComunidade.getText();
            if (this.comunidade.id == null) {
                BaseDados.rComunidades.insert(this.comunidade);
            } else {
                BaseDados.rComunidades.update(this.comunidade);
            }
        } catch (Exception ex) {
            new AlertDialog.Builder(this)
                    .setMessage(ex.getMessage())
                    .setPositiveButton(android.R.string.yes, null)
                    .show();
        }
        this.comunidade = new Comunidade();
        this.edtNomeComunidade.setText("");
        getListaMontadoras();
    }


    public void getListaMontadoras() {
        List<Comunidade> lista = BaseDados.rComunidades.find().toList();
        final ArrayAdapter<Comunidade> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        listaViewComunidade.setAdapter(arrayAdapter);
        listaViewComunidade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                comunidade = BaseDados.rComunidades.getById(arrayAdapter.getItem(i).id);
                edtNomeComunidade.setText(comunidade.nome);
                edtNomeComunidade.requestFocus();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        getListaMontadoras();
    }


    public void cancelarComunidade(View view) {
        this.comunidade = new Comunidade();
        edtNomeComunidade.setText("");
        edtNomeComunidade.requestFocus();
    }


    public void excluirComunidade(View view) {
        if (this.comunidade.id != null) {
            BaseDados.rComunidades.remove(this.comunidade);
        }
        this.comunidade = new Comunidade();
        this.edtNomeComunidade.setText("");
        getListaMontadoras();
    }
}
