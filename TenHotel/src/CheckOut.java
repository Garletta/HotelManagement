import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CheckOut extends JFrame {

    public CheckOutJPanel checkOutJPanel;   //界面画板

    public JLabel orderNumberOrRoomNumber;
    public JTextField oNumberOrRNumber;     //订单号或房间号
    public JButton backMenu;                //返回主界面
    public JButton checkout;                //退房

    public CheckOut() {
        super();
        initCheckOut();
    }

    public void initCheckOut() {
        setTitle("退房");
        setSize(300,200);
        setLocationRelativeTo(null);    //放置于屏幕中央
        setLayout(null);                //布局方式
        setResizable(false);            //不可延伸
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        checkOutJPanel = new CheckOutJPanel();
        checkOutJPanel.setBounds(0,0,this.getWidth(),this.getHeight());
        add(checkOutJPanel);

        setVisible(true);               //设可见
    }

    class CheckOutJPanel extends JPanel{

        public CheckOutJPanel() {
            super();
            initCheckOutJPanel();
        }

        public void initCheckOutJPanel() {
            setLayout(null);
            setLocationRelativeTo(null);

            orderNumberOrRoomNumber = new JLabel("请输入订单号或房间号");
            orderNumberOrRoomNumber.setBounds(20,10,260,40);
            orderNumberOrRoomNumber.setFont(new Font("楷体",Font.BOLD,20));
            add(orderNumberOrRoomNumber);

            //订单号或房间号
            oNumberOrRNumber = new JTextField();
            oNumberOrRNumber.setBounds(20,50,260,40);
            oNumberOrRNumber.setFont(new Font("楷体",Font.BOLD,20));
            add(oNumberOrRNumber);

            //返回主界面
            backMenu = new JButton("返回");
            backMenu.setBounds(40,100,100,40);
            backMenu.setFont(new Font("楷体",Font.BOLD,20));
            backMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame hotel = new Hotel();
                    dispose();
                }
            });
            add(backMenu);

            //退房
            checkout = new JButton("确认退房");
            checkout.setBounds(160,100,100,40);
            checkout.setFont(new Font("楷体",Font.BOLD,15));
            checkout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //找到需要退的房间
                    for(int i = 0;i < Main.orders.size();i++) {
                        if(oNumberOrRNumber.getText().equals(Main.orders.get(i).orderNumber) || oNumberOrRNumber.getText().equals(Main.orders.get(i).roomNuber)) {
                            //恢复房间为未使用
                            for(int j = 0;j < Main.singleRoomMessages.size();j++) {
                                if(Main.singleRoomMessages.get(j).rNumber.equals(Main.orders.get(i).roomNuber)) {
                                    Main.singleRoomMessages.get(j).hadUsed = false;
                                    Main.saveData();
                                    JFrame correct = new CorrectFeedback("退房成功","请打印发票");
                                    ((CorrectFeedback) correct).back.setText("打印发票");
                                    return;
                                }
                            }
                            for(int j = 0;j < Main.doubleRoomMessages.size();j++) {
                                if(Main.doubleRoomMessages.get(j).rNumber.equals(Main.orders.get(i).roomNuber)) {
                                    Main.doubleRoomMessages.get(j).hadUsed = false;
                                    Main.saveData();
                                    JFrame correct = new CorrectFeedback("退房成功","请打印发票");
                                    ((CorrectFeedback) correct).back.setText("打印发票");
                                    return;
                                }
                            }
                            for(int j = 0;j < Main.precidentRoomMessages.size();j++) {
                                if(Main.precidentRoomMessages.get(j).rNumber.equals(Main.orders.get(i).roomNuber)) {
                                    Main.precidentRoomMessages.get(j).hadUsed = false;
                                    Main.saveData();
                                    JFrame correct = new CorrectFeedback("退房成功","请打印发票");
                                    ((CorrectFeedback) correct).back.setText("打印发票");
                                    return;
                                }
                            }
                        }
                    }
                    new ErrorFeedback("退房失败","订单号或房间号不对");
                }
            });
            add(checkout);

            setVisible(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            ImageIcon icon = new ImageIcon(new File("").getAbsolutePath() + "/backgroud.jpg");
            Image image = icon.getImage();
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
