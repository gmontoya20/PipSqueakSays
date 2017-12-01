import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovieListWindow extends JDialog{

    JLabel label;
    JButton alpha;
    JButton popular;
    JButton date;
    
    public MovieListWindow(JFrame frame){
	super(frame, "Movie Lists", true);
	setLayout(new FlowLayout());

	label = new JLabel("What order would you like to see the movies?");
	add(label);
	
	alpha = new JButton("Alphabetical");
	add(alpha);

	popular = new JButton("Most Popular");
	add(popular);
	
	date = new JButton("Most Recent");
	add(date);
	
	Events ev = new Events();
	alpha.addActionListener(ev);
	popular.addActionListener(ev);
	date.addActionListener(ev);
    }
    
    public class Events implements ActionListener{
	public void actionPerformed(ActionEvent ev){
	    
	    Object src = ev.getSource();

	    if(src == alpha){
		//this is where we'd call a Movie method that would return the
		//movie array list in alphabetical order and input it into
		//parameters below
		ArrayList<Movie> alpha = callAlphaorder(ArrayList<Movie> movie);
		Table table = new Table();
		table.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		table.setSize(500, 500);
		table.setLocation(200, 200);
		table.setVisible(true);
	       	       
	    }else if(src == popular){
		//this is where we'd call a Movie method that would return the
		//movie array list in order of most popular
		Table table = new Table();
		table.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		table.setSize(500, 500);
		table.setLocation(200, 200);
		table.setVisible(true);

	    }else if(src == date){
		//this is where we'd call a Movie method that would return the
		//movie array list in order of date released
		Table table = new Table();
		table.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		table.setSize(500, 500);
		table.setLocation(200, 200);
		table.setVisible(true);

	    }
	    
	}
	public void callAlphaorder(ArrayList<Movie> movie){
		
	}
    }
    


}
