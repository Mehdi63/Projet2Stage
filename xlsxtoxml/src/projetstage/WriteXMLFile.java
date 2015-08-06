package projetstage;

import java.io.FileOutputStream;
import java.io.IOException;

import org.sonar.api.utils.SonarException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.CDATA;
   
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

   static void generer(String[] fiche, String type) {

      String xmlFile = "C:/Users/elhaddad/Documents/Annuaire de Compétence/fiche_"
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
      CDATA cdatatitle = new CDATA(fiche[Config.I]);
      title.addContent(cdatatitle);
      Element savoirfaire = new Element("savoir_faire");
      competence.addContent(savoirfaire);
      Element applications = new Element("applications");
      competence.addContent(applications);
      CDATA cdataAppli = new CDATA(fiche[Config.IX]);
      applications.addContent(cdataAppli);
      Element equipment = new Element("equipment");
      competence.addContent(equipment);
      CDATA cdataEquip = new CDATA(Config.EMPTY);
      equipment.addContent(cdataEquip);
      Element samples = new Element("samples");
      competence.addContent(samples);
      Element prestationtype = new Element("prestation_type");
      competence.addContent(prestationtype);
      CDATA cdataPrestationType = new CDATA("Recherche et Développement");
      prestationtype.addContent(cdataPrestationType);
      Element contactexpert = new Element("contact_expert");
      competence.addContent(contactexpert);
      Element language2 = new Element(Config.LANGUAGE);
      contactexpert.addContent(language2);
      language2.setText(Config.FR);
      Element civility1 = new Element(Config.CIVILITY);
      contactexpert.addContent(civility1);
      CDATA cdataCivility = new CDATA(fiche[Config.XI]);
      civility1.addContent(cdataCivility);
      Element surname1 = new Element(Config.SURNAME);
      contactexpert.addContent(surname1);
      CDATA cdataSurname = new CDATA(fiche[Config.XII]);
      surname1.addContent(cdataSurname);
      Element firstname1 = new Element(Config.FIRSTNAME);
      contactexpert.addContent(firstname1);
      CDATA cdataFirstName = new CDATA(fiche[Config.XIII]);
      firstname1.addContent(cdataFirstName);
      Element phonenumber1 = new Element(Config.PHONENUMBER);
      contactexpert.addContent(phonenumber1);
      CDATA cdataPhoneNumber = new CDATA(fiche[Config.XV]);
      phonenumber1.addContent(cdataPhoneNumber);
      Element faxnumber1 = new Element(Config.FAXNUMBER);
      contactexpert.addContent(faxnumber1);
      Element email1 = new Element(Config.EMAIL);
      CDATA cdataEmail = new CDATA(fiche[Config.XIV]);
      email1.addContent(cdataEmail);
      contactexpert.addContent(email1);
      Element function1 = new Element(Config.FUNCTION);
      contactexpert.addContent(function1);
      Element contactinterface = new Element("contact_interface");
      competence.addContent(contactinterface);
      Element language3 = new Element(Config.LANGUAGE);
      contactinterface.addContent(language3);
      Element civility2 = new Element(Config.CIVILITY);
      contactinterface.addContent(civility2);
      Element surname2 = new Element(Config.SURNAME);
      contactinterface.addContent(surname2);
      Element firstname2 = new Element(Config.FIRSTNAME);
      contactinterface.addContent(firstname2);
      Element phonenumber2 = new Element(Config.PHONENUMBER);
      contactinterface.addContent(phonenumber2);
      Element faxnumber2 = new Element(Config.FAXNUMBER);
      contactinterface.addContent(faxnumber2);
      Element email2 = new Element(Config.EMAIL);
      contactinterface.addContent(email2);
      Element function2 = new Element(Config.FUNCTION);
      contactinterface.addContent(function2);
      Element brevets = new Element("brevets");
      competence.addContent(brevets);
      CDATA cdataBrevets = new CDATA(fiche[Config.XVIII]);
      brevets.addContent(cdataBrevets);
      Element certificationsetagrement = new Element(
            "certifications_et_agrement");
      competence.addContent(certificationsetagrement);
      Element polescompetitivite = new Element("poles_competitivite");
      competence.addContent(polescompetitivite);
      Element technoscles2010 = new Element("technos_cles_2010");
      competence.addContent(technoscles2010);
      Element url = new Element(Config.URL1);
      CDATA cdataUrl = new CDATA(fiche[Config.XVI]);
      url.addContent(cdataUrl);
      competence.addContent(url);
      Element interventionsector = new Element("intervention_sector");
      competence.addContent(interventionsector);
      CDATA cdataSecteur = new CDATA(fiche[Config.VI]);
      interventionsector.addContent(cdataSecteur);
      Element interventionsubsector = new Element("intervention_subsector");
      competence.addContent(interventionsubsector);
      CDATA cdataSousSecteur = new CDATA(fiche[Config.VII]);
      interventionsubsector.addContent(cdataSousSecteur);
      if(type.equals(Config.TECHNOLOGIQUE)){
         Element technoDomain = new Element("techno_domain");
         competence.addContent(technoDomain);
         CDATA cdataDomaine = new CDATA(fiche[Config.III]);
         technoDomain.addContent(cdataDomaine);
         Element technoSubDomain = new Element("techno_subdomain");
         competence.addContent(technoSubDomain);
         CDATA cdataSousDomaine = new CDATA(fiche[Config.IV]);
         technoSubDomain.addContent(cdataSousDomaine);
      }
      if(type.equals(Config.SHS)){
          Element technoDiscipline = new Element("shs_discipline");
          competence.addContent(technoDiscipline);
          CDATA cdataDiscipline = new CDATA(fiche[Config.III]);
          technoDiscipline.addContent(cdataDiscipline);
          Element technoSubDiscipline = new Element("shs_subdiscipline");
          competence.addContent(technoSubDiscipline);
          CDATA cdataSousDiscipline = new CDATA(fiche[Config.IV]);
          technoSubDiscipline.addContent(cdataSousDiscipline);
       } 
      Element keywords = new Element("keywords");
      competence.addContent(keywords);
      Element carnotmines = new Element("carnot_mines");
      competence.addContent(carnotmines); 

      enregistrer(document, xmlFile);
   }
}
