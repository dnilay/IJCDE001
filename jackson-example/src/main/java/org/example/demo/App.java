package org.example.demo;

import java.io.File;

import org.example.demo.model.Employee;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	ObjectMapper objectMappe=new ObjectMapper();
        	Employee employee=objectMappe.readValue(new File("sample.json"), Employee.class);
        	System.out.println(employee);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
