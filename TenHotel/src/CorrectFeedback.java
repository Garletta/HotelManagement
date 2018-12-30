import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//正确反馈
public class CorrectFeedback extends JFrame {

    public JLabel success;
    public JButton back;

    public CorrectFeedback(String correctFeedbackTitle,String correctFeedbackText) {
        super();
        setTitle(correctFeedbackTitle);
        initSuccess(correctFeedbackText);
    }

    public void initSuccess(String correctFeedbackText) {
        setSize(300,180);
        setLocationRelativeTo(null);    //放置于屏幕中央
        setLayout(null);  //布局方式
        setResizable(false);            //不可延伸
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //反馈正确信息
        success = new JLabel(correctFeedbackText,JLabel.CENTER);
        success.setBounds(0,20,this.getWidth(),40);
        success.setFont(new Font("楷体",Font.BOLD,20));
        add(success);

        //返回主界面
        back = new JButton("返回");
        back.setBounds(100,80,100,40);
        back.setFont(new Font("楷体",Font.BOLD,15));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(back);

        setVisible(true);
    }
}