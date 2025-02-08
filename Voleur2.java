package Game;

import java.util.Random;

class Voleur extends Personnage {
    private int niveau;
    private int experience;
    private String arme;
    private boolean estCache;

    public Voleur(String nom) {
        super(nom, 70, 12);
        this.niveau = 1;
        this.experience = 0;
        this.arme = "Dague";
        this.estCache = false;
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque furtivement " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
        gagnerExperience(10); // Gagner de l'expérience après une attaque

        // Chance d'une attaque critique
        if (Math.random() < 0.2) {
            System.out.println(nom + " inflige un coup critique !");
            cible.recevoirDegats(degats); // Coup critique inflige des dégâts supplémentaires
        }
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Attaque rapide !");
        cible.recevoirDegats(degats * 3);
        gagnerExperience(20); // Gagner plus d'expérience pour une compétence spéciale
    }

    public void seCacher() {
        this.estCache = true;
        System.out.println(nom + " se cache dans l'ombre !");
    }

    public void sortirDeCache() {
        this.estCache = false;
        System.out.println(nom + " sort de sa cachette !");
    }

    public void voler(Personnage cible) {
        if (estCache) {
            System.out.println(nom + " vole de l'or à " + cible.getNom() + " !");
            // Logique pour voler de l'or ou des objets
        } else {
            System.out.println(nom + " doit se cacher avant de voler !");
        }
    }

    public void gagnerExperience(int points) {
            experience += points;
            if (experience >= 100) {
                niveau++;
                experience = 0; // Réinitialiser l'expérience après avoir monté de niveau
                System.out.println(nom + " a atteint le niveau " + niveau + " !");
            }
        }

    public int getNiveau() {
        return niveau;
    }

    public String getArme() {
        return arme;
    }
}
