package com.javamaster.tatyana;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class UsersService {
    private List<Users> users=new ArrayList<Users>();

    public UsersService() {

    }

    public UsersService(List <Users> users)
    {
        this.users = users;
    }

    public List <Users> getUsers()
    {
        return users;
    }

    public List <Users> createNewUser(String name, LocalDate dateOfBirth) throws Exception {
        validateUser(name, dateOfBirth);
        users.add(new Users(name, dateOfBirth));
        return users;
    }

    private void validateUser(String name, LocalDate dateOfBirth) throws Exception {
        if(isNull(name)||(name.isEmpty())){
            throw new CustomFieldException("Name could not be empty or null");
        }
        if(isNull(dateOfBirth)){
            throw new CustomFieldException("Date of birth could not be null");
        }
    }

    public void removeUser(String name)
    {
       users = users.stream()
               .filter(it -> !it.Name.equals(name))
               .collect(Collectors.toList());
    }
    
    public boolean isBirthDay(Users user, LocalDate date) throws CustomFieldException {
        if (isNull(user)||isNull(user.dateOfBirth))
        {
            throw new CustomFieldException("User or Date of Birth is null");
        }
        if (isNull(date))
        {
            throw new CustomFieldException("Compare date must not be null");
        }
        return date.getDayOfMonth() == user.dateOfBirth.getDayOfMonth() && date.getMonth().equals(user.dateOfBirth.getMonth());
    }
}

