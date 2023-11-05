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
import com.example.connectsales.models.Posts;

import java.util.List;

public class PostsActivity extends AppCompatActivity {

    Posts post = new Posts();


    //componentes visuais
    EditText edtNomePosts;
    ListView listaViewPosts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Posts");
        setContentView(R.layout.activity_comunidade);
        edtNomePosts = findViewById(R.id.edtNomePosts);
        listaViewPosts = findViewById(R.id.listaViewPosts);
    }


    public void salvarPost(View view) {
        try {
            this.post.titulo = "" + edtNomePosts.getText();
            if (this.post.id == null) {
                BaseDados.rPosts.insert(this.post);
            } else {
                BaseDados.rPosts.update(this.post);
            }
        } catch (Exception ex) {
            new AlertDialog.Builder(this)
                    .setMessage(ex.getMessage())
                    .setPositiveButton(android.R.string.yes, null)
                    .show();
        }
        this.post = new Posts();
        this.edtNomePosts.setText("");
        getListaPosts();
    }


    public void getListaPosts() {
        List<Posts> lista = BaseDados.rPosts.find().toList();
        final ArrayAdapter<Posts> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        listaViewPosts.setAdapter(arrayAdapter);
        listaViewPosts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                post = BaseDados.rPosts.getById(arrayAdapter.getItem(i).id);
                edtNomePosts.setText(post.titulo);
                edtNomePosts.requestFocus();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        getListaPosts();
    }


    public void cancelarPost(View view) {
        this.post = new Posts();
        edtNomePosts.setText("");
        edtNomePosts.requestFocus();
    }


    public void excluirPost(View view) {
        if (this.post.id != null) {
            BaseDados.rPosts.remove(this.post);
        }
        this.post = new Posts();
        this.edtNomePosts.setText("");
        getListaPosts();
    }
}