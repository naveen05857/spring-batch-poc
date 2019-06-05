package com.springpoc.springpoc.config;

import com.springpoc.springpoc.batch.Processor;
import com.springpoc.springpoc.model.Employee;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.batch.core.Job;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemWriter<Employee> writer;

    @Autowired
    private JdbcCursorItemReader<Employee> reader;

    @Bean
    public Processor processor() {
        return new Processor();
    }

    @Bean
    public Job job() {

        Step step = stepBuilderFactory.get("Reading-GreyCorn")
                .<Employee, Employee> chunk(100)
                .reader(reader)
                .processor(processor())
                .writer(writer)
                .build();

        return jobBuilderFactory.get("ETL-LOAD")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }
}
