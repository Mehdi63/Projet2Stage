package projetstage;

public class Algo2 {

   private Algo2() {
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

   static void toRefactor(int i, int cpt, String[] fiche,
       String[][] resRegroupe) {
     if (isEqualToYes(resRegroupe, i, cpt)) {
       fiche[Item.XII] += " -" + Item.EQUIPEMENTS[cpt - Item.MCCCLIII];
       if (isDifferentToSpace(resRegroupe, i, cpt + Item.I)) {
         fiche[Item.XII] += "(" + resRegroupe[i][cpt + Item.I] + ") ";
       }
     }
   }

   static void toRefactor(int i, String[] fiche, String[][] resRegroupe) {
     for (int cpt = Item.CXXXI; cpt < Item.CCXLVIII; cpt++) {
       if (isEqualToYes(resRegroupe, i, cpt)) {
         fiche[Item.IV] = Item.COMPETENCES[cpt - Item.CXXXI];
       }
     }
   }

   static void fillAnArrays1(String[] fiche, int i, String[][] resRegroupe) {
     if (fiche[Item.III].equals(Item.ICCF)) {
       fiche[Item.IV] = resRegroupe[i][Item.CXXVIII];
     } else if (fiche[Item.III].equals(Item.LAMP)) {
       fiche[Item.IV] = resRegroupe[i][Item.CXXIX];
     } else if (fiche[Item.III].equals(Item.LM)) {
       fiche[Item.IV] = resRegroupe[i][Item.CXXX];
     } else {
       toRefactor(i, fiche, resRegroupe);
     }
   }

   static void fillAnArrays2(String[] fiche, int i, String[][] resRegroupe) {
     fiche[Item.VI] = "";
     int techneo = Item.ZERO;
     for (int cpt = Item.CCLXXXIII; cpt < Item.CCCXXXVIII; cpt++) {
       if (isEqualToYes(resRegroupe, i, cpt)) {
         fiche[Item.VI] += " -" + Item.DOMAINES[cpt - Item.CCLXXXIII];
         techneo = Item.I;
       }
     }
     if (isDifferentToSpace(resRegroupe, i, Item.CCCX)) {
       fiche[Item.VI] += " -" + resRegroupe[i][Item.CCCX];
       techneo = Item.I;
     }
     if (isDifferentToSpace(resRegroupe, i, Item.CCCXXXVIII)) {
       fiche[Item.VI] += " -" + resRegroupe[i][Item.CCCXXXVIII];
       techneo = Item.I;
     }
     for (int cpt = Item.DCIII; cpt < Item.DCXXIX; cpt++) {
       if (resRegroupe[i][cpt].equals(Item.OUI)) {
         fiche[Item.VI] += " -" + Item.DISCIPLINES[cpt - Item.DCIII];
       }
     }
     if (isDifferentToSpace(resRegroupe, i, Item.DCXXIX)) {
       fiche[Item.VI] += " -" + resRegroupe[i][Item.DCXXIX];
     }
     if (techneo != Item.ZERO) {
       fiche[Item.XXVII] = Item.TECHNOLOGIQUE;
     } else {
       fiche[Item.XXVII] = Item.SHS;
     }
   }

   static void fillAnArrays3(String[] fiche, int i, String[][] resRegroupe) {
     fiche[Item.VII] = "";
     for (int cpt = Item.CCCXXXIX; cpt < Item.DCII; cpt++) {
       if (isEqualToYes(resRegroupe, i, cpt)) {
         fiche[Item.VII] += " -"
              + Item.SOUS_DOMAINES[cpt - Item.CCCXXXIX];
       }
     }
     for (int cpt = Item.DCXXX; cpt < Item.CMXVIII; cpt++) {
       if (isEqualToYes(resRegroupe, i, cpt)) {
         fiche[Item.VII] += " -"
              + Item.SOUS_DISCIPLINES[cpt - Item.DCXXX];
       }
     }

     for (Integer col : Item.TO_CLEAN) {
       if (isDifferentToSpace(resRegroupe, i, col)) {
         fiche[Item.VII] += " -" + resRegroupe[i][col];
       }
     }
   }

   static void fillAnArrays4(String[] fiche, int i, String[][] resRegroupe) {
     fiche[Item.IX] = "";
     for (int cpt = Item.CMXVIII; cpt < Item.CMLV; cpt++) {
       if (isEqualToYes(resRegroupe, i, cpt)) {
         fiche[Item.IX] += " -" + Item.SECTEURS[cpt - Item.CMXVIII];
       }
     }
     if (isDifferentToSpace(resRegroupe, i, Item.CMLIV)) {
       fiche[Item.IX] += " -" + resRegroupe[i][Item.CMLIV];
     }

     fiche[Item.X] = "";
     for (int cpt = Item.CMLV; cpt < Item.MCCCVI; cpt++) {
       if (isEqualToYes(resRegroupe, i, cpt)) {
         fiche[Item.X] += " -" + Item.SOUS_SECTEURS[cpt - Item.CMLV];
       }
     }
     for (Integer col : Item.TO_CLEAN1) {
       if (isDifferentToSpace(resRegroupe, i, col)) {
         fiche[Item.X] += " -" + resRegroupe[i][col];
       }
     }
   }

   static void fillAnArrays5(String[] fiche, int i, String[][] resRegroupe) {
     fiche[Item.XI] = "";
     if (isDifferentToSpace(resRegroupe, i, Item.MCCCVII)) {
       fiche[Item.XI] += " -" + resRegroupe[i][Item.MCCCVII];
     }
     if (isDifferentToSpace(resRegroupe, i, Item.MCCCVIII)) {
       fiche[Item.XI] += " -" + resRegroupe[i][Item.MCCCVIII];
     }

     fiche[Item.XII] = "";
     for (int cpt = Item.MCCCLIII; cpt < Item.MCDIIX; cpt += Item.II) {
       toRefactor(i, cpt, fiche, resRegroupe);
     }
     if (resRegroupe[i][Item.MCDIX].equals(Item.OUI)) {
       fiche[Item.XII] += " -" + resRegroupe[i][Item.MCDX];
     }
     fiche[Item.XIII] = " Recherche et Développement";

     fiche[Item.XXII] = "";
     if (isDifferentToSpace(resRegroupe, i, Item.MCDXI)) {
       fiche[Item.XXII] += resRegroupe[i][Item.MCDXI];
     }
     fiche[Item.XIV] = Item.CONTACTEXPERT[i];
     fiche[Item.XVI] = Item.URL[i];

   }

   static void toGenerate(String[] fiche, int i, Fiche[] fichetechneo,
       String xmlfile) {
     if (isConditionVerified(fiche)) {
        WriteXMLFile.generer(i, fichetechneo, xmlfile);
     }
   }

   static boolean isConditionVerified(String[] fiche) {
     return isSubConditionVerified(fiche, Item.VI)
         && isSubConditionVerified(fiche, Item.VII)
         && isSubConditionVerified(fiche, Item.IX)
         && isSubConditionVerified(fiche, Item.X);
   }

   static boolean isSubConditionVerified(String[] fiche, int i) {
     return !fiche[i].equals(Item.EMPTY);
   }

   static void remplir(String[][] resRegroupe, String xmlfile) {
     Fiche[] fichetechneo = new Fiche[Item.XII + Item.COMPETENCES.length];
     for (int i = Item.ZERO; i < Item.XII + Item.COMPETENCES.length; i++) {
       String[] fiche = new String[Item.XXVIII];
       fichetechneo[i] = new Fiche(fiche);
       fiche[Item.III] = resRegroupe[i][Item.CXXVI];
       fillAnArrays1(fiche, i, resRegroupe);
       fillAnArrays2(fiche, i, resRegroupe);
       fillAnArrays3(fiche, i, resRegroupe);
       fillAnArrays4(fiche, i, resRegroupe);
       fillAnArrays5(fiche, i, resRegroupe);
       toGenerate(fiche, i, fichetechneo, xmlfile);
     }
   }
}
