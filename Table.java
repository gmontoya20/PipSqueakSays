import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Table extends JDialog{

    JTable table;
    JLabel label;
    JButton button;
    JLabel searchPrompt;
    JLabel searchFail;
    JTextField textField;
    ArrayList<Movie> movieOrder;
    private int x = 0;
 
    public Table(){//constructor takes in an array list of Movie Objects
       	this.setModal(true);
	setLayout(new FlowLayout());
	
	movieOrder = Movie.movieList;//change movieOrder to be whatever list is called
	
	String[] columnNames = {"Title", "Date Released", "Rating", "Producer"};	      Object[][] data = new Object[Movie.movieList.size()][4];
	//fill the matrix with the appropriate movie info
	for(int i = 0; i < Movie.movieList.size(); i++){
	    data[i][0] = movieOrder.get(i).title;
	    data[i][1] = movieOrder.get(i).yearReleased;
	    data[i][2] = movieOrder.get(i).avgRating;
	    data[i][3] = movieOrder.get(i).producer;
	}

	table = new JTable(data, columnNames){
		public boolean isCellEditable(int row, int col){
		    return false;
		}
	    };
	table.setPreferredScrollableViewportSize(new Dimension(450, 300));
	table.setFillsViewportHeight(true);


	JScrollPane scrollPane = new JScrollPane(table);
	add(scrollPane);

	searchPrompt = new JLabel("Type a movie title to learn more about it");
	add(searchPrompt);

	textField = new JTextField(30);
	add(textField);

	searchFail = new JLabel("");
	add(searchFail);
	
	label = new JLabel("Can't find a movie? Add it to our list!");
	add(label);
	
	button = new JButton("Add a movie");
	add(button);

	TableEvent te = new TableEvent();
	textField.addActionListener(te);

    }
    
    public class TableEvent implements ActionListener{
	public void actionPerformed(ActionEvent te){
	    String input = textField.getText();
	    Movie movie;

	    for(int i = 0; i < Movie.movieList.size(); i++){
		movie = Movie.movieList.get(i);
		if(input.equalsIgnoreCase(movie.title)){
		    FilmInfo film = new FilmInfo(movie);
		    film.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		    film.setSize(700, 500);
		    film.setLocation(200, 200);
		    film.setVisible(true);
		    film.setTitle(movie.title);
		    searchFail.setText("");
		    x = 0;
		    break;
		}
		else{ 
		    x = 1;
		}  
		
	    }
	    if(x == 1){
		searchFail.setText("PipSqueak hasn't seen that movie.");
		x = 0;
	    }

	}
    }
   
    


}


