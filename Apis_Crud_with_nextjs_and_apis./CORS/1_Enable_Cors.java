The error you're encountering is a CORS (Cross-Origin Resource Sharing) issue. It's happening because your frontend, running on `http://localhost:3000`, is trying to make an XMLHttpRequest to your backend, running on `http://localhost:9002`, and the backend is not configured to allow requests from the frontend's origin. 

To fix this issue, you need to configure CORS on your Spring Boot backend to allow requests from `http://localhost:3000`. Here's how to do it:

1. **Add the Required Dependencies**:

   Make sure you have the `spring-boot-starter-web` dependency in your `pom.xml`. This dependency provides the necessary CORS configuration options.

   ```xml
   <dependencies>
       <!-- Other dependencies -->
       <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-web</artifactId>
       </dependency>
   </dependencies>
   ```

2. **Configure CORS**:

   Create a configuration class to define CORS settings. You can configure CORS globally for your entire application or per controller if needed. Here's an example of configuring it globally:

   ```java
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.web.servlet.config.annotation.CorsRegistry;
   import org.springframework.web.servlet.config.annotation.EnableWebMvc;
   import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

   @Configuration
   @EnableWebMvc
   public class CorsConfig implements WebMvcConfigurer {

       @Override
       public void addCorsMappings(CorsRegistry registry) {
           registry.addMapping("/**")
                   .allowedOrigins("http://localhost:3000") // Replace with your frontend URL
                   .allowedMethods("GET", "POST", "PUT", "DELETE")
                   .allowCredentials(true);
       }
   }
   ```

   In this example, replace `"http://localhost:3000"` with the actual domain where your frontend is hosted. The `allowedMethods` option specifies the HTTP methods that are allowed.

3. **Testing**:

   After adding the CORS configuration, test your frontend to ensure that it can communicate with your Spring Boot backend without CORS-related issues. Make sure that the specified frontend domain matches the actual domain where your frontend is hosted.

With these steps, your Spring Boot application should be configured to allow requests from your frontend on `http://localhost:3000`, and you should no longer encounter CORS errors when making requests from your frontend to your backend.
