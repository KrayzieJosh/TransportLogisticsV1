package za.ac.cput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.factory.ProjectManagerFactory;
import za.ac.cput.service.ProjectManagerService;
import za.ac.cput.service.ProjectService;
import za.ac.cput.util.Helper;

import java.util.Arrays;
import java.util.List;

@RestController
@SpringBootApplication
public class Main{
    @RequestMapping({"/","/home"})
    String home(){
        return "Hello Yellows";

    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}