class Person {
    private String name;
    private Date born;
    private Date died;

    public Person(String name, Date born, Date died) {
        this.name = name;
        this.born = born;
        this.died = died;
    }

    public String getDetails() {
        return "Name: " + name + "\nBorn: " + born.getYyyyMmDd() + "\nDied: " + (died != null ? died.getYyyyMmDd() : "N/A");
    }

    public boolean isAlive() {
        return died == null;
    }
}