public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        UserService us=new UserService(new MySQLDatabase());

        us.printUser();
        us.saveToDb();
    }
}

class UserService
{
    Database db; // Dependency Injection

    UserService(Database db){
        this.db=db;
    }

    void printUser(){
        System.out.println("USER");
    }

    void saveToDb(){
        db.save();
        System.out.println("User Stored To Database Successfully");
    }
}

abstract class Database { // Inversion Calss
    abstract void save();
}

class MySQLDatabase extends Database{
    @Override
    void save() {
        System.out.println("Saving Data to MySQL Database...");
    }
}

class MongoDBDatabase extends Database {
    @Override
    void save() {
        System.out.println("Saving Data to MongoDB Database...");
    }
}