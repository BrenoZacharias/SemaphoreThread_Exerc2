package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPratos;

public class Main {

	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
			
		for(int id = 1; id <= 5; id++){
			Thread tPratos = new ThreadPratos(id, semaforo);
			tPratos.start();
		}
		
	}

}
