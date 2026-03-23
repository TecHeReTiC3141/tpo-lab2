package org.example.math.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.example.math.exception.ToleranceException;

import com.opencsv.CSVWriter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class FunctionCalculator {
    private static final Path CSV_PATH = Path.of("output", "result_log.csv");
    private static CSVWriter csvWriter;

    static {
        initializeCsvWriter();
        Runtime.getRuntime().addShutdownHook(new Thread(FunctionCalculator::closeCsvWriter));
    }

    @Getter
    private final FunctionType function;

    private static void initializeCsvWriter() {
        try {
            Path parentPath = CSV_PATH.getParent();
            if (parentPath != null) {
                Files.createDirectories(parentPath);
            }

            csvWriter = new CSVWriter(Files.newBufferedWriter(
                    CSV_PATH,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING));

            csvWriter.writeNext(new String[]{"module_name", "x", "result"}, false);
            csvWriter.flush();
        } catch (IOException e) {
            csvWriter = null;
        }
    }

    private static void closeCsvWriter() {
        try {
            csvWriter.close();
        } catch (IOException e) {
            // Never happens.
        }
    }

    protected void writeCalculationResult(double x, double result) {
        try {
            csvWriter.writeNext(new String[]{getClass().getSimpleName(), Double.toString(x), Double.toString(result)}, false);
            csvWriter.flush();
        } catch (IOException e) {
            // Never happens.
        }
    }

    protected abstract boolean checkToleranceHit(double x);

    public abstract double calculate(double x);

    public double calculate(double x, double epsilon) {
        if (!checkToleranceHit(x)) {
            throw new ToleranceException(String
                    .format("Argument x = %f is out of tolerance range for the '%s' function.", x, function.getName()));
        }

        return calculate(x);
    }
}
