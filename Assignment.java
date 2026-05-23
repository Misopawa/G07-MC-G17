import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main application window using Java Swing.
 * Contributed by: [Mohamad Syahmi bin Soria]
 * Ties together the GUI design, inputs, validations, and encoding execution.
 */
public class Assignment extends JFrame {

    // GUI Component Layout Fields
    private JTextField inputField;
    private JButton encodeButton;
    private JLabel headerLabel;
    private JLabel charCountLabel;
    private JLabel finalShiftLabel;
    private JTextArea resultArea;

    // Instance of Member 1's Encoded class to process calculations
    private Encoded encoderInstance;

    public Assignment() {
        // Initialize the backend logic model
        encoderInstance = new Encoded();

        // 1. Set Up Window Properties 
        setTitle("Secure Hash-Derived Group Shift Cipher");
        setSize(550, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on screen
        setLayout(new BorderLayout(10, 10));

        // 2. Create UI Components 
        // Header Text - Keeping it professional and generic to keep Group ID secure from UI 
        headerLabel = new JLabel("Custom String Encoding Application");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));

        // Input Panel Components 
        JLabel promptLabel = new JLabel("Enter text to encode (lowercase letters, numbers, spaces only):");
        inputField = new JTextField(30);
        encodeButton = new JButton("Encode Text");

        // Stat Labels (Middle Panel) 
        charCountLabel = new JLabel("Character Count (excluding spaces): -");
        finalShiftLabel = new JLabel("Final Computed Shift: -");

        // Output Result Field 
        resultArea = new JTextArea(4, 30);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setBorder(BorderFactory.createTitledBorder("Encoded Output Result"));

        // 3. Assemble Layout Panels
        // Top Panel: Header Accent
        add(headerLabel, BorderLayout.NORTH);

        // Center Panel: Controls and Metrics
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        // Grouping Input elements
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        inputPanel.add(promptLabel);
        
        centerPanel.add(inputPanel);
        centerPanel.add(inputField);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(encodeButton);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        // Grouping Metric Readouts (Base Group Shift and Group ID have been excluded per rubric guidelines) 
        centerPanel.add(charCountLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        centerPanel.add(finalShiftLabel);

        add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel: Output Area Layout 
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        bottomPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // 4. Hook up the Action Event Listener to Button
        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processEncoding();
            }
        });
    }

    /**
     * Core application workflow orchestrated when the action button triggers.
     * Validates input fields and manages programmatic communication between team branches.
     */
    private void processEncoding() {
        String rawInput = inputField.getText();

        // Step A: Trigger Member 1's validation handler check 
        boolean isValid = encoderInstance.checkStringValidity(rawInput);

        if (!isValid) {
            // Error Prompt Pop-up Dialog Box 
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Input detected!\n\nRules:\n1. Input cannot be blank.\n2. Uppercase letters or symbols are strictly forbidden.",
                    "Input Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            // Reset display layouts cleanly
            charCountLabel.setText("Character Count (excluding spaces): -");
            finalShiftLabel.setText("Final Computed Shift: -");
            resultArea.setText("");
            return;
        }

        // Set backend text property 
        encoderInstance.setInputText(rawInput);

        // Step B: Calculate metrics using Member 2's backend logic components 
        int charCount = encoderInstance.countCharacters(rawInput);
        int baseShift = encoderInstance.generateShift(); 
        
        // Final Shift Formula calculation: finalShift = groupShift + non-space characters 
        int finalShift = baseShift + charCount;

        // Step C: Update GUI metric labels to reflect new state 
        charCountLabel.setText("Character Count (excluding spaces): " + charCount);
        finalShiftLabel.setText("Final Computed Shift (Base Shift + Char Count): " + finalShift);

        // Step D: Apply Member 3's cipher algorithm transformations 
        String cipherOutput = encoderInstance.applyCipher(rawInput, finalShift);

        // Step E: Render output variables to the screen View 
        resultArea.setText(cipherOutput);
    }

    // Main execution hook to compile and execute the interface thread 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Assignment().setVisible(true);
            }
        });
    }
}