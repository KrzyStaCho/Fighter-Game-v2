import Characters.Character;
import Characters.PointTypeCharacter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends JFrame implements ActionListener {
    private static final String FrameTitle = "Fighter Game v2";
    private static final String FrameIconPath = "src/Images/FrameIcon.png";
    private static final String CreateIconPath = "src/Images/CreateIcon.png";
    private static final String ConfirmIconPath = "src/Images/ConfirmIcon.png";
    private static final String PlusIconPath = "src/Images/PlusIcon.png";
    private static final String MinusIconPath = "src/Images/MinusIcon.png";
    private static final Color BackgroundColor = new Color(124, 121, 120);

    private JPanel TopPanel;
    private JPanel BottomPanel;
    private JPanel CenterPanel;

    private int FreePoints;
    private String CharName;
    private int CharHealthPoints;
    private int CharArmorPoints;
    private int CharAttackDamagePoints;
    private int CharCriticalChancePoints;
    private int CharAttackSpeedPoints;

    private PointTypeCharacter PlayerCharacter;

    private JLabel PointsLabel;
    private JButton ConfirmButton;
    private JTextField NameField;
    private JTextField HealthField;
    private JTextField ArmorField;
    private JTextField AttackDamageField;
    private JTextField CriticalChanceField;

    private JTextField AttackSpeedField;

    public FirstFrame() {

        CreateWindow();
        setVisible(true);
    }

    private void CreateWindow() {
        FreePoints = PointTypeCharacter.MaxPointOnOneCharacter;
        PlayerCharacter = null;

        //Images
        ImageIcon frameIcon = new ImageIcon(FrameIconPath);
        ImageIcon createIcon = new ImageIcon(CreateIconPath);
        ImageIcon confirmIcon = new ImageIcon(ConfirmIconPath);
        ImageIcon plusIcon = new ImageIcon(PlusIconPath);
        ImageIcon minusIcon = new ImageIcon(MinusIconPath);

        //Frame
        setTitle(FrameTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(420, 600);
        getContentPane().setBackground(BackgroundColor);
        setIconImage(frameIcon.getImage());

        //Layout
        setLayout(new BorderLayout(10, 5));

        TopPanel = new JPanel();
        TopPanel.setBorder(BorderFactory.createEtchedBorder());
        TopPanel.setBackground(BackgroundColor);
        TopPanel.setPreferredSize(new Dimension(400, 50));
        add(TopPanel, BorderLayout.NORTH);

        CenterPanel = new JPanel();
        CenterPanel.setBorder(BorderFactory.createEtchedBorder());
        CenterPanel.setBackground(BackgroundColor);
        add(CenterPanel, BorderLayout.CENTER);

        BottomPanel = new JPanel();
        BottomPanel.setBorder(BorderFactory.createEtchedBorder());
        BottomPanel.setBackground(BackgroundColor);
        BottomPanel.setPreferredSize(new Dimension(400, 50));
        add(BottomPanel, BorderLayout.SOUTH);

        //TopPanel
        JLabel TopLabel = new JLabel("Create your own character!");
        TopLabel.setIcon(createIcon);
        TopLabel.setForeground(Color.WHITE);
        TopLabel.setFont(new Font("MV Boli", Font.PLAIN, 25));
        TopPanel.add(TopLabel);

        //CenterPanel
        CenterPanel.setLayout(new GridLayout(7,1,0,10));
        Font font = new Font("serif", Font.PLAIN, 20);

        //CenterPanel - NamePanel
        JPanel namePanel = new JPanel();
        namePanel.setBackground(BackgroundColor);
        JLabel label = new JLabel("Name: ");
        label.setFont(font);

        NameField = new JTextField();
        NameField.setPreferredSize(new Dimension(200,30));
        NameField.setFont(font);
        NameField.setBackground(Color.lightGray);
        NameField.setText("Character");

        namePanel.add(label);
        namePanel.add(NameField);

        //CenterPanel - HealthPanel
        JPanel healthPanel = new JPanel();
        healthPanel.setBackground(BackgroundColor);
        label = new JLabel("Health Points: ");
        label.setFont(font);

        HealthField = new JTextField();
        HealthField.setPreferredSize(new Dimension(30,30));
        HealthField.setFont(font);
        HealthField.setBackground(Color.lightGray);
        HealthField.setText("0");
        HealthField.setEditable(false);

        JButton increaseButton = new JButton();
        increaseButton.setPreferredSize(new Dimension(30,30));
        increaseButton.setIcon(plusIcon);
        increaseButton.setBackground(Color.lightGray);
        increaseButton.setBorder(BorderFactory.createSoftBevelBorder(0));
        increaseButton.addActionListener(e -> IncreasePoints(HealthField));

        JButton decreaseButton = new JButton();
        decreaseButton.setPreferredSize(new Dimension(30,30));
        decreaseButton.setIcon(minusIcon);
        decreaseButton.setBackground(Color.lightGray);
        decreaseButton.setBorder(BorderFactory.createSoftBevelBorder(0));
        decreaseButton.addActionListener(e -> DecreasePoints(HealthField));

        healthPanel.add(label);
        healthPanel.add(increaseButton);
        healthPanel.add(HealthField);
        healthPanel.add(decreaseButton);

        //CenterPanel - ArmorPanel
        JPanel armorPanel = new JPanel();
        armorPanel.setBackground(BackgroundColor);
        label = new JLabel("Armor Points: ");
        label.setFont(font);

        ArmorField = new JTextField();
        ArmorField.setPreferredSize(new Dimension(30,30));
        ArmorField.setFont(font);
        ArmorField.setBackground(Color.lightGray);
        ArmorField.setText("0");
        ArmorField.setEditable(false);

        increaseButton = new JButton();
        increaseButton.setPreferredSize(new Dimension(30,30));
        increaseButton.setIcon(plusIcon);
        increaseButton.setBackground(Color.lightGray);
        increaseButton.setBorder(BorderFactory.createSoftBevelBorder(0));
        increaseButton.addActionListener(e -> IncreasePoints(ArmorField));

        decreaseButton = new JButton();
        decreaseButton.setPreferredSize(new Dimension(30,30));
        decreaseButton.setIcon(minusIcon);
        decreaseButton.setBackground(Color.lightGray);
        decreaseButton.setBorder(BorderFactory.createSoftBevelBorder(0));
        decreaseButton.addActionListener(e -> DecreasePoints(ArmorField));

        armorPanel.add(label);
        armorPanel.add(increaseButton);
        armorPanel.add(ArmorField);
        armorPanel.add(decreaseButton);

        //CenterPanel - AttackDamagePanel
        JPanel attackDamagePanel = new JPanel();
        attackDamagePanel.setBackground(BackgroundColor);
        label = new JLabel("Attack Damage Points: ");
        label.setFont(font);

        AttackDamageField = new JTextField();
        AttackDamageField.setPreferredSize(new Dimension(30,30));
        AttackDamageField.setFont(font);
        AttackDamageField.setBackground(Color.lightGray);
        AttackDamageField.setText("0");
        AttackDamageField.setEditable(false);

        increaseButton = new JButton();
        increaseButton.setPreferredSize(new Dimension(30,30));
        increaseButton.setIcon(plusIcon);
        increaseButton.setBackground(Color.lightGray);
        increaseButton.setBorder(BorderFactory.createSoftBevelBorder(0));
        increaseButton.addActionListener(e -> IncreasePoints(AttackDamageField));

        decreaseButton = new JButton();
        decreaseButton.setPreferredSize(new Dimension(30,30));
        decreaseButton.setIcon(minusIcon);
        decreaseButton.setBackground(Color.lightGray);
        decreaseButton.setBorder(BorderFactory.createSoftBevelBorder(0));
        decreaseButton.addActionListener(e -> DecreasePoints(AttackDamageField));

        attackDamagePanel.add(label);
        attackDamagePanel.add(increaseButton);
        attackDamagePanel.add(AttackDamageField);
        attackDamagePanel.add(decreaseButton);

        //CenterPanel - CriticalChancePanel
        JPanel criticalChancePanel = new JPanel();
        criticalChancePanel.setBackground(BackgroundColor);
        label = new JLabel("Critical Chance Points: ");
        label.setFont(font);

        CriticalChanceField = new JTextField();
        CriticalChanceField.setPreferredSize(new Dimension(30,30));
        CriticalChanceField.setFont(font);
        CriticalChanceField.setBackground(Color.lightGray);
        CriticalChanceField.setText("0");
        CriticalChanceField.setEditable(false);

        increaseButton = new JButton();
        increaseButton.setPreferredSize(new Dimension(30,30));
        increaseButton.setIcon(plusIcon);
        increaseButton.setBackground(Color.lightGray);
        increaseButton.setBorder(BorderFactory.createSoftBevelBorder(0));
        increaseButton.addActionListener(e -> IncreasePoints(CriticalChanceField));

        decreaseButton = new JButton();
        decreaseButton.setPreferredSize(new Dimension(30,30));
        decreaseButton.setIcon(minusIcon);
        decreaseButton.setBackground(Color.lightGray);
        decreaseButton.setBorder(BorderFactory.createSoftBevelBorder(0));
        decreaseButton.addActionListener(e -> DecreasePoints(CriticalChanceField));

        criticalChancePanel.add(label);
        criticalChancePanel.add(increaseButton);
        criticalChancePanel.add(CriticalChanceField);
        criticalChancePanel.add(decreaseButton);

        //CenterPanel - AttackSpeedPanel
        JPanel attackSpeedPanel = new JPanel();
        attackSpeedPanel.setBackground(BackgroundColor);
        label = new JLabel("Attack Speed Points: ");
        label.setFont(font);

        AttackSpeedField = new JTextField();
        AttackSpeedField.setPreferredSize(new Dimension(30,30));
        AttackSpeedField.setFont(font);
        AttackSpeedField.setBackground(Color.lightGray);
        AttackSpeedField.setText("0");
        AttackSpeedField.setEditable(false);

        increaseButton = new JButton();
        increaseButton.setPreferredSize(new Dimension(30,30));
        increaseButton.setIcon(plusIcon);
        increaseButton.setBackground(Color.lightGray);
        increaseButton.setBorder(BorderFactory.createSoftBevelBorder(0));
        increaseButton.addActionListener(e -> IncreasePoints(AttackSpeedField));

        decreaseButton = new JButton();
        decreaseButton.setPreferredSize(new Dimension(30,30));
        decreaseButton.setIcon(minusIcon);
        decreaseButton.setBackground(Color.lightGray);
        decreaseButton.setBorder(BorderFactory.createSoftBevelBorder(0));
        decreaseButton.addActionListener(e -> DecreasePoints(AttackSpeedField));

        attackSpeedPanel.add(label);
        attackSpeedPanel.add(increaseButton);
        attackSpeedPanel.add(AttackSpeedField);
        attackSpeedPanel.add(decreaseButton);

        //CenterPanel - PointsPanel
        JPanel pointsPanel = new JPanel();
        pointsPanel.setBackground(BackgroundColor);
        String text = "Remaining Points: " + FreePoints;
        PointsLabel = new JLabel(text);
        PointsLabel.setFont(font);
        PointsLabel.setForeground(Color.WHITE);
        pointsPanel.add(PointsLabel);

        //CenterPanel
        CenterPanel.add(namePanel);
        CenterPanel.add(healthPanel);
        CenterPanel.add(armorPanel);
        CenterPanel.add(attackDamagePanel);
        CenterPanel.add(criticalChancePanel);
        CenterPanel.add(attackSpeedPanel);
        CenterPanel.add(pointsPanel);

        //BottomPanel
        ConfirmButton = new JButton("Confirm your choice");
        ConfirmButton.setPreferredSize(new Dimension(300, 40));
        ConfirmButton.addActionListener(this);
        ConfirmButton.setFocusable(false);
        ConfirmButton.setIcon(confirmIcon);
        ConfirmButton.setFont(new Font("MV Boli", Font.PLAIN, 15));
        ConfirmButton.setBackground(Color.lightGray);
        ConfirmButton.setBorder(BorderFactory.createSoftBevelBorder(0));
        ConfirmButton.setEnabled(false);
        ConfirmButton.setToolTipText("Use all remaining points!");
        BottomPanel.add(ConfirmButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ConfirmButton) {
            if (NameField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name cannot be empty. Please write a name.", "Empty Name - Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                CharName = NameField.getText();
                CharHealthPoints = Integer.parseInt(HealthField.getText());
                CharArmorPoints = Integer.parseInt(ArmorField.getText());
                CharAttackDamagePoints = Integer.parseInt(AttackDamageField.getText());
                CharCriticalChancePoints = Integer.parseInt(CriticalChanceField.getText());
                CharAttackSpeedPoints = Integer.parseInt(AttackSpeedField.getText());

                PlayerCharacter = PointTypeCharacter.CreateCharacter(CharName, CharHealthPoints, CharArmorPoints, CharAttackDamagePoints, CharCriticalChancePoints, CharAttackSpeedPoints);
                Program.FirstFrameSetCharacter(PlayerCharacter);
                dispose();
            }
        }
    }

    private void IncreasePoints(JTextField textField) {
        if (FreePoints == 0) return;

        int attribute = Integer.parseInt(textField.getText());

        if (attribute == PointTypeCharacter.MaxPointOnOneAttribute) return;

        FreePoints -= 1;
        attribute += 1;

        textField.setText(String.valueOf(attribute));
        PointsLabel.setText("Remaining Points: " + FreePoints);

        if (FreePoints == 0) ConfirmButton.setEnabled(true);
    }

    private void DecreasePoints(JTextField textField) {
        int attribute = Integer.parseInt(textField.getText());

        if (attribute == 0) return;

        if (FreePoints == 0) ConfirmButton.setEnabled(false);

        FreePoints += 1;
        attribute -= 1;

        textField.setText(String.valueOf(attribute));
        PointsLabel.setText("Remaining Points: " + FreePoints);
    }

    public PointTypeCharacter getPlayerCharacter() {
        return PlayerCharacter;
    }
}
