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

}
