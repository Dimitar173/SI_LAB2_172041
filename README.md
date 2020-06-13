## Софтверско инженерство Лабораториска бежба 2
## Димитар Танчески [172041]
## Група на код:
Ја добив групата 2

## Control Flow Diagram

## Цикломатска комплексност
Цикломатската комплексност на овој код е 10. Ја пресметав преку формулата E-N+2, каде што бројот на ребра(E=33), а број на јазли(N=25).

## Тест случаите според Every Path критериумот:
```Java
//1,2, 3, 4, 26

ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, createList("trajce", "goce", "sime")));

//1,2, 3, 5, 6, 26

ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("trajce", null, "trajce.jankuloski@gmail.com"), createList("trajce", "goce", "sime")));

//1,2, 3, 5, 7,8, 9, 10, 26 User user = new User("goce", "73goce?", "goce@yahoo.com");

//1,2,3,5,7,8, 9, 11, 12, 26 User user1 = new User("goce", "73g", "goce@yahoo.com");

//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 17, 18, 19, 20, 22, 15.3, 15.2), 23, 24, 26 user = new User("goce", "73goce37", "goce@gmail.com");

//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 17, 18, 20, 22, 15.3, 15.2), 23, 24, 26 user = new User("goce", "123456789", "goce@gmail.com");

//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 19, 20, 21, 22, 15.3, 15.2), 23, 24, 26 user = new User("goce", "TR!mdr?", "goce@gmail.com");

//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 19, 20, 22, 15.3, 15.2), 23, 24, 26 user = new User("goce", "BBBBAAAAA", "goce@gmail.com");

//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 20, 21, 22, 15.3, 15.2), 23, 24, 26 user = new User("goce", "##!$lalalala", "goce@gmail.com");

//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 20, 22, 15.3, 15.2), 23, 24, 26 user = new User("goce", "kjdhbewkdj", "goce@gmail.com");

//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 20, 22, 15.3, 15.2), 23, 25, 26 // za ova nema //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, 23, 24, 26 //za ova nema //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, 23, 25, 26 //za ova nema //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 20, 21, 22, 15.3, 15.2), 23, 25, 26 //za ova nema //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 19, 20, 22, 15.3, 15.2), 23, 25, 26 //za ova nema //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 19, 20, 21, 22, 15.3, 15.2), 23, 25, 26 //za ova nema //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 17, 18, 20, 21, 22, 15.3, 15.2), 23, 25, 26 //za ova nema //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 17, 18, 20, 22, 15.3, 15.2), 23, 25, 26 //za ova nema //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 17, 18, 19, 20, 22, 15.3, 15.2), 23, 25, 26 //za ova nema //1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 17, 18, 19, 20, 21, 22, 15.3, 15.2), 23, 24, 26 //za ova nema
```

## Тест случаи за Every Branch критериумот :
```java
//vo ova testiranje treba da se izmine sekoja granka //1,2-3-4

RuntimeException ex; ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, createList("trajce", "goce", "sime"))); assertTrue(ex.getMessage().contains("The user is not instantiated"));

//1,2-3-5-6-26// user.getUsername()==null || user.getPassword()==null ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User(null, null, "trajce.jankuloski@gmail.com"), 6 createList("trajce", "goce", "sime")));
assertTrue(ex.getMessage().contains("The user is missing some mandatory information")); //1,2-3-5-7,8-9-10-26 //passwordLower.contains(user.getUsername().toLowerCase()) User user = new User("goce", "73goce?", "goce@yahoo.com"); assertFalse(user.getUsername().contains(user.getPassword().toLowerCase()));

//1,2-3,-5-7,8-9-11-12-26 //passwordLower.length()<8

User user1 = new User("goce", "73g", "goce@yahoo.com"); assertTrue(user1.getPassword().length() < 8);

//1,2, 3, 5, 7,8, 9, 11, 13,14, 15.1, 15.2, (16, 18, 20, 22, 15.3, 15.2), 23, 24, 26 user = new User("goce", "kjdhbewkdj", "goce@gmail.com"); assertTrue(!user.getPassword().contains(num) && !user.getPassword().contains(specialCharacters) && !user.getPassword().contains(upper)); }

}
