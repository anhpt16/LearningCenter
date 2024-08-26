package com.nhatanh.centerlearn.admin.validator;

import com.tvd12.ezyfox.bean.annotation.EzySingleton;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EzySingleton
public class FormValidator {

    public boolean validateBlank(String str) {
        return str == null || str.isEmpty() ||
            str.chars().allMatch(Character::isWhitespace);
    }

    public boolean validateSpecialCharacter(String str) {
        String regex = "^[\\p{L}0-9\\s]+$";
        return str.matches(regex);
    }

    public boolean validateNumberPositive(int number) {
        return number > 0;
    }
    public boolean validateNumberPositive(long number) {
        return number >= 0;
    }

    public <T> boolean isNull(T object) {
        return object == null;
    }
}
