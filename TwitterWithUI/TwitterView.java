import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.*;

public class TwitterView extends JFrame implements ActionListener{
    // the instance of the user account
    private Account model;
                
	private JPanel menuPanel = new JPanel(); // contains the homeBtn, and searchPanel
	private JButton homeButton = new JButton("Home");
	private JTextField searchField = new JTextField(20);
	private JButton searchBtn = new JButton("Search");
	
	private JPanel sideBarPanel = new JPanel(); // contains the userInfoPanel and the postTweetPanel
	private JPanel userInfoPanel = new JPanel(); // contains the nameLabel, unameLabel, and tweetCountLabel
	private JLabel nameLabel = new JLabel();
	private JLabel unameLabel = new JLabel();
	private JLabel tweetCountLabel = new JLabel();
	
	private JPanel postTweetPanel = new JPanel(); // contains the newTweetTextArea and postTweetBtn
	private JLabel postTweetLabel = new JLabel("Post Tweet");
	private JTextArea newTweetTextArea = new JTextArea(4, 17);
	private JButton postTweetBtn = new JButton("Tweet");
	
	private JPanel deletePanel = new JPanel();
	private JButton deleteBtn = new JButton("Delete");
	
	private JPanel tweetsPanel = new JPanel(); // contains the tweetList
	private JLabel tweetLabel = new JLabel("Tweets:");
	private DefaultListModel<String> tweetListModel = new DefaultListModel<String>();
	private JList tweetList = new JList(tweetListModel);
	
	private JScrollPane browseTweets = new JScrollPane(tweetList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	public TwitterView(Account account){
		this.model = account;
		
		setTitle("Twitter");
		setSize(800, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menuPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		menuPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		homeButton.addActionListener(this);
        searchBtn.addActionListener(this);
		menuPanel.add(homeButton);
		menuPanel.add(searchField);
		menuPanel.add(searchBtn);
		
		sideBarPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		sideBarPanel.setPreferredSize(new Dimension(200, 0));
		sideBarPanel.setLayout(new BorderLayout());
		
		userInfoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		userInfoPanel.setLayout(new GridLayout(3, 1));
		userInfoPanel.add(nameLabel);
		userInfoPanel.add(unameLabel);
		userInfoPanel.add(tweetCountLabel);
		
		postTweetPanel.add(postTweetLabel);
		newTweetTextArea.setLineWrap(true);
		postTweetPanel.add(newTweetTextArea);
		postTweetBtn.addActionListener(this);
		postTweetPanel.add(postTweetBtn);
		
		sideBarPanel.add(userInfoPanel, BorderLayout.NORTH);
		sideBarPanel.add(postTweetPanel);
		
		tweetsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		tweetsPanel.setPreferredSize(new Dimension(600, 0));
		tweetsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		browseTweets.setPreferredSize(new Dimension(580,360));
		tweetsPanel.add(tweetLabel);
		tweetsPanel.add(browseTweets);
		
		deletePanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		deletePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		deleteBtn.addActionListener(this);
		deletePanel.add(deleteBtn);
		
		add(menuPanel, BorderLayout.NORTH);
		add(sideBarPanel, BorderLayout.WEST);
		add(tweetsPanel, BorderLayout.EAST);
		add(deletePanel, BorderLayout.SOUTH);
		
		initializeContents();
	}
	
	private void initializeContents(){
        nameLabel.setText("Welcome " + model.getName() + "!");
        unameLabel.setText("@" + model.getUname());
        tweetCountLabel.setText("Number Of Tweets: " + model.getTweetCnt());
        for(int i = 0; i < model.getTweetCnt(); i++)
            tweetListModel.addElement(model.tweetString(i));
    }
	
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == homeButton){
            searchField.setText(null);
            newTweetTextArea.setText(null);
            tweetListModel.clear();
            initializeContents();
        }
        else if(event.getSource() == postTweetBtn){
            int counter = model.getTweetCnt();
            model.postTweet(newTweetTextArea.getText());
            tweetListModel.addElement(model.tweetString(counter));
            tweetCountLabel.setText("Number Of Tweets: "+model.getTweetCnt());
			newTweetTextArea.setText(null);
        }
        else if(event.getSource() == searchBtn){
            tweetListModel.clear();
            model.searchTweets(searchField.getText());
            for(int i = 0; i < model.getSearchCnt(); i++)
                tweetListModel.addElement(model.searchTweetString(i));
        }
		else if(event.getSource() == deleteBtn){
			model.deleteTweet(tweetList.getSelectedIndex() + 1);
			newTweetTextArea.setText(null);
			tweetListModel.clear();
            initializeContents();
        }
    }
}