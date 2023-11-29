/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casoestudioesteban;

/**
 *
 * @author Cynthia Camacho
 */



import javax.swing.JOptionPane;

public class CasoEstudioEsteban {
    public static void main(String[] args) {
        Cancion[] top10 = new Cancion[10];
        for (int i = 0; i < 10; i++) {
            String id = JOptionPane.showInputDialog("Ingresa el ID de la canción #" + (i + 1)) + "Este orden va del primero al ultimo";
            String titulo = JOptionPane.showInputDialog("Ingrese el título de la canción #" + (i + 1));
            String autor = JOptionPane.showInputDialog("Ingrese el autor de la canción #" + (i + 1));
            //Esto es para poder ponerlo en minutos y que no mande errores
            String duracion = JOptionPane.showInputDialog("Ingrese la duración de la canción #" + (i + 1) + " en el formato minutos:segundos");
            String[] partes = duracion.split(":");
            int duracionEnSegundos = Integer.parseInt(partes[0]) * 60 + Integer.parseInt(partes[1]);
            String año = JOptionPane.showInputDialog("Ingrese el año de publicación de la canción #" + (i + 1));
            top10[i] = new Cancion(Integer.parseInt(id), titulo, autor, duracion, duracionEnSegundos, Integer.parseInt(año));
        }

        JOptionPane.showMessageDialog(null, "Canciones anteriores a este año:\n" + cancionesAnteriores(top10));
        JOptionPane.showMessageDialog(null, "Canciones de este año:\n" + cancionesEsteAño(top10));
        JOptionPane.showMessageDialog(null, "Canción con más duración:\n" + cancionMasLarga(top10));
        JOptionPane.showMessageDialog(null, "Autor de la canción #1:\n" + top10[0].getAutor());
        JOptionPane.showMessageDialog(null, "Top 10 de canciones:\n" + listaCanciones(top10));
    }

    public static String cancionesAnteriores(Cancion[] canciones) {
        String resultado = "";
        int esteAño = 2023; // Cambia esto al año actual
        for (Cancion cancion : canciones) {
            if (cancion.getAño() < esteAño) {
                resultado += cancion + "\n";
            }
        }
        return resultado;
    }

    public static String cancionesEsteAño(Cancion[] canciones) {
        String resultado = "";
        int esteAño = 2023; // Cambia esto al año actual
        for (Cancion cancion : canciones) {
            if (cancion.getAño() == esteAño) {
                resultado += cancion + "\n";
            }
        }
        return resultado;
    }

    public static String cancionMasLarga(Cancion[] canciones) {
        Cancion cancionMasLarga = canciones[0];
        for (int i = 1; i < canciones.length; i++) {
            if (canciones[i].getDuracionEnSegundos() > cancionMasLarga.getDuracionEnSegundos()) {
                cancionMasLarga = canciones[i];
            }
        }
        return cancionMasLarga.toString();
    }

    public static String listaCanciones(Cancion[] canciones) {
        String resultado = "";
        for (int i = 0; i < canciones.length; i++) {
            resultado += (i + 1) + ". " + canciones[i] + "\n";
        }
        return resultado;
    }
}

class Cancion {
    private int id;
    private String titulo;
    private String autor;
    private String duracion;
    private int duracionEnSegundos;
    private int año;

    public Cancion(int id, String titulo, String autor, String duracion, int duracionEnSegundos, int año) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.duracion = duracion;
        this.duracionEnSegundos = duracionEnSegundos;
        this.año = año;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getDuracion() {
        return duracion;
    }
//Sirve para que lo mande en formato de minutos
    public int getDuracionEnSegundos() {
        return duracionEnSegundos;
    }

    public int getAño() {
        return año;
    }

    public String toString() {
        return "Cancion: " +
            "ID = " + id +
            ", Titulo = '" + titulo + '\'' +
            ", Autor = '" + autor + '\'' +
            ", Duracion = " + duracion +
            ", Año = " + año;
    }
}

