package travellingSalemansProblem;

import java.io.FileReader;
import java.util.Scanner;

import classesPb.Certificat;
import classesPb.NP;

public class testHamiltonRed {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// saisie du probleme
		if (args.length < 3) {
			System.out
			.println("java testHamiltonRed <-cycle|-path> mode file.ham");
		} else {
			// le probleme dans un fichier de donnees
			Scanner donnee = new Scanner(new FileReader(args[2]));
			for (int i = 0; i < 3; i++) {
				donnee.nextLine();
			}
			donnee.next();
			int nbv = donnee.nextInt();
			for (int i = 0; i < 4; i++) {
				donnee.nextLine();
			}
			boolean D[][] = new boolean[nbv][nbv];
			for (int i = 0; i < nbv; i++) {
				for (int j = 0; j < nbv; j++) {
					D[i][j] = donnee.nextBoolean();
					System.out.println(D[i][j] + " ");
				}
				System.out.println();
			}
			NP pb;
			if (args[0].equals("-cycle")) {
				pb = new HamiltonCycleRed(nbv, D);
			} else if (args[0].equals("-path")) {
				pb = new HamiltonPathRed(nbv, D);
			} else {
				System.out.println("erreur de mode");
				donnee.close();
				return;
			}
			System.out.println(args[1] + " en mode "+args[0]);
			// les differents modes
			if (args[1].equals("-verif")) {
				Certificat c = pb.cert();
				System.out.print("Proposez un certificat;");
				c.saisie();
				System.out.print("votre certificat est-il correct? ");
				System.out.println(pb.estCorrect(c));
			} else if (args[1].equals("-nondet")) {
				System.out.println(pb.aUneSolutionNonDeterministe());
			} else if (args[1].equals("-exhaust")) {
				System.out.println("le probleme a-t-il une solution?: ");
				System.out.println(pb.aUneSolution());
			} else {
				System.out.println("erreur de mode");
			}
			donnee.close();
		}
	}
}