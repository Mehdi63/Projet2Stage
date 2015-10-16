package fichetechneo.xlsxtoxml;

import java.io.FileOutputStream;
import java.io.IOException;

import org.sonar.api.utils.SonarException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.CDATA;
import org.jdom.Document;
import org.jdom.Element;

import fichetechneo.xlsxtoxlsx.Config;
   
public class WriteXMLFile {

   private WriteXMLFile() {
   }

   static void enregistrer(org.jdom.Document document, String fichier) {
      try {
         XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
         sortie.output(document, new FileOutputStream(fichier));
      } catch (IOException e) {
         throw new SonarException(
               "A exception occured while generating the 'Techno Fiche' file.",
               e);
      }
   }

   public static void generer(String[] fiche, String type) {

      String xmlFile = Config.XML
            + fiche[Config.I] + ".xml";
      Element racine = new Element("import");
      org.jdom.Document document = new Document(racine);
      Element competence = new Element("competence");
      racine.addContent(competence);
      Element id = new Element("id");
      competence.addContent(id);
      id.addContent(fiche[Config.XX]);
      Element language = new Element(Config.LANGUAGE);
      competence.addContent(language);
      language.setText(Config.FR);
      Element entityId = new Element("entity_id");
      competence.addContent(entityId);
      entityId.addContent(fiche[Config.XXI]);
      Element title = new Element("title");
      competence.addContent(title);
      CDATA cDatatitle = new CDATA(fiche[Config.I]);
      title.addContent(cDatatitle);
      Element savoirfaire = new Element("savoir_faire");
      competence.addContent(savoirfaire);
      CDATA cDataSavoirfaire = new CDATA(fiche[Config.II]);
      savoirfaire.addContent(cDataSavoirfaire);
      Element applications = new Element("applications");
      competence.addContent(applications);
      CDATA cDataAppli = new CDATA(fiche[Config.VIII]);
      applications.addContent(cDataAppli);
      Element equipment = new Element("equipment");
      competence.addContent(equipment);
      CDATA cDataEquip = new CDATA(fiche[Config.IX]);
      equipment.addContent(cDataEquip);
      Element samples = new Element("samples");
      competence.addContent(samples);
      Element prestationtype = new Element("prestation_type");
      competence.addContent(prestationtype);
      CDATA cDataPrestationType = new CDATA(fiche[Config.X]);
      prestationtype.addContent(cDataPrestationType);
      Element contactExpert = new Element("contact_expert");
      competence.addContent(contactExpert);
      Element language2 = new Element(Config.LANGUAGE);
      contactExpert.addContent(language2);
      language2.setText(Config.FR);
      Element civility1 = new Element(Config.CIVILITY);
      contactExpert.addContent(civility1);
      CDATA cDataCivility = new CDATA(fiche[Config.XI]);
      civility1.addContent(cDataCivility);
      Element surname1 = new Element(Config.SURNAME);
      contactExpert.addContent(surname1);
      CDATA cDataSurname = new CDATA(fiche[Config.XII]);
      surname1.addContent(cDataSurname);
      Element firstname1 = new Element(Config.FIRSTNAME);
      contactExpert.addContent(firstname1);
      CDATA cDataFirstName = new CDATA(fiche[Config.XIII]);
      firstname1.addContent(cDataFirstName);
      Element phonenumber1 = new Element(Config.PHONENUMBER);
      contactExpert.addContent(phonenumber1);
      CDATA cDataPhoneNumber = new CDATA(fiche[Config.XV]);
      phonenumber1.addContent(cDataPhoneNumber);
      Element faxnumber1 = new Element(Config.FAXNUMBER);
      contactExpert.addContent(faxnumber1);
      Element email1 = new Element(Config.EMAIL);
      CDATA cDataEmail = new CDATA(fiche[Config.XIV]);
      email1.addContent(cDataEmail);
      contactExpert.addContent(email1);
      Element function1 = new Element(Config.FUNCTION);
      contactExpert.addContent(function1);
      Element contactInterface = new Element("contact_interface");
      competence.addContent(contactInterface);
      Element language3 = new Element(Config.LANGUAGE);
      contactInterface.addContent(language3);
      Element civility2 = new Element(Config.CIVILITY);
      contactInterface.addContent(civility2);
      Element surname2 = new Element(Config.SURNAME);
      contactInterface.addContent(surname2);
      Element firstname2 = new Element(Config.FIRSTNAME);
      contactInterface.addContent(firstname2);
      Element phonenumber2 = new Element(Config.PHONENUMBER);
      contactInterface.addContent(phonenumber2);
      Element faxnumber2 = new Element(Config.FAXNUMBER);
      contactInterface.addContent(faxnumber2);
      Element email2 = new Element(Config.EMAIL);
      contactInterface.addContent(email2);
      Element function2 = new Element(Config.FUNCTION);
      contactInterface.addContent(function2);
      Element brevets = new Element("brevets");
      competence.addContent(brevets);
      CDATA cDataBrevets = new CDATA(fiche[Config.XIX]);
      brevets.addContent(cDataBrevets);
      Element certificationsEtAgrement = new Element(
            "certifications_et_agrement");
      competence.addContent(certificationsEtAgrement);
      CDATA cDataCertification = new CDATA(fiche[Config.XVII]); 
      certificationsEtAgrement.addContent(cDataCertification);
      Element polescompetitivite = new Element("poles_competitivite");
      competence.addContent(polescompetitivite);
      Element technoscles2010 = new Element("technos_cles_2010");
      competence.addContent(technoscles2010);
      Element url = new Element(Config.URL1);
      url.addContent(fiche[Config.XVI]);
      competence.addContent(url);
      Element interventionsector = new Element("intervention_sector");
      competence.addContent(interventionsector);
      CDATA cDataSecteur = new CDATA(fiche[Config.VI]);
      interventionsector.addContent(cDataSecteur);
      Element interventionsubsector = new Element("intervention_subsector");
      competence.addContent(interventionsubsector);
      CDATA cDataSousSecteur = new CDATA(fiche[Config.VII]);
      interventionsubsector.addContent(cDataSousSecteur);
      if(type.equals(Config.TECHNOLOGIQUE)){
         Element technoDomain = new Element("techno_domain");
         competence.addContent(technoDomain);
         CDATA cDataDomaine = new CDATA(fiche[Config.III]);
         technoDomain.addContent(cDataDomaine);
         Element technoSubDomain = new Element("techno_subdomain");
         competence.addContent(technoSubDomain);
         CDATA cDataSousDomaine = new CDATA(fiche[Config.IV]);
         technoSubDomain.addContent(cDataSousDomaine);
      }
      if(type.equals(Config.SHS)){
          Element technoDiscipline = new Element("shs_discipline");
          competence.addContent(technoDiscipline);
          CDATA cDataDiscipline = new CDATA(fiche[Config.III]);
          technoDiscipline.addContent(cDataDiscipline);
          Element technoSubDiscipline = new Element("shs_subdiscipline");
          competence.addContent(technoSubDiscipline);
          CDATA cDataSousDiscipline = new CDATA(fiche[Config.IV]);
          technoSubDiscipline.addContent(cDataSousDiscipline);
       } 
      Element keywords = new Element("keywords");
      competence.addContent(keywords);
      CDATA cDataKeywords = new CDATA(fiche[Config.V]);
      keywords.addContent(cDataKeywords);
      Element carnotmines = new Element("carnot_mines");
      competence.addContent(carnotmines); 
      CDATA cDataCarnotMines = new CDATA(fiche[Config.XVIII]);
      carnotmines.addContent(cDataCarnotMines);
      
      enregistrer(document, xmlFile);
   }
}
