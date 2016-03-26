import dto.UserDto;
import model.User;
import transformer.Transformer;
import transformer.impl.TransformerImpl;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Transformer tr = new TransformerImpl();

        User user1 = new User();
        UserDto userDto1 = new UserDto();

        UserDto userDto2 = tr.transformTo(user1);
        User user2 = tr.transformTo(userDto1);
    }
}
