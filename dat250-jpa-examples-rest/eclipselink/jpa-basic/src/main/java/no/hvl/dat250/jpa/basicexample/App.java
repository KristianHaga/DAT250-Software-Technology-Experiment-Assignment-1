package no.hvl.dat250.jpa.basicexample;

import com.google.gson.Gson;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {

    static Todo todo = null;
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("todos");
    static EntityManager em = factory.createEntityManager();

    public static void main(String[] args) {

        if (args.length > 0) {
            port(Integer.parseInt(args[0]));
        } else {
            port(8090);
        }

        todo = new Todo();

        after((req, res) -> {
            res.type("application/json");
        });

        // Get all the objects
        get("/todos", (req, res) -> {
            String output = "";
            List<Todo> todos = em.createQuery("Select t from Todo t").getResultList();
            for (Todo todo : todos) {
                output += todo.toJson()  + "\n";
            }
            return output;
        });

        // Get object from id
        get("/todos/:id", (req, res) -> {
            Long id = Long.parseLong(req.params(":id"));
            Todo todo = em.find(Todo.class, id);
            return todo.toJson();
        });

        // Update object
        put("/todos/:id", (req,res) -> {
            Gson gson = new Gson();
            Long id = Long.parseLong(req.params(":id"));

            Todo newTodo = gson.fromJson(req.body(), Todo.class);

            em.getTransaction().begin();
            Todo todo = em.find(Todo.class, id);
            todo.setDescription(newTodo.getDescription());
            todo.setSummary(newTodo.getSummary());
            em.merge(todo);
            em.getTransaction().commit();

            return todo.toJson();
        });

        post("/todos", (req,res) -> {
            Gson gson = new Gson();

            em.getTransaction().begin();
            Todo todo = gson.fromJson(req.body(), Todo.class);
            em.merge(todo);
            em.getTransaction().commit();

            return todo.toJson();
        });

        delete("/todos/:id", (req,res) -> {
            Long id = Long.parseLong(req.params(":id"));

            em.getTransaction().begin();
            Todo todo = em.find(Todo.class, id);
            em.remove(todo);
            em.getTransaction().commit();

            return todo.toJson();
        });
    }
}
