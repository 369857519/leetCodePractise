package basics;

public class InnerClassTest {
    private int id=0;
    public static int sId=10;
    public class Inner{
        private int id=1;
        public int getWrapperId(){
            return InnerClassTest.this.id;
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

    public int methodInnerClass(final int num){
        class InnerClass{
            public int getWrapperId(int a){
                return a+num;
            }
        }
        return 10;
    }

    public static void main(String[] args) {
        //普通内部类
        InnerClassTest wrapper=new InnerClassTest();
        InnerClassTest.Inner inner= wrapper.new Inner();
        wrapper.id=2;
        System.out.println(inner.getWrapperId());
        System.out.println(inner.getInnerId());
        System.out.println(inner.getWrapperStatic());

        //静态内部类
        StaticInner staticInner=new InnerClassTest.StaticInner();
        staticInner.getWrapperId();
        InnerClassTest.StaticInner.getWrapperStaticId();

        //方法内部类
        wrapper.methodInnerClass(10);
    }
}
