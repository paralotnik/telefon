package ninja.sedzik.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "Nieznajomy") String username,
                       @RequestParam(defaultValue = "0") int age,
                       @RequestHeader("user-agent") String userAgent) {
        System.out.println("Hello " + username);
        if (age > 0) {
            System.out.println("Your age is: " + age);
        }
        System.out.println("Web browser: " + userAgent);
        return "home";
    }



    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public String home1() {
        return "home";
    }


    @RequestMapping(path = "/getpost", method = {RequestMethod.GET, RequestMethod.POST})
    public String home2() {
        return "home";
    }


    @GetMapping("/get2")
    public String home3() {
        return "home";
    }



    @GetMapping("/params")
    public String home4(HttpServletRequest request) {
        String username = request.getParameter("username");
        if(username != null) {
            System.out.println("Hello " + username);
        }
        javax.servlet.http.Cookie[] cookies = request.getCookies();
        for(javax.servlet.http.Cookie cookie: cookies) {
            System.out.println(cookie.getName() + " " + cookie.getValue());
        }
        return "home";
    }

    @GetMapping("/dupa")
    public String home5(@RequestParam(name="username") String username) {
        System.out.println("Hello " + username);
        return "home";
    }


    @GetMapping("/dupa2")
    public String hom6(@RequestParam(name="username",
            defaultValue="Nieznajomy",
            required = true) String username) {
        System.out.println("Hello " + username);
        return "home";
    }



    @GetMapping("/dupa3")
    public String home7(@RequestParam(defaultValue="Nieznajomy") String username) {
        System.out.println("Hello " + username);
        return "home";
    }

    @GetMapping("/dupa4")
    public String home8(
            @RequestParam(defaultValue="Nieznajomy") String username,
            @RequestHeader("user-agent") String userAgent) {
        System.out.println("Hello " + username);
        System.out.println("Web browser: " + userAgent);
        return "home";
    }




}