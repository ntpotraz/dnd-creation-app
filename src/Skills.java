import java.util.ArrayList;

public class Skills {
  // Bool: Proficient, Int: Modifier, String: Name, Integer: Stat index
  private ArrayList<Skill> skillList = new ArrayList<>();

  // Sets up the skills with a base case
  public Skills() {
    skillList.add(new Skill(false, 0, "Athletics", 0));
    skillList.add(new Skill(false, 0, "acrobatics", 1));
    skillList.add(new Skill(false, 0, "sleight_of_hand", 1));
    skillList.add(new Skill(false, 0, "stealth", 1));
    skillList.add(new Skill(false, 0, "arcana", 3));
    skillList.add(new Skill(false, 0, "history", 3));
    skillList.add(new Skill(false, 0, "investigation", 3));
    skillList.add(new Skill(false, 0, "nature", 3));
    skillList.add(new Skill(false, 0, "religion", 3));
    skillList.add(new Skill(false, 0, "animal_handling", 4));
    skillList.add(new Skill(false, 0, "insight", 4));
    skillList.add(new Skill(false, 0, "medicine", 4));
    skillList.add(new Skill(false, 0, "perception", 4));
    skillList.add(new Skill(false, 0, "survival", 4));
    skillList.add(new Skill(false, 0, "deception", 5));
    skillList.add(new Skill(false, 0, "intimidation", 5));
    skillList.add(new Skill(false, 0, "performance", 5));
    skillList.add(new Skill(false, 0, "persuasion", 5));
  }

  // The intended constructor to call. Accepts an array of ints and an ArrayList
  // of strings
  public Skills(int[] stats, ArrayList<String> prof) {
    this(); // Calls the base constructor to setup the skillList field
    for (Skill skill : skillList) {
      int modifier = skill.getModifier();
      // grabs the stat index of the current skill in the for loop and increases the
      // modifer by it Right now it's adding the actual Stat level, so if Strength is
      // at 19, it's adding 18 rather than the stat modifier of +4, but I don't know
      // if we want to keep a list of Stat modifiers in the Character class or if we
      // wanna calculate when needed
      // Personally, think we should have two Int arrays, one for the Stat level and
      // one for the Stat modifier
      switch (skill.getIndex()) {
        case 0:
          modifier += stats[0];
          skill.setModifier(modifier);
          break;
        case 1:
          modifier += stats[1];
          skill.setModifier(modifier);
          break;
        case 3:
          modifier += stats[3];
          skill.setModifier(modifier);
          break;
        case 4:
          modifier += stats[4];
          skill.setModifier(modifier);
          break;
        case 5:
          modifier += stats[5];
          skill.setModifier(modifier);
          break;
        default:
          break;
      }
    }

    for (Skill skill : skillList) {
      for (String p : prof) {
        if (skill.getName() == p.toLowerCase()) {
          skill.setProficient(true);
          int modifier = skill.getModifier();
          modifier += 2;
          skill.setModifier(modifier);
        }
      }
    }
  }

  public ArrayList<Skill> getSkillList() {
    return skillList;
  }

  public String toString() {
    String output = "";
    for (Skill skill : skillList) {
      output += "[" + skill.isProficient() + ", " + skill.getModifier() + ", " +
          skill.getName() + ", " + skill.getIndex() + "]\n";
    }
    return output;
  }

  // Purely for testing purposes. Gonna leave it in for now cuz fuck it
  public static void main(String[] args) {
    int str = 15;
    int dex = 15;
    int con = 15;
    int intel = 15;
    int wis = 15;
    int cha = 15;
    int[] stats = { str, dex, con, intel, wis, cha };
    ArrayList<String> prof = new ArrayList<String>();
    prof.add("arcana");
    prof.add("nature");

    Skills testSkills = new Skills(stats, prof);

    System.out.println(testSkills.toString());
  }
}

class Skill {
  public boolean proficient;
  public int modifier;
  public final String name;
  public final int statIndex;

  public Skill(boolean proficient, int modifier, String name, int statIndex) {
    this.proficient = proficient;
    this.modifier = modifier;
    this.name = name;
    this.statIndex = statIndex;
  }

  public boolean isProficient() {
    return proficient;
  }

  public void setProficient(boolean proficient) {
    this.proficient = proficient;
  }

  public int getModifier() {
    return modifier;
  }

  public void setModifier(int modifier) {
    this.modifier = modifier;
  }

  public String getName() {
    return name;
  }

  public int getIndex() {
    return statIndex;
  }
}