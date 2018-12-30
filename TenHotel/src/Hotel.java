import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//主界面
public class Hotel extends JFrame {

    public HotelJPanel hotelJPanel; //界面画板

    public JLabel hotelName;        //酒店名字
    public JLabel buttonBorder;     //边框
    public JButton bookRoom;        //订房
    public JButton checkIn;         //入住
    public JButton checkOut;        //退房

    public Hotel() {
        super();
        initHotel();
    }

    public void initHotel() {
        setTitle("酒店客房管理系统");       //标题
        setSize(400,500);   //界面大小
        setLocationRelativeTo(null);    //放置于屏幕中央
        setLayout(null);                //布局方式
        setResizable(false);            //不可延伸
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //界面关闭方式

        hotelJPanel = new HotelJPanel();
        hotelJPanel.setBounds(0,0,this.getWidth(),this.getHeight());
        add(hotelJPanel);

        setVisible(true);               //设可见
    }

    class HotelJPanel extends JPanel {

        public HotelJPanel() {
            super();
            initHotelJPanel();
        }

        public void initHotelJPanel() {
            setLayout(null);
            setLocationRelativeTo(null);

            //酒店名称
            hotelName = new JLabel("圣地亚哥酒店",JLabel.CENTER);
            hotelName.setBounds(10,40,380,80);
            hotelName.setFont(new Font("楷体",Font.BOLD,50));
            add(hotelName);

            //装饰小边框
            buttonBorder = new JLabel();
            buttonBorder.setBounds(60,120,260,320);
            buttonBorder.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(buttonBorder);

            //订房
            bookRoom = new JButton("订房");
            bookRoom.setBounds(100,140,180,80);
            bookRoom.setFont(new Font("黑体",Font.BOLD,40));
            bookRoom.setHorizontalAlignment(SwingConstants.CENTER);
            bookRoom.setVerticalAlignment(SwingConstants.CENTER);
            bookRoom.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame book = new Booking();
                    dispose();
                }
            });
            add(bookRoom);

            //入住
            checkIn = new JButton("入住");
            checkIn.setBounds(100,240,180,80);
            checkIn.setFont(new Font("黑体",Font.BOLD,40));
            checkIn.setHorizontalAlignment(SwingConstants.CENTER);
            checkIn.setVerticalAlignment(SwingConstants.CENTER);
            checkIn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame checkin = new CheckIn();
                    dispose();
                }
            });
            add(checkIn);

            //退房
            checkOut = new JButton("退房");
            checkOut.setBounds(100,340,180,80);
            checkOut.setFont(new Font("黑体",Font.BOLD,40));
            checkOut.setHorizontalAlignment(SwingConstants.CENTER);
            checkOut.setVerticalAlignment(SwingConstants.CENTER);
            checkOut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame checkout = new CheckOut();
                    dispose();
                }
            });
            add(checkOut);

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
