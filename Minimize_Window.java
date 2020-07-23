package texteditor;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;



@SuppressWarnings("serial")
public class Minimize_Window extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menubar;
	private JMenu file,edit;        //format,view,help;
	private JMenuItem i1,i2,i3,i4,i5,i7,i8,i9,i10;
	private JTextArea textArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Minimize_Window frame1 = new Minimize_Window();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Minimize_Window() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 600, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(0, 57, 600, 400);
		contentPane.add(textArea);
		
		
		menubar = new JMenuBar();
		menubar.setBounds(0, 33, 600, 25);
		contentPane.add(menubar);
		menubar.setBackground(Color.WHITE);
		menubar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		file = new JMenu("File");
		file.setFont(new Font("Georgia", Font.PLAIN, 14));
		edit = new JMenu("Edit");
		edit.setFont(new Font("Georgia", Font.PLAIN, 14));
		/*
		format = new JMenu("Format");
		view = new JMenu("View");
		help = new JMenu("Help");
		*/
		
		
		i1 = new JMenuItem("New");
		i1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		i2 = new JMenuItem("Open");
		i2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		i3 = new JMenuItem("Save");
		i3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		i4 = new JMenuItem("Save As");
		i4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		i5 = new JMenuItem("Exit");
		i5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		
		//i6 = new JMenuItem("Undo");
		//i6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		i7 = new JMenuItem("Cut");
		i7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		i8 = new JMenuItem("Copy");
		i8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		i9 = new JMenuItem("Paste");
		i9.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		i10 = new JMenuItem("Select All");
		i10.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		//i6.addActionListener(this);
		i7.addActionListener(this);
		i8.addActionListener(this);
		i9.addActionListener(this);
		i10.addActionListener(this);
		
		
		file.add(i1);
		file.add(i2);
		file.add(i3);
		file.add(i4);
		file.add(i5);
		
		//edit.add(i6);
		edit.add(i7);
		edit.add(i8);
		edit.add(i9);
		edit.add(i10);
		
		menubar.add(file);
		menubar.add(edit);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 600, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton restore_btn = new JButton("");
		restore_btn.setFocusable(false);
		restore_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Minimize_Window().setVisible(false);
				new Notepad().setVisible(true);
			}
		});
		restore_btn.setIcon(new ImageIcon("C:\\Users\\Abijot Gupta\\Desktop\\NOTEPAD\\src\\img\\icons8-restore-down-16.png"));
		restore_btn.setBackground(Color.WHITE);
		restore_btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		restore_btn.setBounds(529, 0, 37, 28);
		panel.add(restore_btn);
		
		JButton close_btn = new JButton("");
		close_btn.setFocusable(false);
		close_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		close_btn.setIcon(new ImageIcon("C:\\Users\\Abijot Gupta\\Desktop\\NOTEPAD\\src\\img\\icons8-close-window-24.png"));
		close_btn.setBackground(Color.WHITE);
		close_btn.setAlignmentX(0.5f);
		close_btn.setBounds(563, 0, 37, 28);
		panel.add(close_btn);
	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == i1)
		{
			this.setTitle("New Document.txt");
			textArea.setText("");
		}
		
		if(e.getSource() == i2)
		{
			
			JFileChooser open = new JFileChooser();
			
			//FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			    
			//open.setFileFilter(filter);
			int option = open.showOpenDialog(this);
			
		    if(option == JFileChooser.APPROVE_OPTION)
		    {
		    	this.textArea.setText("");
		    	
		    	try {
		    			BufferedReader br = new BufferedReader(new FileReader(open.getSelectedFile().getPath()));
		    			String line = br.readLine();
		    		
		    			while(line != null)
		    			{
		    				this.textArea.append(line + "\n");
		    				line = br.readLine();		
		    			} 	
		    			
		    			br.close();
		    		}
		    	
		    	catch(Exception e1) {
	    			System.out.println(e1.getMessage());
	    			}
		    	
		    }
		}
		
		
		
		if(e.getSource() == i3)
		{
			JFileChooser save = new JFileChooser();
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text", ".txt");
		    save.setFileFilter(filter);
			
			int option = save.showSaveDialog(this);
			 if(option == JFileChooser.APPROVE_OPTION)
			 {
			    	this.textArea.setText("");
			    	
			    	try {
			    			PrintWriter out = new PrintWriter(save.getSelectedFile().getPath());
			    			out.write(this.textArea.getText());
			    			out.close();
			    		}
			    	
			    	catch(Exception e1) {
		    			System.out.println(e1.getMessage());
			    	}	
			  }	
		}
		
		if(e.getSource() == i4)
		{
			JFileChooser save = new JFileChooser();
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text", ".txt");
		    save.setFileFilter(filter);
			
			int option = save.showSaveDialog(this);
			 if(option == JFileChooser.APPROVE_OPTION)
			 {
			    this.textArea.setText("");
			    	
			    try {
			   			PrintWriter out = new PrintWriter(save.getSelectedFile().getPath());
			   			out.write(this.textArea.getText());
			   			out.close();
			   		}
		    	
		    	catch(Exception e1) {
	    			System.out.println(e1.getMessage());
	    		   }	
			  }	
		}
		
		if(e.getSource() == i5)
		{
			System.exit(0);
		}
		
		//if(e.getSource() == i6)
		//{
			//UNDO
		//}
		
		if(e.getSource() == i7)
		{
			textArea.cut();
		}
		
		if(e.getSource() == i8)
		{
			textArea.copy();
		}
		
		if(e.getSource() == i9)
		{
			textArea.paste();
		}
		
		if(e.getSource() == i10)
		{
			textArea.selectAll();
		}
	}
}
