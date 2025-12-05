package com.farziaghfory.poo.redsocial;
import java.time.LocalTime;
public class Publicacion {
	private String text;
	private LocalTime hora;
	private int likes;
	public Publicacion() {
		// TODO Auto-generated constructor stub
	
	}
	public Publicacion(String text) {
		this.text = text;
		this.hora = LocalTime.now();
		this.likes = 0;}
	public void mostrar() {
		System.out.println("Texto: " + text);
		System.out.println("Fecha: " +  hora);
		System.out.println("Likes: " + likes);
	}
	public void darMeGusta() {
		likes++;
	}
	public int verMeGusta() {
		return likes;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String massage = "Write your text";
Publicacion n = new Publicacion(massage);
n.darMeGusta();
n.mostrar();

	}
}

