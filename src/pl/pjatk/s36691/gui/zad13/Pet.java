package pl.pjatk.s36691.gui.zad13;

public interface Pet{
    void conditions();
    default String commonProblem(){
        return "";
    }
}
