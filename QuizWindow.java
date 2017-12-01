import java.awt.*;
import javax.swing.*;

public class QuizWindow extends JDialog{
    
    JLabel label;
    
    public QuizWindow(JFrame frame){
	super(frame, "PipSqueak's Quiz", true);
	setLayout(new FlowLayout());
	label = new JLabel("This is where we'll put a quiz");
	add(label);
	
    }

}