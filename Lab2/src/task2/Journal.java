package task2;

import java.util.ArrayList;

public class Journal {
    private final ArrayList<Record> records = new ArrayList<>();;

    public void addRecord(Record record) {
        records.add(record);
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    static public boolean validateData(String[] args) {
        try {
            Integer.parseInt(args[args.length - 1]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
