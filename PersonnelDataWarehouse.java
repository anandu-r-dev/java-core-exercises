import java.util.function.Consumer;
import java.util.function.Function;

class TextSanitizer {

    public static String cleanRecord(String input) {
        return (input != null) ? input.replace("-", " ").trim() : "";
    }
}

public class PersonnelDataWarehouse {

    public static void main(String[] args) {
        System.out.println("Initializing Enterprise Data Reference Pipeline...");
        System.out.println("---------------------------------------------------------");

        String[] rawEmployeeList = {"  Anmbu ", " Guna  ", " Sentil "};

        Function<String, String> recordCleaner = TextSanitizer::cleanRecord;

        Function<String, String> caseTransformer = String::toUpperCase;

        Consumer<String> consolePrinter = System.out::println;

        System.out.println("Processing Sanitized Output Manifest:");
        for (String rawRecord : rawEmployeeList) {
            String cleanData = recordCleaner.apply(rawRecord);

            String structuralData = caseTransformer.apply(cleanData);

            consolePrinter.accept(" -> Active Profile: " + structuralData);
        }
        System.out.println("---------------------------------------------------------");
    }
}