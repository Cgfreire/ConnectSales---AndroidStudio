package com.example.connectsales.DAO;

import com.example.connectsales.models.Comunidade;
import com.example.connectsales.models.Posts;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;



public class BaseDados {
    public static ObjectRepository<Comunidade> rComunidades;
    public static ObjectRepository<Posts> rPosts;


    public static void init(String file) {
        Nitrite db = Nitrite.builder()
                .compressed()
                .filePath(file)
                .openOrCreate("root", "salesiano");


        rComunidades = db.getRepository(Comunidade.class);
        rPosts = db.getRepository(Posts.class);
    }
}
