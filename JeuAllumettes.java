import java.util.Scanner;

public class allumettes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer votre nom :");
        String nom = sc.nextLine();

        // Générer un nombre aléatoire d'allumettes entre 10 et 20
        int min = 10;
        int max = 20;
        int nbrAllumettes = (int)(Math.random() * (max - min + 1)) + min;

        // Afficher le nombre initial d'allumettes
        afficherAllumettes(nbrAllumettes);

        while (nbrAllumettes > 1) {
            // Tour de l'utilisateur
            int nbAllumSaisie = saisirAllumettes(nbrAllumettes);
            nbrAllumettes -= nbAllumSaisie;
            afficherAllumettes(nbrAllumettes);

            if (nbrAllumettes == 1) {
                System.out.println("O computer ,Vous avez perdu");
                break;
            }

            // Tour de l'ordinateur
            int nbrAllumettesC = calculerRetraitOrdi(nbrAllumettes);
            System.out.println("Je retire " + nbrAllumettesC + " allumettes");
            nbrAllumettes -= nbrAllumettesC;
            afficherAllumettes(nbrAllumettes);

            if (nbrAllumettes == 1) {
                System.out.println(nom + ", vous avez perdu");
                break;
            }
        }
    }

    public static String repeatChar(char c, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static int saisirAllumettes(int nbAllumettes) {
        Scanner sc = new Scanner(System.in);
        int nb;
        do {
            System.out.println("Saisir le nombre d'allumettes à enlever (entre 1 et 3) :");
            nb = sc.nextInt();
            if (nb < 1) {
                System.out.println("Vous devez enlever au moins une allumette");
            } else if (nb > 3) {
                System.out.println("Vous ne pouvez enlever plus de 3 allumettes");
            } else if (nb > nbAllumettes) {
                System.out.println("Il ne reste que " + nbAllumettes + " allumettes, enlevez moins de ça.");
            }
        } while (nb < 1 || nb > 3 || nb > nbAllumettes);
        return nb;
    }

    public static void afficherAllumettes(int nbAllumettes) {
        System.out.println(nbAllumettes + " : " + repeatChar('|', nbAllumettes));
    }

    public static int calculerRetraitOrdi(int nbAllumettes) {
        // Calculer le retrait optimal pour laisser toujours 1 allumette à la fin si possible
        int retrait = (nbAllumettes - 1) % 4;
        if (retrait == 0) {
            retrait = (int) (Math.random() * 3) + 1;  // Choisir un nombre aléatoire entre 1 et 3 si optimal
        }
        return retrait;
    }
}
