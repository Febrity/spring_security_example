<h2>Spring security example</h2>
Пример использования spring_security
****
SpringSecurityExample - запускает тесты на проверку доступа к методам ExampleController
У метода createUser стоит разрешение на использование только у роли Админ или Бизнесс-Админ.

Также приложение доступно по пути: ***http://localhost:8030/api/example***

---
Кратко о Spring security:
**SpringSecurity**. Для использования аннотаций @PreAuthorize и @Secured добавляем 
 @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) в наш SpringSecurity.
 
  >**http.authorizeRequests()
                       .antMatchers("/", "/api/**").permitAll()
                       .anyRequest().authenticated()** - доступ по пути "/api" будет доступна только авторизованным пользователям.
 
  >**.formLogin()
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll()** -  формочка логина и релогина стандартная. 
 
***Авторизация из пользователей в базе*** 

Для настройки пользователей используется UserDetailsService, в котором 
необходимо переопределить метод  UserDetails loadUserByUsername(String username), который вернет нам наш UserDetails 
с паролем и ролями. 
 
>**configure(AuthenticationManagerBuilder auth)** - проверка аутентификации пользователя. 
