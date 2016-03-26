package transformer;

import dto.UserDto;
import model.User;

/**
 * Created by alexey on 24.03.16.
 */
public interface Transformer {
    User transformTo(UserDto userDto);
    UserDto transformTo(User user);
}
