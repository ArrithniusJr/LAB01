/**
 * Represents a person's first name and their last name
 *
 * @author Khuliso Junior Ravhuravhu and Arehone Brenden Mbadaliga
 *
 * @version 1.0
 *
 */

class Name {

    private final String first;
    private final String last;

    private final static int FIRST_CHAR = 0;
    private final static int MAX_CHAR = 45;

    /**
     * @param first and last name
     * @throws IllegalArgumentException
     *          if either first or last is null,
     *          blank, longer than 45 characters,
     *          or contains the word "admin".
     */
    Name(String first, String last) {
        if (first == null || last == null || first.isBlank() || last.isBlank()) {
            throw new IllegalArgumentException("First and last names cannot be blank.");
        }
        if (first.length() > MAX_CHAR || last.length() > MAX_CHAR) {
            throw new IllegalArgumentException("First and last names must be fewer than 45 characters.");
        }
        if (first.toLowerCase().contains("admin") || last.toLowerCase().contains("admin")) {
            throw new IllegalArgumentException("Names cannot contain the word 'admin'.");
        }
        this.first = first;
        this.last = last;
    }

    /**
     * Gets the first and the last name
     *
     * @return first's and the last's name first characters
     * */
    String getInitials(String first, String last){
        return first.charAt(FIRST_CHAR) + "." + last.charAt(FIRST_CHAR) + ".";
    }

    /**
     * Gets the first and the last name
     *
     * @return first and the last name first characters
     * */
    String getFullName(String first, String last) {
        return first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase() + " " +
                last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
    }

}
