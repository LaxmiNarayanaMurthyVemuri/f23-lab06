public class PlayerDataService {
    private Records records;

    public PlayerDataService(Records records) {
        this.records = records;
    }

    public boolean recordPlayer(Frogger frogger) {
        // Extract player data from Frogger
        // This might involve changing Frogger to expose player data more appropriately
        return records.addRecord(frogger.getFirstName(), frogger.getFirstName(), frogger.getPhoneNumber(), 
                                 frogger.getZipCode(), frogger.getState(), frogger.getGender());
    }
}
