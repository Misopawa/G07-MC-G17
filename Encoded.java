//Contributor for Class Skeleton, Constructors, and Validation: Mohamad Nazri
//Contributor for Encoder Cipher Algorithm: Rosaliny Lisa

public class Encoded {
    // DATA FIELDS (Encapsulation - Private)
    private String inputText;
    private int charCount;
    private String resultText;
    
    // Hardcoded hidden group ID
    private final String groupID = "G07/MC-G17";
   
    //CONSTRUCTORS (Contributed by Mohamad Nazri)
    public Encoded() {
        this.inputText = "";
        this.charCount = 0;
        this.resultText = "";
    }

    public Encoded(String inputText) {
        this.inputText = inputText;
        this.charCount = 0; // Will be calculated by Member 2
        this.resultText = ""; // Will be computed by Member 3
    }

    // VALIDATION METHOD (Contributed by Mohamad Nazri)
    public boolean checkStringValidity(String inputText) {
        // Return false if the user didn't type anything
        if (inputText == null || inputText.isEmpty()) {
            return false;
        }

        // Check every single character in the string one by one
        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);

            // Check if the character is allowed
            if (c >= 'a' && c <= 'z') {
                // It is a lowercase letter, which is allowed. Do nothing and continue.
            } 
            else if (c >= '0' && c <= '9') {
                // It is a number, which is allowed. Do nothing and continue.
            } 
            else if (c == ' ') {
                // It is a space, which is allowed. Do nothing and continue.
            } 
            else {
                // If we reach here, the character is NOT a lowercase letter, number, or space.
                // This means it's an uppercase letter or symbol, so the string is invalid.
                return false;
            }
        }
        
        // If the loop finishes without finding any bad characters, the string is valid
        return true;
    }

    // GETTERS AND SETTERS
    public String getInputText() {
        return this.inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public int getCharCount() {
        return this.charCount;
    }

    public void setCharCount(int charCount) {
        this.charCount = charCount;
    }

    public String getResultText() {
        return this.resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    // Getter for groupID is provided, but NO setter exists to guarantee it is unchangeable
    public String getGroupID() {
        return this.groupID;
    }


    // =========================================================================
    // CODE STUBS - TO BE COMPLETED BY OTHER MEMBERS
    // These placeholder methods allow the file to compile while keeping tasks modular.
    // =========================================================================

    /**
     * Counts non-space characters in the input string.
     * To be implemented fully by Member 2.
     * * @param inputText The string to count
     * @return count of non-space characters
     */
    public int countCharacters(String inputText) {
        // TODO: Contributed by [Member 2]
        // Temporary dummy return value so the class compiles
        return 0; 
    }

    /**
     * Generates a shift constant from the hardcoded groupID hash.
     * To be implemented fully by Member 2.
     * * @return a shift value between 1 and 10
     */
    public int generateShift() {
        // TODO: Contributed by [Member 2]
        // Temporary dummy return value so the class compiles
        return 1;
    }

    // Contributed by [Rosaliny Lisa]
    public String applyCipher(String inputText, int shift) {
       StringBuilder result = new StringBuilder(); 
       
       // Check each character one by one from start to end of string
       for (int i = 0; i < inputText.length(); i++){
        char c = inputText.charAt(i);

        // For lowercase letter (a-z) using (c - 'a' + finalShift) % 26 + 'a' 
        if (c >= 'a' && c <= 'z') {
            char shiftedChar = (char) (((c - 'a' + shift) % 26) + 'a');
                result.append(shiftedChar);
        }
        // For numbers (0-9) using (c - '0' + finalShift) % 10 + '0' 
            else if (c >= '0' && c <= '9') {
                char shiftedChar = (char) (((c - '0' + shift) % 10) + '0');
                result.append(shiftedChar);
            } 
            // If it's a blank space, just leave it as it is
            else if (c == ' ') {
                result.append(c);
            }
        }
