package projetstage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jdom.Element;

class Fiche {
   static final Map<String, Integer> ELEMENTS = new HashMap<>();
   static {
      ELEMENTS.put("ezpublish_id", Item.ZERO);
      ELEMENTS.put("orga_id", Item.I);
      ELEMENTS.put("entity_id", Item.II);
      ELEMENTS.put("entity", Item.III);
      ELEMENTS.put("title", Item.IV);
      ELEMENTS.put("type", Item.XXVII);
      ELEMENTS.put("savoir-faire", Item.V);
      ELEMENTS.put("shs_discipline", Item.VI);
      ELEMENTS.put("shs_subdiscipline", Item.VII);
      ELEMENTS.put("keywords", Item.VIII);
      ELEMENTS.put("intervention_sector", Item.IX);
      ELEMENTS.put("intervention_subsector", Item.X);
      ELEMENTS.put("applications", Item.XI);
      ELEMENTS.put("equipement", Item.XII);
      ELEMENTS.put("prestation_type", Item.XIII);
      ELEMENTS.put("contact_expert", Item.XIV);
      ELEMENTS.put("contact_interface", Item.XV);
      ELEMENTS.put("url", Item.XVI);
      ELEMENTS.put("savoir-faire", Item.XVII);
      ELEMENTS.put("certification_et_agrement", Item.XVIII);
      ELEMENTS.put("poles_competitivite", Item.XIX);
      ELEMENTS.put("technos_cles_2015", Item.XX);
      ELEMENTS.put("carnot_mines", Item.XXI);
      ELEMENTS.put("brevets", Item.XXII);
      ELEMENTS.put("piece_joint_1", Item.XXIII);
      ELEMENTS.put("Departmement", Item.XXIV);
      ELEMENTS.put("Published", Item.XXV);
      ELEMENTS.put("Modified", Item.XXVI);
   }

   String[] data;

   Fiche(String[] data) {
      this.data = data;
   }

   public String get(String name) {
      return data[ELEMENTS.get(name)];
   }

   public void set(String name, String value) {

      data[ELEMENTS.get(name)] = value;
   }

   public Iterable<Element> createElements() {
      List<Element> elts = new LinkedList<>();
      for (String name : Fiche.ELEMENTS.keySet()) {
         Element e = new Element(name);
         e.setText(get(name));
         elts.add(e);
      }
      return elts;
   }
}