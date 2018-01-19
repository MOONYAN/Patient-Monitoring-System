public class Main {

    public static void main(String[] args) {
        String input = args.length == 0 ? "SampleInput" : args[0];
        IDatabase database = new JsonDatabase();
        MonitorBulider bulider = new MonitorBulider(new FileReader(input), database);
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
