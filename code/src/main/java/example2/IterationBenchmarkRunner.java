package example2;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IterationBenchmarkRunner {

    public static void main(String[] args) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SS");
        Options opt = new OptionsBuilder()
                .include(IterationBenchmark.class.getSimpleName())
                .resultFormat(ResultFormatType.TEXT)
                .result("benchmark-result/" + LocalDateTime.now().format(formatter) + ".txt")
                .build();

        new Runner(opt).run();
    }
}
