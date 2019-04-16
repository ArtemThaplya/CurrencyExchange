package controllers;


import loginAdminUser.ValidationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


public class LoginController {

    private final ValidationService validationService = new ValidationService();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("login") final String login,
                        @RequestParam("password") final String password) {
        boolean isAdmin = validationService.isAdmin(login, password);
        if (isAdmin) {
            return "adminMenu.html";
        } else {
            return "error.html";
        }
    }
}
