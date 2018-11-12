package com.newsweaterproject.repos;

import com.newsweaterproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> { //необходиом для хранения информ о пользователе

    User findByUsername(String username);// Вкратце шаблонный метод который обрабатывается JPA и инстанцируется и делает ту логику в названии


}
