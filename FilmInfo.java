import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FilmInfo extends JDialog{

    private JLabel mainLine;
    private JLabel producer;
    private JLabel summary;
    JTable reviewTable;
    private JLabel reviewPrompt;
    private JTextField enterRating;
    private JTextArea enterReview;
    private JButton reviewButton;
    private JLabel warningLabel;
    private Movie movie;

    public FilmInfo(Movie movie){
	this.setModal(true);
	this.setTitle(movie.title);
	this.setLayout(new FlowLayout());
	this.movie = movie;
	
	mainLine = new JLabel(movie.title + " (" + movie.yearReleased + ")");
	add(mainLine);
	
	producer = new JLabel(movie.producer);
	add(producer);

	summary = new JLabel(movie.summary);
	add(summary);
	
	String[] columnNames = {"Rating", "Review"};
	Object[][] data = new Object[movie.reviews.size()][2];

	for(int i = 0; i < movie.reviews.size(); i++){
	    data[i][0] = movie.reviews.get(i).rating;
	    data[i][1] = movie.reviews.get(i).theReview;
	}
	
	reviewTable = new JTable(data, columnNames){
		public boolean isCellEditable(int row, int col){
		    return false;
		}
	    };
	reviewTable.setPreferredScrollableViewportSize(new Dimension(300, 150));
	reviewTable.setFillsViewportHeight(true);

	JScrollPane scrollPane = new JScrollPane(reviewTable);
	add(scrollPane);
		
	reviewPrompt = new JLabel("Want to add a review?");
	add(reviewPrompt);

	enterRating = new JTextField("Enter decimals only here. Example: 7.5");
        add(enterRating);

	enterReview = new JTextArea("Write your review here", 5, 30);
	add(enterReview);
	
	reviewButton = new JButton("Click here when your review is done");
	add(reviewButton);
	
	warningLabel = new JLabel("");
	add(warningLabel);

	FilmInfoEvent filmevent = new FilmInfoEvent();
	reviewButton.addActionListener(filmevent);
    }
    
    public class FilmInfoEvent implements ActionListener{
	public void actionPerformed(ActionEvent filmevent){
	    String review = enterReview.getText();
	    String rating = enterRating.getText();
	    
	    try{
		Double decimalRating = Double.parseDouble(rating);
		movie.addReview(decimalRating, review);
		warningLabel.setText("Close and Re-Open window to see review");
	    }
	    catch(NumberFormatException ignore){
		warningLabel.setText("Please enter only decimal values for the r ating");
	    }
	    
	    
	    }
	}
}