package projetstage;

public class Algo {
   
   public static final String OUI = "Oui";
   public static final String NON = "Non";
   public static final String ESPACE = " ";
   public static final String ICCF = "Institut de Chimie de Clermont-Ferrand ICCF, UMR 6296";
   public static final String LAMP = "Laboratoire de Météorologie Physique LaMP, UMR 6016";
   public static final String LM = "Laboratoire de Mathématiques LM, UMR 6620";
   public static final String TECHNOLOGIQUE = "Technologique";
   public static final String SHS = "SHS";

   private Algo() {
   }

   static String[][] initialiser(int numCols) {
      String[][] resregroupe = new String[Item.XII + Item.COMPETANCE.length][numCols];
      for (int i = Item.ZERO; i < Item.XII + Item.COMPETANCE.length; i++) {
         for (int j = Item.ZERO; j < numCols; j++) {
            resregroupe[i][j] = ESPACE;
         }
      }
      return resregroupe;
   }

   static String[][] regrouper(int i, int k, int col, String[][] res,
         String[][] resregroupe) {
      resregroupe[k][Item.CXXVI] = res[i][Item.CXXVI];
      resregroupe[k][col] = res[i][col];
      for (int j = Item.CCLXXXIII; j < Item.MCDXI; j++) {
         if (res[i][j].equals(OUI)) {
            resregroupe[k][j] = OUI;
         } else if (!res[i][j].equals(ESPACE) && !res[i][j].equals(NON)) {
            resregroupe[k][j] += " -" + res[i][j];
         }
      }
      return resregroupe;
   }

   static String[][] regrouper(int i, int k, String[][] res,
         String[][] resregroupe) {

      resregroupe[k][Item.CXXVI] = res[i][Item.CXXVI];
      for (int j = Item.CXXXI; j < Item.MCDXI; j++) {

         if (res[i][j].equals(OUI)) {
            resregroupe[k][j] = OUI;
         } else if (!res[i][j].equals(ESPACE) && !res[i][j].equals(NON)) {
            resregroupe[k][j] = res[i][j];
         }
      }
      return resregroupe;
   }
   static String[][] soustraiter1(int i, int j,String[][] res, String[][] resregroupe){
      int nr=resregroupe.length;
      int nc=resregroupe[0].length;
      String[][] toreturn= new String[nr][nc];
      if (j < Item.III) {
         for (int cpt = Item.ZERO; cpt < Item.EQUIPE[j].length; cpt++) {
            if (res[i][Item.CXXVIII].equals(Item.EQUIPE[j][cpt])) {
               toreturn= regrouper(i, cpt,
                     Item.CXXVIII, res, resregroupe);
            } else if (res[i][Item.CXXIX]
                  .equals(Item.EQUIPE[j][cpt])) {
               toreturn = regrouper(i, cpt + Item.V,
                     Item.CXXIX, res, resregroupe);
            } else if (res[i][Item.CXXX]
                  .equals(Item.EQUIPE[j][cpt])) {
               toreturn = regrouper(i, cpt + Item.VIII,
                     Item.CXXX, res, resregroupe);
            }   
         }   
      } else {
         for (int cpt2 = Item.CXXXI; cpt2 < Item.CCXLVIII; cpt2++) {
            if (res[i][cpt2].equals(OUI)) {
               toreturn = regrouper(i, cpt2
                     - Item.CXXXI + Item.XII, res, resregroupe);
            }
         }
      }
      return toreturn;
   }
   static String[][] traiter(int numRows, String[][] res,
         String[][] resregroupe) {
      int nr=resregroupe.length;
      int nc=resregroupe[0].length;
      String[][] toreturnfinal= new String[nr][nc];
      for (int i = Item.II; i < numRows; i++) {
            for (int j = Item.ZERO; j < Item.LABO.length; j++) {
               if (res[i][Item.CXXVI].equals(Item.LABO[j]) && res[i][Item.CCLXXXII].equals(OUI)) {
                  toreturnfinal=soustraiter1(i,j,res,resregroupe);
                  }
            }
      }
      return toreturnfinal;
   }   
   static void torefactor(int i, int cpt, String[] fiche, String[][] resregroupe){
      if (resregroupe[i][cpt].equals(OUI)) {
           fiche[Item.XII] += " -" + Item.EQUIPEMENTS[cpt - Item.MCCCLIII];
           if (!resregroupe[i][cpt + Item.I].equals(ESPACE)) {
              fiche[Item.XII] += "(" + resregroupe[i][cpt + Item.I] + ") ";
           }
        }
   }
   static void torefactor(int i, String[] fiche, String[][] resregroupe){
      for (int cpt = Item.CXXXI; cpt < Item.CCXLVIII; cpt++) {
         if (resregroupe[i][cpt].equals(OUI)) {
            fiche[Item.IV] = Item.COMPETANCE[cpt - Item.CXXXI];
         }
      }
   }
   static void remplir1(String[] fiche, int i, String[][] resregroupe){
      if (fiche[Item.III].equals(ICCF)) {
           fiche[Item.IV] = resregroupe[i][Item.CXXVIII];
        } else if (fiche[Item.III].equals(LAMP)) {
           fiche[Item.IV] = resregroupe[i][Item.CXXIX];
        } else if (fiche[Item.III].equals(LM)) {
           fiche[Item.IV] = resregroupe[i][Item.CXXX];
        } else {
           torefactor(i, fiche, resregroupe);
        }
   }
   static void remplir2(String[] fiche, int i, String[][] resregroupe){
      fiche[Item.VI] = "";
      int techneo = Item.ZERO;
       for (int cpt = Item.CCLXXXIII; cpt < Item.CCCXXXVIII; cpt++) {
          if (resregroupe[i][cpt].equals(OUI)) {
             fiche[Item.VI] += " -" + Item.DOMAINES[cpt - Item.CCLXXXIII];
             techneo = Item.I;
          }
       }
       if (!resregroupe[i][Item.CCCX].equals(ESPACE)) {
          fiche[Item.VI] += " -" + resregroupe[i][Item.CCCX];
          techneo = Item.I;
       }
       if (!resregroupe[i][Item.CCCXXXVIII].equals(ESPACE)) {
          fiche[Item.VI] += " -" + resregroupe[i][Item.CCCXXXVIII];
          techneo = Item.I;
       }
       for (int cpt = Item.DCIII; cpt < Item.DCXXIX; cpt++) {
          if (resregroupe[i][cpt].equals(OUI)) {
             fiche[Item.VI] += " -" + Item.DISCIPLINES[cpt - Item.DCIII];
          }
       }
       if (!resregroupe[i][Item.DCXXIX].equals(ESPACE)) {
          fiche[Item.VI] += " -" + resregroupe[i][Item.DCXXIX];
       }
       if (techneo != Item.ZERO) {
          fiche[Item.XXVII] = TECHNOLOGIQUE;
       } else {
          fiche[Item.XXVII] = SHS;
       }
   }
   static void remplir3(String[] fiche, int i, String[][] resregroupe){
      fiche[Item.VII] = "";
       for (int cpt = Item.CCCXXXIX; cpt < Item.DCII; cpt++) {
          if (resregroupe[i][cpt].equals(OUI)) {
             fiche[Item.VII] += " -" + Item.SOUS_DOMAINES1[cpt - Item.CCCXXXIX];
          }
       }
       for (int cpt = Item.DCXXX; cpt < Item.CMXVIII; cpt++) {
          if (resregroupe[i][cpt].equals(OUI)) {
             fiche[Item.VII] += " -" + Item.SOUS_DOMAINES2[cpt - Item.DCXXX];
          }
       }

       for (Integer col : Item.TO_CLEAN) {
          if (!resregroupe[i][col].equals(ESPACE)) {
             fiche[Item.VII] += " -" + resregroupe[i][col];
          }
       }
   }
   
   static void remplir4(String[] fiche, int i, String[][] resregroupe){
      fiche[Item.IX] = "";
       for (int cpt = Item.CMXVIII; cpt < Item.CMLV; cpt++) {
          if (resregroupe[i][cpt].equals(OUI)) {
             fiche[Item.IX] += " -" + Item.SECTEURS[cpt - Item.CMXVIII];
          }
       }
       if (!resregroupe[i][Item.CMLIV].equals(ESPACE)) {
          fiche[Item.IX] += " -" + resregroupe[i][Item.CMLIV];
       }

       fiche[Item.X] = "";
       for (int cpt = Item.CMLV; cpt < Item.MCCCVI; cpt++) {
          if (resregroupe[i][cpt].equals(OUI)) {
             fiche[Item.X] += " -" + Item.SOUS_SECTEURS[cpt - Item.CMLV];
          }
       }
       for (Integer col : Item.TO_CLEAN1) {
          if (!resregroupe[i][col].equals(ESPACE)) {
             fiche[Item.X] += " -" + resregroupe[i][col];
          }
       }
   }
   static void remplir5(String[] fiche, int i, String[][] resregroupe){
      fiche[Item.XI] = "";
       if (!resregroupe[i][Item.MCCCVII].equals(ESPACE)) {
          fiche[Item.XI] += " -" + resregroupe[i][Item.MCCCVII];
       }
       if (!resregroupe[i][Item.MCCCVIII].equals(ESPACE)) {
          fiche[Item.XI] += " -" + resregroupe[i][Item.MCCCVIII] + " (en cours)";
       }

       fiche[Item.XII] = "";
       for (int cpt = Item.MCCCLIII; cpt < Item.MCDXI; cpt += Item.II) {
          torefactor(i, cpt, fiche, resregroupe);
       }
       fiche[Item.XIII] = " Recherche et Développement";

       fiche[Item.XXII] = "";
       if (!resregroupe[i][Item.MCDXI].equals(ESPACE)) {
          fiche[Item.XXII] += resregroupe[i][Item.MCDXI];
       }
       fiche[Item.XIV]=Item.CONTACTEXPERT[i];
       
   }
   static void togenerate(String[] fiche, int i , Fiche[] fichetechneo, String xmlfile){
      if (!fiche[Item.III].equals(ESPACE) && !fiche[Item.IV].equals(ESPACE)
               && !fiche[Item.IV].equals(Item.NONAPPLICABLE)) {
            XML.generer(i, fichetechneo, xmlfile);
         }   
   }
   static void remplir(String[][] resregroupe, String xmlfile) {
      Fiche[] fichetechneo = new Fiche[Item.XII + Item.COMPETANCE.length];
      for (int i = Item.ZERO; i < Item.XII + Item.COMPETANCE.length; i++) {
         String[] fiche = new String[Item.XXVIII];
         fichetechneo[i] = new Fiche(fiche);
         fiche[Item.III] = resregroupe[i][Item.CXXVI];
         remplir1(fiche, i, resregroupe);
         remplir2(fiche, i, resregroupe);
         remplir3(fiche, i, resregroupe);
         remplir4(fiche, i, resregroupe);
         remplir5(fiche, i, resregroupe);         
         togenerate(fiche, i ,fichetechneo, xmlfile);
      }
   }   
}