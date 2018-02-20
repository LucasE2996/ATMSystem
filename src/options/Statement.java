package options;

public class Statement {
    TrackingService trackingService;

    public Statement(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    public void printStatement(Account account) {
        trackingService.getTransactions().forEach(transaction -> System.out.println(
                "Foi feita um(a)" + transaction.getType() +
                        " no valor de " + transaction.getValue()
        ));
    }

}
