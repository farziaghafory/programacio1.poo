package com.farziaghfory.poo.redsocial;

import java.util.ArrayList;
import java.util.Scanner;

enum Estado {
    ACTIVO("You are active"),
    DESACTIVO("You are desactivated");

    private String mensaje;

    Estado(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}

public class redPerfilSocial {

    private String nombreUsuario;
    private String nombreVisible;
    private String bio;
    private String Ciudad;
    private int numSeguidores;
    private int numPublicacion;
    private boolean cuentaVerificada;
    private Estado estado;

    private ArrayList<String> publicaciones;

    public redPerfilSocial(String nombreUsuario, String nombreVisible, String bio, String Ciudad, boolean verificado) {
        this.nombreUsuario = nombreUsuario;
        this.nombreVisible = nombreVisible;
        this.bio = bio;
        this.Ciudad = Ciudad;
        this.numSeguidores = 0;
        this.numPublicacion = 0;
        this.cuentaVerificada = verificado;
        this.estado = Estado.ACTIVO;
        this.publicaciones = new ArrayList<>();
    }

    public void mostrarInfo() {
        System.out.println("name of the user: " + nombreUsuario);
        System.out.println("Name visible: " + nombreVisible);
        System.out.println("Your bio: " + bio);
        System.out.println("City living in: " + Ciudad);
        System.out.println("number of people following: " + numSeguidores);
        System.out.println("number of posts: " + numPublicacion);
        System.out.println("Are you varified: " + cuentaVerificada);
        System.out.println("Profile status: " + estado.getMensaje());
    }

    public void anadirSeguidores(int cantidad) {
        if (cantidad > 0) {
            numSeguidores += cantidad;
        }
    }

    public void cambiarEstado(Estado nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void crearPublicacion(String texto) {
        publicaciones.add(texto);
        numPublicacion++;
    }

    public void mostrarPublicaciones() {
        for (String p : publicaciones) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Write your username: ");
        String user = sc.nextLine();

        System.out.print("Write your visible name: ");
        String visible = sc.nextLine();

        System.out.print("Write your bio: ");
        String bio = sc.nextLine();

        System.out.print("Write your city: ");
        String city = sc.nextLine();

        System.out.print("Are you verified? (true/false): ");
        boolean verif = sc.nextBoolean();
        sc.nextLine();

        redPerfilSocial perfil = new redPerfilSocial(user, visible, bio, city, verif);

        System.out.println("How many publications do you want to create?");
        int cantidad = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Write publication " + (i + 1) + ": ");
            String texto = sc.nextLine();
            perfil.crearPublicacion(texto);
        }

        System.out.println("Profile Info ");
        perfil.mostrarInfo();

        System.out.println(" Publication");
        perfil.mostrarPublicaciones();

        System.out.print("Do you want to deactivate the profile? (yes/no): ");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("yes")) {
            perfil.cambiarEstado(Estado.DESACTIVO);
        }

        System.out.println("Updated profile status ");
        perfil.mostrarInfo();

        sc.close();
    }
}
