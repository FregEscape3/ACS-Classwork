import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

public class ScienceNote extends Note {
    public ScienceNote(String title, String topic, int unit) {
        super(title, topic, unit);
    }

    public void generateWebsiteNote(String type) {
        type = type.toLowerCase();
        if (type.equals("chemistry")) {
            String url = "";
            if (getUnit() == 0) {
                url = "https://notesbyjoshua.github.io/notes/ap/chem/cheatsheet/";
            } else if (getUnit() == 1) {
                url = "https://notesbyjoshua.github.io/notes/ap/chem/atomicstrucprop/";
            } else if (getUnit() == 2) {
                url = "https://notesbyjoshua.github.io/notes/ap/chem/compounds/";
            } else if (getUnit() == 3) {
                url = "https://notesbyjoshua.github.io/notes/ap/chem/submix/";
            } else if (getUnit() == 4) {
                url = "https://notesbyjoshua.github.io/notes/ap/chem/chemrxns/";
            } else if (getUnit() == 5) {
                url = "https://notesbyjoshua.github.io/notes/ap/chem/kinetics/";
            } else if (getUnit() == 6) {
                url = "https://notesbyjoshua.github.io/notes/ap/chem/thermochemistry/";
            } else if (getUnit() == 7) {
                url = "https://notesbyjoshua.github.io/notes/ap/chem/equilibrium/";
            } else if (getUnit() == 8) {
                url = "https://notesbyjoshua.github.io/notes/ap/chem/acidbase/";
            } else if (getUnit() == 9) {
                url = "https://notesbyjoshua.github.io/notes/ap/chem/thermoelectro/";
            } else {
                System.out.println("That is not a valid AP Chemistry unit.");
                return;
            }
            openWebsite(url);

            return;
        } else if (type.equals("physics")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Is this AP Physics C Mechanics or AP Physics C E&M? Enter mech or em: ");
            String physicsType = sc.nextLine().toLowerCase();
            String url = "";
            if (physicsType.equals("mech") || physicsType.equals("mechanics")) {
                if (getUnit() == 1) {
                    url = "https://notesbyjoshua.github.io/notes/physics/kinematics/";
                } else if (getUnit() == 2) {
                    url = "https://notesbyjoshua.github.io/notes/physics/forces/";
                } else if (getUnit() == 3) {
                    url = "https://notesbyjoshua.github.io/notes/physics/work/";
                } else if (getUnit() == 4) {
                    url = "https://notesbyjoshua.github.io/notes/physics/linearmomentum/";
                } else if (getUnit() == 5) {
                    url = "https://notesbyjoshua.github.io/notes/physics/torque/";
                } else if (getUnit() == 6) {
                    url = "https://notesbyjoshua.github.io/notes/physics/rotationalmomentum/";
                } else if (getUnit() == 7) {
                    url = "https://notesbyjoshua.github.io/notes/physics/oscillations/";
                } else {
                    System.out.println("That is not a valid AP Physics C Mechanics unit. You thold.");
                    sc.close();
                    return;
                }
            } else if (physicsType.equals("em") || physicsType.equals("e&m")) {
                if (getUnit() == 1) {
                    url = "https://notesbyjoshua.github.io/notes/physics/electrostatics/";
                } else if (getUnit() == 2) {
                    url = "https://notesbyjoshua.github.io/notes/physics/electricpot/";
                } else if (getUnit() == 3) {
                    url = "https://notesbyjoshua.github.io/notes/physics/condcap/";
                } else if (getUnit() == 4) {
                    url = "https://notesbyjoshua.github.io/notes/physics/circuits/";
                } else if (getUnit() == 5) {
                    url = "https://notesbyjoshua.github.io/notes/physics/magnetism/";
                } else if (getUnit() == 6) {
                    url = "https://notesbyjoshua.github.io/notes/physics/eminduction/";
                } else {
                    System.out.println("That is not a valid AP Physics C E&M unit. You thold.");
                    sc.close();
                    return;
                }
                sc.close();
            } else {
                System.out.println("That is not a supported AP Physics C type. Bum bum bum sahur.");
                sc.close();
                return;
            }
            openWebsite(url);
            return;
        }
        System.out.println("That is not a supported science note type. You are a failure.");
    }

    private void openWebsite(String url) {
        System.out.println("Website URL: " + url);
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            System.out.println("Could not automatically open this website.");
        }
    }
}
