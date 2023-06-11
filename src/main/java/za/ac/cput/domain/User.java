package za.ac.cput.domain;

/* User.java
 Entity for the domain
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/
public class User {
    private String userId;
    private String userFirstName;
    private String userMiddleName;
    private String userLastName;
    private String userContact;
    private String userEmail;
    private String userDriverCode;

    private User(Builder builder) {
        this.userId = builder.userId;
        this.userFirstName = builder.userFirstName;
        this.userMiddleName = builder.userMiddleName;
        this.userLastName = builder.userLastName;
        this.userContact = builder.userContact;
        this.userEmail = builder.userEmail;
        this.userDriverCode = builder.userDriverCode;
    }

    public String getUserId() { // retrieves values
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserContact() {
        return userContact;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserDriverCode() {
        return userDriverCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userMiddleName='" + userMiddleName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userContact='" + userContact + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userDriverCode='" + userDriverCode + '\'' +
                '}';
    }
    public static class Builder {
        private String userId;
        private String userFirstName;
        private String userMiddleName;
        private String userLastName;
        private String userContact;
        private String userEmail;
        private String userDriverCode;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }
        public Builder setUserFirstName(String userFirstName) {
            this.userFirstName = userFirstName;
            return this;
        }
        public Builder setUserMiddleName(String userMiddleName) {
            this.userMiddleName = userMiddleName;
            return this;
        }
        public Builder setUserLastName(String userLastName) {
            this.userLastName = userLastName;
            return this;
        }
        public Builder setUserContact(String userContact) {
            this.userContact = userContact;
            return this;
        }
        public Builder setUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }
        public Builder setUserDriverCode(String userDriverCode) {
            this.userDriverCode = userDriverCode;
            return this;
        }
        public Builder copy(User user) {
            this.userId = user.userId;
            this.userFirstName = user.userFirstName;
            this.userMiddleName = user.userMiddleName;
            this.userLastName = user.userLastName;
            this.userContact = user.userContact;
            this.userEmail = user.userEmail;
            this.userDriverCode = user.userDriverCode;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}
