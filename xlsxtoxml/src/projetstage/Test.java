package projetstage;

public class Test {

   private Test() {

   }

   static boolean isDifferentToSpace(String[][] resRegroupe, int i, int col) {
      return !resRegroupe[i][col].equals(Item.SPACE);
   }
   
   static boolean isEqualToYes(String[][] resRegroupe, int i, int col) {
      return resRegroupe[i][col].equals(Item.OUI);
   }

   static boolean isDifferentToNo(String[][] res, int i, int j) {
      return !res[i][j].equals(Item.NON);
   }

   static boolean isDifferentToEmpty(String[] fiche, int i) {
      return !fiche[i].equals(Item.EMPTY);
   }
    
    static boolean isConditionVerified(String[] fiche) {
      return isDifferentToEmpty(fiche, Item.VI)
            && isDifferentToEmpty(fiche, Item.VII)
            && isDifferentToEmpty(fiche, Item.IX)
            && isDifferentToEmpty(fiche, Item.X);
   }

}   
