package atrotskov.controller;

import atrotskov.dto.UserDto;
import atrotskov.model.Role;
import atrotskov.model.User;
import atrotskov.service.api.ProductService;
import atrotskov.service.api.UserService;
import atrotskov.transformer.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GuestController {

    @Autowired
    public UserService userService;

    @Autowired
    public ProductService productService;

    @Autowired
    public Transformer transformer;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/user")
    public String getAllUser(ModelMap model) {
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : userService.getAll()) {
            usersDto.add(transformer.transformTo(user));
        }
        model.addAttribute("userList", usersDto);
        return "userList";
    }

    @RequestMapping(value = "/user/add")
    public String addUser(UserDto userDto) {
        return null;
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

        user.setRole(Role.valueOf(role));

        userService.create(user);
        //model.addAttribute("userList", userDao.getAll());
        return "redirect:/userlist";
    }

    @RequestMapping(value = "/user/id/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserDto getUserById(@PathVariable("id") Long id) {
        return transformer.transformTo(userService.getById(id));
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserDto> getAllUsers() {
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : userService.getAll()) {
            usersDto.add(transformer.transformTo(user));
        }
        return usersDto;
    }

    @RequestMapping(value = "/user/update")
    public void updateUser(UserDto userDto) {

    }

    @RequestMapping(value = "/user/delete")
    public void deleteUser(UserDto userDto) {

    }

   /* @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUserListGet(ModelMap model){
        model.addAttribute("userList", userService.getAll());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
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

        user.setRole(Role.valueOf(role));
        user = userService.update(user);
        return "redirect:/userlist";
    }

    @RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("id") String id){
        userService.delete(userService.getById(Long.parseLong(id)));
        return "redirect:/userlist";
    }

    @RequestMapping(value = "/api/users/get/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/api/users/get/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @RequestMapping(value = "/ajaxuser", method = RequestMethod.GET)
    public String ajaxUser(){
        return "ajaxUser";
    }*/
}