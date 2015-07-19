package projetstage;

import java.io.FileOutputStream;
import java.io.IOException;
import org.sonar.api.utils.SonarException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class WriteXMLFile {
   static Element racine = new Element("fichetechneo");
   static org.jdom.Document document = new Document(racine);
   private WriteXMLFile() {
   }
   
   static void enregistrer(org.jdom.Document document, String fichier){
      try {
         XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
         sortie.output(document, new FileOutputStream(fichier));
      } catch (IOException e) {
         throw new SonarException("A exception occured while generating the 'Techno Fiche' file.", e);
      }
   }
   
   static void generer(int i, Fiche[] fichetechneo, String xmlfile) {
      Element e = new Element("competence");
      racine.addContent(e);
         for (Element elt : fichetechneo[i].createElements()) {
         e.addContent(elt);
      }
      enregistrer(document, xmlfile);
   }
}  