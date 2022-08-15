package sg.edu.rp.c346.id21045028.crudebirthratedata;

public class Birth {

    private String id;
    private String level;
    private String value;
    private String year;

    public Birth(String id, String level, String value, String year) {
        this.id = id;
        this.level = level;
        this.value = value;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Birth Rate" + '\n' +
                "ID : " + id + '\n' +
                "Level1 : " + level + '\n' +
                "Value : " + value + '\n' +
                "Year : " + year + '\n';
    }
}
