import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

//MATERIA: REDES DE COMPUTADORES
//LABORATORIO Nº: 2
//AUTOR: JENNY CASTRO

public class ServidorTCP {

	private static final int PORT = 9090;

	public static void main(String[] args) throws IOException {

		// Socket del servidor
		ServerSocket serverSocket = new ServerSocket(PORT);

                //AVISO que el puerto se encuentra en ejecución
		JOptionPane.showMessageDialog(null,"Servidor ejecutándose en el puerto " + PORT);

		try {

			while (true) {
                                      
				// Aceptar la conexión y crea un nuevo Socket para la comunicación
				Socket socket = serverSocket.accept();
				try {
					// Prepara la comunicación para enviar mensajes
					PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                                        
                                       JOptionPane.showMessageDialog(null, "Message from JENNY");
                                       JOptionPane.showMessageDialog(null, "SUMA DE DOS NUMEROS");
                                       
                                        //Envía un mensaje de respuesta para que el cliente devuelva el valor de "a" o primer valor
					out.println(" INGRESE EL PRIMER VALOR");
                                        
                                        //Prepara la comunicación para recibir mensajes desde el cliente
                                        InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
                                        BufferedReader input = new BufferedReader(inputStream);

                                        //Lee y asigna a la variable "a", la respuesta del cliente
                                        String a = input.readLine();
                                        double valorA = Double.valueOf(a);
                                        
                                        //Envia un mensaje de respuesta para que el cliente devuelva el valor de "b" o segundo valor
                                        out.println("INGRESE EL SEGUNDO VALOR");
                                        
                                        //Lee y asigna a la variable "b", la respuesta del cliente
                                        String b = input.readLine();
                                        double valorB = Double.valueOf(b);
                                        
                                        //Suma los valores y los asigna a la variable c
                                        double c= valorA+valorB;
                                        
                                        //Envia un mensaje de respuesta con el resultado de la suma
                                        out.println("Su resultado es: "+c);                                     
                                        
				} finally {
                                        //cierra la conexion con el socket
					socket.close();
				}
			}
		} finally {
                        //finaliza la conexion con el servidor
			serverSocket.close();

		}

	}

}