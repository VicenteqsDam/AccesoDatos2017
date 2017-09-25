package test.sesion;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Sesion1 {
	public void escribirSecuencial() throws IOException {
		File file = new File("fichero.txt");
		FileWriter fichero = new FileWriter(file);
		fichero.write("Texto de prueba");
		fichero.close();
	}

	public void leerSecuencial() throws IOException {
		File file = new File("fichero.txt");
		FileReader fichero = new FileReader(file);
		char chr = (char) fichero.read();
		while (chr != -1) {
			System.out.print(chr);
			chr = (char) fichero.read();
		}
		fichero.close();
	}

	public void escribirBytes() throws IOException {
		File file = new File("ficheroBinario.bin");
		FileOutputStream fichero = new FileOutputStream(file);
		// Podriamos usar cualquier clase Serializable
		String texto = "Texto de prueba binario";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(texto);
		os.close();
		fichero.write(out.toByteArray());
		fichero.close();
	}

	public void leerBytes() throws IOException, ClassNotFoundException {
		File file = new File("ficheroBinario.bin");
		FileInputStream fichero = new FileInputStream(file);
		ObjectInputStream is = new ObjectInputStream(fichero);
		String texto = (String) is.readObject();
		is.close();
		fichero.close();
		System.out.println(texto);
	}
}
