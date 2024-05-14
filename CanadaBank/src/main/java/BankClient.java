class BankClient extends Person {
    private String clientId;
    private Date dateJoinedTheBank;

    public BankClient(String name, Date born, Date died, String clientId, Date dateJoinedTheBank) {
        super(name, born, died);
        this.clientId = clientId;
        this.dateJoinedTheBank = dateJoinedTheBank;
    }

    public String getClientId() {
        return clientId;
    }

    public Date getDateJoinedTheBank() {
        return dateJoinedTheBank;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\nClient ID: " + clientId + "\nJoined The Bank: " + dateJoinedTheBank.getYyyyMmDd();
    }
}