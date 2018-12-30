import javax.swing.*;
import java.awt.*;

//失败反馈
public class ErrorFeedback extends JFrame {

    public ErrorFeedback(String errorFeedbackTitle,String errorFeedbackText) {
        super();
        setTitle(errorFeedbackTitle);
        initErrorFeedback(errorFeedbackText);
    }

    public void initErrorFeedback(String errorFeedbackText) {
        setSize(300,80);
        setLocationRelativeTo(null);    //放置于屏幕中央
        setLayout(new BorderLayout());  //布局方式
        setResizable(false);            //不可延伸
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //反馈失败信息
        JLabel errorFeedback = new JLabel(errorFeedbackText,JLabel.LEFT);
        errorFeedback.setForeground(Color.RED);
        errorFeedback.setFont(new Font("楷体",Font.BOLD,20));
        add(errorFeedback);

        setVisible(true);
    }
}