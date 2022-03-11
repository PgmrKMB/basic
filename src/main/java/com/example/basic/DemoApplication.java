package com.example.basic;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        String path = "http://ggoreb.com/images/luffy.jpg";

        ApplicationContext context =
        new AnnotationConfigApplicationContext(BeanConfig.class);
        Game game = (Game) context.getBean("game");
        game.play();
        Movie movie = (Movie) context.getBean("movie");
        movie.play();
        Music music = (Music) context.getBean("music");
        music.play();

        ImageUtil imgs = (ImageUtil) context.getBean("imgdw"); // 자동 cammelCase
        try {
            imgs.save(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((AnnotationConfigApplicationContext) context).close();
        }
    }