package controller;

import java.util.concurrent.Semaphore;

public class ThreadPratos extends Thread {

	private int id;
	private Semaphore semaforo;

	public ThreadPratos(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		Preparo();
		try {
			semaforo.acquire();
			Entrega();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void Preparo() {
		if (id % 2 == 1) {
			System.out.println("Prato " + id + " de Sopa de Cebola foi iniciado");
			int tempoPreparo = (int) (Math.random() * 301) + 500;
			int percentualCozimento = 0;
			int tempo = 0;
			while (percentualCozimento <= 100) {
				tempo += 100;
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				percentualCozimento = ((tempo * 100) / (tempoPreparo));
				if(percentualCozimento > 100){
					System.out.println("Prato " + id + ", percentual 100%");
				}
				else{
					System.out.println("Prato " + id + ", percentual " + percentualCozimento + "%");
				}
			}
		}

		else if (id % 2 == 0) {
			System.out.println("Prato " + id + " de Lasanha a Bolonhesa foi iniciado");
			int tempoPreparo = (int) (Math.random() * 601) + 600;
			int percentualCozimento = 0;
			int tempo = 0;
			while (percentualCozimento <= 100) {
				tempo += 100;
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				percentualCozimento = ((tempo * 100) / (tempoPreparo));
				if(percentualCozimento>100){
					System.out.println("Prato " + id + ", percentual 100%");
				}
				else{
					System.out.println("Prato " + id + ", percentual " + percentualCozimento + "%");
				}
			}
		}
	}

	private void Entrega() {
		if(id % 2 == 1){
			System.out.println("Prato " + id + " de Sopa de Cebola está sendo entregue");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Prato " + id + " de Sopa de Cebola foi entregue");
		}
		else if(id % 2 == 0){
			System.out.println("Prato " + id + " de Lasanha a Bolonhesa está sendo entregue");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Prato " + id + " de Lasanha a Bolonhesa foi entregue");
		}
	}
}
