package projetstage;

public class Algo1 {

   private Algo1() {
   }

   static String[][] initialiser(int numCols) {
      String[][] resRegroupe = new String[Item.XII + Item.COMPETENCES.length][numCols];
      for (int i = Item.ZERO; i < Item.XII + Item.COMPETENCES.length; i++) {
         for (int j = Item.ZERO; j < numCols; j++) {
            resRegroupe[i][j] = Item.SPACE;
         }
      }
      return resRegroupe;
   }

   static String[][] traiter(int numRows, String[][] res,
         String[][] resRegroupe) {
      String[][] toReturnFinal = new String[resRegroupe[0].length][resRegroupe.length];
      for (int i = Item.I; i < numRows; i++) {
         for (int j = Item.ZERO; j < Item.LABO.length; j++) {
            if (res[i][Item.CXXVI].equals(Item.LABO[j])
                  && Test.isEqualToYes(res, i, Item.CCLXXXII)) {
               toReturnFinal = sousTraiter(i, j, res, resRegroupe);
            }
         }
      }
      return toReturnFinal;
   }

   static String[][] sousTraiter(int i, int j, String[][] res,
         String[][] resRegroupe) {
      String[][] toReturn = new String[resRegroupe.length][resRegroupe[0].length];
      if (j < Item.III) {
         for (int cpt = Item.ZERO; cpt < Item.EQUIPE[j].length; cpt++) {
            if (res[i][Item.CXXVIII].equals(Item.EQUIPE[j][cpt])) {
               toReturn = regrouper(i, cpt, Item.CXXVIII, res, resRegroupe);
            } else if (res[i][Item.CXXIX].equals(Item.EQUIPE[j][cpt])) {
               toReturn = regrouper(i, cpt + Item.V, Item.CXXIX, res,
                     resRegroupe);
            } else if (res[i][Item.CXXX].equals(Item.EQUIPE[j][cpt])) {
               toReturn = regrouper(i, cpt + Item.VIII, Item.CXXX, res,
                     resRegroupe);
            }
         }
      } else {
         for (int cpt2 = Item.CXXXI; cpt2 < Item.CCXLVIII; cpt2++) {
            if (Test.isEqualToYes(res, i, cpt2)) {
               toReturn = regrouper(i, cpt2 - Item.CXXXI + Item.XII, res,
                     resRegroupe);
            }
         }
      }
      return toReturn;
   }
   
   static String[][] regrouper(int i, int k, int col, String[][] res,
         String[][] resRegroupe) {
      resRegroupe[k][Item.CXXVI] = res[i][Item.CXXVI];
      resRegroupe[k][col] = res[i][col];
      for (int j = Item.CCLXXXIII; j < Item.MCDXI; j++) {
         if (res[i][j].equals(Item.OUI)) {
            resRegroupe[k][j] = Item.OUI;
         } else if (Test.isDifferentToSpace(res, i, j) && Test.isDifferentToNo(res, i, j)) {
            resRegroupe[k][j] += " -" + res[i][j];
         }
      }
      return resRegroupe;
   }

   static String[][] regrouper(int i, int k, String[][] res,
         String[][] resRegroupe) {

      resRegroupe[k][Item.CXXVI] = res[i][Item.CXXVI];
      for (int j = Item.CXXXI; j < Item.MCDXI; j++) {

         if (Test.isEqualToYes(res, i, j)) {
            resRegroupe[k][j] = Item.OUI;
         } else if (Test.isDifferentToSpace(res, i, j) && Test.isDifferentToNo(res, i, j)) {
            resRegroupe[k][j] = res[i][j];
         }
      }
      return resRegroupe;
   }
}