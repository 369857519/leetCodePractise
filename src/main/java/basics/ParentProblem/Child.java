package basics.ParentProblem;

public class Child extends Parent {
    public static void main(String[] args) {
        new Child();
    }
    public Child(){
        super(1);
        System.out.println("c1");
    }
}
