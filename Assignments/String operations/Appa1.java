class Appa1 {
    public static void main(String args[]) {
        String str = "i am srinivasarao";
        
        // Loop through the string to find the first character of each word
        for (int i = 0; i < str.length(); i++) {
            // Check if it's the start of a word or after a space
            if (i == 0 || str.charAt(i - 1) == ' ') {
                // Convert the character to uppercase if it's the first character of a word
                char currentChar = str.charAt(i);
                char upperChar = Character.toUpperCase(currentChar);
                
                // Replace the original character with the uppercase one
                str = str.substring(0, i) + upperChar + str.substring(i + 1);
            }
        }

        // Print the modified string
        System.out.println(str);
    }
}
