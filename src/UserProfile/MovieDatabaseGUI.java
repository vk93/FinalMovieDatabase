/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserProfile;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Foxtrot
 */
public class MovieDatabaseGUI extends javax.swing.JFrame {

    /**
     * Creates new form MovieDatabaseGUI
     */
    List<String> moviesList = new ArrayList<String>();
    List<String> movies = new ArrayList<String>();
    List<String> moviesbyrating = new ArrayList<String>();
    profile defaultUser = new profile("test","test");
    profile currentUser = defaultUser;
    AutocompleteComboBox combo;
    ItemSearchable searchable;
    
    ArrayList<profile> users = new ArrayList();
    
    int movieDataSize = 0;
    String[] movieDataArray;
    String[] movieRatingArray;
    
    public MovieDatabaseGUI() {
        
        readFileMovies();
        searchable = new ItemSearchable(moviesList);
        combo = new AutocompleteComboBox(searchable);
        initComponents2();
        readFile();
        //Loading Users
        try {
            Scanner line = new Scanner(new File("users.txt"));
            while (line.hasNext()){
            String userName = line.next();
            String passWord = line.next();
            profile oldUser = new profile(userName, passWord);
            users.add(oldUser);
            }
        line.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MovieDatabaseGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        users.add(defaultUser);
        
        ReviewPanel.setVisible(false);
        NewUserPanel.setVisible(false);
        MovieDatabasePanel.setVisible(false);
        HomePagePanel.setVisible(false);
        InvalidLoginLabel.setVisible(false);
        Genre2Spinner.setVisible(false);
        Genre3Spinner.setVisible(false);
        SuggestMoviePanel.setVisible(false);
      
    }
    public void readFileMovies()
    {
        String string="";
        String file ="reviews.txt";

        //reading   
        try{
            InputStream ips=new FileInputStream(file); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String line;
            int i =0;
            while ((line=br.readLine())!=null){
                if(!(moviesList.contains(line)))
                {
                moviesList.add(line);
                string+=line+"\n";
                }
                br.readLine();
                string+=line+"\n";
                br.readLine();
                string+=line+"\n";
                br.readLine();
                string+=line+"\n";
                br.readLine();
                string+=line+"\n";
                br.readLine();
                string+=line+"\n";
                br.readLine();
                string+=line+"\n";
                br.readLine();
                string+=line+"\n";
                string = "";
                i++;
            }
            br.close(); 
            
        }       
        catch (Exception e){
            System.out.println(e.toString());
        }

    }
        public void readFile()
    {
        String string="";
        String file ="reviews.txt";

        //reading   
        try{
            InputStream ips=new FileInputStream(file); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            
            String line;
            while ((line=br.readLine())!=null){
                movies.add(line);
                string+=line+"\n";
                movieDataSize+=1;
            }
            br.close(); 
        }       
        catch (Exception e){
            System.out.println(e.toString());
        }
        try{
            InputStream ips=new FileInputStream(file); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            
            String line;
            movieDataArray = new String[movieDataSize];
            int g = 0;
            
            while ((line=br.readLine())!=null) {
                movieDataArray[g] = line;
                g+=1;
            }

            br.close(); 
        }       
        catch (Exception e){
            System.out.println(e.toString());
        }
        
        addMovies(movieDataArray);
    }
        
    protected void addMovies(String[] movies) {
        MovieDatabaseList.setListData(movies);
    }
    
    public void SortMovieByRating(){     // sort movies by rating
        movieRatingArray=movieDataArray;
        String[] CurReview = new String[10];
        for(int k=0;k<movieDataSize;k=k+8){
        for(int i=0;i<movieDataSize-12;i=i+8){
            int cur = Character.getNumericValue(movieRatingArray[i+2].charAt(6));
            int next = Character.getNumericValue(movieRatingArray[i+2+8].charAt(6));
            if(cur<next){
                CurReview=Arrays.copyOfRange(movieRatingArray, i, i+7);
                    for(int j=0;j<7;j++){
                        movieRatingArray[i+j]=movieRatingArray[i+j+8];
                        movieRatingArray[i+j+8]=CurReview[j];
                    }
            }
        }
        }
        SuggestMovieList.setListData(movieRatingArray);
    }

    private profile hasUser(String username)
    {
        for(profile p: users)
        {
            if(p.getUsername().equals(username))
                return p;
        }
        return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginPanel = new javax.swing.JPanel();
        LoginTitleLabel = new javax.swing.JLabel();
        LoginUsernameLabel = new javax.swing.JLabel();
        LoginPasswordLabel = new javax.swing.JLabel();
        LoginUsernameTextField = new javax.swing.JTextField();
        LoginPasswordTextField = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        NewUserButton = new javax.swing.JButton();
        InvalidLoginLabel = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        AboutLabel = new javax.swing.JLabel();
        AboutLabel2 = new javax.swing.JLabel();
        ReviewPanel = new javax.swing.JPanel();
        LogoutButton = new javax.swing.JButton();
        MovieTitleTextField = new javax.swing.JTextField();
        MovieTitleLabel = new javax.swing.JLabel();
        FeedbackLabel = new javax.swing.JLabel();
        RatingLabel = new javax.swing.JLabel();
        RatingSlider = new javax.swing.JSlider();
        String[] genrelist = {"Action","Adventure","Animation","Comedy","Crime","Documentary","Drama", "Family","Fantasy","Film-Noir","History","Horror","Music","Musical","Mystery","Romance","Sci-Fi","Sport","Thriller","War","Western"};
        SpinnerListModel genremodel = new SpinnerListModel(genrelist);
        Genre1Spinner = new javax.swing.JSpinner(genremodel);
        //String[] genrelist = {"Action","Adventure","Animation","Comedy","Crime","Documentary","Drama", "Family","Fantasy","Film-Noir","History","Horror","Music","Musical","Mystery","Romance","Sci-Fi","Sport","Thriller","War","Western"};
        SpinnerListModel genremodel2 = new SpinnerListModel(genrelist);
        Genre2Spinner = new javax.swing.JSpinner(genremodel2);
        //String[] genrelist = {"Action","Adventure","Animation","Comedy","Crime","Documentary","Drama", "Family","Fantasy","Film-Noir","History","Horror","Music","Musical","Mystery","Romance","Sci-Fi","Sport","Thriller","War","Western"};
        SpinnerListModel genremodel3 = new SpinnerListModel(genrelist);
        Genre3Spinner = new javax.swing.JSpinner(genremodel3);
        SpinnerModel model =
        new SpinnerNumberModel(1, //initial value
            1, //min
            3, //max
            1);
        NumGenresSpinner = new javax.swing.JSpinner(model);
        NumGenresLabel = new javax.swing.JLabel();
        ChooseGenresLabel = new javax.swing.JLabel();
        ReccomendLabel = new javax.swing.JLabel();
        RecommendYesCheckBox = new javax.swing.JCheckBox();
        RecommendNoCheckBox = new javax.swing.JCheckBox();
        SubmitButton1 = new javax.swing.JButton();
        CurrentUserLabel = new javax.swing.JLabel();
        ReviewToHomeButton = new javax.swing.JButton();
        NewUserPanel = new javax.swing.JPanel();
        NewProfileLabel = new javax.swing.JLabel();
        NewUsernameLabel = new javax.swing.JLabel();
        PasswordLabel1 = new javax.swing.JLabel();
        NewUsernameTextField = new javax.swing.JTextField();
        NewPasswordField1 = new javax.swing.JPasswordField();
        CreateProfileButton = new javax.swing.JButton();
        PasswordLabel2 = new javax.swing.JLabel();
        NewPasswordField2 = new javax.swing.JPasswordField();
        ProfileErrorLabel = new javax.swing.JLabel();
        MovieDatabasePanel = new javax.swing.JPanel();
        DatabaseLogoutButton = new javax.swing.JButton();
        DatabaseToHomeButton = new javax.swing.JButton();
        icon2 = new javax.swing.JLabel();
        MovieDatabaseScrollable = new javax.swing.JScrollPane();
        MovieDatabaseList = new javax.swing.JList();
        HomePagePanel = new javax.swing.JPanel();
        WelcomeLabel = new javax.swing.JLabel();
        HomeLogoutButton = new javax.swing.JButton();
        HomeUserLabel = new javax.swing.JLabel();
        CanDoLabel = new javax.swing.JLabel();
        SuggestionButton = new javax.swing.JButton();
        HomeReviewButton = new javax.swing.JButton();
        FindFriendsButton = new javax.swing.JButton();
        HomeToMoviesButtom = new javax.swing.JButton();
        SuggestMoviePanel = new javax.swing.JPanel();
        SuggestLogoutButton = new javax.swing.JButton();
        icon3 = new javax.swing.JLabel();
        SuggestMovieToHomeButton = new javax.swing.JButton();
        SuggestMovieScrollable = new javax.swing.JScrollPane();
        SuggestMovieList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MovieDatabase");
        getContentPane().setLayout(new java.awt.CardLayout());

        LoginPanel.setBackground(new java.awt.Color(255, 102, 0));

        LoginTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        LoginTitleLabel.setFont(new java.awt.Font("PilGi", 1, 96)); // NOI18N
        LoginTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoginTitleLabel.setText("Login");

        LoginUsernameLabel.setFont(new java.awt.Font("PilGi", 0, 36)); // NOI18N
        LoginUsernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoginUsernameLabel.setText("Username");

        LoginPasswordLabel.setFont(new java.awt.Font("PilGi", 0, 36)); // NOI18N
        LoginPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoginPasswordLabel.setText("Password");

        LoginUsernameTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        LoginPasswordTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        LoginButton.setText("Let me in!");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        NewUserButton.setText("I'm new here.");
        NewUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewUserButtonActionPerformed(evt);
            }
        });

        InvalidLoginLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        InvalidLoginLabel.setForeground(new java.awt.Color(255, 255, 255));
        InvalidLoginLabel.setText("Invalid username or password!");

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserProfile/rsz_couch-potato-illustration-1142363.jpg"))); // NOI18N
        icon.setMaximumSize(new java.awt.Dimension(400, 403));
        icon.setMinimumSize(new java.awt.Dimension(400, 403));

        AboutLabel.setFont(new java.awt.Font("PilGi", 0, 20)); // NOI18N
        AboutLabel.setForeground(new java.awt.Color(255, 255, 255));
        AboutLabel.setText("Meet Couch Potato. Your friendly guide to movies");

        AboutLabel2.setFont(new java.awt.Font("PilGi", 0, 20)); // NOI18N
        AboutLabel2.setForeground(new java.awt.Color(255, 255, 255));
        AboutLabel2.setText("and fellow couch potatoes.");

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addGap(0, 126, Short.MAX_VALUE)
                .addComponent(AboutLabel)
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(InvalidLoginLabel)
                                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(LoginPanelLayout.createSequentialGroup()
                                        .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(NewUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LoginPanelLayout.createSequentialGroup()
                                            .addComponent(LoginPasswordLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(LoginPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LoginPanelLayout.createSequentialGroup()
                                            .addComponent(LoginUsernameLabel)
                                            .addGap(18, 18, 18)
                                            .addComponent(LoginUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(LoginPanelLayout.createSequentialGroup()
                                .addComponent(LoginTitleLabel)
                                .addGap(193, 193, 193)))
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addComponent(AboutLabel2)
                        .addGap(165, 165, 165))))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoginTitleLabel)
                .addGap(51, 51, 51)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginUsernameLabel)
                    .addComponent(LoginUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginPasswordTextField)
                    .addComponent(LoginPasswordLabel))
                .addGap(18, 18, 18)
                .addComponent(InvalidLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginButton)
                    .addComponent(NewUserButton))
                .addGap(18, 18, 18)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AboutLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AboutLabel2)
                .addGap(34, 34, 34))
        );

        getContentPane().add(LoginPanel, "card2");

        ReviewPanel.setBackground(new java.awt.Color(255, 102, 0));

        LogoutButton.setText("Logout");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        MovieTitleLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        MovieTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        MovieTitleLabel.setText("What movie did you watch?");

        FeedbackLabel.setFont(new java.awt.Font("PilGi", 0, 20)); // NOI18N
        FeedbackLabel.setForeground(new java.awt.Color(255, 255, 255));

        RatingLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        RatingLabel.setForeground(new java.awt.Color(255, 255, 255));
        RatingLabel.setText("How fantastic (or crumby) was it?");

        RatingSlider.setMajorTickSpacing(1);
        RatingSlider.setMaximum(5);
        RatingSlider.setPaintLabels(true);
        RatingSlider.setPaintTicks(true);

        NumGenresSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                NumGenresSpinnerStateChanged(evt);
            }
        });

        NumGenresLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        NumGenresLabel.setForeground(new java.awt.Color(255, 255, 255));
        NumGenresLabel.setText("Number of Movie Genres?");

        ChooseGenresLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        ChooseGenresLabel.setForeground(new java.awt.Color(255, 255, 255));
        ChooseGenresLabel.setText("Choose genres:");

        ReccomendLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        ReccomendLabel.setForeground(new java.awt.Color(255, 255, 255));
        ReccomendLabel.setText("Should I see it?");

        RecommendYesCheckBox.setFont(new java.awt.Font("PilGi", 0, 20)); // NOI18N
        RecommendYesCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        RecommendYesCheckBox.setSelected(true);
        RecommendYesCheckBox.setText("Add to your movie bucket list!");
        RecommendYesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecommendYesCheckBoxActionPerformed(evt);
            }
        });

        RecommendNoCheckBox.setFont(new java.awt.Font("PilGi", 0, 20)); // NOI18N
        RecommendNoCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        RecommendNoCheckBox.setText("Save two hours of your life.");
        RecommendNoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecommendNoCheckBoxActionPerformed(evt);
            }
        });

        SubmitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButton1ActionPerformed(evt);
            }
        });

        CurrentUserLabel.setFont(new java.awt.Font("PilGi", 0, 36)); // NOI18N
        CurrentUserLabel.setForeground(new java.awt.Color(255, 255, 255));

        ReviewToHomeButton.setText("I want to do something else.");
        ReviewToHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReviewToHomeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ReviewPanelLayout = new javax.swing.GroupLayout(ReviewPanel);
        ReviewPanel.setLayout(ReviewPanelLayout);
        ReviewPanelLayout.setHorizontalGroup(
            ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReviewPanelLayout.createSequentialGroup()
                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(RatingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LogoutButton))
                    .addComponent(FeedbackLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MovieTitleLabel)
                            .addComponent(CurrentUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RatingLabel)))
                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(MovieTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ReviewPanelLayout.createSequentialGroup()
                                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                                        .addComponent(ChooseGenresLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(Genre1Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(NumGenresLabel)))
                                .addGap(18, 18, 18)
                                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NumGenresSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                                        .addComponent(Genre2Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Genre3Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(ReviewPanelLayout.createSequentialGroup()
                                .addComponent(ReccomendLabel)
                                .addGap(18, 18, 18)
                                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RecommendNoCheckBox)
                                    .addComponent(RecommendYesCheckBox)
                                    .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(SubmitButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ReviewToHomeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        ReviewPanelLayout.setVerticalGroup(
            ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReviewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoutButton)
                .addGap(18, 18, 18)
                .addComponent(CurrentUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(MovieTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MovieTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RatingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RatingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumGenresLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumGenresSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChooseGenresLabel)
                    .addComponent(Genre1Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Genre2Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Genre3Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReccomendLabel)
                    .addComponent(RecommendYesCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RecommendNoCheckBox)
                .addGap(18, 18, 18)
                .addComponent(SubmitButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReviewToHomeButton)
                .addGap(18, 18, 18)
                .addComponent(FeedbackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        Genre2Spinner.setVisible(false);
        Genre3Spinner.setVisible(false);

        getContentPane().add(ReviewPanel, "card3");

        NewUserPanel.setBackground(new java.awt.Color(255, 102, 0));

        NewProfileLabel.setFont(new java.awt.Font("PilGi", 0, 64)); // NOI18N
        NewProfileLabel.setForeground(new java.awt.Color(255, 255, 255));
        NewProfileLabel.setText("Join the cult!");

        NewUsernameLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        NewUsernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        NewUsernameLabel.setText("What should we call you?");

        PasswordLabel1.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        PasswordLabel1.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLabel1.setText("Secret passcode:");

        NewUsernameTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        NewPasswordField1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        CreateProfileButton.setText("BECOME ONE OF US.");
        CreateProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateProfileButtonActionPerformed(evt);
            }
        });

        PasswordLabel2.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        PasswordLabel2.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLabel2.setText("Retype password:");

        NewPasswordField2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        ProfileErrorLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        ProfileErrorLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout NewUserPanelLayout = new javax.swing.GroupLayout(NewUserPanel);
        NewUserPanel.setLayout(NewUserPanelLayout);
        NewUserPanelLayout.setHorizontalGroup(
            NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewUserPanelLayout.createSequentialGroup()
                .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewUserPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NewUsernameLabel)
                            .addComponent(PasswordLabel1)
                            .addComponent(PasswordLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NewUsernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(NewPasswordField1)
                            .addComponent(NewPasswordField2)))
                    .addGroup(NewUserPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NewProfileLabel)
                            .addComponent(ProfileErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewUserPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CreateProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
        );
        NewUserPanelLayout.setVerticalGroup(
            NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewUserPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(NewProfileLabel)
                .addGap(51, 51, 51)
                .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewUsernameLabel)
                    .addComponent(NewUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLabel1)
                    .addComponent(NewPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLabel2)
                    .addComponent(NewPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(CreateProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(ProfileErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );

        getContentPane().add(NewUserPanel, "card4");

        MovieDatabasePanel.setBackground(new java.awt.Color(255, 102, 0));

        DatabaseLogoutButton.setText("Logout");
        DatabaseLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatabaseLogoutButtonActionPerformed(evt);
            }
        });

        DatabaseToHomeButton.setText("GET ME OUT OF HERE!");
        DatabaseToHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatabaseToHomeButtonActionPerformed(evt);
            }
        });

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserProfile/rsz_couch-potato-illustration-1142363.jpg"))); // NOI18N

        MovieDatabaseScrollable.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MovieDatabaseScrollable.setPreferredSize(new java.awt.Dimension(50, 50));
        MovieDatabaseScrollable.setSize(new java.awt.Dimension(50, 50));

        MovieDatabaseList.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        MovieDatabaseScrollable.setViewportView(MovieDatabaseList);

        javax.swing.GroupLayout MovieDatabasePanelLayout = new javax.swing.GroupLayout(MovieDatabasePanel);
        MovieDatabasePanel.setLayout(MovieDatabasePanelLayout);
        MovieDatabasePanelLayout.setHorizontalGroup(
            MovieDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(DatabaseToHomeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DatabaseLogoutButton)
                .addContainerGap())
            .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(MovieDatabaseScrollable, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(icon2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MovieDatabasePanelLayout.setVerticalGroup(
            MovieDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                .addGroup(MovieDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DatabaseLogoutButton))
                    .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(DatabaseToHomeButton)))
                .addGroup(MovieDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(MovieDatabaseScrollable, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(icon2)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        getContentPane().add(MovieDatabasePanel, "card5");

        HomePagePanel.setBackground(new java.awt.Color(255, 102, 0));

        WelcomeLabel.setFont(new java.awt.Font("PilGi", 0, 48)); // NOI18N
        WelcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        WelcomeLabel.setText("Welcome back,");

        HomeLogoutButton.setText("Logout");
        HomeLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeLogoutButtonActionPerformed(evt);
            }
        });

        HomeUserLabel.setFont(new java.awt.Font("PilGi", 0, 48)); // NOI18N
        HomeUserLabel.setForeground(new java.awt.Color(255, 255, 255));

        CanDoLabel.setFont(new java.awt.Font("PilGi", 0, 36)); // NOI18N
        CanDoLabel.setForeground(new java.awt.Color(255, 255, 255));
        CanDoLabel.setText("What can I do for you today?");

        SuggestionButton.setText("Find me a movie!");
        SuggestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuggestionButtonActionPerformed(evt);
            }
        });

        HomeReviewButton.setText("Let me give my two cents.");
        HomeReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeReviewButtonActionPerformed(evt);
            }
        });

        FindFriendsButton.setText("Friends, please...?");
        FindFriendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindFriendsButtonActionPerformed(evt);
            }
        });

        HomeToMoviesButtom.setText("Leave me alone.  I want to find my own movie.");
        HomeToMoviesButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeToMoviesButtomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HomePagePanelLayout = new javax.swing.GroupLayout(HomePagePanel);
        HomePagePanel.setLayout(HomePagePanelLayout);
        HomePagePanelLayout.setHorizontalGroup(
            HomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePagePanelLayout.createSequentialGroup()
                .addGroup(HomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePagePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HomeLogoutButton))
                    .addGroup(HomePagePanelLayout.createSequentialGroup()
                        .addGroup(HomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HomePagePanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(WelcomeLabel)
                                .addGap(18, 18, 18)
                                .addComponent(HomeUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HomePagePanelLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(CanDoLabel))
                            .addGroup(HomePagePanelLayout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addGroup(HomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FindFriendsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(HomeToMoviesButtom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(HomeReviewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SuggestionButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addContainerGap())
        );
        HomePagePanelLayout.setVerticalGroup(
            HomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeLogoutButton)
                .addGap(20, 20, 20)
                .addGroup(HomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WelcomeLabel)
                    .addComponent(HomeUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(CanDoLabel)
                .addGap(38, 38, 38)
                .addComponent(SuggestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(HomeReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FindFriendsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(HomeToMoviesButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        getContentPane().add(HomePagePanel, "card6");

        SuggestMoviePanel.setBackground(new java.awt.Color(255, 102, 0));

        SuggestLogoutButton.setText("Logout");
        SuggestLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuggestLogoutButtonActionPerformed(evt);
            }
        });

        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserProfile/rsz_couch-potato-illustration-1142363.jpg"))); // NOI18N

        SuggestMovieToHomeButton.setText("GET ME OUT OF HERE!");
        SuggestMovieToHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuggestMovieToHomeButtonActionPerformed(evt);
            }
        });

        SuggestMovieScrollable.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SuggestMovieScrollable.setPreferredSize(new java.awt.Dimension(50, 50));
        SuggestMovieScrollable.setSize(new java.awt.Dimension(50, 50));

        SuggestMovieList.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        SuggestMovieScrollable.setViewportView(SuggestMovieList);

        javax.swing.GroupLayout SuggestMoviePanelLayout = new javax.swing.GroupLayout(SuggestMoviePanel);
        SuggestMoviePanel.setLayout(SuggestMoviePanelLayout);
        SuggestMoviePanelLayout.setHorizontalGroup(
            SuggestMoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SuggestMoviePanelLayout.createSequentialGroup()
                .addGroup(SuggestMoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(SuggestMovieScrollable, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(icon3))
                    .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(SuggestMovieToHomeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SuggestLogoutButton)))
                .addContainerGap())
        );
        SuggestMoviePanelLayout.setVerticalGroup(
            SuggestMoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                .addGroup(SuggestMoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SuggestLogoutButton))
                    .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(SuggestMovieToHomeButton)))
                .addGroup(SuggestMoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(icon3))
                    .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(SuggestMovieScrollable, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        getContentPane().add(SuggestMoviePanel, "card7");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // TODO add your handling code here:
        //String feedback = "Review for " + "\"" + MovieTitleTextField.getText() + "\" submitted by " + UsernameTextField.getText();
        currentUser = null;
        ReviewPanel.setVisible(false);
        LoginPanel.setVisible(true);
        LoginUsernameTextField.setText("");
        LoginPasswordTextField.setText("");
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        String entered = LoginUsernameTextField.getText();
        if(hasUser(entered) != null && hasUser(entered).getPassword().equals(LoginPasswordTextField.getText()))
        {
            NumGenresSpinner.setValue(1);
            LoginPanel.setVisible(false);
            HomePagePanel.setVisible(true);
            currentUser = hasUser(entered);
            HomeUserLabel.setText(currentUser.getUsername() + "!");
        }
        else
        {
            InvalidLoginLabel.setVisible(true);
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void CreateProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateProfileButtonActionPerformed
        // TODO add your handling code here:
        if(hasUser(NewUsernameTextField.getText()) != null)
        {
            ProfileErrorLabel.setText("Somebody already goes by that! Be more creative.");
        }
        else if(NewPasswordField1.getText().equals(NewPasswordField2.getText()))
        {
            profile newuser = new profile(NewUsernameTextField.getText(), NewPasswordField1.getText());
            users.add(newuser); 
            
            //This part writes out to a text file called "users.txt"
            //The username and password are two different lines
            try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("users.txt", true)))) {
                 out.println(newuser.username);
                 out.println(newuser.getPassword());
            }catch (IOException e) {
            //exception handling left as an exercise for the reader
            }
            NewUserPanel.setVisible(false);
            LoginPanel.setVisible(true);
            InvalidLoginLabel.setVisible(false);
            LoginUsernameTextField.setText("");
            LoginPasswordTextField.setText("");
        }
        else
            ProfileErrorLabel.setText("Mismatched Passwords! Let's try this again.");
    }//GEN-LAST:event_CreateProfileButtonActionPerformed

    private void NewUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewUserButtonActionPerformed
        // TODO add your handling code here:
        LoginPanel.setVisible(false);
        NewUserPanel.setVisible(true);
        NewUsernameTextField.setText("");
        NewPasswordField1.setText("");
        NewPasswordField2.setText("");
    }//GEN-LAST:event_NewUserButtonActionPerformed

    private void NumGenresSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_NumGenresSpinnerStateChanged
        
        int numGenres = (int)NumGenresSpinner.getValue();
        
        switch(numGenres)
        {
            case 2:
                Genre1Spinner.setVisible(true);
                Genre2Spinner.setVisible(true);
                Genre3Spinner.setVisible(false);
                break;
            case 3:
                Genre1Spinner.setVisible(true);
                Genre2Spinner.setVisible(true);
                Genre3Spinner.setVisible(true);
                break;
            default:
                Genre1Spinner.setVisible(true);
                Genre2Spinner.setVisible(false);
                Genre3Spinner.setVisible(false);
                break;
        }
    }//GEN-LAST:event_NumGenresSpinnerStateChanged

    private void RecommendYesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecommendYesCheckBoxActionPerformed
        if(RecommendYesCheckBox.isSelected())
            RecommendNoCheckBox.setSelected(false);
    }//GEN-LAST:event_RecommendYesCheckBoxActionPerformed

    private void RecommendNoCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecommendNoCheckBoxActionPerformed
        if(RecommendNoCheckBox.isSelected())
            RecommendYesCheckBox.setSelected(false);        // TODO add your handling code here:
    }//GEN-LAST:event_RecommendNoCheckBoxActionPerformed

    private void SubmitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButton1ActionPerformed
        
            //This part writes out to a text file called "reviews.txt"
            // Each value is a separate line
        FeedbackLabel.setText("Congrats, " + currentUser.getUsername() + "! You just reviewed \""+ combo.getString() +"\".");     
        review myReview;
        int selected;
        if( RecommendYesCheckBox.isSelected())
            selected = 1;
        else
            selected = 0;
        if((int)NumGenresSpinner.getValue() ==1)
            myReview = new review(currentUser,combo.getString(),RatingSlider.getValue(),(String)Genre1Spinner.getValue(), "-----","-----", selected);
        else if ((int)NumGenresSpinner.getValue() ==2)
            myReview = new review(currentUser,combo.getString(),RatingSlider.getValue(),(String)Genre1Spinner.getValue(), (String)Genre2Spinner.getValue(),"-----", selected);
        else
            myReview = new review(currentUser,combo.getString(),RatingSlider.getValue(),(String)Genre1Spinner.getValue(), (String)Genre2Spinner.getValue(),(String)Genre3Spinner.getValue(), selected);
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reviews.txt", true)))) {
            out.println(combo.getString());
            out.println("Critiqued by: " + currentUser.getUsername());
            out.println("Rated " + RatingSlider.getValue() + " out of 5 stars."); //This is to figure out how many ratings
            out.println("Genres: " + (String)Genre1Spinner.getValue());
            if((int)NumGenresSpinner.getValue() ==1) {
                out.println("        -----");
                out.println("        -----");
            }
            if((int)NumGenresSpinner.getValue() ==2) {
                out.println("        " + (String)Genre2Spinner.getValue());
                out.println("        -----");
            }
            if((int)NumGenresSpinner.getValue() ==3) {
                out.println("        " + (String)Genre2Spinner.getValue());
                out.println("        " + (String)Genre3Spinner.getValue());
            }
            if(selected == 1) {
                out.println("Their advice? WATCH IT.");
                out.println("--------");
            }
            if(selected == 0) {
                out.println("They suggest you don't watch it...");
                out.println("--------");
            }
            }catch (IOException e) {
            }
        MovieTitleTextField.setText("");
        moviesList.add(combo.getString());
        readFileMovies();
    }//GEN-LAST:event_SubmitButton1ActionPerformed

    private void HomeLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeLogoutButtonActionPerformed
        // TODO add your handling code here:
        currentUser = null;
        HomePagePanel.setVisible(false);
        LoginPanel.setVisible(true);
        LoginUsernameTextField.setText("");
        LoginPasswordTextField.setText("");
    }//GEN-LAST:event_HomeLogoutButtonActionPerformed

    private void SuggestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuggestionButtonActionPerformed
        // TODO add your handling code here:
        // This is the Find me a Movie Function
        //readFile();
        SortMovieByRating();
        HomePagePanel.setVisible(false);
        SuggestMoviePanel.setVisible(true);
    }//GEN-LAST:event_SuggestionButtonActionPerformed

    private void HomeReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeReviewButtonActionPerformed
        // TODO add your handling code here:
        String entered = LoginUsernameTextField.getText();
        HomePagePanel.setVisible(false);
        NumGenresSpinner.setValue(1);
        ReviewPanel.setVisible(true);
        currentUser = hasUser(entered);
        CurrentUserLabel.setText(currentUser.getUsername() + ", spill the beans...");
        SubmitButton1.setText("Sincerely, " + currentUser.getUsername());
    }//GEN-LAST:event_HomeReviewButtonActionPerformed

    private void FindFriendsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindFriendsButtonActionPerformed
        // TODO add your handling code here:
        // This is the Friends please button
    }//GEN-LAST:event_FindFriendsButtonActionPerformed

    private void HomeToMoviesButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeToMoviesButtomActionPerformed
        // TODO add your handling code here:
        readFile();
        HomePagePanel.setVisible(false);
        MovieDatabasePanel.setVisible(true);
    }//GEN-LAST:event_HomeToMoviesButtomActionPerformed

    private void ReviewToHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReviewToHomeButtonActionPerformed
        // TODO add your handling code here:
        ReviewPanel.setVisible(false);
        HomePagePanel.setVisible(true);
    }//GEN-LAST:event_ReviewToHomeButtonActionPerformed

    private void DatabaseLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatabaseLogoutButtonActionPerformed
        // TODO add your handling code here:
        currentUser = null;
        MovieDatabasePanel.setVisible(false);
        LoginPanel.setVisible(true);
        LoginUsernameTextField.setText("");
        LoginPasswordTextField.setText("");
    }//GEN-LAST:event_DatabaseLogoutButtonActionPerformed

    private void DatabaseToHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatabaseToHomeButtonActionPerformed
        // TODO add your handling code here:
        MovieDatabasePanel.setVisible(false);
        HomePagePanel.setVisible(true);
    }//GEN-LAST:event_DatabaseToHomeButtonActionPerformed

    private void SuggestLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuggestLogoutButtonActionPerformed
        // TODO add your handling code here:
        currentUser = null;
        SuggestMoviePanel.setVisible(false);
        LoginPanel.setVisible(true);
        LoginUsernameTextField.setText("");
        LoginPasswordTextField.setText("");
    }//GEN-LAST:event_SuggestLogoutButtonActionPerformed

    private void SuggestMovieToHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuggestMovieToHomeButtonActionPerformed
        // TODO add your handling code here:
        MovieDatabasePanel.setVisible(false);
        HomePagePanel.setVisible(true);
    }//GEN-LAST:event_SuggestMovieToHomeButtonActionPerformed

    private void initComponents2() 
    {

        LoginPanel = new javax.swing.JPanel();
        LoginTitleLabel = new javax.swing.JLabel();
        LoginUsernameLabel = new javax.swing.JLabel();
        LoginPasswordLabel = new javax.swing.JLabel();
        LoginUsernameTextField = new javax.swing.JTextField();
        LoginPasswordTextField = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        NewUserButton = new javax.swing.JButton();
        InvalidLoginLabel = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        AboutLabel = new javax.swing.JLabel();
        AboutLabel2 = new javax.swing.JLabel();
        ReviewPanel = new javax.swing.JPanel();
        LogoutButton = new javax.swing.JButton();
        MovieTitleTextField = new javax.swing.JTextField();
        MovieTitleLabel = new javax.swing.JLabel();
        FeedbackLabel = new javax.swing.JLabel();
        RatingLabel = new javax.swing.JLabel();
        RatingSlider = new javax.swing.JSlider();
        String[] genrelist = {"Action","Adventure","Animation","Comedy","Crime","Documentary","Drama", "Family","Fantasy","Film-Noir","History","Horror","Music","Musical","Mystery","Romance","Sci-Fi","Sport","Thriller","War","Western"};
        SpinnerListModel genremodel = new SpinnerListModel(genrelist);
        Genre1Spinner = new javax.swing.JSpinner(genremodel);
        //String[] genrelist = {"Action","Adventure","Animation","Comedy","Crime","Documentary","Drama", "Family","Fantasy","Film-Noir","History","Horror","Music","Musical","Mystery","Romance","Sci-Fi","Sport","Thriller","War","Western"};
        SpinnerListModel genremodel2 = new SpinnerListModel(genrelist);
        Genre2Spinner = new javax.swing.JSpinner(genremodel2);
        //String[] genrelist = {"Action","Adventure","Animation","Comedy","Crime","Documentary","Drama", "Family","Fantasy","Film-Noir","History","Horror","Music","Musical","Mystery","Romance","Sci-Fi","Sport","Thriller","War","Western"};
        SpinnerListModel genremodel3 = new SpinnerListModel(genrelist);
        Genre3Spinner = new javax.swing.JSpinner(genremodel3);
        SpinnerModel model =
        new SpinnerNumberModel(1, //initial value
            1, //min
            3, //max
            1);
        NumGenresSpinner = new javax.swing.JSpinner(model);
        NumGenresLabel = new javax.swing.JLabel();
        ChooseGenresLabel = new javax.swing.JLabel();
        ReccomendLabel = new javax.swing.JLabel();
        RecommendYesCheckBox = new javax.swing.JCheckBox();
        RecommendNoCheckBox = new javax.swing.JCheckBox();
        SubmitButton1 = new javax.swing.JButton();
        CurrentUserLabel = new javax.swing.JLabel();
        ReviewToHomeButton = new javax.swing.JButton();
        NewUserPanel = new javax.swing.JPanel();
        NewProfileLabel = new javax.swing.JLabel();
        NewUsernameLabel = new javax.swing.JLabel();
        PasswordLabel1 = new javax.swing.JLabel();
        NewUsernameTextField = new javax.swing.JTextField();
        NewPasswordField1 = new javax.swing.JPasswordField();
        CreateProfileButton = new javax.swing.JButton();
        PasswordLabel2 = new javax.swing.JLabel();
        NewPasswordField2 = new javax.swing.JPasswordField();
        ProfileErrorLabel = new javax.swing.JLabel();
        MovieDatabasePanel = new javax.swing.JPanel();
        DatabaseLogoutButton = new javax.swing.JButton();
        DatabaseToHomeButton = new javax.swing.JButton();
        icon2 = new javax.swing.JLabel();
        MovieDatabaseScrollable = new javax.swing.JScrollPane();
        MovieDatabaseList = new javax.swing.JList();
        HomePagePanel = new javax.swing.JPanel();
        WelcomeLabel = new javax.swing.JLabel();
        HomeLogoutButton = new javax.swing.JButton();
        HomeUserLabel = new javax.swing.JLabel();
        CanDoLabel = new javax.swing.JLabel();
        SuggestionButton = new javax.swing.JButton();
        HomeReviewButton = new javax.swing.JButton();
        FindFriendsButton = new javax.swing.JButton();
        HomeToMoviesButtom = new javax.swing.JButton();
        SuggestMoviePanel = new javax.swing.JPanel();
        SuggestLogoutButton = new javax.swing.JButton();
        icon3 = new javax.swing.JLabel();
        SuggestMovieToHomeButton = new javax.swing.JButton();
        SuggestMovieScrollable = new javax.swing.JScrollPane();
        SuggestMovieList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MovieDatabase");
        getContentPane().setLayout(new java.awt.CardLayout());

        LoginPanel.setBackground(new java.awt.Color(255, 102, 0));

        LoginTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        LoginTitleLabel.setFont(new java.awt.Font("PilGi", 1, 96)); // NOI18N
        LoginTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoginTitleLabel.setText("Login");

        LoginUsernameLabel.setFont(new java.awt.Font("PilGi", 0, 36)); // NOI18N
        LoginUsernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoginUsernameLabel.setText("Username");

        LoginPasswordLabel.setFont(new java.awt.Font("PilGi", 0, 36)); // NOI18N
        LoginPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoginPasswordLabel.setText("Password");

        LoginUsernameTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        LoginPasswordTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        LoginButton.setText("Let me in!");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        NewUserButton.setText("I'm new here.");
        NewUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewUserButtonActionPerformed(evt);
            }
        });

        InvalidLoginLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        InvalidLoginLabel.setForeground(new java.awt.Color(255, 255, 255));
        InvalidLoginLabel.setText("Invalid username or password!");

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserProfile/rsz_couch-potato-illustration-1142363.jpg"))); // NOI18N
        icon.setMaximumSize(new java.awt.Dimension(400, 403));
        icon.setMinimumSize(new java.awt.Dimension(400, 403));

        AboutLabel.setFont(new java.awt.Font("PilGi", 0, 20)); // NOI18N
        AboutLabel.setForeground(new java.awt.Color(255, 255, 255));
        AboutLabel.setText("Meet Couch Potato. Your friendly guide to movies");

        AboutLabel2.setFont(new java.awt.Font("PilGi", 0, 20)); // NOI18N
        AboutLabel2.setForeground(new java.awt.Color(255, 255, 255));
        AboutLabel2.setText("and fellow couch potatoes.");

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addGap(0, 126, Short.MAX_VALUE)
                .addComponent(AboutLabel)
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(InvalidLoginLabel)
                                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(LoginPanelLayout.createSequentialGroup()
                                        .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(NewUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LoginPanelLayout.createSequentialGroup()
                                            .addComponent(LoginPasswordLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(LoginPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LoginPanelLayout.createSequentialGroup()
                                            .addComponent(LoginUsernameLabel)
                                            .addGap(18, 18, 18)
                                            .addComponent(LoginUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(LoginPanelLayout.createSequentialGroup()
                                .addComponent(LoginTitleLabel)
                                .addGap(193, 193, 193)))
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addComponent(AboutLabel2)
                        .addGap(165, 165, 165))))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoginTitleLabel)
                .addGap(51, 51, 51)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginUsernameLabel)
                    .addComponent(LoginUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginPasswordTextField)
                    .addComponent(LoginPasswordLabel))
                .addGap(18, 18, 18)
                .addComponent(InvalidLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginButton)
                    .addComponent(NewUserButton))
                .addGap(18, 18, 18)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AboutLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AboutLabel2)
                .addGap(34, 34, 34))
        );

        getContentPane().add(LoginPanel, "card2");

        ReviewPanel.setBackground(new java.awt.Color(255, 102, 0));

        LogoutButton.setText("Logout");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        MovieTitleLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        MovieTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        MovieTitleLabel.setText("What movie did you watch?");

        FeedbackLabel.setFont(new java.awt.Font("PilGi", 0, 20)); // NOI18N
        FeedbackLabel.setForeground(new java.awt.Color(255, 255, 255));

        RatingLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        RatingLabel.setForeground(new java.awt.Color(255, 255, 255));
        RatingLabel.setText("How fantastic (or crumby) was it?");

        RatingSlider.setMajorTickSpacing(1);
        RatingSlider.setMaximum(5);
        RatingSlider.setPaintLabels(true);
        RatingSlider.setPaintTicks(true);

        NumGenresSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                NumGenresSpinnerStateChanged(evt);
            }
        });

        NumGenresLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        NumGenresLabel.setForeground(new java.awt.Color(255, 255, 255));
        NumGenresLabel.setText("Number of Movie Genres?");

        ChooseGenresLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        ChooseGenresLabel.setForeground(new java.awt.Color(255, 255, 255));
        ChooseGenresLabel.setText("Choose genres:");

        ReccomendLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        ReccomendLabel.setForeground(new java.awt.Color(255, 255, 255));
        ReccomendLabel.setText("Should I see it?");

        RecommendYesCheckBox.setFont(new java.awt.Font("PilGi", 0, 20)); // NOI18N
        RecommendYesCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        RecommendYesCheckBox.setSelected(true);
        RecommendYesCheckBox.setText("Add to your movie bucket list!");
        RecommendYesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecommendYesCheckBoxActionPerformed(evt);
            }
        });

        RecommendNoCheckBox.setFont(new java.awt.Font("PilGi", 0, 20)); // NOI18N
        RecommendNoCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        RecommendNoCheckBox.setText("Save two hours of your life.");
        RecommendNoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecommendNoCheckBoxActionPerformed(evt);
            }
        });

        SubmitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButton1ActionPerformed(evt);
            }
        });

        CurrentUserLabel.setFont(new java.awt.Font("PilGi", 0, 36)); // NOI18N
        CurrentUserLabel.setForeground(new java.awt.Color(255, 255, 255));

        ReviewToHomeButton.setText("I want to do something else.");
        ReviewToHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReviewToHomeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ReviewPanelLayout = new javax.swing.GroupLayout(ReviewPanel);
        ReviewPanel.setLayout(ReviewPanelLayout);
        ReviewPanelLayout.setHorizontalGroup(
            ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReviewPanelLayout.createSequentialGroup()
                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(RatingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LogoutButton))
                    .addComponent(FeedbackLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MovieTitleLabel)
                            .addComponent(CurrentUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RatingLabel)))
                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ReviewPanelLayout.createSequentialGroup()
                                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                                        .addComponent(ChooseGenresLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(Genre1Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(NumGenresLabel)))
                                .addGap(18, 18, 18)
                                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NumGenresSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ReviewPanelLayout.createSequentialGroup()
                                        .addComponent(Genre2Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Genre3Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(ReviewPanelLayout.createSequentialGroup()
                                .addComponent(ReccomendLabel)
                                .addGap(18, 18, 18)
                                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RecommendNoCheckBox)
                                    .addComponent(RecommendYesCheckBox)
                                    .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(SubmitButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ReviewToHomeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        ReviewPanelLayout.setVerticalGroup(
            ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReviewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoutButton)
                .addGap(18, 18, 18)
                .addComponent(CurrentUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(MovieTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RatingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RatingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumGenresLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumGenresSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChooseGenresLabel)
                    .addComponent(Genre1Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Genre2Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Genre3Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ReviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReccomendLabel)
                    .addComponent(RecommendYesCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RecommendNoCheckBox)
                .addGap(18, 18, 18)
                .addComponent(SubmitButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReviewToHomeButton)
                .addGap(18, 18, 18)
                .addComponent(FeedbackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        Genre2Spinner.setVisible(false);
        Genre3Spinner.setVisible(false);

        getContentPane().add(ReviewPanel, "card3");

        NewUserPanel.setBackground(new java.awt.Color(255, 102, 0));

        NewProfileLabel.setFont(new java.awt.Font("PilGi", 0, 64)); // NOI18N
        NewProfileLabel.setForeground(new java.awt.Color(255, 255, 255));
        NewProfileLabel.setText("Join the cult!");

        NewUsernameLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        NewUsernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        NewUsernameLabel.setText("What should we call you?");

        PasswordLabel1.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        PasswordLabel1.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLabel1.setText("Secret passcode:");

        NewUsernameTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        NewPasswordField1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        CreateProfileButton.setText("BECOME ONE OF US.");
        CreateProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateProfileButtonActionPerformed(evt);
            }
        });

        PasswordLabel2.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        PasswordLabel2.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLabel2.setText("Retype password:");

        NewPasswordField2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        ProfileErrorLabel.setFont(new java.awt.Font("PilGi", 0, 24)); // NOI18N
        ProfileErrorLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout NewUserPanelLayout = new javax.swing.GroupLayout(NewUserPanel);
        NewUserPanel.setLayout(NewUserPanelLayout);
        NewUserPanelLayout.setHorizontalGroup(
            NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewUserPanelLayout.createSequentialGroup()
                .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewUserPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NewUsernameLabel)
                            .addComponent(PasswordLabel1)
                            .addComponent(PasswordLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NewUsernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(NewPasswordField1)
                            .addComponent(NewPasswordField2)))
                    .addGroup(NewUserPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NewProfileLabel)
                            .addComponent(ProfileErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewUserPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CreateProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
        );
        NewUserPanelLayout.setVerticalGroup(
            NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewUserPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(NewProfileLabel)
                .addGap(51, 51, 51)
                .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewUsernameLabel)
                    .addComponent(NewUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLabel1)
                    .addComponent(NewPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLabel2)
                    .addComponent(NewPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(CreateProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(ProfileErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );

        getContentPane().add(NewUserPanel, "card4");

        MovieDatabasePanel.setBackground(new java.awt.Color(255, 102, 0));
        DatabaseLogoutButton.setText("Logout");
        DatabaseLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatabaseLogoutButtonActionPerformed(evt);
            }
        });

        DatabaseToHomeButton.setText("GET ME OUT OF HERE!");
        DatabaseToHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatabaseToHomeButtonActionPerformed(evt);
            }
        });

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserProfile/rsz_couch-potato-illustration-1142363.jpg"))); // NOI18N

        MovieDatabaseScrollable.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MovieDatabaseScrollable.setPreferredSize(new java.awt.Dimension(50, 50));
        MovieDatabaseScrollable.setSize(new java.awt.Dimension(50, 50));

        MovieDatabaseList.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        MovieDatabaseScrollable.setViewportView(MovieDatabaseList);

        javax.swing.GroupLayout MovieDatabasePanelLayout = new javax.swing.GroupLayout(MovieDatabasePanel);
        MovieDatabasePanel.setLayout(MovieDatabasePanelLayout);
        MovieDatabasePanelLayout.setHorizontalGroup(
            MovieDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(DatabaseToHomeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DatabaseLogoutButton)
                .addContainerGap())
            .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(MovieDatabaseScrollable, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(icon2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MovieDatabasePanelLayout.setVerticalGroup(
            MovieDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                .addGroup(MovieDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DatabaseLogoutButton))
                    .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(DatabaseToHomeButton)))
                .addGroup(MovieDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(MovieDatabaseScrollable, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MovieDatabasePanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(icon2)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        getContentPane().add(MovieDatabasePanel, "card5");

        HomePagePanel.setBackground(new java.awt.Color(255, 102, 0));

        WelcomeLabel.setFont(new java.awt.Font("PilGi", 0, 48)); // NOI18N
        WelcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        WelcomeLabel.setText("Welcome back,");

        HomeLogoutButton.setText("Logout");
        HomeLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeLogoutButtonActionPerformed(evt);
            }
        });

        HomeUserLabel.setFont(new java.awt.Font("PilGi", 0, 48)); // NOI18N
        HomeUserLabel.setForeground(new java.awt.Color(255, 255, 255));

        CanDoLabel.setFont(new java.awt.Font("PilGi", 0, 36)); // NOI18N
        CanDoLabel.setForeground(new java.awt.Color(255, 255, 255));
        CanDoLabel.setText("What can I do for you today?");

        SuggestionButton.setText("Find me a movie!");
        SuggestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuggestionButtonActionPerformed(evt);
            }
        });

        HomeReviewButton.setText("Let me give my two cents.");
        HomeReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeReviewButtonActionPerformed(evt);
            }
        });

        FindFriendsButton.setText("Friends, please...?");
        FindFriendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindFriendsButtonActionPerformed(evt);
            }
        });

        HomeToMoviesButtom.setText("Leave me alone.  I want to find my own movie.");
        HomeToMoviesButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeToMoviesButtomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HomePagePanelLayout = new javax.swing.GroupLayout(HomePagePanel);
        HomePagePanel.setLayout(HomePagePanelLayout);
        HomePagePanelLayout.setHorizontalGroup(
            HomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePagePanelLayout.createSequentialGroup()
                .addGroup(HomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePagePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HomeLogoutButton))
                    .addGroup(HomePagePanelLayout.createSequentialGroup()
                        .addGroup(HomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HomePagePanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(WelcomeLabel)
                                .addGap(18, 18, 18)
                                .addComponent(HomeUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HomePagePanelLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(CanDoLabel))
                            .addGroup(HomePagePanelLayout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addGroup(HomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FindFriendsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(HomeToMoviesButtom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(HomeReviewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SuggestionButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addContainerGap())
        );
        HomePagePanelLayout.setVerticalGroup(
            HomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeLogoutButton)
                .addGap(20, 20, 20)
                .addGroup(HomePagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WelcomeLabel)
                    .addComponent(HomeUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(CanDoLabel)
                .addGap(38, 38, 38)
                .addComponent(SuggestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(HomeReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FindFriendsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(HomeToMoviesButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        getContentPane().add(HomePagePanel, "card6");

        SuggestMoviePanel.setBackground(new java.awt.Color(255, 102, 0));

        SuggestLogoutButton.setText("Logout");
        SuggestLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuggestLogoutButtonActionPerformed(evt);
            }
        });

        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserProfile/rsz_couch-potato-illustration-1142363.jpg"))); // NOI18N

        SuggestMovieToHomeButton.setText("GET ME OUT OF HERE!");
        SuggestMovieToHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuggestMovieToHomeButtonActionPerformed(evt);
            }
        });

        SuggestMovieScrollable.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SuggestMovieScrollable.setPreferredSize(new java.awt.Dimension(50, 50));
        SuggestMovieScrollable.setSize(new java.awt.Dimension(50, 50));

        SuggestMovieList.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        SuggestMovieScrollable.setViewportView(SuggestMovieList);

        javax.swing.GroupLayout SuggestMoviePanelLayout = new javax.swing.GroupLayout(SuggestMoviePanel);
        SuggestMoviePanel.setLayout(SuggestMoviePanelLayout);
        SuggestMoviePanelLayout.setHorizontalGroup(
            SuggestMoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SuggestMoviePanelLayout.createSequentialGroup()
                .addGroup(SuggestMoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(SuggestMovieScrollable, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(icon3))
                    .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(SuggestMovieToHomeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SuggestLogoutButton)))
                .addContainerGap())
        );
        SuggestMoviePanelLayout.setVerticalGroup(
            SuggestMoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                .addGroup(SuggestMoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SuggestLogoutButton))
                    .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(SuggestMovieToHomeButton)))
                .addGroup(SuggestMoviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(icon3))
                    .addGroup(SuggestMoviePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(SuggestMovieScrollable, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        getContentPane().add(SuggestMoviePanel, "card7");

        pack();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MovieDatabaseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovieDatabaseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovieDatabaseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieDatabaseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovieDatabaseGUI().setVisible(true);
            }
        });
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AboutLabel;
    private javax.swing.JLabel AboutLabel2;
    private javax.swing.JLabel CanDoLabel;
    private javax.swing.JLabel ChooseGenresLabel;
    private javax.swing.JButton CreateProfileButton;
    private javax.swing.JLabel CurrentUserLabel;
    private javax.swing.JButton DatabaseLogoutButton;
    private javax.swing.JButton DatabaseToHomeButton;
    private javax.swing.JLabel FeedbackLabel;
    private javax.swing.JButton FindFriendsButton;
    private javax.swing.JSpinner Genre1Spinner;
    private javax.swing.JSpinner Genre2Spinner;
    private javax.swing.JSpinner Genre3Spinner;
    private javax.swing.JButton HomeLogoutButton;
    private javax.swing.JPanel HomePagePanel;
    private javax.swing.JButton HomeReviewButton;
    private javax.swing.JButton HomeToMoviesButtom;
    private javax.swing.JLabel HomeUserLabel;
    private javax.swing.JLabel InvalidLoginLabel;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JLabel LoginPasswordLabel;
    private javax.swing.JPasswordField LoginPasswordTextField;
    private javax.swing.JLabel LoginTitleLabel;
    private javax.swing.JLabel LoginUsernameLabel;
    private javax.swing.JTextField LoginUsernameTextField;
    private javax.swing.JButton LogoutButton;
    private static javax.swing.JList MovieDatabaseList;
    private javax.swing.JPanel MovieDatabasePanel;
    private javax.swing.JScrollPane MovieDatabaseScrollable;
    private javax.swing.JLabel MovieTitleLabel;
    private javax.swing.JTextField MovieTitleTextField;
    private javax.swing.JPasswordField NewPasswordField1;
    private javax.swing.JPasswordField NewPasswordField2;
    private javax.swing.JLabel NewProfileLabel;
    private javax.swing.JButton NewUserButton;
    private javax.swing.JPanel NewUserPanel;
    private javax.swing.JLabel NewUsernameLabel;
    private javax.swing.JTextField NewUsernameTextField;
    private javax.swing.JLabel NumGenresLabel;
    private javax.swing.JSpinner NumGenresSpinner;
    private javax.swing.JLabel PasswordLabel1;
    private javax.swing.JLabel PasswordLabel2;
    private javax.swing.JLabel ProfileErrorLabel;
    private javax.swing.JLabel RatingLabel;
    private javax.swing.JSlider RatingSlider;
    private javax.swing.JLabel ReccomendLabel;
    private javax.swing.JCheckBox RecommendNoCheckBox;
    private javax.swing.JCheckBox RecommendYesCheckBox;
    private javax.swing.JPanel ReviewPanel;
    private javax.swing.JButton ReviewToHomeButton;
    private javax.swing.JButton SubmitButton1;
    private javax.swing.JButton SuggestLogoutButton;
    private static javax.swing.JList SuggestMovieList;
    private javax.swing.JPanel SuggestMoviePanel;
    private javax.swing.JScrollPane SuggestMovieScrollable;
    private javax.swing.JButton SuggestMovieToHomeButton;
    private javax.swing.JButton SuggestionButton;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    // End of variables declaration//GEN-END:variables
}
