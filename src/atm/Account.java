package atm;

import atm.options.TrackingService;

public class Account {

   private final String numero;
   private final String clientName;
   private final TrackingService trackingService;

   public Account(String numero, String cliente, TrackingService trackingService) {
        this.numero = numero;
        this.clientName = cliente;
        this.trackingService = trackingService;
    }

    public String getClientName() {
        return clientName;
    }

    public TrackingService getTrackingService() {
        return trackingService;
    }
}
