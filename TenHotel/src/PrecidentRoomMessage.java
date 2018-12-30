
//总统套房信息
public class PrecidentRoomMessage {

    public boolean hadUsed;         //房间是否已使用
    public static String type;      //房型
    public static String price;     //房价
    public String rNumber;          //房号
    public static String rMarks;    //房型简介

    public PrecidentRoomMessage(boolean used,String roomNumber) {

        type = "豪华套房";
        hadUsed = used;
        price = "998";
        rNumber = roomNumber;
        rMarks = "  豪华早餐";
    }
}
