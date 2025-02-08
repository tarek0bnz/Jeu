package Game;

abstract class Personnage implements Attaquable {
    protected String nom;
    protected int pointsDeVie;
    protected int degats; // Dégâts de base
    protected int niveau;
    protected int experience;

    public Personnage(String nom, int pointsDeVie, int degats) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.degats = degats;
        this.niveau = 1;
        this.experience = 0;
    }

    public void recevoirDegats(int degats) {
        pointsDeVie -= degats;
        if (pointsDeVie < 0) {
            pointsDeVie = 0; // Prévenir les points de vie négatifs
        }
        System.out.println(nom + " a reçu " + degats + " points de dégâts. Points de vie restants : " + pointsDeVie);
    }

    public boolean estVivant() {
        return pointsDeVie > 0;
    }

    public String getNom() {
        return nom;
    }

    public void gagnerExperience(int xp) {
        experience += xp;
        if (experience >= 100) {
            niveau++;
            experience = 0;
            System.out.println(nom + " a atteint le niveau " + niveau + " !");
            // Possibilité d'augmenter les dégâts ou points de vie ici
        }
    }

    public void recupererPointsDeVie(int points) {
        pointsDeVie += points;
        System.out.println(nom + " a récupéré " + points + " points de vie. Points de vie actuels : " + pointsDeVie);
    }
}
