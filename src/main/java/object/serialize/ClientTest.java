package object.serialize;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientTest {

    public static void main(String args[])
    {
        String filename = "employee.ser";
        serializeObject(filename);
        deserializeObject(filename);

    }
    private static void serializeObject(String filename){
    Employee emp1=new Employee();
        Employee emp2=new Employee();
        ArrayList<Employee> employees=new ArrayList<Employee>();

    emp1.setId(12345);
    emp1.setName("VMadhavi");
    emp1.setEmail("vmd@gmail.com");
    emp1.setSalary(500000.00);
    employees.add(emp1);

        emp2.setId(12344);
        emp2.setName("DVBShyam");
        emp2.setEmail("dvb@gmail.com");
        emp2.setSalary(900000.00);
        employees.add(emp2);

        try{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(filename)));
        oos.writeObject(employees);
        System.out.println("emps serialized....");
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }

    private static void deserializeObject(String filename)
    {
        try{
            ObjectInputStream ois = new ObjectInputStream((new FileInputStream(new File(filename))));
            Object obj1=ois.readObject();
           // Employee emp = (Employee)obj1;
            ArrayList<Employee> emps = (ArrayList)obj1;
            //ArrayList<Employee> employees=new ArrayList<Employee>();
            int i=0;
            for (Employee emp : emps) {
                i++;
                System.out.println("Emp "+i+" deserialized..");
                System.out.println("emp id=" + emp.getId());
                System.out.println("emp name=" + emp.getName());
                System.out.println("emp email=" + emp.getEmail());
                System.out.println("emp salary=" + emp.getSalary());
            }
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    @RequestMapping("/add/{val1}/{val2}")
    public int doAdd(@PathVariable("val1") String val1, @PathVariable("val2") String val2)
    {
        int result = Integer.getInteger(val1) + Integer.getInteger(val2);
        return  result;
    }
////localhost:8080/add/2/3
}
