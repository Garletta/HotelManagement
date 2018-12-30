import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//付款
public class Payment extends JFrame{

    public static boolean payed;   //是否已付款

    public JLabel needPay;
    public JTextField nPay; //实付款输入
    public JButton back;    //返回
    public JButton receipt; //付款

    public Payment(String requiredPayment) {
        super();
        setTitle("付款");
        initPayment(requiredPayment);
    }

    public void initPayment(String requiredPayment) {
        setSize(300,200);
        setLocationRelativeTo(null);    //放置于屏幕中央
        setLayout(null);                //布局方式
        setResizable(false);            //不可延伸
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        payed = false;

        needPay = new JLabel("需付" + requiredPayment + "元");
        needPay.setBounds(20,20,240,50);
        needPay.setFont(new Font("楷体",Font.BOLD,15));
        add(needPay);

        //实付款（前台人员输入）
        nPay = new JTextField();
        nPay.setBounds(110,20,140,50);
        nPay.setFont(new Font("楷体",Font.BOLD,20));
        add(nPay);

        //退出付款界面
        back = new JButton("返回");
        back.setBounds(40,100,100,40);
        back.setFont(new Font("楷体",Font.BOLD,20));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(back);

        //收款
        receipt = new JButton("收款");
        receipt.setBounds(160,100,100,40);
        receipt.setFont(new Font("楷体",Font.BOLD,20));
        receipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double rPayment = Double.parseDouble(requiredPayment);
                double aPayment = Double.parseDouble(nPay.getText());
                nPay.setVisible(false);
                if(rPayment <= aPayment) {
                    payed = true;
                    needPay.setText("付款成功，找零 " + (aPayment - rPayment) + "元");
                } else {
                    payed = false;
                    needPay.setText("付款失败");
                }
                receipt.setEnabled(false);
            }
        });
        add(receipt);

        setVisible(true);
    }
}
