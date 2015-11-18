package travellingSalemansProblem;

import classesPb.Certificat;
import classesPb.NP;
import classesPb.NPRed;

public class HamiltonPathRed extends NPRed {
	public int nbSommets;
	public boolean[][] aretes;

	public HamiltonPathRed(int nb, boolean[][] arr) {
		this.nbSommets = nb;
		this.aretes = arr;
	}



	@Override
	public NP red() {
		boolean[][] dist = new boolean[nbSommets+1][nbSommets+1];
		for (int i = 0, l = dist.length; i < l-1; i++) {
			for (int j = 0; j < l-1; j++) {
				dist[i][j] = aretes[i][j];
			}
			dist[i][l-1] = true; // dernière col
		}
		for (int i = dist.length-1,j=0;j<= i;j++) { // dernière ligne
			dist[i][j] = true;
		}
		return new HamiltonCycleRed(nbSommets+1, dist);
	}

	@Override
	public boolean estCorrect(Certificat cert) {
		return red().estCorrect(cert);
	}

}
