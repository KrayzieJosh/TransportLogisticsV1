package za.ac.cput.domain;

/* Company.java
 Entity for the domain
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

public class Company  {
    private String companyId;
    private String companyName;
    private String companyAddress;
    private String companyContact;
    private String companyEmail;

    private Company(Builder builder){
        this.companyId = builder.companyId;
        this.companyName = builder.companyName;
        this.companyAddress = builder.companyAddress;
        this.companyContact = builder.companyContact;
        this.companyEmail = builder.companyEmail;
    }
    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyContact='" + companyContact + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                '}';
    }
    public static class Builder { // static nested builder class
        private String companyId;
        private String companyName;
        private String companyAddress;
        private String companyContact;
        private String companyEmail;

        public Builder setCompanyId(String companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setCompanyAddress(String companyAddress) {
            this.companyAddress = companyAddress;
            return this;
        }

        public Builder setCompanyContact(String companyContact) {
            this.companyContact = companyContact;
            return this;
        }

        public Builder setCompanyEmail(String companyEmail) {
            this.companyEmail = companyEmail;
            return this;
        }
        public Builder copy(Company company){
            this.companyId = company.companyId;
            this.companyName = company.companyName;
            this.companyAddress = companyAddress;
            this.companyContact = company.companyContact;
            this.companyEmail = company.companyEmail;
            return this; // returning the builder object
        }
        public Company build(){
            return new Company(this);

        }
    }
}
