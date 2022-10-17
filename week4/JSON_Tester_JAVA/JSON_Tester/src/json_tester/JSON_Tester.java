/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json_tester;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author mountant
 */
public class JSON_Tester {

    public static void main(String[] args) {
        System.out.println("1. JSON TO JAVA CLASS OBJECT");
        Person person1 = JSONtoObject();
        System.out.println(person1);

        Person person2 = new Person();
        person2.name = "Tsitsipas";
        person2.work = "Tennis";
        person2.age = 23;
        person2.city = "Vouliagmeni";

        System.out.println("\n2. JAVA CLASS OBJECT TO JSON");
        String json = JavaObjectToJSON(person2);
        System.out.println(json);

        System.out.println("\n3. JAVA CLASS OBJECT TO JSON Add element motto");
        String json2 = JavaObjectToJSONAddElements(person2);
        System.out.println(json2);

        System.out.println("\n4. JAVA CLASS OBJECT TO JSON Remove element age");
        String json3 = JavaObjectToJSONRemoveElements(person2);
        System.out.println(json3);

        System.out.println("\n5. Totally new JSON");
        String json4 = totallyNewJSON(person2);
        System.out.println(json4);

        System.out.println("\n6. Many Class Objects to json");
        Person[] persons = new Person[2];
        persons[0] = person1;
        persons[1] = person2;
        String json5 = manyPersonsToJSON(persons);
        System.out.println(json5);

        System.out.println("\n7. JSON array to many Persons");
        String jsonArray = "[{\"name\":\"Antetokounmpo\",\"work\":\"Basketball\",\"age\":27,\"city\":\"Sepolia\"},{\"name\":\"Tsitsipas\",\"work\":\"Tennis\",\"age\":23,\"city\":\"Vouliagmeni\"}]";
        Person[] personsArray = jsonArrayToPersons(jsonArray);
        System.out.println(personsArray[0]+"\n");
        System.out.println(personsArray[1]);

    }

  

    private static Person JSONtoObject() {

        // Storing preprocessed json(Added slashes)
        String personJSON = "{\"name\": \"Antetokounmpo\","
                + "\"work\": \"Basketball\","
                //+ "\"city\": \"Sepolia\","
                + "\"age\": \"27\"}";

        // Creating a Gson Object
        Gson gson = new Gson();

        // Converting json to object
        // first parameter should be prpreocessed json
        // and second should be mapping class
        Person pers = gson.fromJson(personJSON, Person.class);
        return pers;
    }

    private static String JavaObjectToJSON(Person p) {;

        // Creating a Gson Object
        Gson gson = new Gson();

        // Converting json to object
        // first parameter should be prpreocessed json
        // and second should be mapping class
        String json = gson.toJson(p, Person.class);
        return json;
    }

    private static String JavaObjectToJSONAddElements(Person p) {
        Gson gson = new Gson();
        String json = gson.toJson(p, Person.class);
        JsonObject object = (JsonObject) gson.toJsonTree(p);
        object.addProperty("motto", "De paizeis me poiotita");
        return object.toString();
    }

    private static String JavaObjectToJSONRemoveElements(Person p) {
        // Creating a Gson Object
        Gson gson = new Gson();
        String json = gson.toJson(p, Person.class);
        JsonObject object = (JsonObject) gson.toJsonTree(p);
        object.remove("age");
        return object.toString();
    }

    private static String totallyNewJSON(Person p1) {
        // Creating a Gson Object
        JsonObject object = new JsonObject();
        object.addProperty("city", p1.city);
        return object.toString();
    }

    private static String manyPersonsToJSON(Person[] persons) {
        // Creating a Gson Object
        Gson gson = new Gson();
        JsonArray json = gson.toJsonTree(persons).getAsJsonArray();//(persons, Person.class);
        return json.toString();

    }
    
      private static Person[] jsonArrayToPersons(String jsonArray) {
        Gson gson = new Gson();
        Person[] personArray = gson.fromJson(jsonArray, Person[].class);
        return personArray;
    }
}
