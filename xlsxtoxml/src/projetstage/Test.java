package projetstage;

public class Test {

   private Test() {

   }

   static boolean isDifferentToSpace(String[][] resRegroupe, int i, int col) {
      return !resRegroupe[i][col].equals(Config.SPACE);
   }
   
   static boolean isEqualToYes(String[][] resRegroupe, int i, int col) {
      return resRegroupe[i][col].equals(Config.OUI);
   }

   static boolean isDifferentToNo(String[][] res, int i, int j) {
      return !res[i][j].equals(Config.NON);
   }

   static boolean isDifferentToEmpty(String[] fiche, int i) {
      return !fiche[i].equals(Config.EMPTY);
   }
    
    static boolean isConditionVerified(String[] fiche) {
      return isDifferentToEmpty(fiche, Config.III)
            && isDifferentToEmpty(fiche, Config.IV)
            && isDifferentToEmpty(fiche, Config.VI)
            && isDifferentToEmpty(fiche, Config.VII);
   }
}   
