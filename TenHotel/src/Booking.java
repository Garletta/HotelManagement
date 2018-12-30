import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

//预订房间界面
public class Booking extends JFrame {

    public BookingJPanel bookingJPanel; //界面画板

    public JLabel roomModel;
    public JComboBox modelBox;          //房间类型
    public JLabel roomPrice;
    public JLabel rPrice;               //房间价格
    public JLabel remainRooms;
    public JLabel reRooms;              //房间余数
    public JTextArea roomRemarks;       //房间类型简介
    public JLabel bookDate;
    public JTextField DateStart;        //入住时间
    public JLabel div;                  //间隔符
    public JTextField DateEnd;          //退房时间
    public JLabel clientName;
    public JTextField cName;            //入住人
    public JLabel clientIDCard;
    public JTextField cID;              //入住人身份证
    public JLabel clientTelephone;
    public JTextField cTel;             //入住人电话号码
    public JButton backMenu;            //返回主菜单
    public JButton checkIn;             //立即入住
    public JButton book;                //仅预订
    public JButton payIt;               //付款
    public Payment paying;

    public Booking() {
        super();
        initBooking();
    }

    public void initBooking() {
        setTitle("预订房间");
        setSize(400, 500);
        setLocationRelativeTo(null);    //放置于屏幕中央
        setLayout(null);                //布局方式
        setResizable(false);            //不可延伸
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        bookingJPanel = new BookingJPanel();
        bookingJPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(bookingJPanel);

        setVisible(true);               //设可见
    }

    class BookingJPanel extends JPanel {

        public BookingJPanel() {
            super();
            initBookingJPanel();
        }

        public void initBookingJPanel() {
            setLayout(null);
            setLocationRelativeTo(null);

            roomModel = new JLabel("房间类型");
            roomModel.setBounds(40, 20, 120, 30);
            roomModel.setFont(new Font("楷体", Font.BOLD, 20));
            add(roomModel);

            //房间类型
            modelBox = new JComboBox<String>();
            modelBox.setBounds(40, 50, 120, 30);
            modelBox.setFont(new Font("楷体", Font.BOLD, 20));
            modelBox.addItem("单人房");
            modelBox.addItem("双人房");
            modelBox.addItem("总统套房");
            modelBox.setSelectedItem(1);
            modelBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(modelBox.getSelectedItem() == "单人房") {
                        roomRemarks.setText(SingleRoomMessage.rMarks);
                        rPrice.setText(SingleRoomMessage.price);
                        int cnt = 0;
                        for(int i = 0;i < Main.singleRoomMessages.size();i++) {
                            if(Main.singleRoomMessages.get(i).hadUsed == false) {
                                cnt++;
                            }
                        }
                        reRooms.setText(String.valueOf(cnt));
                    } else if(modelBox.getSelectedItem() == "双人房") {
                        roomRemarks.setText(DoubleRoomMessage.rMarks);
                        rPrice.setText(DoubleRoomMessage.price);
                        int cnt = 0;
                        for(int i = 0;i < Main.doubleRoomMessages.size();i++) {
                            if(Main.doubleRoomMessages.get(i).hadUsed == false) {
                                cnt++;
                            }
                        }
                        reRooms.setText(String.valueOf(cnt));
                    } else if(modelBox.getSelectedItem() == "总统套房") {
                        roomRemarks.setText(PrecidentRoomMessage.rMarks);
                        rPrice.setText(PrecidentRoomMessage.price);
                        int cnt = 0;
                        for(int i = 0;i < Main.precidentRoomMessages.size();i++) {
                            if(Main.precidentRoomMessages.get(i).hadUsed == false) {
                                cnt++;
                            }
                        }
                        reRooms.setText(String.valueOf(cnt));
                    }
                }
            });
            add(modelBox);

            roomPrice = new JLabel("价格");
            roomPrice.setBounds(180, 20, 50, 30);
            roomPrice.setFont(new Font("楷体", Font.BOLD, 20));
            add(roomPrice);

            //房间价格
            rPrice = new JLabel(SingleRoomMessage.price, JLabel.RIGHT);
            rPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            rPrice.setOpaque(true);
            rPrice.setBackground(Color.WHITE);
            rPrice.setBounds(180, 50, 80, 30);
            rPrice.setFont(new Font("楷体", Font.BOLD, 20));
            add(rPrice);

            remainRooms = new JLabel("剩余房数");
            remainRooms.setBounds(280, 20, 120, 30);
            remainRooms.setFont(new Font("楷体", Font.BOLD, 20));
            add(remainRooms);

            //房间余数
            int cnt = 0;
            for(int i = 0;i < Main.singleRoomMessages.size();i++) {
                if(Main.singleRoomMessages.get(i).hadUsed == false) {
                    cnt++;
                }
            }
            reRooms = new JLabel(String.valueOf(cnt),JLabel.RIGHT);
            reRooms.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            reRooms.setOpaque(true);
            reRooms.setBackground(Color.WHITE);
            reRooms.setBounds(280, 50, 80, 30);
            reRooms.setFont(new Font("楷体", Font.BOLD, 20));
            add(reRooms);

            //房型简介
            roomRemarks = new JTextArea(SingleRoomMessage.rMarks);
            roomRemarks.setBounds(30, 100, 340, 100);
            roomRemarks.setFont(new Font("楷体", Font.BOLD, 20));
            roomRemarks.setLineWrap(true);
            roomRemarks.setEditable(false);
            add(roomRemarks);

            bookDate = new JLabel("时间");
            bookDate.setForeground(Color.WHITE);
            bookDate.setBounds(40, 220, 120, 30);
            bookDate.setFont(new Font("楷体", Font.BOLD, 20));
            add(bookDate);

            //入住时间
            DateStart = new JTextField("");
            DateStart.setBounds(100, 220, 120, 30);
            DateStart.setFont(new Font("楷体", Font.BOLD, 20));
            add(DateStart);

            //间隔符
            div = new JLabel(" 至 ");
            div.setForeground(Color.WHITE);
            div.setBounds(230, 220, 120, 30);
            div.setFont(new Font("楷体", Font.BOLD, 20));
            add(div);

            //退房时间
            DateEnd = new JTextField("");
            DateEnd.setBounds(260, 220, 120, 30);
            DateEnd.setFont(new Font("楷体", Font.BOLD, 20));
            add(DateEnd);

            clientName = new JLabel("入住人");
            clientName.setForeground(Color.WHITE);
            clientName.setBounds(40, 260, 120, 30);
            clientName.setFont(new Font("楷体", Font.BOLD, 20));
            add(clientName);

            //入住人姓名
            cName = new JTextField("");
            cName.setBounds(140, 260, 220, 30);
            cName.setFont(new Font("楷体", Font.BOLD, 20));
            add(cName);

            clientIDCard = new JLabel("身份证");
            clientIDCard.setForeground(Color.WHITE);
            clientIDCard.setBounds(40, 300, 120, 30);
            clientIDCard.setFont(new Font("楷体", Font.BOLD, 20));
            add(clientIDCard);

            //入住人身份证
            cID = new JTextField("");
            cID.setBounds(140, 300, 220, 30);
            cID.setFont(new Font("楷体", Font.BOLD, 20));
            add(cID);

            clientTelephone = new JLabel("电话号码");
            clientTelephone.setForeground(Color.WHITE);
            clientTelephone.setBounds(40, 340, 120, 30);
            clientTelephone.setFont(new Font("楷体", Font.BOLD, 20));
            add(clientTelephone);

            //入住人电话号码
            cTel = new JTextField("");
            cTel.setBounds(140, 340, 220, 30);
            cTel.setFont(new Font("楷体", Font.BOLD, 20));
            add(cTel);

            //返回主界面
            backMenu = new JButton("返回");
            backMenu.setBounds(20, 400, 80, 40);
            backMenu.setFont(new Font("楷体", Font.BOLD, 20));
            backMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame hotel = new Hotel(); //返回系统初始界面
                    dispose();
                }
            });
            add(backMenu);

            //立即入住
            checkIn = new JButton("入住");
            checkIn.setBounds(110, 400, 80, 40);
            checkIn.setFont(new Font("楷体", Font.BOLD, 20));
            checkIn.setEnabled(false);
            checkIn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkMessage() == false) {
                        return;
                    }
                    if(Payment.payed = false) {
                        new ErrorFeedback("操作失败","未付款");
                        return;
                    }
                    Payment.payed = false;

                    //预设时间格式，用时间（精确到秒）来生成订单号
                    SimpleDateFormat format = new SimpleDateFormat("yyyymmddhhmmss");

                    //付款成功后分配房间
                    if(modelBox.getSelectedItem() == "单人房") {
                        for(int i = 0;i < Main.singleRoomMessages.size();i++) {
                            if(Main.singleRoomMessages.get(i).hadUsed == false) {
                                Main.singleRoomMessages.get(i).hadUsed = true;
                                Order order = new Order(true,format.format(new Date()), DateStart.getText(), DateEnd.getText(), cName.getText(), cID.getText(), cTel.getText(), Main.singleRoomMessages.get(i).rNumber,true);
                                Main.orders.add(order);
                                Main.singleRoomMessages.get(i).hadUsed = true;
                                Main.saveData();
                                new CorrectFeedback("入住成功","房间号：" + Main.singleRoomMessages.get(i).rNumber);
                                return;
                            }
                        }
                    } else if(modelBox.getSelectedItem() == "双人房") {
                        for(int i = 0;i < Main.doubleRoomMessages.size();i++) {
                            if(Main.doubleRoomMessages.get(i).hadUsed == false) {
                                Main.doubleRoomMessages.get(i).hadUsed = true;
                                Order order = new Order(true,format.format(new Date()), DateStart.getText(), DateEnd.getText(), cName.getText(), cID.getText(), cTel.getText(), Main.doubleRoomMessages.get(i).rNumber,true);
                                Main.orders.add(order);
                                Main.doubleRoomMessages.get(i).hadUsed = true;
                                Main.saveData();
                                new CorrectFeedback("入住成功","房间号：" + Main.doubleRoomMessages.get(i).rNumber);
                                return;
                            }
                        }
                    } else if(modelBox.getSelectedItem() == "总统套房") {
                        for(int i = 0;i < Main.precidentRoomMessages.size();i++) {
                            if(Main.precidentRoomMessages.get(i).hadUsed == false) {
                                Main.precidentRoomMessages.get(i).hadUsed = true;
                                Order order = new Order(true,format.format(new Date()), DateStart.getText(), DateEnd.getText(), cName.getText(), cID.getText(), cTel.getText(), Main.precidentRoomMessages.get(i).rNumber,true);
                                Main.orders.add(order);
                                Main.precidentRoomMessages.get(i).hadUsed = true;
                                Main.saveData();
                                new CorrectFeedback("入住成功","房间号：" + Main.precidentRoomMessages.get(i).rNumber);
                                return;
                            }
                        }
                    }
                }
            });
            add(checkIn);

            //仅预订房间
            book = new JButton("预订");
            book.setBounds(200, 400, 80, 40);
            book.setFont(new Font("楷体", Font.BOLD, 20));
            book.setEnabled(false);
            book.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkMessage() == false) {
                        return;
                    }
                    if(Payment.payed = false) {
                        new ErrorFeedback("操作失败","未付款");
                        return;
                    }
                    Payment.payed = false;

                    //预设时间格式，用时间（精确到秒）来生成订单号
                    SimpleDateFormat format = new SimpleDateFormat("yyyymmddhhmmss");

                    //付款成功后分配房间
                    if(modelBox.getSelectedItem() == "单人房") {
                        for(int i = 0;i < Main.singleRoomMessages.size();i++) {
                            if(Main.singleRoomMessages.get(i).hadUsed == false) {
                                Main.singleRoomMessages.get(i).hadUsed = true;
                                Order order = new Order(true,format.format(new Date()), DateStart.getText(), DateEnd.getText(), cName.getText(), cID.getText(), cTel.getText(), Main.singleRoomMessages.get(i).rNumber,true);
                                Main.orders.add(order);
                                Main.singleRoomMessages.get(i).hadUsed = true;
                                Main.saveData();
                                new CorrectFeedback("预订成功", "订单号:" + order.orderNumber);
                                return;
                            }
                        }
                    } else if(modelBox.getSelectedItem() == "双人房") {
                        for(int i = 0;i < Main.doubleRoomMessages.size();i++) {
                            if(Main.doubleRoomMessages.get(i).hadUsed == false) {
                                Main.doubleRoomMessages.get(i).hadUsed = true;
                                Order order = new Order(true,format.format(new Date()), DateStart.getText(), DateEnd.getText(), cName.getText(), cID.getText(), cTel.getText(), Main.doubleRoomMessages.get(i).rNumber,true);
                                Main.orders.add(order);
                                Main.doubleRoomMessages.get(i).hadUsed = true;
                                Main.saveData();
                                new CorrectFeedback("预订成功", "订单号:" + order.orderNumber);
                                return;
                            }
                        }
                    } else if(modelBox.getSelectedItem() == "总统套房") {
                        for(int i = 0;i < Main.precidentRoomMessages.size();i++) {
                            if(Main.precidentRoomMessages.get(i).hadUsed == false) {
                                Main.precidentRoomMessages.get(i).hadUsed = true;
                                Order order = new Order(true,format.format(new Date()), DateStart.getText(), DateEnd.getText(), cName.getText(), cID.getText(), cTel.getText(), Main.precidentRoomMessages.get(i).rNumber,true);
                                Main.orders.add(order);
                                Main.precidentRoomMessages.get(i).hadUsed = true;
                                Main.saveData();
                                new CorrectFeedback("预订成功", "订单号:" + order.orderNumber);
                                return;
                            }
                        }
                    }
                }
            });
            add(book);

            payIt = new JButton("付款");
            payIt.setBounds(290,400,80,40);
            payIt.setFont(new Font("楷体", Font.BOLD, 20));
            payIt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //付款
                    if(checkMessage() == false) {
                        return;
                    }
                    paying = new Payment(rPrice.getText());
                    book.setEnabled(true);
                    checkIn.setEnabled(true);
                }
            });
            add(payIt);

            setVisible(true);
        }

        public boolean checkMessage() {
            //检查必填信息是否为空
            if (DateStart.getText().equals("") || DateStart.getText().equals(null) || DateEnd.getText().equals("") || DateEnd.getText().equals(null)) {
                new ErrorFeedback("操作失败", "入住时间不能为空");
                return false;
            }
            if (cName.getText().equals("") || cName.getText().equals(null)) {
                new ErrorFeedback("操作失败", "入住人不能为空");
                return false;
            }
            if (cID.getText().equals("") || cID.getText().equals(null)) {
                new ErrorFeedback("操作失败", "入住人身份证不能为空");
                return false;
            }
            if (cTel.getText().equals("") || cTel.getText().equals(null)) {
                new ErrorFeedback("操作失败", "入住人电话号码不能为空");
                return false;
            }
            if (reRooms.getText().equals("0")) { //检查余房是否充足
                new ErrorFeedback("操作失败", "房间不足");
                return false;
            }

            return true;
        }

        @Override
        protected void paintComponent(Graphics g) {
            ImageIcon icon = new ImageIcon(new File("").getAbsolutePath() + "/backgroud.jpg");
            Image image = icon.getImage();
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
