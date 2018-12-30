import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//入住
public class CheckIn extends JFrame{

    public CheckInJPanel checkInJPanel; //界面画板

    public JLabel orderNumber;
    public JTextField oNumber;          //订单号
    public JLabel roomModel;
    public JTextField rModel;           //房间类型
    public JLabel roomPrice;
    public JTextField rPrice;           //房间价格
    public JTextArea roomRemarks;       //房型简介
    public JLabel bookDate;
    public JTextField DateStart;        //入住时间
    public JLabel div;                  //分隔符
    public JTextField DateEnd;          //退房时间
    public JLabel clientName;
    public JTextField cName;            //入住人
    public JLabel clientIDCard;
    public JTextField cID;              //入住人身份证
    public JLabel clientTelephone;
    public JTextField cTel;             //入住人电话号码
    public JButton backMenu;            //返回主界面
    public JButton checkOrder;          //查询订单
    public JButton clientCheckIn;       //确认入住

    public CheckIn() {
        super();
        initCheckIn();
    }

    public void initCheckIn() {
        setTitle("入住");
        setSize(400,500);
        setLocationRelativeTo(null);    //放置于屏幕中央
        setLayout(null);                //布局方式
        setResizable(false);            //不可延伸
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        checkInJPanel = new CheckInJPanel();
        checkInJPanel.setBounds(0,0,this.getWidth(),this.getHeight());
        add(checkInJPanel);

        setVisible(true);               //设可见
    }

    class CheckInJPanel extends JPanel {

        public CheckInJPanel() {
            super();
            initCheckInJPanel();
        }

        public void initCheckInJPanel() {
            setLayout(null);
            setLocationRelativeTo(null);

            orderNumber = new JLabel("订单号");
            orderNumber.setBounds(30,30,120,30);
            orderNumber.setFont(new Font("楷体",Font.BOLD,20));
            add(orderNumber);

            //订单号
            oNumber = new JTextField();
            oNumber.setBounds(140,30,220,30);
            oNumber.setFont(new Font("楷体",Font.BOLD,20));
            add(oNumber);

            roomModel = new JLabel("房间类型");
            roomModel.setForeground(Color.WHITE);
            roomModel.setBounds(30,70,220,30);
            roomModel.setFont(new Font("楷体",Font.BOLD,20));
            add(roomModel);

            //房型
            rModel = new JTextField();
            rModel.setEditable(false);
            rModel.setBounds(140,70,220,30);
            rModel.setFont(new Font("楷体",Font.BOLD,20));
            add(rModel);

            roomPrice = new JLabel("价格");
            roomPrice.setForeground(Color.WHITE);
            roomPrice.setBounds(30,110,220,30);
            roomPrice.setFont(new Font("楷体",Font.BOLD,20));
            add(roomPrice);

            //房间价格
            rPrice = new JTextField();
            rPrice.setEditable(false);
            rPrice.setBounds(140,110,220,30);
            rPrice.setFont(new Font("楷体",Font.BOLD,20));
            add(rPrice);

            //房型简介
            roomRemarks = new JTextArea();
            roomRemarks.setBounds(50,150,300,60);
            roomRemarks.setFont(new Font("楷体",Font.BOLD,20));
            roomRemarks.setLineWrap(true);
            roomRemarks.setEditable(false);
            add(roomRemarks);

            bookDate = new JLabel("时间");
            bookDate.setForeground(Color.WHITE);
            bookDate.setBounds(40,220,120,30);
            bookDate.setFont(new Font("楷体",Font.BOLD,20));
            add(bookDate);

            //入住时间
            DateStart = new JTextField();
            DateStart.setEditable(false);
            DateStart.setBounds(100,220,120,30);
            DateStart.setFont(new Font("楷体",Font.BOLD,20));
            add(DateStart);

            div = new JLabel(" 至 ");
            div.setForeground(Color.WHITE);
            div.setBounds(225,220,120,30);
            div.setFont(new Font("楷体",Font.BOLD,20));
            add(div);

            //退房时间
            DateEnd = new JTextField();
            DateEnd.setEditable(false);
            DateEnd.setBounds(260,220,120,30);
            DateEnd.setFont(new Font("楷体",Font.BOLD,20));
            add(DateEnd);

            clientName = new JLabel("入住人");
            clientName.setForeground(Color.WHITE);
            clientName.setBounds(40,260,120,30);
            clientName.setFont(new Font("楷体",Font.BOLD,20));
            add(clientName);

            //入住人姓名
            cName = new JTextField();
            cName.setEditable(false);
            cName.setBounds(140,260,220,30);
            cName.setFont(new Font("楷体",Font.BOLD,20));
            add(cName);

            clientIDCard = new JLabel("身份证");
            clientIDCard.setForeground(Color.WHITE);
            clientIDCard.setBounds(40,300,120,30);
            clientIDCard.setFont(new Font("楷体",Font.BOLD,20));
            add(clientIDCard);

            //入住人身份证
            cID = new JTextField();
            cID.setEditable(false);
            cID.setBounds(140,300,220,30);
            cID.setFont(new Font("楷体",Font.BOLD,20));
            add(cID);

            clientTelephone = new JLabel("电话号码");
            clientTelephone.setForeground(Color.WHITE);
            clientTelephone.setBounds(40,340,120,30);
            clientTelephone.setFont(new Font("楷体",Font.BOLD,20));
            add(clientTelephone);

            //入住人电话号码
            cTel = new JTextField();
            cTel.setEditable(false);
            cTel.setBounds(140,340,220,30);
            cTel.setFont(new Font("楷体",Font.BOLD,20));
            add(cTel);

            //返回主界面
            backMenu = new JButton("返回");
            backMenu.setBounds(30,400,100,40);
            backMenu.setFont(new Font("楷体",Font.BOLD,20));
            backMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame hotel = new Hotel();
                    dispose();
                }
            });
            add(backMenu);

            //查询订单是否存在
            checkOrder = new JButton("查询");
            checkOrder.setBounds(150,400,100,40);
            checkOrder.setFont(new Font("楷体",Font.BOLD,20));
            checkOrder.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i = 0;i < Main.orders.size();i++) {
                        if(oNumber.getText().equals(Main.orders.get(i).orderNumber)) {
                            int tempRoomType = Integer.parseInt(Main.orders.get(i).roomNuber);  //根据房间号码的范围得知房间类型
                            if(tempRoomType >= 5000 && tempRoomType < 6000) {
                                rModel.setText(SingleRoomMessage.type);
                                rPrice.setText(SingleRoomMessage.price);
                                roomRemarks.setText(SingleRoomMessage.rMarks);
                            } else if(tempRoomType >= 6000 && tempRoomType < 7000){
                                rModel.setText(DoubleRoomMessage.type);
                                rPrice.setText(DoubleRoomMessage.price);
                                roomRemarks.setText(DoubleRoomMessage.rMarks);
                            } else if(tempRoomType >= 8000 && tempRoomType < 9000) {
                                rModel.setText(PrecidentRoomMessage.type);
                                rPrice.setText(PrecidentRoomMessage.price);
                                roomRemarks.setText(PrecidentRoomMessage.rMarks);
                            }
                            DateStart.setText(Main.orders.get(i).dateStart);
                            DateEnd.setText(Main.orders.get(i).dateEnd);
                            cName.setText(Main.orders.get(i).clientName);
                            cID.setText(Main.orders.get(i).clientIDCard);
                            cTel.setText(Main.orders.get(i).clientTelephone);
                            clientCheckIn.setEnabled(true);
                            return;
                        }
                    }
                    new ErrorFeedback("查询失败","没有此订单");
                }
            });
            add(checkOrder);

            //确认入住
            clientCheckIn = new JButton("确认入住");
            clientCheckIn.setBounds(270,400,100,40);
            clientCheckIn.setFont(new Font("楷体",Font.BOLD,15));
            clientCheckIn.setEnabled(false);
            clientCheckIn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i = 0;i < Main.orders.size();i++) {
                        if(oNumber.getText().equals(Main.orders.get(i).orderNumber)) {
                            if(Main.orders.get(i).hadChecking == true) {
                                new ErrorFeedback("入住失败","该订单已入住");
                                return;
                            }
                            //订单记录已入住
                            Main.orders.get(i).hadChecking = true;
                            //反馈分配的房间号
                            new CorrectFeedback("入住成功","房间号：" + Main.orders.get(i).roomNuber);
                            //让房间状态变为被使用
                            for(int j = 0;j < Main.singleRoomMessages.size();j++) {
                                if(Main.singleRoomMessages.get(j).rNumber.equals(Main.orders.get(i).roomNuber)) {
                                    Main.singleRoomMessages.get(j).hadUsed = true;
                                    Main.saveData();
                                    return;
                                }
                            }
                            for(int j = 0;j < Main.doubleRoomMessages.size();j++) {
                                if(Main.doubleRoomMessages.get(j).rNumber.equals(Main.orders.get(i).roomNuber)) {
                                    Main.doubleRoomMessages.get(j).hadUsed = true;
                                    Main.saveData();
                                    return;
                                }
                            }
                            for(int j = 0;j < Main.precidentRoomMessages.size();j++) {
                                if(Main.precidentRoomMessages.get(j).rNumber.equals(Main.orders.get(i).roomNuber)) {
                                    Main.precidentRoomMessages.get(j).hadUsed = true;
                                    Main.saveData();
                                    return;
                                }
                            }
                            clientCheckIn.setEnabled(false);
                            return;
                        }
                    }
                    new ErrorFeedback("入住失败","没有此订单");
                }
            });
            add(clientCheckIn);

            setVisible(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            ImageIcon icon = new ImageIcon(new File("").getAbsolutePath() + "/backgroud.jpg");
            Image image = icon.getImage();
            g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
        }
    }
}
