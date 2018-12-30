import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static String parentPath;                                        //工程文件绝对路径

    public static ArrayList<SingleRoomMessage> singleRoomMessages;          //单人房信息
    public static ArrayList<DoubleRoomMessage> doubleRoomMessages;          //双人房信息
    public static ArrayList<PrecidentRoomMessage> precidentRoomMessages;    //豪华套房信息
    public static ArrayList<Order> orders;                                  //订单信息

    public static void main(String[] args) {

        singleRoomMessages = new ArrayList<>();     //单人房信息
        doubleRoomMessages = new ArrayList<>();     //双人房信息
        precidentRoomMessages = new ArrayList<>();  //豪华套房信息
        orders = new ArrayList<>();                 //订单信息

        parentPath = new File("").getAbsolutePath();

        getData();

        JFrame hotel = new Hotel();

        saveData();
    }

    //从存储文件读取数据
    public static void getData() {
        try {
            BufferedReader bfreader = new BufferedReader(new FileReader(parentPath + "/SingleRoom.txt"));
            String temp;
            String[] RoomMessage;
            while((temp = bfreader.readLine()) != null) {
                RoomMessage = temp.split(" ");
                singleRoomMessages.add(new SingleRoomMessage(Boolean.parseBoolean(RoomMessage[0]),RoomMessage[1]));
            }
            bfreader.close();

            bfreader = new BufferedReader(new FileReader(parentPath + "/DoubleRoom.txt"));
            while((temp = bfreader.readLine()) != null) {
                RoomMessage = temp.split(" ");
                doubleRoomMessages.add(new DoubleRoomMessage(Boolean.parseBoolean(RoomMessage[0]),RoomMessage[1]));
            }
            bfreader.close();

            bfreader = new BufferedReader(new FileReader(parentPath + "/PrecidentRoom.txt"));
            while((temp = bfreader.readLine()) != null) {
                RoomMessage = temp.split(" ");
                precidentRoomMessages.add(new PrecidentRoomMessage(Boolean.parseBoolean(RoomMessage[0]),RoomMessage[1]));
            }
            bfreader.close();

            String[] OrdersMessage;
            bfreader = new BufferedReader(new FileReader(parentPath + "/Orders.txt"));
            while((temp = bfreader.readLine()) != null) {
                OrdersMessage = temp.split(" ");
                orders.add(new Order(Boolean.valueOf(OrdersMessage[0]),OrdersMessage[1],OrdersMessage[2],OrdersMessage[3],OrdersMessage[4],OrdersMessage[5],OrdersMessage[6],OrdersMessage[7],Boolean.valueOf(OrdersMessage[8])));
            }
            bfreader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //把数据更新回存储文件
    public static void saveData() {
        try {
            BufferedWriter bfwriter = new BufferedWriter(new FileWriter(parentPath + "/SingleRoom.txt"));
            for(int i = 0;i < singleRoomMessages.size();i++) {
                bfwriter.write(String.valueOf(singleRoomMessages.get(i).hadUsed) + " " + singleRoomMessages.get(i).rNumber + "\n");
            }
            bfwriter.close();

            bfwriter = new BufferedWriter(new FileWriter(parentPath + "/DoubleRoom.txt"));
            for(int i = 0;i < doubleRoomMessages.size();i++) {
                bfwriter.write(String.valueOf(doubleRoomMessages.get(i).hadUsed) + " " + doubleRoomMessages.get(i).rNumber + "\n");
            }
            bfwriter.close();

            bfwriter = new BufferedWriter(new FileWriter(parentPath + "/PrecidentRoom.txt"));
            for(int i = 0;i < precidentRoomMessages.size();i++) {
                bfwriter.write(String.valueOf(precidentRoomMessages.get(i).hadUsed) + " " + precidentRoomMessages.get(i).rNumber + "\n");
            }
            bfwriter.close();

            bfwriter = new BufferedWriter(new FileWriter(parentPath + "/Orders.txt"));
            for(int i = 0;i < orders.size();i++) {
                bfwriter.write(String.valueOf(orders.get(i).hadChecking) + " " + orders.get(i).orderNumber + " " + orders.get(i).dateStart + " " + orders.get(i).dateEnd + " " + orders.get(i).clientName + " " + orders.get(i).clientIDCard + " " + orders.get(i).clientTelephone + " " + orders.get(i).roomNuber + " " + String.valueOf(orders.get(i).hadPayment) + "\n");
            }
            bfwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
