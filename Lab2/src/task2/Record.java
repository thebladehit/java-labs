package task2;

public class Record {
    public String surName;
    public String name;
    public String birth;
    public int phone;

    public Record(String[] data) {
        this.surName = data[0];
        this.name = data[1];
        this.birth = data[2];
        this.phone = Integer.parseInt(data[3]);
    }

    public Record() {
        this.surName = "auto created";
    }

    @Override
    public String toString() {
        return "Record{" +
                "surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", phone=" + phone +
                '}';
    }
}
