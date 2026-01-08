import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Quiz implements ActionListener {
    String[] questions=new String[15];
    String[][] options=new String[15][4];
    char[] answers=new char[15];
    int total_questions=15;
    String[] indiaQuestions = {
            "1. Capital of India?",
            "2. National animal of India?",
            "3. National bird of India?",
            "4. Who is the Father of the Nation?",
            "5. Indian currency?",
            "6. National flower?",
            "7. Largest state by area?",
            "8. Smallest state?",
            "9. First Prime Minister?",
            "10. National sport?",
            "11. River Ganga flows into?",
            "12. Taj Mahal is in?",
            "13. National tree?",
            "14. Who wrote national anthem?",
            "15. ISRO headquarters?"
    };
    String[][] indiaOptions = {
            {"Mumbai","Delhi","Chennai","Kolkata"},
            {"Lion","Elephant","Tiger","Horse"},
            {"Peacock","Crow","Sparrow","Eagle"},
            {"Gandhi","Nehru","Patel","Bose"},
            {"Dollar","Euro","Yen","Rupee"},
            {"Lotus","Rose","Lily","Sunflower"},
            {"Rajasthan","MP","UP","Gujarat"},
            {"Sikkim","Tripura","Goa","Manipur"},
            {"Nehru","Gandhi","Patel","Bose"},
            {"Cricket","Hockey","Football","Kabaddi"},
            {"Bay of Bengal","Arabian Sea","Indian Ocean","Pacific"},
            {"Agra","Delhi","Jaipur","Lucknow"},
            {"Neem","Banyan","Peepal","Mango"},
            {"Gandhi","Nehru","Bose","Tagore"},
            {"Bengaluru","Delhi","Hyderabad","Mumbai"}
    };
    char[] indiaAnswers = {
            'B','C','A','A','D','A','A','C','A','B',
            'A','A','B','D','A'
    };
    String[] scienceQuestions = {
            "1. Unit of force?",
            "2. Speed formula?",
            "3. Water chemical formula?",
            "4. Planet closest to sun?",
            "5. Gas for breathing?",
            "6. Largest organ?",
            "7. Electric unit?",
            "8. Boiling point of water?",
            "9. Center of atom?",
            "10. Vitamin C source?",
            "11. Blood color?",
            "12. Sound travels fastest in?",
            "13. SI unit of power?",
            "14. Heart chambers?",
            "15. Human bones?"
    };
    String[][] scienceOptions = {
            {"Joule","Newton","Watt","Pascal"},
            {"d/t","t/d","d*s","s/d"},
            {"H2","CO2","O2","H2O"},
            {"Venus","Earth","Mercury","Mars"},
            {"Oxygen","Nitrogen","CO2","Hydrogen"},
            {"Heart","Skin","Liver","Brain"},
            {"Ampere","Volt","Watt","Ohm"},
            {"100","90","80","70"},
            {"Electron","Nucleus","Proton","Neutron"},
            {"Apple","Rice","Orange","Milk"},
            {"Red","Blue","Green","Yellow"},
            {"Solid","Liquid","Gas","Vacuum"},
            {"Joule","Volt","Watt","Ampere"},
            {"2","4","3","1"},
            {"206","208","210","212"}
    };
    char[] scienceAnswers = {
            'B','A','D','C','A','B','A','A','B','C',
            'A','A','C','B','A'
    };
    String[] mathsQuestions = {
            "1. 2+2?","2. 5×5?","3. Square root of 16?","4. 10÷2?",
            "5. Value of π?","6. 7+8?","7. 9×9?","8. 15−5?",
            "9. Cube of 3?","10. Even number?",
            "11. Prime number?","12. Angle in triangle?",
            "13. Perimeter square?","14. 1 km = ? m",
            "15. 10²?"
    };
    String[][] mathsOptions = {
            {"5","6","7","4"},
            {"20","25","30","15"},
            {"4","5","6","3"},
            {"5","4","6","3"},
            {"3","22","3.14","7"},
            {"15","14","13","16"},
            {"81","72","90","99"},
            {"5","15","20","10"},
            {"27","9","6","18"},
            {"3","2","5","7"},
            {"2","4","6","8"},
            {"90","360","45","180"},
            {"4a","a","2a","a²"},
            {"100","10","1000","1"},
            {"10","100","20","50"}
    };
    char[] mathsAnswers = {
            'D','B','A','A','C','A','A','D','A','B',
            'A','D','A','C','B'
    };


    char guess;
    char answer;
    int index;
    int correct_guess=0;
    int result;
    int seconds=10;

    JFrame frame=new JFrame();
    JTextField textfield =new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA=new JButton();
    JButton buttonB=new JButton();
    JButton buttonC=new JButton();
    JButton buttonD=new JButton();
    JLabel answer_labelA=new JLabel();
    JLabel answer_labelB=new JLabel();
    JLabel answer_labelC=new JLabel();
    JLabel answer_labelD=new JLabel();
    JLabel time_label=new JLabel();
    JLabel seconds_left=new JLabel();
    JTextField number_right=new JTextField();
    JTextField percentage=new JTextField();


    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if(seconds<=0){
                displayAnswer();
            }
        }
    });


    public Quiz(String category) {
        if(category.equals("INDIA")){
            questions = indiaQuestions;
            options = indiaOptions;
            answers = indiaAnswers;
        }
        if(category.equals("SCIENCE")){
            questions = scienceQuestions;
            options = scienceOptions;
            answers = scienceAnswers;
        }
        if(category.equals("MATHS")){
            questions = mathsQuestions;
            options = mathsOptions;
            answers = mathsAnswers;
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        ImageIcon icon = new ImageIcon(
                getClass().getResource("/images/quiz.png")
        );
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(new Color(0,0,50));
        frame.setLayout(null);
        frame.setResizable(false);
        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(0,0,0));
        textfield.setForeground(new Color(25,250,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,30));
        textfield.setBorder(BorderFactory.createEtchedBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(0,50,650,50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(0,0,0));
        textarea.setForeground(new Color(25,250,0));
        textarea.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,25));
        textarea.setBorder(BorderFactory.createEtchedBorder(1));
        textarea.setEditable(false);

        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,25));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,25));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,25));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,25));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(125,100,500,100);
        answer_labelA.setBackground(new Color(50,50,50));
        answer_labelA.setForeground(new Color(25,255,0));
        answer_labelA.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,35));

        answer_labelB.setBounds(125,200,500,100);
        answer_labelB.setBackground(new Color(50,50,50));
        answer_labelB.setForeground(new Color(25,255,0));
        answer_labelB.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,35));

        answer_labelC.setBounds(152,300,500,100);
        answer_labelC.setBackground(new Color(50,50,50));
        answer_labelC.setForeground(new Color(25,255,0));
        answer_labelC.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,35));

        answer_labelD.setBounds(152,400,500,100);
        answer_labelD.setBackground(new Color(50,50,50));
        answer_labelD.setForeground(new Color(25,255,0));
        answer_labelD.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,35));

        seconds_left.setBounds(535,510,100,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground((new Color(255,0,0)));
        seconds_left.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(535,475,100,25);
        time_label.setBackground((new Color(255,0,0)));
        time_label.setForeground((new Color(255,0,0)));
        time_label.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,18));
        time_label.setHorizontalAlignment((JTextField.CENTER));

        number_right.setBounds(225,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,255,0));
        number_right.setFont(new Font("Ink Free",Font.BOLD,50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("Ink Free",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);

        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);

        textarea.setText("Sample");
        frame.add(textarea);
        frame.add(textfield);
        frame.setVisible(true);

        nextQuestion();
    }

    public void nextQuestion(){
        if(index>=total_questions){
            results();
        }
        else{
            textfield.setText("Question"+(index+1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource()==buttonA){
            answer='A';
            if(answer==answers[index]){
                correct_guess++;
            }
        }
        if(e.getSource()==buttonB){
            answer='B';
            if(answer==answers[index]){
                correct_guess++;
            }
        }
        if(e.getSource()==buttonC){
            answer='C';
            if(answer==answers[index]){
                correct_guess++;
            }
        }
        if(e.getSource()==buttonD){
            answer='D';
            if(answer==answers[index]){
                correct_guess++;
            }
        }
        displayAnswer();
    }

    public void displayAnswer(){
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index]!='A'){
            answer_labelA.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='B'){
            answer_labelB.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='C'){
            answer_labelC.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='D'){
            answer_labelD.setForeground(new Color(255,0,0));
        }
        Timer pause = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_labelA.setForeground(new Color(25,255,0));
                answer_labelB.setForeground(new Color(25,255,0));
                answer_labelC.setForeground(new Color(25,255,0));
                answer_labelD.setForeground(new Color(25,255,0));

                answer=' ';
                seconds=10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result= (int)((correct_guess/(double)total_questions)*100);

        textfield.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("("+correct_guess+"/"+total_questions+")");
        percentage.setText(result+"%");


        frame.add(number_right);
        frame.add(percentage);
    }
}
