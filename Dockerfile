FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY *.class /app/
CMD ["java", "ExpenseTrackerAPI"]