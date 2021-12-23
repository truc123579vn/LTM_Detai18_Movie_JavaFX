package FXML.ltm_doandetai18_javafx;

import Support.SupportTool;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class Start extends Application {
    public static Scene scene;
    public static int destPort = 5000;
    public static String hostname = "localhost";
    public static Socket socket;
    public Start() {
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Home"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Bao cao de tai 18");
        stage.show();
    }
    public static void setRoot(String fxml) throws IOException {

        scene.setRoot(loadFXML(fxml));

    }

    static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void alertInf(String inf) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(inf);
        a.setTitle("Thông báo");
        a.setHeaderText(null);
        a.showAndWait();
    }

    public static void main(String[] args) throws IOException {

        socket=new Socket("localhost",5000);
        SupportTool.InitializeOutputClient(socket);
        SupportTool.InitializeInputClient(socket);

        //SupportTool.getOutputClient().flush();
        launch();
//            DatagramSocket socket;
//            DatagramPacket dpsend, dpreceive;
//            InetAddress add; Scanner stdIn;
//            try {
//                add = InetAddress.getByName(hostname);	//UnknownHostException
//                socket = new DatagramSocket();			//SocketException
//                stdIn = new Scanner(System.in);
//                while(true) {
//                    System.out.print("Client input: ");
//                    String tmp = stdIn.nextLine();
//
//                    System.out.println("Client sent " + tmp + " to " + add.getHostAddress() +
//                            " from port " + socket.getLocalPort());
//
//
//                    sendToServer(tmp,socket,add);
//                    if(tmp.equals("bye")) {
//                        System.out.println("Client socket closed");
//                        stdIn.close();
//                        socket.close();
//                        break;
//                    }
//                    // Get response from server
//
//                    int length= Integer.parseInt(ReceiveFromServer(10,socket));
//                    sendToServer("",socket,add);
//                    tmp=ReceiveFromServer(length,socket);
//                    System.out.println("Client get: " + tmp + " from server");
//                }
//            } catch (IOException e) { System.err.println(e);}
//
//    }
//    public static String ReceiveFromServer(int n, DatagramSocket socket) throws IOException {
//        DatagramPacket dpreceive;
//        dpreceive = new DatagramPacket(new byte[n], n);
//        socket.receive(dpreceive);
//        return  new String(dpreceive.getData(), 0, dpreceive.getLength());
//    }
//    public static void sendToServer(String tmp,DatagramSocket socket,InetAddress add) throws IOException {
//        DatagramPacket dpsend;
//        byte[] data = tmp.getBytes();
//        dpsend = new DatagramPacket(data, data.length, add, destPort);
//        socket.send(dpsend);
//    }
    }
}
