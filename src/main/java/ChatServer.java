import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);
        Socket socket = serverSocket.accept();

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream((socket.getOutputStream()));
        Scanner scanner = new Scanner(System.in);

        while (true){
            // doc du lieu tu client truyen len
            String str = dataInputStream.readUTF();
            //nhap exit de ket thuc chuong trinh
            if (str.equals("exit")){
                break;
            }
            System.out.println("ClientIP said: "+ str);
            //truyen du lieu tu server ve client
            String str2 = scanner.nextLine();
            dataOutputStream.writeUTF(str2);
            dataOutputStream.flush();
        }
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
        serverSocket.close();
    }
}
