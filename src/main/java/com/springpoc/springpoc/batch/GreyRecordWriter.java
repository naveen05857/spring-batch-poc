package com.springpoc.springpoc.batch;

import com.springpoc.springpoc.model.Employee;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

@Component
public class GreyRecordWriter {

    @Bean
    public ItemWriter<Employee> writer() {

        String filePath = "xml/outputs/Student.xml";
        StaxEventItemWriter<Employee> xmlFileWriter = new StaxEventItemWriter<>();
        xmlFileWriter.setResource(new FileSystemResource(filePath));
        xmlFileWriter.setRootTagName("students");

        Jaxb2Marshaller employeeMarshaller = new Jaxb2Marshaller();
        employeeMarshaller.setClassesToBeBound(Employee.class);
        xmlFileWriter.setMarshaller(employeeMarshaller);

        return xmlFileWriter;
    }
 }
