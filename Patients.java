import java.util.Stack;

class Patient{
     private  String name;
     private int age;
     private String illness;
    private int tempreture;
    private int puls;
    Stack<String> medicalhestory= new Stack<>();
    private int id;
    public Patient(){}
    public Patient(String name ,int age ,String s, int id)
    {
        this.setName(name);
        this.setAge(age);
        this.id=id;
        this.illness=s;
    }
     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getAge() {
         return age;
     }

     public void setAge(int age) {
         this.age = age;
     }

     public int getTempreture() {
         return tempreture;
     }

     public void setTempreture(int tempreture) {
         this.tempreture = tempreture;
     }

     public int getPuls() {
         return puls;
     }

     public void setPuls(int puls) {
         this.puls = puls;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public void PrintInfo(){

        System.out.println("Name is: " + getName());
        System.out.println("age is: "+ getAge());
        System.out.println("id is: " + id);
    }
}
