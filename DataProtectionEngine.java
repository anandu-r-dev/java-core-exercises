interface StorageTarget {
    void savePayload(String data);
}

class LocalHardDrive implements StorageTarget {
    @Override
    public void savePayload(String data) {
        System.out.println("LocalDiskIO -> Spinning up physical plates...");
        System.out.println("LocalDiskIO -> Success: Written to block storage: [ " + data + " ]");
    }
}

class CloudBucket implements StorageTarget {
    @Override
    public void savePayload(String data) {
        System.out.println("CloudAPI -> Resolving secure REST endpoint token...");
        System.out.println("CloudAPI -> Success: Streamed compressed blob: [ " + data + " ]");
    }
}

class BackupManager {
    private final StorageTarget targetStorage;

    public BackupManager(StorageTarget targetStorage) {
        this.targetStorage = targetStorage;
    }

    public void runBackupSequence(String backupContent) {
        System.out.println("BackupManager -> Initiating system state capture...");

        targetStorage.savePayload(backupContent);

        System.out.println("BackupManager -> Sequence finalized successfully.");
    }
}

public class DataProtectionEngine {

    public static void main(String[] args) {
        System.out.println("Booting Secure Data Protection Subsystem...");
        System.out.println("---------------------------------------------------------");

        String sensitiveMetadata = "UserProfiles_2026_Dump.bin";

        System.out.println("[Configuring Pipeline A: Local Hardware]");
        StorageTarget diskDrive = new LocalHardDrive();

        BackupManager clientA = new BackupManager(diskDrive);
        clientA.runBackupSequence(sensitiveMetadata);

        System.out.println("---------------------------------------------------------");

        System.out.println("[Configuring Pipeline B: Remote Cloud Platform]");
        StorageTarget AWSBucket = new CloudBucket();

        BackupManager clientB = new BackupManager(AWSBucket);
        clientB.runBackupSequence(sensitiveMetadata);

        System.out.println("---------------------------------------------------------");
    }
}