
package DAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import config.MongoDBConnection;
import java.io.IOException;
import java.util.ArrayList;
import model.Person;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author User
 */
public class PersonDAO {
    private MongoDBConnection dbConnection;
    private ObjectMapper objectMapper;

    public PersonDAO() {
        dbConnection = new MongoDBConnection();
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.EAGER_SERIALIZER_FETCH.INDENT_OUTPUT);
    }
    
    public List<Person> getAllUsuarios() {
        MongoCollection<Document> collection = dbConnection.getCollection("demo1");
        List<Person> usuarios = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find().iterator();
        FindIterable<Document> documents = collection.find();
        try {
            for (Document doc : documents) {
            System.out.println("Documento recuperado: " + doc);
            Person usuario = new Person();
                usuario.setId(doc.getObjectId("_id").toString());
                usuario.setName(doc.getString("name"));
                usuario.setLastname(doc.getString("lastname"));
                usuario.setAge(doc.getInteger("age"));
                usuario.setPhone(doc.getInteger("phone"));
                usuario.setEmail(doc.getString("email"));
                usuarios.add(usuario);
            }
        } finally {
            cursor.close();
        }
        return usuarios;
    }

    public void createDocument(Person person) {
        MongoCollection<Document> collection = dbConnection.getCollection("demo1");
        String json = null;

        try {
            json = objectMapper.writeValueAsString(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Document doc = Document.parse(json);
        collection.insertOne(doc);
    }

    public Person readDocument(String id) {
        MongoCollection<Document> collection = dbConnection.getCollection("demo1");
        Document document = collection.find(new Document("_id", id)).first();

        if (document != null) {
            try {
                return objectMapper.readValue(document.toJson(), Person.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public void updateDocument(String id, Person person) {
        try {
            MongoCollection<Document> collection = dbConnection.getCollection("demo1");
            Document updatedDocument = Document.parse(objectMapper.writeValueAsString(person));

        collection.replaceOne(new Document("_id", id), updatedDocument);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void deleteDocument(String id) {
        MongoCollection<Document> collection = dbConnection.getCollection("demo1");
        collection.deleteOne(new Document("_id", id));
    }

}
