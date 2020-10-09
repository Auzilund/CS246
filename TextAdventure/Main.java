package lundberg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main extends JFrame {
    private Main() {
        super();
        setSize(0, 0);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void slowtext (String text) {

        for(int i = 0; i < text.length(); i++) {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 50) {

            }
            System.out.print(text.charAt(i));
        }
        return;
    }

    public static void main(String[] args) throws Exception {
        Console console = new Console();
        Main launcher = new Main();
        launcher.setVisible(true);
        console.getFrame().setLocation(
                launcher.getX() + launcher.getWidth() + launcher.getInsets().right,
                launcher.getY());
        String input = "";
        String text = "";
        text = "> Welcome to your console...\n";
        slowtext(text);
        text = "> To gain access to this terminal enter the password:\n" + "> ";
        slowtext(text);
        text = "\n> You did not enter the right password!\n";
        slowtext(text);
        text = "> You are DEAD\n";
        slowtext(text);
        text = "                  uu$$$$$$$$$$$uu\n" +
                "              uu$$$$$$$$$$$$$$$$$uu\n" +
                "             u$$$$$$$$$$$$$$$$$$$$$u\n" +
                "            u$$$$$$$$$$$$$$$$$$$$$$$u\n" +
                "           u$$$$$$$$$$$$$$$$$$$$$$$$$u\n" +
                "           u$$$$$$*   *$$$*   *$$$$$$u\n" +
                "           *$$$$*      u$u       $$$$*\n" +
                "            $$$u       u$u       u$$$\n" +
                "            $$$u      u$$$u      u$$$\n" +
                "             *$$$$uu$$$   $$$uu$$$$*\n" +
                "              *$$$$$$$*   *$$$$$$$*\n" +
                "                u$$$$$$$u$$$$$$$u\n" +
                "                 u$*$*$*$*$*$*$u\n" +
                "      uuu        $$u$ $ $ $ $u$$       uuu\n" +
                "      u$$$$       $$$$$u$u$u$$$       u$$$$\n" +
                "      $$$$$uu      *$$$$$$$$$*     uu$$$$$$\n" +
                "    u$$$$$$$$$$$uu    *****    uuuu$$$$$$$$$\n" +
                "    $$$$***$$$$$$$$$$uuu   uu$$$$$$$$$***$$$*\n" +
                "     ***      **$$$$$$$$$$$uu **$***\n" +
                "              uuuu **$$$$$$$$$$uuu\n" +
                "     u$$$uuu$$$$$$$$$uu **$$$$$$$$$$$uuu$$$\n" +
                "     $$$$$$$$$$****           **$$$$$$$$$$$*\n" +
                "       *$$$$$*                      **$$$$**\n" +
                "         $$$*                         $$$$*";

        System.out.print(text);
    }
}

class Console {
    final JFrame frame = new JFrame();
    JTextArea textArea;

    public Console() throws Exception {
        textArea = new JTextArea(24, 80);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.green);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        frame.add(textArea);
        frame.pack();
        frame.setVisible(true);
        redirectOut();

    }

    public PrintStream redirectOut() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                textArea.append(String.valueOf((char) b));
            }
        };
        PrintStream ps = new PrintStream(out);

        System.setOut(ps);
        System.setErr(ps);

        return ps;
    }

    public JFrame getFrame() {
        return frame;
    }
}