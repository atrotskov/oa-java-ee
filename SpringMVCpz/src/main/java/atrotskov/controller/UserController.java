package atrotskov.controller;

import atrotskov.model.Role;
import atrotskov.model.User;
import atrotskov.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String myMethod(ModelMap model){
        model.addAttribute("message", "Hello Spring MVC Framevork");
        return "hello";
    }

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public String getUserListGet(ModelMap model){
        model.addAttribute("userList", userService.getAll());
        return "userList";
    }

    @RequestMapping(value = "/userlist", method = RequestMethod.POST)
    public String getUserListPost(ModelMap model){
        model.addAttribute("userList", userService.getAll());
        return "userList";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String getAddUserPage(ModelMap model){
        return "addUser";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(@RequestParam("first-name") String firstName,
                          @RequestParam("last-name") String lastName,
                          @RequestParam("email") String email,
                          @RequestParam("age") String age,
                          @RequestParam("role") String role,
                          ModelMap model){

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAge(Integer.parseInt(age));
        user.setRole(Role.valueOf(role));

        userService.create(user);
        //model.addAttribute("userList", userDao.getAll());
        return "redirect:/userlist";
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
     public String getUpdateUserPage(@RequestParam("id") String id,
                                     ModelMap model){

        User user = userService.getById(Long.parseLong(id));
        model.addAttribute("userForUpdate", user);

        return "updateUser";
    }

    @RequestMapping(value = "/updateuserdone", method = RequestMethod.POST)
    public String updateUser(@RequestParam("id") String id,
                             @RequestParam("first-name") String firstName,
                             @RequestParam("last-name") String lastName,
                             @RequestParam("email") String email,
                             @RequestParam("age") String age,
                             @RequestParam("role") String role,
                             ModelMap model){

        User user = new User();
        user.setId(Long.parseLong(id));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAge(Integer.parseInt(age));
        user.setRole(Role.valueOf(role));


        user = userService.update(user);

        return "redirect:/userlist";
    }

    @RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("id") String id){

        userService.delete(userService.getById(Long.parseLong(id)));

        return "redirect:/userlist";
    }

}
