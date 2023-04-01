import Characters.FightSimulation;
import Characters.PointTypeCharacter;
import Characters.RangeTypeCharacter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SecondFrame extends JFrame {
    private static final String FrameTitle = "Fighter Game v2";
    private static final String FrameIconPath = "src/Images/FrameIcon.png";
    private static final String InformationIconPath = "src/Images/InformationIcon.png";
    private static final String ConfirmIconPath = "src/Images/ConfirmIcon.png";
    private static final Color BackgroundColor = new Color(124, 121, 120);

    private JPanel TopPanel;
    private JPanel BottomPanel;
    private JPanel LeftPanel;
    private JPanel RightPanel;
    private JPanel CenterPanel;
    private JButton CloseButton;

    private PointTypeCharacter Player;
    private RangeTypeCharacter Enemy;
    ArrayList<String> Log;

    public SecondFrame(PointTypeCharacter player, RangeTypeCharacter enemy, ArrayList<String> log) {
        super();

        Player = player;
        Enemy = enemy;
        Log = log;

        CreateWindow();
        setVisible(true);
    }

    private void CreateWindow() {
        //Images
        ImageIcon frameIcon = new ImageIcon(FrameIconPath);
        ImageIcon informationIcon = new ImageIcon(InformationIconPath);
        ImageIcon confirmIcon = new ImageIcon(ConfirmIconPath);

        //Frame
        setTitle(FrameTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(820, 600);
        getContentPane().setBackground(BackgroundColor);
        setIconImage(frameIcon.getImage());

        //Layout
        setLayout(new BorderLayout(10,5));

        TopPanel = new JPanel();
        TopPanel.setBorder(BorderFactory.createEtchedBorder());
        TopPanel.setBackground(BackgroundColor);
        TopPanel.setPreferredSize(new Dimension(600, 50));
        add(TopPanel, BorderLayout.NORTH);

        LeftPanel = new JPanel();
        LeftPanel.setBorder(BorderFactory.createEtchedBorder());
        LeftPanel.setBackground(BackgroundColor);
        LeftPanel.setPreferredSize(new Dimension(200, 400));
        add(LeftPanel, BorderLayout.WEST);

        RightPanel = new JPanel();
        RightPanel.setBorder(BorderFactory.createEtchedBorder());
        RightPanel.setBackground(BackgroundColor);
        RightPanel.setPreferredSize(new Dimension(200, 400));
        add(RightPanel, BorderLayout.EAST);

        CenterPanel = new JPanel();
        CenterPanel.setBorder(BorderFactory.createEtchedBorder());
        CenterPanel.setBackground(BackgroundColor);
        add(CenterPanel, BorderLayout.CENTER);

        BottomPanel = new JPanel();
        BottomPanel.setBorder(BorderFactory.createEtchedBorder());
        BottomPanel.setBackground(BackgroundColor);
        BottomPanel.setPreferredSize(new Dimension(600, 50));
        add(BottomPanel, BorderLayout.SOUTH);

        //TopPanel
        JLabel TopLabel = new JLabel("Result about fight with enemy");
        TopLabel.setIcon(informationIcon);
        TopLabel.setForeground(Color.WHITE);
        TopLabel.setFont(new Font("MV Boli", Font.PLAIN, 25));
        TopPanel.add(TopLabel);

        //LeftPanel
        JLabel LeftLabel = new JLabel(Player.getInfo(), SwingConstants.CENTER);
        LeftLabel.setForeground(Color.white);
        LeftLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
        LeftPanel.add(LeftLabel);

        //RightPanel
        JLabel RightLabel = new JLabel(Enemy.getInfo(), SwingConstants.CENTER);
        RightLabel.setForeground(Color.white);
        RightLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
        RightPanel.add(RightLabel);

        //CenterPanel
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);

        String text = "";
        for (String element : Log) {
            text += element + "\n";
        }

        textArea.setText(text);
        textArea.setForeground(Color.white);
        textArea.setBackground(BackgroundColor);
        textArea.setFont(new Font("serif", Font.PLAIN, 15));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setAutoscrolls(true);
        scrollPane.setPreferredSize(new Dimension(350, 430));
        CenterPanel.add(scrollPane);

        //BottomPanel
        CloseButton = new JButton("Close Application");
        CloseButton.setPreferredSize(new Dimension(300, 40));
        CloseButton.addActionListener(e -> Program.ExitProgram());
        CloseButton.setFocusable(false);
        CloseButton.setIcon(confirmIcon);
        CloseButton.setFont(new Font("MV Boli", Font.PLAIN, 15));
        CloseButton.setBackground(Color.lightGray);
        CloseButton.setBorder(BorderFactory.createSoftBevelBorder(0));
        BottomPanel.add(CloseButton);
    }
}
