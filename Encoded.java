//Contributor for Class Skeleton, Constructors, and Validation: Mohamad Nazri
//Contributor for Encoder Cipher Algorithm: Rosaliny Lisa
//Contributor for Character Counting & Shift Logic: Siti Nur Amira binti Zulkiply

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
    // MEMBER 2 COMPONENT: CHARACTER COUNTING & SHIFT LOGIC
    // =========================================================================

    /**
     * Counts the total number of non-space characters within the user's input string.
     * Contributed by: Siti Nur Amira binti Zulkiply (Member 2)
     * * @param inputText The validated user input string.
     * @return The integer count of characters that are not spaces.
     */
    public int countCharacters(String inputText) {
        // Guard rail: if input is null, return 0 immediately to prevent crashes
        if (inputText == null) {
            return 0;
        }
        
        int count = 0;
        
        // Loop through every character in the string sequentially
        for (int i = 0; i < inputText.length(); i++) {
            // Check if the current character is not a whitespace space
            if (inputText.charAt(i) != ' ') {
                count++; // Increment our counter
            }
        }
        
        // Save the result into the class data field and return it
        this.charCount = count; 
        return count;
    }

    /**
     * Generates a unique, permanent base groupShift value from the hardcoded groupID.
     * The resulting value is strictly bounded between 1 and 10.
     * Contributed by: Siti Nur Amira binti Zulkiply (Member 2)
     * * @return An integer shift value between 1 and 10.
     */
    public int generateShift() {
        // 1. Retrieve the standard Java internal hash code of our group ID string
        int hash = this.groupID.hashCode(); 
        
        // 2. Apply Math.abs() because String.hashCode() can return a negative number.
        //    We must work with absolute positive numbers for our math bounds.
        int positiveHash = Math.abs(hash);
        
        // 3. Apply modulo 10 (% 10) to get a remainder range of 0 to 9.
        //    Then, add 1 to shift that range perfectly to be between 1 and 10.
        int groupShift = (positiveHash % 10) + 1; 
        
        return groupShift;
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
        this.resultText = result.toString();
        return this.resultText;
    }
}
