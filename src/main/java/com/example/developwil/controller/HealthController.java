package com.example.developwil.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/service")
public class HealthController {

    @GetMapping("/v1/health")
    public String getGreetingFromService(HttpServletResponse response) {
        //response.setHeader("Set-Cookie", "wc=abc; Max-Age=86400; Path=/");



        List<Student> students = Arrays.asList(new Student("Tom", "A+", 90),
                new Student("Lisa", "A+", 98),
                new Student("John", "A", 85),
                new Student("Joe", "A", 80),
                new Student("Jason", "E", 35));

        Map<String, List<Student>> studentsByGrade
                = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));

        for (Map.Entry<String, List<Student>> entry: studentsByGrade.entrySet()) {
            System.out.println("Students with " + entry.getKey() +
                    " grade are " + entry.getValue());
        }





        return "Hello, Testing services are up!";
    }


}
