package Game;

abstract class Personnage {
    protected String nom;
    protected int sante;
    protected int degats;
    protected int niveau;
    protected int experience;

    public Personnage(String nom, int sante, int degats) {
        this.nom = nom;
        this.sante = sante;
        this.degats = degats;
        this.niveau = 1;
        this.experience = 0;
    }

    public abstract void attaquer(Personnage cible);
    public abstract void utiliserCompetence(Personnage cible);
    
    public void recevoirDegats(int degats) {
        sante -= degats;
        System.out.println(nom + " reçoit " + degats + " points de dégâts !");
    }

    public void gagnerExperience(int points) {
        experience += points;
        if (experience >= 100) {
            niveau++;
            experience = 0; // Réinitialiser l'expérience
            System.out.println(nom + " a atteint le niveau " + niveau + " !");
        }
    }

    public String getNom() {
        return nom;
    }
}

class Guerrier extends Personnage {
    public Guerrier(String nom) {
        super(nom, 100, 10);
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
        gagnerExperience(10);
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise Coup de Rage !");
        cible.recevoirDegats(degats * 2);
        gagnerExperience(20);
    }
}

class Mage extends Personnage {
    public Mage(String nom) {
        super(nom, 70, 15);
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " lance un projectile magique sur " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
        gagnerExperience(10);
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise Boule de Feu !");
        cible.recevoirDegats(degats * 3);
        gagnerExperience(20);
    }
}

class Voleur extends Personnage {
    public Voleur(String nom) {
        super(nom, 70, 12);
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque furtivement " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
        gagnerExperience(10);
        
        // Chance d'un coup critique
        if (Math.random() < 0.2) {
            System.out.println(nom + " inflige un coup critique !");
            cible.recevoirDegats(degats); // Coup critique
        }
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise Attaque Rapide !");
        cible.recevoirDegats(degats * 3);
        gagnerExperience(20);
    }
}
