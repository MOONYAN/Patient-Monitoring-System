package com.company;

public class Main {

    public static void main(String[] args) {
        IDatabase database = new JsonDatabase();
        MonitorBulider bulider = new MonitorBulider(new FileReader("SampleInput"), database);
        StationMonitor monitor = bulider.build();
        monitor.startMonitor();
        database.display(new IMonitor() {
            @Override
            public void display(String text) {
                System.out.println(text);
            }
        });
    }
}
