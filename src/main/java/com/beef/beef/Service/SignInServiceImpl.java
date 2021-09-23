package com.beef.beef.Service;

import com.beef.beef.model.User;
import com.beef.beef.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
public class SignInServiceImpl implements SignInService{

    private UserRepository userRepository;
    @Autowired
    public SignInServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean loginAndPasswordValidation(String passError, String loginError, Model model) {
        if (!passError.equals("") || !loginError.equals("")) {
            model.addAttribute("passError", passError);
            model.addAttribute("loginError", loginError);
            return false;
        }
        return true;
    }
}
