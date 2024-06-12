package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {


    //Bu method ile json datayı java objesine çeviriyoruz.
    //Object mapper kullanırken atılan exception'ı burada try-catch ile hallediyoruz.
    public static <T> T jsonToJava(String json, Class<T> tClass) {//Generic Method

        try {
            return new ObjectMapper().readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
