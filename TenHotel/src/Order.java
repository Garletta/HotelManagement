
//系统管理订单信息
public class Order {

    public boolean hadChecking;     //是否已入住
    public String orderNumber;      //订单号码
    public String dateStart;        //住房时间
    public String dateEnd;          //退房时间
    public String clientName;       //入住人
    public String clientIDCard;     //入住人身份证
    public String clientTelephone;  //入住人电话号码
    public String roomNuber;        //房间号
    public boolean hadPayment;      //是否已付款

    public Order(boolean hChecked,String clientOrder,String clientDateStart,String clientDateEnd,String nameOfClient,String IDCardOfClient,String telephoneOfClient,String clientRoomNuber,boolean hadPayed) {

        hadChecking = hChecked;
        orderNumber = clientOrder;
        dateStart = clientDateStart;
        dateEnd = clientDateEnd;
        clientName = nameOfClient;
        clientIDCard = IDCardOfClient;
        clientTelephone = telephoneOfClient;
        roomNuber = clientRoomNuber;
        hadPayment = hadPayed;
    }
}
