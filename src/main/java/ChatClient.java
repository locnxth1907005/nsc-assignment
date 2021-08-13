import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8088);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        while (true){
            //truyen du lieu len server
            String str = scanner.nextLine();
            dataOutputStream.writeUTF(str);
            dataOutputStream.flush();
            // chat exit  de ket thuc chuong trinh
            if (str.equals("exit")){
                break;
            }
            // doc du lieu tu server truyen ve
            String str2 = dataInputStream.readUTF();
            System.out.println("Server Say:"+ str2);

        }
        dataInputStream.close();
        dataOutputStream.close();
    }
}
