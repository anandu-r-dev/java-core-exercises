class InventoryItem {
    private String itemSku;
    private int stockQuantity;

    public InventoryItem(String itemSku, int initialStock) {
        setItemSku(itemSku);
        setStockQuantity(initialStock);
    }

    public String getItemSku() {
        return this.itemSku;
    }

    public void setItemSku(String itemSku) {
        if (itemSku == null || itemSku.trim().isEmpty()) {
            System.out.println("VALIDATION ALERT: Invalid SKU assigned. Using fallback default.");
            this.itemSku = "UNKNOWN_SKU";
        } else {
            this.itemSku = itemSku.trim();
        }
    }

    public int getStockQuantity() {
        return this.stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) {
            System.out.println("VALIDATION ALERT: Negative stock [ " + stockQuantity + " ] rejected. Forcing floor baseline of 0.");
            this.stockQuantity = 0;
        } else {
            this.stockQuantity = stockQuantity;
        }
    }
}

public class SupplyChainLedger {

    public static void main(String[] args) {
        System.out.println("Initializing Supply Chain Validation Matrix...");
        System.out.println("------------------------------------------------");

        System.out.println("Processing Valid Item Allocation...");
        InventoryItem clearItem = new InventoryItem("SKU-998A", 150);
        System.out.println("Verified SKU   : " + clearItem.getItemSku());
        System.out.println("Verified Stock : " + clearItem.getStockQuantity() + " units");
        System.out.println("------------------------------------------------");

        System.out.println("Processing Corrupted Data Allocation Test...");
        InventoryItem corruptedItem = new InventoryItem("   ", -45);

        System.out.println("\nResulting Protected State Matrix:");
        System.out.println("Sanitized SKU  : " + corruptedItem.getItemSku());
        System.out.println("Sanitized Stock: " + corruptedItem.getStockQuantity() + " units");
        System.out.println("------------------------------------------------");

        System.out.println("Applying Update Operations via Setter Checks...");
        corruptedItem.setItemSku("SKU-774B");
        corruptedItem.setStockQuantity(25);

        System.out.println("\nFinal State Matrix:");
        System.out.println("Updated SKU    : " + corruptedItem.getItemSku());
        System.out.println("Updated Stock  : " + corruptedItem.getStockQuantity() + " units");
    }
}