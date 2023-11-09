import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Practica {
    public static void main(String argv[]) throws Exception {
        //Configuramos los flujos convenientemente
        Socket socket = new Socket("212.128.3.86", 6789); 
        DataOutputStream streamToServer = new DataOutputStream(socket.getOutputStream());
        InputStream input = socket.getInputStream(); 
        
        //Enviamos el servidor
        String nombre_apellido = "Tarek Kheir_________";
        String DNI = "06761154";
        String sentence = nombre_apellido + DNI;
        streamToServer.writeBytes(sentence);
        byte[] buffer = new byte[255];
        int byteRead;
        InputStream fileInput = new BufferedInputStream(input);
        FileOutputStream fileOutput = new FileOutputStream("archivo.pdf"); 
        
        //Esperamos respuesta
        while (byteRead = fileInput.read(buffer) != -1) {
            fileOutput.write(buffer, 0, byteRead);
        }
        //Cerramos y mostramos resultado
        socket.close(); 
 
    }
}