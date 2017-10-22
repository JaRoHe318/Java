public class Baby extends Daddy {

    Baby(){

    }

    Baby(int numb){
        super(numb);
        System.out.println("In Baby(stuff)");
    }

    @Override
    public int getNum(){
        System.out.println("In Baby getNum)");
        return super.getNum();
    }
}
