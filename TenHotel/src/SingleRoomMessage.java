
//单人房信息
public class SingleRoomMessage {

    public boolean hadUsed;         //房间是否已使用
    public static String type;      //房型
    public static String price;     //房价
    public String rNumber;          //房号
    public static String rMarks;    //房型简介

    public SingleRoomMessage(boolean used,String roomNumber) {

        type = "单人房";
        hadUsed = used;
        price = "98";
        rNumber = roomNumber;
        rMarks = "  无早餐";
    }
}
