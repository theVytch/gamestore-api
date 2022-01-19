package com.m11h.gamestore;

import com.m11h.gamestore.domain.Categoria;
import com.m11h.gamestore.domain.Jogo;
import com.m11h.gamestore.repositories.CategoriaRepository;
import com.m11h.gamestore.repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class GamestoreApplication{

	public static void main(String[] args) {
		SpringApplication.run(GamestoreApplication.class, args);
	}
}
