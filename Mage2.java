package Game;

class Mage extends Personnage {
    private int mana;
    private static final int MANA_MAX = 100;

    public Mage(String nom) {
        super(nom, 80, 15);
        this.mana = MANA_MAX; // Commence avec le mana maximum
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " lance un sort sur " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
        // Régénération de mana après une attaque
        regagnerMana(5);
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        if (mana >= 20) { // Coût de mana pour la compétence
            System.out.println(nom + " invoque une tempête magique !");
            cible.recevoirDegats(degats + 10);
            mana -= 20; // Déduction du mana
            regagnerMana(10); // Régénération de mana après utilisation
        } else {
            System.out.println(nom + " n'a pas assez de mana pour utiliser cette compétence !");
        }
    }

    public void soigner(Personnage cible) {
        if (mana >= 15) {
            System.out.println(nom + " utilise un sort de guérison sur " + cible.getNom() + " !");
            cible.recevoirDegats(-10); // Restauration de 10 PV
            mana -= 15; // Coût de mana pour la guérison
        } else {
            System.out.println(nom + " n'a pas assez de mana pour soigner !");
        }
    }

    private void regagnerMana(int points) {
        mana += points;
        if (mana > MANA_MAX) {
            mana = MANA_MAX; // Limite de mana
        }
    }

    public int getMana() {
        return mana;
    }
}
