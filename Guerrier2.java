package Game;

class Guerrier extends Personnage {
    private int niveau;
    private int experience;
    private String arme;

    public Guerrier(String nom) {
        super(nom, 100, 10);
        this.niveau = 1;
        this.experience = 0;
        this.arme = "Épée basique";
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque " + cible.getNom() + " avec " + arme + " !");
        cible.recevoirDegats(degats);
        gagnerExperience(10); // Gagner de l'expérience après une attaque
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Coup de rage !");
        cible.recevoirDegats(degats * 2);
        gagnerExperience(20); // Gagner plus d'expérience pour une compétence spéciale
    }

    public void equiperArme(String nouvelleArme, int bonusDegats) {
        this.arme = nouvelleArme;
        this.degats += bonusDegats; // Augmenter les dégâts
        System.out.println(nom + " a équipé " + nouvelleArme + " !");
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
