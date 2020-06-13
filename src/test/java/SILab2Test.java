import com.sun.tools.javac.code.Attribute;
import com.sun.tools.javac.tree.DCTree;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    private List<String> createList(String... elems) {
        return new ArrayList<>(Arrays.asList(elems));

    }
    void EveryPathFunction() {

        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        String num = "0123456789";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        RuntimeException ex;
//1,2, 3, 4, 26

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, createList("trajce", "goce", "sime")));
        assertTrue(ex.getMessage().contains("The user is not instantiated"));
//1,2, 3, 5, 6, 26

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("trajce", null, "trajce.jankuloski@gmail.com"), createList("trajce", "goce", "sime")));
        assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));
        //1,2, 3, 5, 7,8, 9, 10, 26
        User user = new User("goce", "73goce?", "goce@yahoo.com");
        assertFalse(user.getUsername().contains(user.getPassword().toLowerCase()));
        //1,2,3,5,7,8, 9, 11, 12, 26
        User user1 = new User("goce", "73g", "goce@yahoo.com");
        assertTrue(user1.getPassword().length() < 8);
//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 17, 18, 19, 20, 22, 15.3, 15.2), 23, 24, 26
        user = new User("goce", "73goce37", "goce@gmail.com");
        assertFalse(user.getPassword().contains(specialCharacters));
//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 17, 18, 20, 22, 15.3, 15.2), 23, 24, 26
        user = new User("goce", "123456789", "goce@gmail.com");
        assertFalse(user.getPassword().contains(num));
//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 19, 20, 21, 22, 15.3, 15.2), 23, 24, 26
        user = new User("goce", "TR!mdr?", "goce@gmail.com");
        assertFalse(user.getPassword().contains(upper) && user.getPassword().contains(specialCharacters));
//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 19, 20, 22, 15.3, 15.2), 23, 24, 26
        user = new User("goce", "BBBBAAAAA", "goce@gmail.com");
        assertFalse(user.getPassword().contains(upper));
//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 20, 21, 22, 15.3, 15.2), 23, 24, 26
        user = new User("goce", "##!$lalalala", "goce@gmail.com");
        assertFalse(user.getPassword().contains(specialCharacters));
//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 20, 22, 15.3, 15.2), 23, 24, 26
        user = new User("goce", "kjdhbewkdj", "goce@gmail.com");
        assertTrue(!user.getPassword().contains(num) && !user.getPassword().contains(specialCharacters) && !user.getPassword().contains(upper));
    }

        //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 20, 22, 15.3, 15.2), 23, 25, 26
        //ne vozmozhno
//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, 23, 24, 26
//ne e vozmozhno
//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, 23, 25, 26
        //ne e vozmozhno
        //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 20, 21, 22, 15.3, 15.2), 23, 25, 26
        //ne e vozmozhno
        //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 19, 20, 22, 15.3, 15.2), 23, 25, 26
        //ne e vozmozhno
//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 19, 20, 21, 22, 15.3, 15.2), 23, 25, 26
        //ne e vozmozhno
        //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 17, 18, 20, 21, 22, 15.3, 15.2), 23, 25, 26
        //ne e vozmozhno
//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 17, 18, 20, 22, 15.3, 15.2), 23, 25, 26
        //ne e vozmozhno
//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 17, 18, 19, 20, 22, 15.3, 15.2), 23, 25, 26
        //ne e vozmozhno
//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 17, 18, 19, 20, 21, 22, 15.3, 15.2), 23, 24, 26
        //ne e vozmozhno

void EveryBranchTestiranje() {
    //vo ova testiranje treba da se izmine sekoja granka
    //1,2-3-4
    RuntimeException ex;
    ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, createList("trajce", "goce", "sime")));
    assertTrue(ex.getMessage().contains("The user is not instantiated"));

//1,2-3-5-6-26
    // user.getUsername()==null || user.getPassword()==null
    ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User(null, null, "trajce.jankuloski@gmail.com"), createList("trajce", "goce", "sime")));
    assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));

    //1,2-3-5-7,8-9-10-26
    //passwordLower.contains(user.getUsername().toLowerCase())
    User user = new User("goce", "73goce?", "goce@yahoo.com");
    assertFalse(user.getUsername().contains(user.getPassword().toLowerCase()));

    //1,2-3,-5-7,8-9-11-12-26
    //passwordLower.length()<8

    User user1 = new User("goce", "73g", "goce@yahoo.com");
    assertTrue(user1.getPassword().length() < 8);

    //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 20, 22, 15.3, 15.2), 23, 24, 26
    user = new User("goce", "kjdhbewkdj", "goce@gmail.com");
    assertTrue(!user.getPassword().contains(num) && !user.getPassword().contains(specialCharacters) && !user.getPassword().contains(upper));
}


    }

