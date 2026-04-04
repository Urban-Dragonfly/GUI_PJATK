package pl.pjatk.s36691.gui.zad24;

public class Main {
    public static void main(String[] args) {
        pascal(23);
    }

    public static void pascal(int n){
        long[][] tab = createTab(n);
        populateTab(tab);
        printTab(tab);
    }

    public static long[][] createTab(int n){
        long[][] tab = new long[n][];
        int j = 1;
        for(int i = 0; i < n; i++){
            tab[i] = new long[j++];
        }
        return tab;
    }

    public static void printTab(long[][] tab){
        long midDigit = tab[tab.length-1][tab.length / 2];
        int digitSize = String.valueOf(midDigit).length();
        digitSize = Math.max(digitSize, 6);
        int rowLength = tab.length * digitSize + tab.length / 2;
        for(int i = 0; i < tab.length; i++){
            int k = (rowLength - tab[i].length * digitSize)/2;
            while(k > 0){
                System.out.print(" ");
                k--;
            }
            for(int j = 0; j < tab[i].length; j++){

                System.out.printf("%" + digitSize + "d ",tab[i][j]);
            }
            System.out.println();
        }
    }

    public static void populateTab(long[][] tab){
        for(int i = 0; i < tab.length; i++){
            for(int j = 0; j < tab[i].length; j++){
                if (j == 0 || j == tab[i].length - 1){
                    tab[i][j] = 1;
                    continue;
                }
                if (i < 2){
                    continue;
                }
                tab[i][j] = tab[i-1][j - 1] + tab[i-1][j];
            }
        }
    }
}
