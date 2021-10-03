import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class PoregressMonitor {

        static JButton button = new JButton("Empezar");
        static ProgressMonitor pm;
        static Timer timer;
        static int progress;

        public static void main(String [] args){
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Progress Monitor");
            frame.setSize(new Dimension(800, 700));

             pm = new ProgressMonitor(frame, "Loading Progress", "Getting Started...", 0, 200);

             ActionListener startActionListener = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent actionEvent){

                            if (pm != null) {
                                if (timer == null) {
                                        timer = new Timer(250, new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    if (pm.isCanceled()) {
                                                        System.out.println("Monitor canceled");
                                                        timer.stop();
                                                        } else {
                                                        progress += 3;
                                                        pm.setProgress(progress);
                                                        pm.setNote("Loaded " + progress + " files");
                                                    }
                                                }
                                        });
                                }
                                timer.start();
                            }
                }
            };


            button.addActionListener(startActionListener);
            frame.add(button, BorderLayout.NORTH);
            frame.setVisible(true);
        }
}