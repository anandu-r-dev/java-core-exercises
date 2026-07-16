import java.util.ArrayList;
import java.util.List;

public class PipelineTelemetrySuite {

    public static void inspectStructure(List<?> elements) {
        System.out.println("Structure Check -> Total Elements Contained: " + elements.size());
    }

    public static double sumElements(List<? extends Number> numericList) {
        double accumulation = 0.0;

        for (Number item : numericList) {
            accumulation += item.doubleValue();
        }


        return accumulation;
    }

    public static void appendMetrics(List<? super Integer> destinationList) {
        destinationList.add(105);
        destinationList.add(210);

    }

    public static void main(String[] args) {
        System.out.println("Booting Invariant Telemetry Ingestion Hub...");
        System.out.println("---------------------------------------------------------");

        List<Integer> integerStream = new ArrayList<>();
        integerStream.add(10);
        integerStream.add(20);

        List<Double> doubleStream = new ArrayList<>();
        doubleStream.add(5.5);
        doubleStream.add(14.5);

        inspectStructure(integerStream);
        inspectStructure(doubleStream);
        System.out.println("---------------------------------------------------------");

        System.out.println("Integer Stream Accumulation: " + sumElements(integerStream));
        System.out.println("Double Stream Accumulation : " + sumElements(doubleStream));
        System.out.println("---------------------------------------------------------");

        List<Number> polymorphicStorage = new ArrayList<>();
        polymorphicStorage.add(55.3);

        appendMetrics(polymorphicStorage);
        System.out.println("Polymorphic Destination Buffer Content: " + polymorphicStorage);
        System.out.println("---------------------------------------------------------");
    }
}