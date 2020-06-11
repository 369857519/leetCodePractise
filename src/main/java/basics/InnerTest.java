package basics;

public class InnerTest {
    private int id=0;
    public static int sId=10;
    public class Inner{
        private int id=1;
        public int getWrapperId(){
            return InnerTest.this.id;
        }
        public int getInnerId(){
            return id;
        }
        public int getWrapperStatic(){
            return sId;
        }
    }

    public static class StaticInner{
        public int getWrapperId(){
            return sId;
        }
        public static int getWrapperStaticId(){
            return sId;
        }
    }

    public int methodInnerClass(int num){
        class InnerClass{
            public int getWrapperId(int a){
                return a+num;
            }
        }
        return 10;
    }

    public static void main(String[] args) {
        //普通内部类
        InnerTest wrapper=new InnerTest();
        InnerTest.Inner inner= wrapper.new Inner();
        wrapper.id=2;
        System.out.println(inner.getWrapperId());
        System.out.println(inner.getInnerId());
        System.out.println(inner.getWrapperStatic());

        //静态内部类
        StaticInner staticInner=new InnerTest.StaticInner();
        staticInner.getWrapperId();
        InnerTest.StaticInner.getWrapperStaticId();

        //方法内部类
        wrapper.methodInnerClass(10);
    }
}
