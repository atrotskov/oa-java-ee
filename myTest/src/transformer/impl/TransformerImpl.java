package transformer.impl;

import dto.UserDto;
import model.User;
import transformer.Transformer;

/**
 * Created by alexey on 24.03.16.
 */
public class TransformerImpl implements Transformer {
    @Override
    public User transformTo(UserDto userDto) {
        System.out.println("dto2User done");
        return null;
    }

    @Override
    public UserDto transformTo(User user) {
        System.out.println("user2Dto done");
        return null;
    }
}
