package in.tca.main ;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.BeansException; // Import the BeansException

import com.google.gson.Gson;
import in.tca.beans.Student;

public class Main {
    public static void main(String[] args) {
        String configLocation = "/in/tca/config/applicationContext.xml";

        try {
            ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

//            Gson gson = new Gson(); 
            
            Gson gson = (Gson) context.getBean("gson");
            
            Student student = (Student) context.getBean("stdId");
            
            student.setId(1);
            student.setFirstName("Alice");
            student.setLastName("Smith");
            student.setDob("2000-01-01");
            student.setEmail("alice@example.com");
            student.setPassword(123456);
            student.setPhone(9876543210L);
            student.setAddhar(123456789012L);
            student.setAddress("123 Main St");

            // Serialize the Student object to JSON
            String jsonString = gson.toJson(student);
            System.out.println("Serialized JSON: " + jsonString);
            
            // Deserialize the JSON string back into a Student object
            Student deserializedStudent = gson.fromJson(jsonString, Student.class);
            System.out.println("Deserialized Student: " + deserializedStudent);
            
        } catch (BeansException e) {
            e.printStackTrace(); // Handle BeansException
        } catch (Exception e) {
            e.printStackTrace(); // Handle any other exceptions
        }
    }
}
