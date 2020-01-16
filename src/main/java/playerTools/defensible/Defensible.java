package playerTools.defensible;

public class Defensible {
    private int protection;

    public Defensible(int protection){
        this.protection = protection;
    }

    public int getProtection(){
        return this.protection;
    }

    public void looseProtection(int value){
        this.protection -= value;
    }
}
