package main;

public class Pomodora {
    private JButton start;
    private JButton reset;
    private JLabel time_label;
    private JLabel Title;
    private int sessiontime = 1200;
    private int elapsedtime = sessiontime*1000;
    private int h = elapsedtime/3600000;
    private int m = (elapsedtime/60000)%60;
    private int s = (elapsedtime/1000)%60;

    boolean startClicked = false;
    String h_string = String.format("%02d", h);
    String m_string = String.format("%02d", m);
    String s_string = String.format("%02d", s);



    //Hashini
    public Pomodora(){
        this.setSize(420,420);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        this.Title = new JLabel("POMODORO TIMER");
        this.Title.setBounds(120,50,250,150);
        this.Title.setFont(new Font("Sans-serif", Font.BOLD, 18));
        this.add(this.Title);

        this.start = new JButton("Start");
        this.reset = new JButton("Reset");
        this.start.setBounds(100,200,100,50);
        this.reset.setBounds(200, 200, 100, 50);

        this.add(this.start);
        this.add(this.reset);
        this.start.addActionListener(this);
        this.reset.addActionListener(this);

        this.time_label = new JLabel(h_string+":"+m_string+":"+s_string);
        this.time_label.setBounds(175,100,100,100);
        this.add(this.time_label);
    }

    //sewwandi
    Timer timer = new Timer(1000, new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent e) {
            if(elapsedtime !=0 ){
                elapsedtime = elapsedtime - 1000;
                h = (elapsedtime/3600000);
                m = (elapsedtime/60000)%60;
                s = (elapsedtime/1000)%60;
                String h_String = String.format("%02d", h);
                String m_String = String.format("%02d", m);
                String s_String = String.format("%02d", s);
                time_label.setText(h_String+":"+m_String+":"+s_String);
            }else{
                try {
                    stoptimerinzero();
                } catch (Exception ex) {
                    Logger.getLogger(Pomodora.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
    );

    //Thuvarakan
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start){
            if(startClicked==false){
                start.setText("Stop");
                startClicked = true;
                timer.start();
            }
            else{
                start.setText("Start");
                startClicked = false;
                timer.stop();
            }
        }else if(e.getSource()==reset){
            timer.stop();
            elapsedtime = sessiontime*1000;
            h = (elapsedtime/3600000);
            m = (elapsedtime/60000)%60;
            s = (elapsedtime/1000)%60;
            String h_String = String.format("%02d", h);
            String m_String = String.format("%02d", m);
            String s_String = String.format("%02d", s);
            this.time_label.setBounds(175,100,100,100);
            this.time_label.setText(h_String+":"+m_String+":"+s_String);
            this.start.setText("Start");
            startClicked = false;
        }
    }

    // Supun
    public void stoptimerinzero() throws IOException, Exception{
        timer.stop();
        elapsedtime = sessiontime*1000;
        Sewwandi
                Supun
        h = (elapsedtime/3600000);
        m = (elapsedtime/60000)%60;
        s = (elapsedtime/1000)%60;
        String h_String = String.format("%02d", h);
        String m_String = String.format("%02d", m);
        String s_String = String.format("%02d", s);
        //this.time_label.setBounds(175,100,100,100);
        this.time_label.setText(h_String+":"+m_String+":"+s_String);
        this.start.setText("Start");
        startClicked = false;

        Pomodora.screen2();

        //popup messages
// int choice = JOptionPane.showConfirmDialog(null, "Nice Session", "Session
        End",JOptionPane.YES_NO_OPTION);
// if (choice == JOptionPane.YES_OPTION){
// JOptionPane.showMessageDialog(null,"Keep Going");
// }else if (choice == JOptionPane.NO_OPTION){
// JOptionPane.showMessageDialog(null, "Dont Give Up");
// }
    }
    
    public static void screen2() throws InterruptedException {
        JFrame frame2 = new JFrame();
        frame2.setAlwaysOnTop (true);

        Toolkit toolkit=Toolkit.getDefaultToolkit(); //Defining the Toolkit from Java AWT
        Dimension screen = toolkit.getScreenSize(); //Obtains the screen size of the device
        int height = (int)screen.getHeight(); //Obtains the height of the device
        int width = (int)screen.getWidth(); //Obtains the width of the device

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setPreferredSize(new Dimension(width, height)); frame2.setUndecorated(true);
        JPanel panel = new JPanel();
//       panel.setLayout(null);

        JLabel guide = new JLabel("CLICK HERE TO ABORT THE PROCESS!!!");
        guide.setForeground(new Color(0xffffff));

//       JLabel details = new JLabel("||---WAIT FOR TWO MINUTES---||");
//       details.setForeground(new Color(0xffffff));

        panel.setBackground(Color.black);
        panel.add(guide);
//       panel.add(details);

        JButton abt = new JButton("CLOSE");
        abt.setBackground(new Color(0x919191));

        abt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame2.setVisible(false);
            }
        });
        panel.add(abt);
        frame2.add(panel);
        frame2.pack();
        Timer timer = new Timer(100000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false);
                frame2.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        frame2.setVisible(true);
//        frame2.setExtendedState(JFrame.ICONIFIED);
//        frame2.setExtendedState(fullscreen ? JFrame.MAXIMIZED_BOTH : JFrame.NORMAL);




    }


}
