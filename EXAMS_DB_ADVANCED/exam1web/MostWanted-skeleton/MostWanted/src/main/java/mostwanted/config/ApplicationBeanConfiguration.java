package mostwanted.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mostwanted.util.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public FileUtil fileUtil() {
        // TODO : Implement me

        return new FileUtilImpl();
    }

    @Bean
    public Gson gson() {
        // TODO : Implement me
        return new GsonBuilder().serializeNulls().
                setDateFormat("yyyy-MM-dd'T'HH:mm:ss").setPrettyPrinting().create();
    }

    @Bean
    public XmlParser xmlParser() {
        // TODO : Implement me

        return new XmlParserImpl();
    }

    @Bean
    public ValidationUtil validationUtil() {
        // TODO : Implement me

        return new ValidationUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        // TODO : Implement me
        return new ModelMapper();
    }
}
