package pl.pjatk.s36691.gui.zad21;
import pl.pjatk.s36691.gui.zad19.Tree;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        SupremeArray<Tree> supremeTrees = new SupremeArray<>();

        Tree[] trees = {
                new Tree("Dąb", 15, 65),
                new Tree("Choinka", 2, 1),
                new Tree("Sosna", 27, 14),
                new Tree("Brzoza", 10, 3),
                new Tree("Modrzew", 17,12)
        };
        System.out.println("= - -A-D-D-I-N-G- - =");
        for(int i = 0; i < trees.length; i++){
            supremeTrees.add(trees[i]);
        }
        supremeTrees.print();
        System.out.println("= -R-E-M-O-V-I-N-G- =");
        supremeTrees.remove();
        supremeTrees.print();
        System.out.println("= -A-D-D-I-N-G- -A-T- =");
        supremeTrees.addAt(2, new Tree("Yggdrasil", 23523, 420042));
        supremeTrees.print();
        System.out.println("= -R-E-M-O-V-I-N-G- -A-T- =");
        supremeTrees.removeAt(3);
        supremeTrees.print();
        System.out.println("= -S-O-R-T- -N-O- -C-O-M-P- =");
        supremeTrees.sort();
        supremeTrees.print();
        System.out.println("= -S-O-R-T- -W-I-T-H- -C-O-M-P- =");
        supremeTrees.sort(Comparator.comparingInt(Tree::getHeight).reversed());
        supremeTrees.print();
    }
}
