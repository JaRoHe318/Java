
public class Daddy implements Implentable {

    private int num;


    public Daddy(){
        System.out.println("In Daddy()");
        num=0;
    }

    public Daddy(int numb){
        System.out.println("In Daddy(stuff)");
        num=numb;
    }


    public int getNum(){
        System.out.println("In Daddy getNum)");
        return num;
    }

    public void printNum(){
        System.out.println("In Daddy printNum");
        System.out.println("Number is "+num);
    }

    public void test(){
        System.out.println("In Daddy Test!");
    }

    public void test2(){
        System.out.println("In daddy test 2");
    }

}
