import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TCPCliente {
    public static void main(String argv[]) throws Exception {
        //Configuramos los flujos convenientemente
        Socket socket = new Socket("212.128.3.86", 6789); 
        DataOutputStream streamToServer = new DataOutputStream(socket.getOutputStream());
        InputStreamReader streamFromServer=new InputStreamReader(socket.getInputStream());
        BufferedReader serverInput = new BufferedReader(streamFromServer); 
        //Enviamos el servidor
        String nombre_apellido = "Tarek Kheir_________";
        String DNI = "06761154";
        String sentence = nombre_apellido + DNI;
        streamToServer.writeBytes(sentence);
        //Esperamos respuesta
        String modifiedSentence = serverInput.readLine(); 
        //Cerramos y mostramos resultado
        socket.close(); 
        System.out.println("DEL SERVIDOR: " + modifiedSentence); 
    }
}   