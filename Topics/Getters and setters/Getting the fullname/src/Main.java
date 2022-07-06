class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        // write your code here
        this.lastName = lastName;
    }

    public String getFullName() {
        if (lastName == null && firstName == null) {
         return "Unknown";
        } else if (lastName == null) {
            return firstName;
        } else if (firstName == null) {
            return lastName;
        } else {
            return firstName + " " + lastName;
        }
    }

}
