package projetstage;

public class Algo1 {

   private Algo1() {
   }
   
   static void initialiser (String[] fiche){
     for(int i=0; i<fiche.length; i++){
       fiche[i]=Config.EMPTY;
     }
   }
   
   static String[][] initialiser(int numCols) {
      String[][] resRegroupe = new String[Config.XII + Config.COMPETENCES.length][numCols];
      for (int i = Config.O; i < Config.XII + Config.COMPETENCES.length; i++) {
         for (int j = Config.O; j < numCols; j++) {
            resRegroupe[i][j] = Config.SPACE;
         }
      }
      return resRegroupe;
   }

   static String[][] traiter(int numRows, String[][] res,
         String[][] resRegroupe) {
      String[][] toReturnFinal = new String[resRegroupe[0].length][resRegroupe.length];
      for (int i = Config.I; i < numRows; i++) {
         for (int j = Config.O; j < Config.LABO.length; j++) {
            if (res[i][Config.CXXVI].equals(Config.LABO[j])
                  && Test.isEqualToYes(res, i, Config.CCLXXXII)) {
               toReturnFinal = sousTraiter(i, j, res, resRegroupe);
            }
         }
      }
      return toReturnFinal;
   }

   static String[][] sousTraiter(int i, int j, String[][] res,
         String[][] resRegroupe) {
      String[][] toReturn = new String[resRegroupe.length][resRegroupe[0].length];
      if (j < Config.III) {
         for (int cpt = Config.O; cpt < Config.EQUIPE[j].length; cpt++) {
            if (res[i][Config.CXXVIII].equals(Config.EQUIPE[j][cpt])) {
               toReturn = regrouper(i, cpt, Config.CXXVIII, res, resRegroupe);
            } else if (res[i][Config.CXXIX].equals(Config.EQUIPE[j][cpt])) {
               toReturn = regrouper(i, cpt + Config.V, Config.CXXIX, res,
                     resRegroupe);
            } else if (res[i][Config.CXXX].equals(Config.EQUIPE[j][cpt])) {
               toReturn = regrouper(i, cpt + Config.VIII, Config.CXXX, res,
                     resRegroupe);
            }
         }
      } else {
         for (int cpt2 = Config.CXXXI; cpt2 < Config.CCXLVIII; cpt2++) {
            if (Test.isEqualToYes(res, i, cpt2)) {
               toReturn = regrouper(i, cpt2 - Config.CXXXI + Config.XII, res,
                     resRegroupe);
            }
         }
      }
      return toReturn;
   }
   
   static String[][] regrouper(int i, int k, int col, String[][] res,
         String[][] resRegroupe) {
      resRegroupe[k][Config.CXXVI] = res[i][Config.CXXVI];
      resRegroupe[k][col] = res[i][col];
      for (int j = Config.CCLXXXIII; j < Config.MCDXI; j++) {
         if (res[i][j].equals(Config.OUI)) {
            resRegroupe[k][j] = Config.OUI;
         } else if (Test.isDifferentToSpace(res, i, j) && Test.isDifferentToNo(res, i, j)) {
            resRegroupe[k][j] += " -" + res[i][j];
         }
      }
      return resRegroupe;
   }
   
   static String[][] regrouper(int i, int k, String[][] res,
         String[][] resRegroupe) {

      resRegroupe[k][Config.CXXVI] = res[i][Config.CXXVI];
      for (int j = Config.CXXXI; j < Config.MCDXI; j++) {

         if (Test.isEqualToYes(res, i, j)) {
            resRegroupe[k][j] = Config.OUI;
         } else if (Test.isDifferentToSpace(res, i, j) && Test.isDifferentToNo(res, i, j)) {
            resRegroupe[k][j] = res[i][j];
         }
      }
      return resRegroupe;
   }
}